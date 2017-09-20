# Use Nginx as Reverse Proxy: from Multiple Domains to Multiple Sites(Golang Apps) on Single CentOS 7 Server

#### Install Nginx on CentOS 7
* Add the CentOS 7 EPEL repository

        sudo yum install epel-release

* Install Nginx

        sudo yum install nginx

#### Nginx Configuration
* `sudo vi /etc/nginx/nginx.conf`.
    * Remove(comment) default server block with `#`.

            #    server {
            #        listen       80 default_server;
            #        ...
            #    }

    * Add 2 `server` to proxy `a.com` to `http://localhost:8000` and `b.com` to `http://localhost:8001`.

            server {
                listen 80;
                server_name a.com;

                location / {
                    proxy_pass http://localhost:8000;
                }
            }

            server {
                listen 80;
                server_name b.com;

                location / {
                    proxy_pass http://localhost:8001;
                }
            }

#### Append `a.com` and `b.com` to `127.0.0.1` record in `/etc/hosts` for Test Use
* `sudo vi /etc/hosts`

        127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4 a.com b.com

* Restart network service or reboot to take effect.
    
         sudo systemctl restart network.service
 
* You may ignore this step if your **REAL** domains are pointer to this server IP(A record).

#### Enable and Start Nginx Service
* `sudo systemctl enable nginx.service`
* `sudo systemctl start nginx.service`
* `sudo systemctl status nginx.service`

#### Implement and Run Golang HTTP Servers
* [Install Latest Go Release from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/Golang/Install/install-latest-go-release-from-source-on-centos7.md)
* Impement server based on [gin](https://github.com/gin-gonic/gin)

    * Install [gin](https://github.com/gin-gonic/gin):

      `go get -v -u github.com/gin-gonic/gin`

    * `mkdir $GOPATH/server`
    * `cd $GOPATH/server`
    * `vi main.go` and copy below code:

```
package main

import (
        "flag"
        "net/http"

        "github.com/gin-gonic/gin"
)

var (
        addr   = ""
        domain = ""
)

func hello(c *gin.Context) {
        c.JSON(http.StatusOK, gin.H{"domain": domain})
}

func main() {
        flag.StringVar(&addr, "a", "", "server address. e.g. -a=localhost:8000")
        flag.StringVar(&domain, "d", "", "domain. e.g. -d=a.com")
        flag.Parse()

        r := gin.Default()
        r.GET("/", hello)
        r.Run(addr)
}
```

* Build and run servers for `a.com` and `b.com`
    * `go build`
    * `./server -a=localhost:8000 -d=a.com &`
    * `./server -a=localhost:8001 -d=b.com &`

#### Use `curl ` to Test
* `curl a.com`
* `curl b.com`
* You may get "502 Bad Gateway" Response
* To fix this, go to "SELinux Configuration"

#### SELinux Configuration
* Running Nginx as reverse proxy(connect to other servers) is **NOT** allowed by SELinux by default.
    * `httpd_can_network_relay`
    * `httpd_can_network_connect`
* Install `SELinux policy core python utilities`
    * Use `yum provides audit2allow` to get the package name: `policycoreutils-python`
    * `sudo yum install policycoreutils-python`
* Use `audit2allow` to generate a set of policy rules that would allow the required actions for Nginx.

    * `grep nginx /var/log/audit/audit.log | audit2allow -M nginx`
    * `semodule -i nginx.pp`

#### Test Again
* Now you will get correct responses:
* `curl a.com`
    * `{"domain":"a.com"}`
* `curl b.com`
    * `{"domain":"b.com"}` 

#### References
* [NGINX Reverse Proxy return 502 bad gateway when proxied server is down](https://stackoverflow.com/questions/33206292/nginx-reverse-proxy-return-502-bad-gateway-when-proxied-server-is-down)
* [NGINX: SELinux Changes when Upgrading to RHEL 6.6 / CentOS 6.6](https://www.nginx.com/blog/nginx-se-linux-changes-upgrading-rhel-6-6/)
* [Using Proxy server to switch between Golang Applications](https://stackoverflow.com/questions/43327793/using-proxy-server-to-switch-between-golang-applications)


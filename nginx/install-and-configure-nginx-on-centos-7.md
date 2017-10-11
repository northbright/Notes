# Install and Configure Nginx on CentOS 7

#### Install Nginx

    sudo yum install -y nginx

#### Enable and Start Nginx Service

    sudo systemctl enable nginx
    sudo systemctl start nginx

#### Configure Firewall for Nginx

    // default HTTP service on port 80:
    sudo firewall-cmd --permanent --zone=public --add-service=http
    
    // or other ports like 8080:
    sudo firewall-cmd --permanent --zone=public --add-port=8080/tcp
    
    // Reload firewalld
    sudo firewall-cmd --reload
    // Check
    sudo firewall-cmd --list-all

#### Check If Nginx Works

    curl localhost

#### Use Customized Server Root of Nginx
* Configuration File
  * `/etc/nginx/nginx.conf`

* Nginx User
  * Nginx worker process is run as the `user` defined in `/etc/nginx/nginx.conf`:

          # Default user is nginx.
          ......
          user nginx;
          ......

* Set a new server root

          server {
                  .......
                  #root         /usr/share/nginx/html;
                  root         /home/xx/html;
                  ......
          }

* Default server root is `/usr/share/nginx/html`
* **All directories(include TOP dir)** of customized server root path should have `rx` permissions for Nginx user or it'll occur 403 forbidden error:

          sudo cat /var/log/nginx/error.log

          // Output:
          2017/09/26 12:50:41 [error] 20491#0: *1 "/home/xx/html/index.html" is forbidden (13: Permission denied), client: ::1, server: _, request: "GET / HTTP/1.1", host: "localhost"

          // Check if other user(nginx) has 'rx' on /home/xx
          ls /home -la
          drwx------.  3 xx  xx   95 9月  26 12:50 xx

          // Add 'rx' for other(user nginx):
          sudo chmod o+rx /home/xx

* Configure SELinux
  * See [Fix 403 Forbidden Error of Nginx on CentOS 7](https://github.com/northbright/Notes/blob/master/nginx/configure-selinux-to-fix-403-forbidden-error-of-nginx-on-centos.md)

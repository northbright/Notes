# Install Latest Nginx from Source on CentOS 7

## Security Setup
* [Disable root SSH Login](https://github.com/northbright/Notes/blob/master/Linux/ssh/disable-root-ssh-login.md)

## Install Dependencies
* Update `yum`
   
      sudo yum update -y

* Install "Development Tools"
   
      # Find the name of "Development Tools" Group under "Optional Group" in the output
      # Pass the group name to `yum group install` 
      # The group name may be translated string(e.g. "开发工具" in Chinese)
      yum group list
      sudo yum group install "Development Tools" -y

* zlib
  * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)

* PCRE
  * [Install Latest PCRE from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/pcre/install-latest-pcre-from-source-on-centos-7.md) 

* OpenSSL
  * [Install Latest OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos-7.md)
   
## Download source on [github](https://github.com/nginx/nginx/releases)

    cd download
    wget https://github.com/nginx/nginx/archive/release-1.17.0.tar.gz

## Configure [Nginx](http://nginx.org/)

    # Configure nginx
    # 1. Specify prefix to install nginx
    # 2. Specify PCRE SOURCE dir(NOT "make install" dir). It'll use STATIC link of PCRE library.
    # 3. Specify zlib SOURCE dir(NOT "make install" dir). It'll use STATIC link of zlib library.
    # 4. Specify OpenSSL library dir(NOT source).

    ./auto/configure \
    --prefix=/usr/local/nginx \
    --with-pcre=/home/xx/download/pcre-8.43 \
    --with-zlib=/home/xx/download/zlib-1.2.11 \
    --with-openssl=/usr/local/openssl \

## Make and Install

    make
    sudo make install
      
## Add New Binary Path of Nginx
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of Nginx
      export PATH=/usr/local/nginx/sbin:$PATH

* `source /etc/profile`

## Configure Nginx as `systemd` Service
* Create `/var/lib/systemd/nginx.service` File

      sudo vi /var/lib/systemd/nginx.service

      [Unit]
      Description=The NGINX HTTP and reverse proxy server
      After=syslog.target network.target remote-fs.target nss-lookup.target

      [Service]
      Type=forking
      PIDFile=/usr/local/nginx/logs/nginx.pid
      ExecStartPre=/usr/local/nginx/sbin/nginx -t
      ExecStart=/usr/local/nginx/sbin/nginx
      ExecReload=/usr/local/nginx/sbin/nginx -s reload
      ExecStop=/bin/kill -s QUIT $MAINPID
      PrivateTmp=true

      [Install]
      WantedBy=multi-user.target

* Enable and Start Nginx Service
  
      sudo systemctl enable nginx.service
      sudo systemctl start nginx.service
        
      # Check nginx service stastus
      systemctl status nginx.service

* Check Users of Running Nginx Processes

      ps aux | grep nginx

    The output should looks like this:

    | User | Process |
    | :--: | :--: |
    | root | master process(`/usr/local/nginx/sbin/nginx`) |
    | nobody | worker process |

## References
* [烂泥：nginx、php-fpm、mysql用户权限解析](http://blog.51cto.com/ilanni/1561097)

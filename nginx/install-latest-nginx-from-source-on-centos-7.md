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

* Install Other Dependencies
      
      sudo yum install -y wget zlib-devel

* [Install Latest PCRE from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/pcre/install-latest-pcre-from-source-on-centos-7.md) 
* [Install Latest OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos-7.md)
   
## Install [Nginx](http://nginx.org/) from Source
* Git clone [Official Repo on Github](https://github.com/nginx/nginx)
      
      git clone https://github.com/nginx/nginx.git
      cd nginx

      # List tags and select stable release
      git tag -l
      
      # Checkout selected release
      # e.g.  1.14.2
      git checkout -b 1.14.2 release-1.14.2

* Compile and Install [Nginx](http://nginx.org/)

      # Configure nginx
      # Use absolute path for PCRE, OpenSSL libraries
      ./auto/configure --with-pcre=/home/xx/PATH/TO/pcre-8.42 --with-openssl=/home/xx/PATH/TO/openssl/

      # Make and Install
      make
      sudo make install
      
* Add New Binary Path of Nginx
  * `sudo vi /etc/profile`

        # Append these lines:
        # Use New Version of Nginx
        export PATH=/usr/local/nginx/sbin:$PATH

  * `source /etc/profile`

* Configure Nginx as `systemd` Service
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

# Configure Nginx to Work with php-fpm

## Set owner of web root

    // e.g. for wordpress
    sudo cp -rf ~/download/WordPress-5.2.2 /var/www/wordpress

    sudo chown -R nobody:nobody /var/www/wordpress

## php.ini Configuration

    sudo vi /usr/local/php/lib/php.ini

    // Uncomment this line and set cgi.fix_pathinfo = 0
    cgi.fix_pathinfo = 0

## php-fpm Configuration

    sudo vi /usr/local/php/etc/php-fpm.d/www.conf

* Nginx and php-fpm worker processes user should be the same to have the permissions to access html / scripts directories.

      ; Unix user/group of processes
      user = nobody
      group = nobody

* Set Unix Socket
      
      ; The address on which to accept FastCGI requests.
      listen = /var/run/php-fpm/php-fpm.sock

      ; Set permissions for unix socket, if one is used. In Linux, read/write
      listen.owner = nobody
      listen.group = nobody
      listen.mode = 0660

## Nginx Configuration
* Follow the nginx [offical configuration for WordPress](https://www.nginx.com/resources/wiki/start/topics/recipes/wordpress/)

      sudo vi /usr/local/nginx/conf/nginx.conf

```
# Upstream to abstract backend connection(s) for php
upstream php {
        # Bind Unix Socket to communicate with PHP-FPM
        #server unix:/var/run/php-fpm/php-fpm.sock;

        # Bind TCP Socket to communicate with PHP-FPM(by default)
        server 127.0.0.1:9000;
}

server {
        ## Your website name goes here.
        server_name domain.tld;
        ## Your only path reference.
        root /var/www/wordpress;
        ## This should be in your http block and if it is, it's not needed here.
        index index.php;

        location = /favicon.ico {
                log_not_found off;
                access_log off;
        }

        location = /robots.txt {
                allow all;
                log_not_found off;
                access_log off;
        }

        location / {
                # This is cool because no php is touched for static content.
                # include the "?$args" part so non-default permalinks doesn't break when using query string
                try_files $uri $uri/ /index.php?$args;
        }

        location ~ \.php$ {
                #NOTE: You should have "cgi.fix_pathinfo = 0;" in php.ini
                include fastcgi.conf;
                fastcgi_intercept_errors on;
                fastcgi_pass php;
        }

        location ~* \.(js|css|png|jpg|jpeg|gif|ico)$ {
                expires max;
                log_not_found off;
        }
}
```

## References
* [WordPress](https://www.nginx.com/resources/wiki/start/topics/recipes/wordpress/)

# Fix 413 Payload Too Large Error when Upload Files to Go App Using Nginx as Reverse Proxy

## Problem
* Quasar SPA as front end and Go App as backend
* Use Nginx as reverse proxy and HTTPS server
* Go App accepts file upload and set max upload size to 10M

  ```go
  const ( 
        // Default max upload size.
        MAX_UPLOAD_SIZE = 1024 * 1024 * 10
  )  

  // Update r.Body with a MaxByteReader to limit the size to read from upload file.
  r.Body = http.MaxBytesReader(w, r.Body, MAX_UPLOAD_SIZE)
  ```
* Use QUploader to upload files in Quasar App
* It still failed to upload files which size is larger than 1M
  * Go App does not receive the HTTP request
  * Quasar SPA call @failed of QUploader
  * Browser debug mode shows the HTTP request failed with 413 status code

## Root Cause
* Nginx has a limit of 1MB for upload size by default.

  * `/var/log/nginx/error.log` has many errors:

    > client intended to send too large body

  * `/var/log/nginx/access.log` has many records:

    > "POST /upload HTTP/2.0" 413 594

## Solution
Add or edit `client_max_body_size` in http, server or location context of `nginx.conf`

e.g. /
```
http {
        ##
        # Basic Settings
        ##

        sendfile on;
        tcp_nopush on;
        types_hash_max_size 2048;
        # server_tokens off;

        # server_names_hash_bucket_size 64;
        # server_name_in_redirect off;

        include /etc/nginx/mime.types;
        default_type application/octet-stream;

        ##
        # SSL Settings
        ##

        #ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3; # Dropping SSLv3, ref: POODLE
        #ssl_prefer_server_ciphers on;

        ##
        # Logging Settings
        ##

        access_log /var/log/nginx/access.log;
        error_log /var/log/nginx/error.log;

        ##
        # Gzip Settings
        ##

        gzip on;

        # gzip_vary on;
        # gzip_proxied any;
        # gzip_comp_level 6;
        # gzip_buffers 16 8k;
        # gzip_http_version 1.1;
        # gzip_types text/plain text/css application/json application/javascript text/xml application/xml application/xml+rss text/javascript;

        ##
        # Virtual Host Configs
        ##

        include /etc/nginx/conf.d/*.conf;
        #include /etc/nginx/sites-enabled/*;

        # Max upload file size
        client_max_body_size 100M;
}
```

Restart Nginx service.
```bash
sudo systemctl restart nginx
```

## References
* [NGINX Error 413: Request Entity Too Large – Causes and Solutions](https://www.slingacademy.com/article/fixing-nginx-error-413/)
* [Error: 413 “Request Entity Too Large” in Nginx](https://dev.to/matthewlafalce/error-413-request-entity-too-large-in-nginx-516)

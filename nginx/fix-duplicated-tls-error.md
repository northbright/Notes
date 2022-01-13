# Fix Duplicated TLS Error

## Problem
* Include a SSL config file(`ssl.conf`) in `nginx.conf`
* `ssl.conf

```
## Protocols - TLSv1.3 requires newer OpenSSL(Feb.2018)
ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3;

## Key Exchange
ssl_dhparam /usr/local/openssl/certs/dhparam.pem;
ssl_ecdh_curve secp384r1;

## Cipher Strength
ssl_ciphers AES256+EECDH:AES256+EDH:!aNULL;

## Enable HSTS on all subdomains
add_header Strict-Transport-Security "max-age=31536000; includeSubDomains" always;

## Other typical SSL settings
ssl_session_cache shared:SSL:10m;
ssl_session_timeout 10m;
ssl_prefer_server_ciphers on;

ssl_stapling on;
ssl_stapling_verify on;

resolver 8.8.8.8 8.8.4.4 valid=300s;
resolver_timeout 10s;

add_header X-Frame-Options DENY;
add_header X-Content-Type-Options nosniff;
```

* Start nginx and got the error:

  > duplicate value "TLSv1" in /etc/nginx/conf.d/ssl.conf:2

## Root Cause
* `nginx.conf` also includes `default` SSL settings on Ubuntu after nginx installed:

  ```
  ##
  # SSL Settings
  ##

  # Below settings duplicated
  ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3; # Dropping SSLv3, ref: POODLE
  ssl_prefer_server_ciphers on;

  ......
  include /etc/nginx/conf.d/ssl.conf
  ......
  ```

## Solution
Remove duplicated SSL settings in `nginx.conf`

## References
* [Disabling TLS 1.0 and TLS 1.1](https://community.letsencrypt.org/t/disabling-tls-1-0-and-tls-1-1/112816)
* [nginx: [warn] duplicate value when editing file in nginx/sites-available](https://www.digitalocean.com/community/questions/nginx-warn-duplicate-value-when-editing-file-in-nginx-sites-available)



# Global TLS Config for Nginx

## Global(common) TLS configuration

Different servers(domains) use **DIFFERENT** TLS certificates / keys,
but share the **SAME** common TLS configuration

* Disable Default SSL Settings in `/etc/nginx/nginx.conf`

  ```
  # Disable default SSL settings to avoid confliction with
  # customized SSL settings in virtual host config
  # Go to SSL Settings
  # Comment ssl_protocols, ssl_prefer_server_ciphers

  #ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3; # Dropping SSLv3, ref: POODLE
  #ssl_prefer_server_ciphers on;
  ``` 

* Create Diffie-Hellman Group

  Diffie-Hellman Group is used in negotiating [Perfect Forward Secrecy](https://en.wikipedia.org/wiki/Forward_secrecy) with clients.

  ```
  // Make dir to put dhparam
  sudo mkdir /etc/nginx/dhparam

  sudo openssl dhparam \
  -out /etc/nginx/dhparam/dhparam.pem 2048
  ```

  Please note, it'll take a long time(a few minutes) if key size >= 4096(but recommended).

* Add global TLS config file

  ```
  sudo vi /etc/nginx/conf.d/ssl.conf
  ```

  ```
  ## Protocols - TLSv1.3 requires newer OpenSSL(Feb.2018)
  ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3;

  ## Key Exchange
  ssl_dhparam /etc/nginx/dhparam/dhparam.pem;
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


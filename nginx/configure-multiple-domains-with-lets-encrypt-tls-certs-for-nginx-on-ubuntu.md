# Configure Multiple Domains with Let's Encrypt TLS Certs for Nginx on Ubuntu

## Problem
* Own a domain: `a.com`
* Have a ECS server(IP: xx.xx.xx.xx, OS: Ubuntu Server 20.04)
* Run a HTTP server on the ECS(Nginx)
* Want to visit the server via **BOTH** `a.com` and `www.a.com`
* Need to configure Let's Encrypt TLS Certificates for **BOTH** `a.com` and `www.a.com`

## Solution
* Create 2 DNS A records of the domains, pointed to the ECS IP
  * `www`(`www.a.com`) --> `xx.xx.xx.xx`
  * `@`(root of `a.com`) --> `xx.xx.xx.xx`
* Configure `/etc/nginx/nginx.conf`
  * Remove **DEFAULT** SSL Settings(to avoid duplicated SSL settings after add our new-added settings: [Fix Duplicated TLS Error](https://github.com/northbright/Notes/blob/master/nginx/fix-duplicated-tls-error.md))
    ```
    ##
    # SSL Settings
    ##

    # Comment below lines to remove default SSL settings
    # ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3; # Dropping SSLv3, ref: POODLE
    # ssl_prefer_server_ciphers on;
    ```
  * Include config files under `/etc/nginx/conf.d`
    
    | File | Desc |
    | :--: | :--: |
    | `/etc/nginx/conf.d/a.com.conf` | server config of `a.com` |
    | `/etc/nginx/conf.d/www.a.com.conf` | server config of `www.a.com` |
    | `/etc/nginx/conf.d/ssl.conf` | global TLS config | 


    ```
    ......
    ##
    # Virtual Host Configs
    ##

    include /etc/nginx/conf.d/*.conf;
    ......
    ```

* Add per-site(domain) server config files

  `a.com` and `www.a.com` use **DIFFERENT** TLS certs and keys.

  * `/etc/nginx/conf.d/a.com.conf`

    ```
    server {
            listen       80;
            server_name  a.com;

            # Redirect HTTP to HTTPS
            return 302 https://$server_name$request_uri;
    }

    server {
            listen       443 ssl http2;
            server_name  a.com;

            ## Certificate and Key
            ssl_certificate /usr/local/openssl/certs/a.com/le.cer;
            ssl_certificate_key /usr/local/openssl/private/a.com/le.key;

            location / {
                root   /var/www/html;
                index  index.html index.htm;
            }
    }
    ```

    * `/etc/nginx/conf.d/www.a.com.conf`

      ```
      server {
              listen       80;
              server_name  www.a.com;
 
              # Redirect HTTP to HTTPS
              return 302 https://$server_name$request_uri;
      }

      server {
              listen       443 ssl http2;
              server_name  www.a.com;

              ## Certificate and Key
              ssl_certificate /usr/local/openssl/certs/www.a.com/le.cer;
              ssl_certificate_key /usr/local/openssl/private/www.a.com/le.key;

              location / {
                  root   /var/www/html;
                 index  index.html index.htm;
              }
      }
      ```
    
* Global(common) TLS configuration

  Different servers(domains) use **DIFFERENT** TLS certificates / keys,
  but share the **SAME** common TLS configuration

  * Create Diffie-Hellman Group
    Diffie-Hellman Group is used in negotiating [Perfect Forward Secrecy](https://en.wikipedia.org/wiki/Forward_secrecy) with clients.

    ```
    sudo openssl dhparam \
    -out /usr/local/openssl/certs/dhparam.pem 2048
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
* Install Let's Encrypt Certs
  * Switch to `root`

    Issue cert, copy key and cert, cmd to restart nginx all need permission, it's better to install and run acme.sh with root.

    ```
    // Switch to root
    sudo su -
    ```

  * Install [acme.sh](https://github.com/acmesh-official)

    Follow [offical guide](https://github.com/acmesh-official/acme.sh#1-how-to-install) to install acme.sh is enough

    ```
    curl https://get.acme.sh | sh
    ```
    or

    ```
    wget -O -  https://get.acme.sh | sh
    ```

  * Install [acme.sh](https://github.com/acmesh-official) for China developers(Optional)

    Because `https://raw.githubusercontent.com` can **NOT** be accessed from China, we need to download the release.

    * Download latest [acme.sh](https://github.com/acmesh-official) from [Github](https://github.com/acmesh-official/acme.sh/releases)


      ```
      wget https://github.com/acmesh-official/acme.sh/archive/2.8.5.tar.gz
      tar -xzvf 2.8.5.tar.gz
      cd acme.sh-2.8.5/
      ```

    * Install [acme.sh](https://github.com/acmesh-official)

      ```
      ./acme.sh --install
      ```

* Reopen a bash(or SSH) for root
  * `acme.sh` can be run without specifying PATH

* Set Default CA to [Let's Encrypt](https://letsencrypt.org/)
  * Starting from August-1st 2021, acme.sh uses [ZeroSSL](https://zerossl.com/) as default CA
  * Set default CA back to [Let's Encrypt](https://letsencrypt.org/)

    ```
    acme.sh --set-default-ca --server letsencrypt
    ```

* Issue Certs with Webroot Mode
  ```
  // -w is the web root dir
  // for a.com
  acme.sh --issue -d a.com -w /var/www/html --force

  // for www.a.com
  acme.sh --issue -d www.a.com -w /var/www/html --force
  ```

* Install the Certs
  ```
  // for a.com
  acme.sh --install-cert -d a.com \
  --key-file /usr/local/openssl/private/a.com/le.key \
  --fullchain-file /usr/local/openssl/certs/a.com/le.cer \
  --reloadcmd "systemctl restart nginx" \

  // for www.a.com
  acme.sh --install-cert -d www.a.com \
  --key-file /usr/local/openssl/private/www.a.com/le.key \
  --fullchain-file /usr/local/openssl/certs/www.a.com/le.cer \
  --reloadcmd "systemctl restart nginx" \

* Restart Nginx to Test Cert
  ```
  systemctl restart nginx
  ```

  * Goto [SSL Labs](https://www.ssllabs.com/ssltest/) to test the cert
  * Use Chrome, Firefox to view the cert

* Test Renew Script in `crontab`
  ```
  // Find the renew script in crontab
  crontab -l
  ```

  ```
  // Test the renew script with --force option
  "/root/.acme.sh"/acme.sh --cron --home "/root/.acme.sh" --force
  ```

## References
* [How to issue a cert](https://github.com/acmesh-official/acme.sh/wiki/How-to-issue-a-cert)
* [Privilege separation #2440](https://github.com/acmesh-official/acme.sh/issues/2440#issuecomment-536139894)
* [不能自动续期，请教该如何处理 #2062](https://github.com/acmesh-official/acme.sh/issues/2062#issuecomment-457890843)
* [Permission denied problem in standalone mode #2622](https://github.com/acmesh-official/acme.sh/issues/2622)
* [Can't run with sudo or as root #2124](https://github.com/acmesh-official/acme.sh/issues/2124)
* [权限与目录问题 #750](https://github.com/acmesh-official/acme.sh/issues/750)
* [通过(--standalone)方式安装证书 - 【续签】 #2449](https://github.com/acmesh-official/acme.sh/issues/2449)
* [无法自动更新证书 #1737](https://github.com/acmesh-official/acme.sh/issues/1737)

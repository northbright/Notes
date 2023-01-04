# Issue and Renew Let's Encrypt TLS Cert as Non-Root User for Nginx Virtual Host on Ubuntu

## Make sure Nginx is installed and setup properly
  * [Install Nginx and Setup Virtual Host on Ubuntu](https://github.com/northbright/Notes/blob/master/nginx/install-nginx-and-setup-virtual-host-on-ubuntu.md) 

## Create `letsencrypt` user to issue and renew TLS certs
* Add User

  ```
  sudo adduser letsencrypt
  ```

  ```
  // Make web root
  su - letsencrypt
  mkdir ~/webroot
  exit
  ```

* Modify `/etc/sudoers` to make `letsencrypt` user no password required when reload nginx

  ```
  sudo visudo
  ```

  ```
  letsencrypt ALL= NOPASSWD: /bin/systemctl reload nginx.service
  ```

* Add `rx` permissions for `/home/letsencrypt` dir(home of letsencrypt user)

  Nginx worker processes run as `www-data` and need `rx` permissions to read / write acme.sh challenge

  ```
  sudo chmod o+rx -R /home/letsencrypt
  ```

## Modify Nginx config(e.g. `/etc/nginx/conf.d/a.com.conf` to add [acme.sh](https://github.com/acmesh-official/acme.sh) challenge config
```
sudo vi /etc/nginx/conf.d/a.com.conf
```

```
server {
        listen       80;

        # Set server_name to your domain
        server_name  a.com;

        location / {
            # Set webroot to home(/var/www/html) of `www-data` user.
            # Nginx worker process is run as `www-data`.
            # Put public content to /var/www/html.
            root   /var/www/html;
            index  index.html index.htm;
        }

        # acme.sh challenge
        location ^~ /.well-known/acme-challenge/ {
            alias /home/letsencrypt/webroot/.well-known/acme-challenge/;
        }
}
```

## Global TLS Config for Nginx
* [Global TLS Config for Nginx](https://github.com/northbright/Notes/blob/master/nginx/global-tls-config-for-nginx.md)

## Install [acme.sh](https://github.com/acmesh-official/acme.sh) as `letsencrypt` user

* Switch user

  ```
  su - letsencrypt
  ```

* Clone code of `acme.sh`

  ```
  git clone https://github.com/acmesh-official/acme.sh.git
  ```

* Add path of `acme.sh` binary

  ```
  vi ~/.bashrc
  export PATH=$PATH:/home/letsencrypt/acme.sh
  ```

  ```
  source ~/.bashrc
  ```

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
  acme.sh --issue --log -d a.com -w ~/webroot --force


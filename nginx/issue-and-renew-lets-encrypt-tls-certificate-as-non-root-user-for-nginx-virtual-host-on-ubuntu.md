# Issue and Renew Let's Encrypt TLS Certificate as Non-Root User for Nginx Virtual Host on Ubuntu

## Make Sure Nginx is Installed and Setup Properly
  * [Install Nginx and Setup Virtual Host on Ubuntu](https://github.com/northbright/Notes/blob/master/nginx/install-nginx-and-setup-virtual-host-on-ubuntu.md) 

## Create `letsencrypt` User to Issue and Renew TLS Certificates
* Add User

  ```
  sudo adduser letsencrypt
  ```

* Make Web Root of `letsencrypt` User for [acme.sh](https://github.com/acmesh-official/acme.sh) Challenge

  ```
  su - letsencrypt
  mkdir ~/webroot
  exit
  ```
* Add `rx` Permissions for `/home/letsencrypt` Dir(Home of `letsencrypt` User)

  Nginx worker processes run as `www-data` and need `rx` permissions to read / write [acme.sh](https://github.com/acmesh-official/acme.sh) challenge

  ```
  sudo chmod o+rx -R /home/letsencrypt
  ```

* Modify `/etc/sudoers` to Make `letsencrypt` User No Password Required when Reload nginx

  ```
  sudo visudo
  ```

  ```
  letsencrypt ALL= NOPASSWD: /usr/sbin/service nginx force-reload
  ```

## Modify Nginx Config(e.g. `/etc/nginx/conf.d/a.com.conf` to Add [acme.sh](https://github.com/acmesh-official/acme.sh) Challenge Config
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

## Restart Nginx
```
sudo systemctl restart nginx
```

## Install [acme.sh](https://github.com/acmesh-official/acme.sh) as `letsencrypt` user

* Switch User

  ```
  su - letsencrypt
  ```

* Clone Code of `acme.sh`

  ```
  git clone https://github.com/acmesh-official/acme.sh.git
  ```

* Create `/home/letsencrypt/.acme.sh`

  If `/home/letsencrypt/.acme.sh` is NOT created you will get error when run `acme.sh --set-default-ca --server letsencrypt`:

  > touch: cannot touch '/home/letsencrypt/.acme.sh/account.conf': No such file or directory

  ```
  mkdir /home/letsencrypt/.acme.sh
  ```

* Add Path of `acme.sh` Binary

  ```
  vi ~/.bashrc
  export PATH=$PATH:/home/letsencrypt/acme.sh
  ```

  ```
  source ~/.bashrc
  ```

* Set Default CA to [Let's Encrypt](https://letsencrypt.org/)
  * Starting from August-1st 2021, acme.sh uses [ZeroSSL](https://zerossl.com/) as default CA
  * Set Default CA Back to [Let's Encrypt](https://letsencrypt.org/)

    ```
    acme.sh --set-default-ca --server letsencrypt
    ```

* Issue Certs with Webroot Mode

  ```
  // -w is the web root dir
  // for a.com
  acme.sh --issue --log -d a.com -w ~/webroot --force
  ```

* Make Dir to Store Certificates

  ```
  mkdir -p ~/certificates/a.com
  ```

* Install the Certificate

  ```
  // for a.com
  acme.sh --install-cert -d a.com \
  --certpath /home/letsencrypt/certificates/a.com/cert \
  --keypath /home/letsencrypt/certificates/a.com/key \
  --fullchainpath /home/letsencrypt/certificates/a.com/fullchain \
  --reloadcmd "sudo service nginx force-reload" \
  --debug 2
  ```

## Update Nginx Virtual Host Config

Switch user
```
exit
```

```
sudo vi /etc/nginx/conf.d/a.com.conf
```

```
server {
        listen       80;

        # Set server_name to your domain
        server_name  a.com;

        # Remove all settings for HTTP
        # Redirect HTTP to HTTPS
        return 302 https://$server_name$request_uri;
}

server {
        listen       443 ssl http2;
        server_name  a.com;

        ## Certificate and Key
        ssl_certificate /home/letsencrypt/certificates/a.com/fullchain;
        ssl_certificate_key /home/letsencrypt/certificates/a.com/key;

        location / {
            # Set webroot to home(/var/www/html) of `www-data` user.
            # Nginx worker process is run as `www-data`.
            # Put public content to /var/www/html.
            root   /var/www/html;
            index  index.html index.htm;

            # To redirect to other app(e.g. Golang app),
            # comment above root / index settings and uncomment below line.
            # proxy_pass http://localhost:8080;
        }

        # acme.sh challenge(HTTP-01 challenge)
        # supports redirection to HTTPS
        location ^~ /.well-known/acme-challenge/ {
            alias /home/letsencrypt/webroot/.well-known/acme-challenge/;
        }
}
```

## Restart Nginx to Test the Certificate

```
sudo service nginx force-reload
```

* Go to [SSL Labs](https://www.ssllabs.com/ssltest/) to test your website's certificate
* Use Chrome, Firefox to view the certificate

## Check crontab

cronjob to renew certificates should be installed automatically when install a
 certificate.

```
su - letsencrypt
```

```
crontab -l

// Output:
// 6 0 * * * "/home/letsencrypt/.acme.sh"/acme.sh --cron --home "/home/letsencrypt/.acme.sh" > /dev/null
```

If the output is: `no crontab for letsencrypt`, install cronjob manually:

```
acme.sh  --install-cronjob --debug 2
```

## Test to Renew the Certificate

Get the command in crontab:

```
crontab -l

// Output:
6 0 * * * "/home/letsencrypt/.acme.sh"/acme.sh --cron --home "/home/letsencrypt/.acme.sh" > /dev/null
```

Run the command with `--force` option to force `acme.sh` to renew certificate:

```
/home/letsencrypt/.acme.sh/acme.sh --cron --home /home/letsencrypt/.acme.sh --force 
```

## Check Installed / Renewed Certificates

```
acme.sh --list
```

Example output:

| Domain | KeyLength | SAN_Domains | CA | Created | Renew |
| :--: | :--: | :--: | :--: | :--: | :--: |
| a.com | "2048" | no | LetsEncrypt.org | 2023-01-05T08:48:43Z | 2023-03-05T08:48:43Z |

## References
* [Certificate from Let's Encrypt with Nginx and a non-root user](https://jereze.com/code/letsencrypt-acme-no-root/)
* [Nginx example](https://github.com/acmesh-official/acme.sh/wiki/%E8%AF%B4%E6%98%8E#nginx-example)
* [HTTP-01 challenge](https://letsencrypt.org/docs/challenge-types/)
* [没有crontab 会自动更新吗? #2435](https://github.com/acmesh-official/acme.sh/issues/2435)

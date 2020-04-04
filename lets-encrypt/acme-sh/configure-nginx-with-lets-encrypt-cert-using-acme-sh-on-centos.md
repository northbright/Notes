# Configure Nginx with Let's Encrypt Cert Using acme.sh on CentOS

## Install Nginx
* [Install Latest Nginx from Source on CentOS](https://github.com/northbright/Notes/blob/master/nginx/install-latest-nginx-from-source-on-centos.md) 

## Configure Self-Signed SSL Cert
* [Configure Self-Signed SSL Certificate for Nginx on CentOS](https://github.com/northbright/Notes/blob/master/nginx/configure-self-signed-ssl-certificate-for-nginx-on-centos.md) 

## Switch to `root`
Issue cert, copy key and cert, cmd to restart nginx all need permission, it's better to install and run acme.sh with root.

```
// Switch to root
sudo su -
```

## Download latest [acme.sh](https://github.com/acmesh-official) from [Github](https://github.com/acmesh-official/acme.sh/releases)
```
wget https://github.com/acmesh-official/acme.sh/archive/2.8.5.tar.gz
tar -xzvf 2.8.5.tar.gz
cd acme.sh-2.8.5/
```

## Install [acme.sh](https://github.com/acmesh-official)
```
./acme.sh --install
```

## Issue a Cert with Webroot Mode
```
// -w is the web root dir
acme.sh --issue -d mysite.com -w /var/www/wordpress/ --force
```

## Install the Cert
```
acme.sh --install-cert -d mysite.com \
--key-file /usr/local/openssl/private/le.key \
--fullchain-file /usr/local/openssl/certs/le.cert \
--reloadcmd "systemctl restart nginx"
```

## Create a conf file(`le.conf`) for Let's Encrpyt Cert
* Create `le.conf` from `self-signed.conf`
```
sudo cp /usr/local/nginx/conf/self-signed.conf /usr/local/nginx/conf/le.conf
```

* Modify `ssl_certificate` and `ssl_certificate_key`
```
## Certificate and Key
ssl_certificate /usr/local/openssl/certs/le.cert;
ssl_certificate_key /usr/local/openssl/private/le.key;

## Protocols
ssl_protocols TLSv1.2 TLSv1.3;

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

## Include `le.conf` in `nginx.conf` and remove `self-signed.conf`
```
server {
    listen       443 ssl http2;
    server_name  mysite.com;
    root   /var/www/wordpress;

    # include SSL certificate settings
    #include /usr/local/nginx/conf/self-signed.conf;
    include /usr/local/nginx/conf/le.conf;

    ......
}
```

## Restart Nginx to Test Cert
```
systemctl restart nginx
```

* Goto [SSL Labs](https://www.ssllabs.com/ssltest/) to test the cert
* Use Chrome, Firefox to view the cert

## Test Renew Script in `crontab`
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

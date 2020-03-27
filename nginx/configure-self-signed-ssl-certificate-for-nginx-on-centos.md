# Configure Self-Signed SSL Certificate for Nginx on CentOS

## Supported CentOS versions
* CentOS 7
* CentOS 8

## Install Nginx from Source(optional) 
* [Install Latest Nginx from Source on CentOS](install-latest-nginx-from-source-on-centos.md)

## Create key and x.509 certificate
```
sudo openssl req \
-x509 \
-nodes \
-days 365 \
-newkey rsa:4096 \
-keyout /usr/local/openssl/private/nginx-selfsigned.key \
-out /usr/local/openssl/certs/nginx-selfsigned.crt \
```
| Subcommand / Option | Description |
| :--: | :--: |
| req | This subcommand specifies that we want to use X.509 certificate signing request (CSR) management. |
| -x509 | Make a self-signed certificate instead of generating a certificate signing request(CSR). |
| -nodes | Skip the option to secure our certificate with a passphrase so that Nginx can read the file, without user intervention. |
| -days 365 | The length of time that the certificate is valid. |
| -newkey rsa:4096 | Generate a new certificate and a new key at the same time(RSA Key that is 4096 bits) |
| -keyout | Path of the output private key |
| -out | Path of the output certificate |


You'll be asked to fill additional information such as country, city, organization...

## Show the content(text) of the certificate
```
openssl x509 \
-in /usr/local/openssl/certs/nginx-selfsigned.crt \
-text \
```

## Create Diffie-Hellman Group
Diffie-Hellman Group is used in negotiating [Perfect Forward Secrecy](https://en.wikipedia.org/wiki/Forward_secrecy) with clients.

```
sudo openssl dhparam \
-out /usr/local/openssl/certs/dhparam.pem 2048
```

Please note, it'll take a long time(a few minutes) if key size >= 4096(but recommended).

## Create `self-signed.conf`
```
sudo vi /usr/local/nginx/conf/self-signed.conf
```

```
## Certificate and Key
ssl_certificate /usr/local/openssl/certs/nginx-selfsigned.crt;
ssl_certificate_key /usr/local/openssl/private/nginx-selfsigned.key;

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

## Modify `nginx.conf`
```
sudo vi /usr/local/nginx/conf/nginx.conf
```

```
server {
        listen       80;
        server_name  YOUR_DOMAIN_OR_IP;

        # Redirect HTTP to HTTPS
        return 302 https://$server_name$request_uri;
        ......
}

server {
        listen       443 ssl http2;
        server_name  YOUR_DOMAIN_OR_IP;

        # include SSL certificate settings
        include /usr/local/nginx/conf/self-signed.conf;

        location / {
            root   html;
            index  index.html index.htm;
        }
        ......
}
```

## Configure Firewall(optional)
* [Configure Firewall to Enable HTTP Service on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/CentOS/network/Configure_Firewall_to_Enable_HTTP_Service_on_CentOS_7.md)

## Check
* Use latest Firefox or Chrome to visit your site
* Accept the risk and go on
* View the certificate details

## References
* [Install Latest Nginx from Source on CentOS](install-latest-nginx-from-source-on-centos.md)
* [How To Create a Self-Signed SSL Certificate for Nginx in Ubuntu 16.04](https://www.digitalocean.com/community/tutorials/how-to-create-a-self-signed-ssl-certificate-for-nginx-in-ubuntu-16-04)
* [How do you score A+ with 100 on all categories on SSL Labs test with Let's Encrypt and Nginx?](https://stackoverflow.com/questions/41930060/how-do-you-score-a-with-100-on-all-categories-on-ssl-labs-test-with-lets-encry)
* [Nginx + TLS 1.3 如何设置默认 AES_128_GCM？](https://www.v2ex.com/t/547650)

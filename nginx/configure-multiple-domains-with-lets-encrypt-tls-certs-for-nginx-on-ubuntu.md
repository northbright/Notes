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

## Config Nginx Virtual Host and Issue Let's Encrypt Certificate for `a.com` and `www.a.com`
* [Issue and Renew Let's Encrypt TLS Certificate as Non-Root User for Nginx Virtual Host on Ubuntu](https://github.com/northbright/Notes/blob/master/nginx/issue-and-renew-lets-encrypt-tls-certificate-as-non-root-user-for-nginx-virtual-host-on-ubuntu.md)

## References
* [How to issue a cert](https://github.com/acmesh-official/acme.sh/wiki/How-to-issue-a-cert)
* [Privilege separation #2440](https://github.com/acmesh-official/acme.sh/issues/2440#issuecomment-536139894)
* [不能自动续期，请教该如何处理 #2062](https://github.com/acmesh-official/acme.sh/issues/2062#issuecomment-457890843)
* [Permission denied problem in standalone mode #2622](https://github.com/acmesh-official/acme.sh/issues/2622)
* [Can't run with sudo or as root #2124](https://github.com/acmesh-official/acme.sh/issues/2124)
* [权限与目录问题 #750](https://github.com/acmesh-official/acme.sh/issues/750)
* [通过(--standalone)方式安装证书 - 【续签】 #2449](https://github.com/acmesh-official/acme.sh/issues/2449)
* [无法自动更新证书 #1737](https://github.com/acmesh-official/acme.sh/issues/1737)

# Can Not Find Nginx conf When Issue a Cert Using acme.sh

## Problem
* [Install Latest Nginx from Source on CentOS](https://github.com/northbright/Notes/blob/master/nginx/install-latest-nginx-from-source-on-centos.md)
* Run `acme.sh --issue -d mydomain.com --nginx`
* Got error:
   ```
  Can not find nginx conf
  ```
 
## Root Cause
* acme.sh runs `nginx -V` and grep `--conf-path=XX` to get the configuration file path:
  ```
  NGINX_CONF="$(nginx -V 2>&1 | _egrep_o "--conf-path=[^ ]* " | tr -d " ")"
  ```
* Check [acme.sh](https://github.com/acmesh-official/acme.sh/blob/2.8.5/acme.sh#L2865) for more information

## Solution
* Add `--conf-path=XX` while configure Nginx


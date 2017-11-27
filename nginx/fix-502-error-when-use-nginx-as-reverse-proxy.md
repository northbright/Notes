# Fix 502 Error when Use Nginx as Reverse Proxy

#### Details
* We use nginx as reverse proxy for API server.
* After configured `/etc/nginx/nginx.conf`, we get 502 error when access `/api/xx`.
* Eample `nginx.conf`:

        server {
            listen 80;
            server_name localhost;

            location /api {
                proxy_pass http://192.168.1.xx:8000;
            }
        }


#### Root Cause
* SELinux permission denied.
Check the logs of nginx:

        connect() to [::1]:8000 failed (13: Permission denied) while connecting to upstream 

#### Solution
* See [Configure SELinux to Fix 403 Forbidden Error of Nginx on CentOS 7](https://github.com/northbright/Notes/blob/master/nginx/configure-selinux-to-fix-403-forbidden-error-of-nginx-on-centos.md).

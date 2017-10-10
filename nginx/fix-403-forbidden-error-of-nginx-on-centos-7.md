# Fix 403 Forbidden Error of Nginx on CentOS 7

#### There're 2 Root Causes may cause 403 forbidden error
1. The nginx user which owns nginx worker process has **NO** `rx` attributes on **ALL** dirs of server root.
2. SELinux Polices.

#### How to determine the root cause?
Check if **"open()"** exists in the error messages in `/var/log/nginx/error.log`:

* **NO "open()"** --> Root Cause 1: The nginx user which owns nginx worker process has **NO** `rx` attributes on **ALL** dirs of server root.
 
        [error] 20491#0: *1 "/var/www/html/index.html" is forbidden (13: Permission denied), client: ::1, server: _, request: "GET / HTTP/1.1", host: "localhost"

* **Has "open()"** --> Root Cause 2: SELinux Polices".
        
        [error] 20491#0: *2 open() "/home/xx/html/index.html" failed (13: Permission denied), client: ::1, server: _, request: "GET / HTTP/1.1", host: "localhost"

#### Solution for Root Cause 1
* Make sure Nginx user has `rx` attributes on **ALL** dirs(include TOP dir) of server root.
  See [Install and Configure Nginx on CentOS 7](https://github.com/northbright/Notes/blob/master/nginx/install-and-configure-nginx-on-centos-7.md).

#### Solution for Root Cause 2
* See [Configure SELinux to Fix 403 Forbidden Error of Nginx on CentOS 7](https://github.com/northbright/Notes/blob/master/nginx/configure-selinux-to-fix-403-forbidden-error-of-nginx-on-centos.md).


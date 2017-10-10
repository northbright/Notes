# Fix 403 Forbidden Error of Nginx on CentOS 7

#### Problem
* It occurs 403(Forbidden) error when access Nginx on CentOS 7.

##### Details
* CentOS 7 1708 minimal.
* Nginx is installed via yum.
* It works well by default.
* It occurs occurs 403(Forbidden) error if we just move default server root from `/usr/share/nginx/html` to `/var/www/html`.

    * Copy `/usr/share/nginx/html` to `/var/www/html`:
      * `sudo mkdir /var/www`
      * `sudo cp /usr/share/nginx/html /var/www/ -r`

    * Update `/etc/nginx/nginx.conf`:

              ......
              # Default user is nginx
              user nginx;
              ......

              server {
                  ......
                  #root         /usr/share/nginx/html;
                  root         /var/www/html;
                  ......

* Nginx service is run as `nginx` user(default setting).

#### Root Cause
* SELinux Policies.

#### How to Fix
* We need `audit2allow` tool.

        yum provides audit2allow
        // Output: 
        // policycoreutils-python-2.5-17.1.el7.x86_64 : SELinux policy core python utilities

        sudo yum install -y policycoreutils-python

* Generate and apply a module package with dontaudit rules for Nginx.
 
  1. Check audit.log:
    
              sudo cat /var/log/audit/audit.log | grep nginx | grep denied
    
              // You may find messages like:
              type=AVC msg=audit(1506398841.964:345): avc:  denied  { getattr } for  pid=20510 comm="nginx" path="/var/www/html/index.html" dev="dm-0" ino=635249 scontext=system_u:system_r:httpd_t:s0 tcontext=unconfined_u:object_r:var_t:s0 tclass=file

  2. Generate a module package:
    
              sudo cat /var/log/audit/audit.log | grep nginx | grep denied | sudo audit2allow -M nginx
    
  3. Apply the module package:
    
              sudo semodule -i nginx.pp

  4. Test if it works

              curl localhost

  5. If it still occurs 403 forbiddden error, **Repeat step 1 - 4** until it return 200 OK.
      * You may find a new error message after run `sudo cat /var/log/audit/audit.log | grep nginx | grep denied`
      * It may need repeat **3 times** on CentOS 7 1708 because there're **3 different SELinux Policies**.


#### References
* [8.3.8. Allowing Access: audit2allow](https://access.redhat.com/documentation/en-US/Red_Hat_Enterprise_Linux/6/html/Security-Enhanced_Linux/sect-Security-Enhanced_Linux-Fixing_Problems-Allowing_Access_audit2allow.html)
* [centos7 中关于 nginx 的权限问题](https://www.v2ex.com/t/171804)



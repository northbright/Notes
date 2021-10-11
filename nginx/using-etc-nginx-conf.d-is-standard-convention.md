# Using `/etc/nginx/conf.d` is Standard Convention

## Problem
* Not sure where to put nginx configuration file on Ubuntu
  * `/etc/nginx/sites-available`
  * `/etc/nginx/sites-enabled`
  * `/etc/nginx/conf.d`
* Can not find `/etc/nginx/sites-available` and `/etc/nginx/sites-enabled` on CentOS

## Solution
Use `/etc/nginx/conf.d`

Using `/etc/nginx/conf.d` is standard convention and works on both Ubuntu and CentOS.

* Remove `include /etc/nginx/sites-enabled/*` in `/etc/nginx.conf`
* Add `include /etc/nginx/conf.d/*.conf`
* Put virtual host config file in `/etc/nginx/conf.d/YOUR_SITE.conf`
* If you want to disable the site but keep site configuration, you can add suffix to the file name because only `*.conf` will be included. e.g. `/etc/nginx.conf.d/YOUR_SITE.conf.disabled`

## References
* [Difference in sites-available vs sites-enabled vs conf.d directories (Nginx)?](https://serverfault.com/questions/527630/difference-in-sites-available-vs-sites-enabled-vs-conf-d-directories-nginx)

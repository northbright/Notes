# Configure Nginx to Block Running PHP Files in WordPress Subdirs

## Problem
* Permit running PHP files in WordPress sub-dirs(`wp-includes`, `wp-content`, `uploads`) is dangerous

## Solution

```
sudo vi /usr/local/nginx/conf/nginx.cof
```

Put these lines in `server` block

```
        # Block running PHP files in Wordpress's includes / content / uploads dirs.
        location ~* /wp-includes/.*.php$ {
                deny all;
                access_log off;
                log_not_found off;
        }

        location ~* /wp-content/.*.php$ {
                deny all;
                access_log off;
                log_not_found off;
        }

        location ~* /(?:uploads|files)/.*.php$ {
                deny all;
                access_log off;
                log_not_found off;
        }

        # Block access to xmlrpc.php.
        location = /xmlrpc.php {
                deny all;
                access_log off;
                log_not_found off;
        }

``` 

## References
* [Block access to PHP files on your WordPress site with Nginx](https://www.bjornjohansen.com/block-access-to-php-files-with-nginx)

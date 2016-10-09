# Include .htaccess File in httpd.conf

#### Purpose
* Set `AllowOverride None` in `httpd.conf` to avoid apache scanning directories to load `.htaccess` files.
* Include specified `.htaccess` files.

#### Steps
* Make sure `AllowOverride None`(by default) in `httpd.conf`
* Find your `<VirtualHost xx>` settings, add `Include xx/.htaccess` in `<Directory xx> </Directory>`

        ## Example: to disable xmlrpc.xml to fix Wordpress XMLRPC vunerability.

        <VirtualHost *:80>
            ServerAdmin admin@mysite.com
            DocumentRoot /var/www/mysite/wordpress
            ServerName mysite.com
            ServerAlias www.mysite.com
            ErrorLog /var/log/httpd/mysite_err.log
            <Directory /var/www/mysite/wordpress>
                AllowOverride None
                Include /var/www/mysite/wordpress/.htaccess
            </Directory>
        </VirtualHost>


        ## wordpress/.htaccess file

        # protect xmlrpc

        <Files xmlrpc.php>
        Order Deny,Allow
        Deny from all
        </Files>

#### References
* [Speed up Apache by including htaccess files into httpd.conf](http://www.g-loaded.eu/2011/11/28/speed-up-apache-by-including-htaccess-files-into-httpd-conf/)
* [3 Small Tweaks to make Apache fly](http://www.jeffgeerling.com/blog/3-small-tweaks-make-apache-fly)


        

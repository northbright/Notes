# Wordpress Needs FTP Credentials to Install Plugins

## Problem
* Installed and configured PHP / Nginx to run Wordpress
* Run `chown -R /var/www/wordpress` for the web root dir
* Got message when install plugin:

  ```
  Wordpress needs FTP credentials...
  ```

## Root Cause
PHP files under Web root dir has no execution permission even for owner.

## Solution
```
sudo chmod 755 -R /var/www/wordpress
```

## References
* [WordPress needs the FTP credentials to update plugins](https://stackoverflow.com/questions/30688431/wordpress-needs-the-ftp-credentials-to-update-plugins)

# Fix WP-Clone Timeout

#### Problem
* There's no response when WP-Clone creates backup for a large Wordpress site(.zip file > 300MB).

#### Root Cause
* PHP max execution time < WP-Clone execution time

#### How to fix
* Increase `max_execution_time` in `/etc/php.ini`

        sudo vi /etc/php.ini

        // Unit is seconds
        max_execution_time = 900

#### References
* [How to increase apache timeout directive in .htaccess?](http://stackoverflow.com/questions/9629566/how-to-increase-apache-timeout-directive-in-htaccess)
* [How to increase the execution timeout in php?](http://stackoverflow.com/questions/3829403/how-to-increase-the-execution-timeout-in-php)

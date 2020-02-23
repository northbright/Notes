# Install PHP from Source on CentOS 7

## Install Dependencies
* "Development Tools"

      sudo yum group install -y "Development Tools"

* 3rd Party Packages provided by yum

      sudo yum install -y bison

* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md) 
      * It'll install latest zlib to a new path: `/usr/local/zlib` which is the value of `--with-zlib-dir` option

* [OpenSSL](https://www.openssl.org/)
   * [Install Latest Release of OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos.md)
   * It'll install latest OpenSSL to a new path: `/usr/local/openssl` which is the value of `--with-openssl-dir` option

* [cURL](https://curl.haxx.se/)
   * [Install Latest cURL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/curl/install-latest-curl-from-source-on-centos-7.md) 
   * It'll install latest cURL to a new path: `/usr/local/curl` which is the value of `--with-curl`

* [libxml2](http://www.xmlsoft.org)
  * [Install libxml2 from Source on CentOS 7](https://github.com/northbright/Notes/blob/38198dcc848ae729c6e61627c1797044b84f13b1/libxml2/install-libxml2-from-source-on-centos7.md)

* [libgd](https://libgd.github.io/)
   * [Install libgd from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/libgd/install-libgd-from-source-on-centos7.md)

* [libiconv](https://www.gnu.org/software/libiconv/)
  * [Install libiconv from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/libiconv/install-libiconv-from-source-on-centos7.md)

## Install [Nginx](https://nginx.org)(optional)
* [Install Latest Nginx from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/nginx/install-latest-nginx-from-source-on-centos-7.md)
   * Nginx worker process will be run as `nobody`(user and group) which are the values of `--with-fpm-user` and `--with-fpm-group` 

## Install [MariaDB](https://mariadb.org/)(optional)
 * [Install MariaDB from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/mariadb/install-mariadb-from-source-on-centos7.md) 
    * Unix Socket path: `/tmp/mysql.sock` which is the value of `--with-mysql-sock` 

## Get Source
* Download latest stable release on [official site](https://www.php.net/downloads.php) or [github](https://github.com/php/php-src/releases)

       cd download
       wget https://github.com/php/php-src/archive/php-7.3.8.tar.gz
       tar -xzvf php-7.3.8.tar.gz
       cd php-src-php-7.3.8

## Configure
* Generate Configue File
    
       ./buildconf --force

* Configure

       ./configure \
       --prefix=/usr/local/php \
       --enable-fpm \
       --with-fpm-user=nobody \
       --with-fpm-group=nobody \
       --enable-mysqlnd \
       --with-pdo-mysql=mysqlnd \
       --with-mysqli=mysqlnd \
       --with-mysql-sock=/tmp/mysql.sock \
       --with-zlib-dir=/usr/local/zlib \
       --with-openssl-dir=/usr/local/openssl \
       --with-curl=/usr/local/curl \
       --with-jpeg-dir=/usr/local/libjpeg \
       --with-png-dir=/usr/local/libpng \
       --with-webp-dir=/usr/local/libwebp \
       --with-gd=/usr/local/libgd \
       --with-libxml-dir=/usr/local/libxml2 \
       --with-iconv-dir=/usr/local/libiconv \
       \
       --enable-mbstring \
       --enable-opcache \
       --disable-fileinfo \
       --disable-rpath \

## Make and Install

    make
    make test
    sudo make install

## Add New Binary Path of cURL
* `sudo vi /etc/profile`

       # Append these lines:
       # Use New Version of php
       export PATH=/usr/local/php/bin:/usr/local/php/sbin/:$PATH

* `source /etc/profile`

## Create Directories and Set Owner if using Unix Socket(Optional)
If Using Unix socket instead of TCP socket(by default) to communicate with Nginx, need to create dirs and config file.

* Create `/var/run/php-fpm/` to store php-fpm related files. e.g. PID, sock, log...

      sudo mkdir -p /var/run/php-fpm
      sudo chown -R nobody:nobody /var/run/php-fpm

* Create `vi /usr/lib/tmpfiles.d/php-fpm.conf` to create `/var/run/php-fpm` after each reboots.
  
      sudo vi /usr/lib/tmpfiles.d/php-fpm.conf

      // Copy this line
      d /var/run/php-fpm 0755 nobody nobody -

## Configuration Files
* `php.ini`
  * Copy File

    Copy `php.ini` from source dir to `--with-config-file-path` specified in `./configure`.
    It's `PREFIX/lib` by default(e.g. `/usr/local/php/lib`).

        sudo cp php.ini-production /usr/local/php/lib/php.ini

  * Set session save path
    
        session.save_path = "/tmp"

  * Set `max_execution_time`

        ; set max execution time(in seconds)
        max_execution_time=300

* `php-fpm.conf`
  * Copy File

    php-fpm will search `php-fpm.conf` in `--sysconfdir` specified in `./configure`.
    It's `PREFIX/etc` by default(e.g. `/usr/local/php/etc`).

        sudo cp /usr/local/php/etc/php-fpm.conf.default /usr/local/php/etc/php-fpm.conf

* `www.conf`
  * Copy File

    Goto last line of `php-fpm.conf` to check include relative path for *.conf:

        ; For example in this case
        include=/usr/local/php/etc/php-fpm.d/*.conf

        ; Copy file
        sudo cp /usr/local/php/etc/php-fpm.d/www.conf.default /usr/local/php/etc/php-fpm.d/www.conf

  * Configure

        ; Unix user/group of processes
        ; user and group should be the same as nginx's
        user = nobody
        group = nobody

        ; Listen on unix socket or tcp socket
        ; Option A: listen on a TCP socket(by default).
        listen = 127.0.0.1:9000

        ; Option B: listen on a unix socket if php-fpm and nginx are on the same server
        ;listen = /var/run/php-fpm/php-fpm.sock

        ;Set permissions for unix socket...
        ;listen.owner = nobody
        ;listen.group = nobody
        ;listen.mode = 0660

## Configure `php-fpm` as systemd Service
* Create systemd unit file

      sudo vi /etc/systemd/system/php-fpm.service

      [Unit]
      Description=The PHP 7 FastCGI Process Manager
      After=network.target

      [Service]
      Type=simple
      PIDFile=/var/run/php-fpm/php-fpm.pid
      ExecStart=/usr/local/php/sbin/php-fpm --nodaemonize --fpm-config /usr/local/php/etc/php-fpm.conf
      ExecReload=/bin/kill -USR2 $MAINPID

      [Install]
      WantedBy=multi-user.target

* Enable and Start `php-fpm.service`

      sudo systemctl enable php-fpm
      sudo systemctl start php-fpm
      sudo systemctl status php-fpm

* Check

      ps aux | grep php-fpm

      // check process and user
      root ...... php-fpm: master process (/usr/local/php/etc/php-fpm.conf)
      nobody ...... php-fpm: pool www
      nobody ...... php-fpm: pool www

## References
* [2015博客升级记(五)：CentOS 7.1编译安装PHP7](https://typecodes.com/web/centos7compilephp7.html)

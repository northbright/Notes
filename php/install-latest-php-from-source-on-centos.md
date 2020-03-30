# Install PHP from Source on CentOS

## PHP Versions
* 7.4.4

## Tested CentOS Versions
* CentOS 8

## Install Dependencies
* "Development Tools"

      sudo yum group install -y "Development Tools"

* 3rd Party Packages provided by yum

      sudo yum install -y bison

* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md) 

* [OpenSSL](https://www.openssl.org/)
   * [Install Latest Release of OpenSSL from Source on CentOS](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos.md)

* [cURL](https://curl.haxx.se/)
   * [Install Latest cURL from Source on CentOS](https://github.com/northbright/Notes/blob/master/curl/install-latest-curl-from-source-on-centos.md) 

* [libxml2](http://www.xmlsoft.org)
  * [Install libxml2 from Source on CentOS](https://github.com/northbright/Notes/blob/master/libxml2/install-libxml2-from-source-on-centos.md)

* [libXpm](https://www.x.org/wiki/Releases/Download/)
  * [Install libXpm on CentOS 7](https://github.com/northbright/Notes/blob/master/libxpm/install-libxpm-devel-on-centos7.md)

* [libpng](http://www.libpng.org/pub/png/libpng.html)
   * [Install libpng from Source on CentOS](https://github.com/northbright/Notes/blob/master/libpng/install-libpng-from-source-on-centos.md)

* [libjpeg](http://www.ijg.org/)
   * [Install libjpeg from Source on CentOS](https://github.com/northbright/Notes/blob/master/libjpeg/install-latest-libjpeg-on-centos.md)

* [WebP](https://github.com/webmproject/libwebp)
   * [Install WebP from Source on CentOS](https://github.com/northbright/Notes/blob/master/webp/install-webp-from-source-on-centos.md)

* [pcre2](http://www.pcre.org/)
  * [Install Latest PCRE2 from Source on CentOS](https://github.com/northbright/Notes/blob/master/pcre/install-latest-pcre2-from-source-on-centos.md)

* [oniguruma](https://github.com/kkos/oniguruma)
  * [Install oniguruma from Source on CentOS](https://github.com/northbright/Notes/blob/master/oniguruma/install-oniguruma-from-source-on-centos.md)

## Install [Nginx](https://nginx.org)(optional)
* [Install Latest Nginx from Source on CentOS](https://github.com/northbright/Notes/blob/master/nginx/install-latest-nginx-from-source-on-centos.md)
   * Nginx worker process will be run as `nobody`(user and group) which are the values of `--with-fpm-user` and `--with-fpm-group` 

## Install [MariaDB](https://mariadb.org/)(optional)
 * [Install MariaDB from Source on CentOS](https://github.com/northbright/Notes/blob/master/mariadb/install-mariadb-from-source-on-centos.md) 
    * Unix Socket path: `/tmp/mysql.sock` which is the value of `--with-mysql-sock` 

## Get Source

Download latest stable release on [official site](https://www.php.net/downloads.php) or [github](https://github.com/php/php-src/releases)

```
wget https://github.com/php/php-src/archive/php-7.4.4.tar.gz
tar -xzvf php-7.4.4.tar.gz
cd php-src-php-7.4.4
```

## Configure
```
./buildconf --force
```

```
PKG_CONFIG_PATH=/usr/local/openssl/lib/pkgconfig/:/usr/local/sqlite/lib/pkgconfig/:/usr/local/zlib/lib/pkgconfig/:/usr/local/curl/lib/pkgconfig/:/usr/local/libpng/lib/pkgconfig/:/usr/local/oniguruma/lib/pkgconfig/:/usr/local/libxml2/lib/pkgconfig/:/usr/local/libgd/lib/pkgconfig/:/usr/local/pcre2/lib/pkgconfig/:/usr/local/libwebp/lib/pkgconfig/:/usr/local/libjpeg/lib/pkgconfig/ \
./configure \
--prefix=/usr/local/php \
--enable-fpm \
--with-fpm-user=nobody \
--with-fpm-group=nobody \
--enable-mysqlnd \
--with-pdo-mysql=mysqlnd \
--with-mysqli=mysqlnd \
--with-mysql-sock=/tmp/mysql.sock \
--with-zlib \
--with-zlib-dir=/usr/local/zlib \
--with-openssl \
--with-openssl-dir=/usr/local/openssl \
--with-system-ciphers \
--with-curl \
--with-libxml \
--enable-gd \
--with-jpeg \
--with-webp \
--with-xpm \
--with-external-pcre \
--enable-mbstring \
--enable-opcache \
--disable-fileinfo \
```

## Make and Install
```
make
make test
sudo make install
```

## Add New Binary Path of cURL
```
sudo vi /etc/profile
```

```
# Append these lines:
# Use New Version of php
export PATH=/usr/local/php/bin:/usr/local/php/sbin/:$PATH
```

```
source /etc/profile
```

## Check RPATH and linked libraries
```
readelf -d /usr/local/php/sbin/php-fpm
ldd /usr/local/php/sbin/php-fpm
```

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

        sudo vi /usr/local/php/etc/php-fpm.d/www.conf

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
* [Other Changes](https://www.php.net/manual/en/migration74.other-changes.php)

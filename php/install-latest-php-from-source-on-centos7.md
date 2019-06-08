# Install PHP from Source on CentOS 7

## Install Dependencies
* "Development Tools"

      sudo yum group install -y "Development Tools"

* 3rd Party Packages provided by yum

      sudo yum install -y bison libxml2-devel

* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md) 
      * It'll install latest zlib to a new path: `/usr/local/zlib` which is the value of `--with-zlib-dir` option

* [OpenSSL](https://www.openssl.org/)
   * [Install Latest Release of OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos-7.md)
   * It'll install latest OpenSSL to a new path: `/usr/local/openssl` which is the value of `--with-openssl-dir` option

* [cURL](https://curl.haxx.se/)
   * [Install Latest cURL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/curl/install-latest-curl-from-source-on-centos-7.md) 
   * It'll install latest cURL to a new path: `/usr/local/curl` which is the value of `--with-curl`

## Install [Nginx](https://nginx.org)(optional)
* [Install Latest Nginx from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/nginx/install-latest-nginx-from-source-on-centos-7.md)
   * Nginx worker process will be run as `nobody`(user and group) which are the values of `--with-fpm-user` and `--with-fpm-group` 

## Install [MariaDB](https://mariadb.org/)(optional)
 * [Install MariaDB from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/mariadb/install-mariadb-from-source-on-centos7.md) 
    * Unix Socket path: `/tmp/mysql.sock` which is the value of `--with-mysql-sock` 

## Get Source
* Download latest stable release on <https://github.com/php/php-src/releases>

       cd download
       wget https://github.com/php/php-src/archive/php-7.3.4.tar.gz
       tar -xzvf php-7.3.4.tar.gz
       cd php-src-php-7.3.4

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
       \
       --enable-mbstring \
       --enable-opcache \
       --disable-fileinfo \
       --disable-rpath \

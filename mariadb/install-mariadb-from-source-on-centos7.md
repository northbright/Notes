# Install MariaDB from Source on CentOS 7

## Create `mysql`Group and User
```
// Check if `mysql` group exists
grep mysql /etc/group

// Create `mysql` group
sudo groupadd mysql

// Check if `mysql` user exists
grep mysql /etc/passwd

// create `mysql` user with these options:
// * group: mysql
// * no home dir
// * no login
sudo useradd mysql -g mysql -M -s /sbin/nologin
```

## Create MariaDB Directories
```
// Create data dir
// Used to set the value of `-DMYSQL_DATADIR`
sudo mkdir -p /var/lib/mysql

// Set owner of data dir
sudo chown -R mysql:mysql /var/lib/mysql
```

## Install Dependencies
* "Development Tools"

      sudo yum group install -y "Development Tools"

* 3rd Party Packages provided by yum

      sudo yum install -y ncurses-devel  bison libxml2-devel libevent-devel

* [CMake](https://cmake.org)
   * Download latest release on https://github.com/Kitware/CMake/releases
   
         cd ~/download
         wget https://github.com/Kitware/CMake/releases/download/v3.13.4/cmake-3.13.4.tar.gz
         tar -xzvf cmake-3.13.4.tar.gz
         cd cmake-3.13.4

   * Configure, compile and install
      
         ./configure
         gmake
         sudo make install

         // Check version
         cmake --version
      
* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md) 
      It'll install latest zlib to a new path: `/usr/local/zlib` which is the value of [`-DWITH_ZLIB`](https://github.com/MariaDB/server/blob/10.3/cmake/zlib.cmake#L37) option for `cmake`

* [OpenSSL](https://www.openssl.org/)
   * [Install Latest Release of OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos-7.md)
   
      It'll install latest OpenSSL to a new path: `/usr/local/openssl` which is the value of [`-DWITH_SSL`](https://github.com/MariaDB/server/blob/10.3/cmake/ssl.cmake#L23) option for `cmake`

## Get Latest Source Code
Download latest release on <https://downloads.mariadb.org/>

    cd ~/download
    wget https://downloads.mariadb.org/interstitial/mariadb-10.3.13/source/mariadb-10.3.13.tar.gz/from/http%3A//mirrors.tuna.tsinghua.edu.cn/mariadb/ -O mariadb-10.3.13.tar.gz
    tar -xzvf mariadb-10.3.13.tar.gz
    cd server-mariadb-10.3.13

## Configure

    // Remove `CMakeCache.text` if it exists
    rm CMakeCache.txt

    cmake . \
    -DWITH_SSL=/usr/local/openssl \
    -DWITH_ZLIB=1 \
    -DZLIB_INCLUDE_DIR=/usr/local/zlib \
    -DCMAKE_INSTALL_PREFIX=/usr/local/mysql \
    -DDEFAULT_CHARSET=utf8 \
    -DDEFAULT_COLLATION=utf8_general_ci \
    -DEXTRA_CHARSETS=all \
    -DSYSCONFDIR=/etc \
    -DWITH_INNOBASE_STORAGE_ENGINE=1 \
    -DWITH_MYISAM_STORAGE_ENGINE=1 \
    -DWITHOUT_TOKUDB=1 \
    -DWITH_READLINE=1 \
    \
    -DMYSQL_DATADIR=/var/lib/mysql \
    -DMYSQL_USER=mysql \
    -DMYSQL_UNIX_ADDR=/tmp/mysql.sock \

## Make & Make Install

    make
    sudo make install

## Add New Binary Path of MariaDB
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of MariaDB
      export PATH=/usr/local/mysql/bin:$PATH

* `source /etc/profile`

## Configure `/etc/my.cnf`

    // Backup old my.cnf
    sudo cp /etc/my.cnf /etc/my.cnf.bak

    sudo vi /etc/my.cnf

    // Goto [mysqld] section, and set datadir, socket and bind-address
    [mysqld]
    datadir=/var/lib/mysql
    socket=/tmp/mysql.sock
    bind-address=127.0.0.1
        
## Initialize MariaDB

    sudo /usr/local/mysql/scripts/mysql_install_db --user=mysql --basedir=/usr/local/mysql/  --datadir=/var/lib/mysql

## Configure `mysqld` as a `systemd` Service
* Copy `mysql.server` to `/etc/rc.d/init.d/mysqld`

      sudo cp /usr/local/mysql/support-files/mysql.server /etc/rc.d/init.d/mysqld

* Enable and Start `mysqld` Service

      sudo systemctl enable mysqld
      sudo systemctl start mysqld
      sudo systemctl status mysqld

## Run `mysql_secure_installation`

    sudo /usr/local/mysql/bin/mysql_secure_installation

## References
* [CentOS 7.5 编译安装 MariaDB 10.3.9](https://blog.csdn.net/qq_32828933/article/details/82720018)
* [CentOS 7 源码编译MariaDB](https://www.cnblogs.com/bigdevilking/p/9452686.html)

# Got "Can NOT Find GnuTLS" Error when Compiling MariaDB from Source

## Problem
* Got "Can NOT Find GnuTLS" Error when Compiling(`cmake`) [MariaDB](https://mariadb.org)

## How to Reproduce
* Download latest [MariaDB](https://mariadb.org) via `git clone`

      // Only fetch specified branch of MariaDB
      git clone --single-branch --branch 10.3 https://github.com/MariaDB/server.git

      // cmake
      cd server
      cmake .

* Got Error

   > CMake Error at /usr/local/share/cmake-3.13/Modules/FindPackageHandleStandardArgs.cmake:137 (message):
  Could NOT find GnuTLS (missing: GNUTLS_LIBRARY GNUTLS_INCLUDE_DIR)
  (Required is at least version "3.3.24")
Call Stack (most recent call first):
  /usr/local/share/cmake-3.13/Modules/FindPackageHandleStandardArgs.cmake:378 (_FPHSA_FAILURE_MESSAGE)
  /usr/local/share/cmake-3.13/Modules/FindGnuTLS.cmake:54 (FIND_PACKAGE_HANDLE_STANDARD_ARGS)
  libmariadb/CMakeLists.txt:311 (FIND_PACKAGE)

## Root Cause
* MariaDB needs SSL support, if there's NO `-DWITH_SSL` option with `cmake`, it'll try to use [GnuTLS](https://gnutls.org/)

## Solutions
Build MariaDB with latest [OpenSSL](https://www.openssl.org/)

* [Install Latest Release of OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos-7.md)

* Goto [cmake/ssl.cmake](https://github.com/MariaDB/server/blob/10.3/cmake/ssl.cmake#L23) to see all possible values of `-DWITH_SSL`
* We choose `cmake -DWITH_SSL=</path/to/custom/openssl>`
  
      cmake . -DWITH_SSL=/usr/local/openssl


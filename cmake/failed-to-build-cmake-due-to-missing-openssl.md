# Failed to Build cmake Due to Missing OpenSSL

## Problem
* Build cmake from source on CentOS 8
  
  ```
  ./configure --prefix=/usr/local/cmake
  ```
* Got error message

  > Could NOT find OpenSSL, try to set the path to OpenSSL root folder in the system variable OPENSSL_ROOT_DIR (missing: OPENSSL_CRYPTO_LIBRARY OPENSSL_INCLUDE_DIR) 
  > CMake Error at Utilities/cmcurl/CMakeLists.txt:454 (message):
  > Could not find OpenSSL.  Install an OpenSSL development package or
  > configure CMake with -DCMAKE_USE_OPENSSL=OFF to build without OpenSSL.

## Root Cause
* CMake needs cURL which use OpenSSL libraries(libcrypto, libssl)
* Need to install OpenSSL development package or set OpenSSL root path when run `configure`

## Solution
* [Install Latest Release of OpenSSL from Source on CentOS](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos.md)

* Set `OPENSSL_ROOT_DIR`
```
OPENSSL_ROOT_DIR=/usr/local/openssl \
LDFLAGS="-Wl,-rpath=/usr/local/openssl/lib" \
./configure --prefix=/usr/local/cmake \
```

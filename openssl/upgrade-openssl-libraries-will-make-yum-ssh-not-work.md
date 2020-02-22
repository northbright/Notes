# Upgrade [OpenSSL](https://www.openssl.org/) Libraries on CentOS 8 Will Make `yum` / `ssh` Not Work

## Background
* Compile latest [OpenSSL](https://www.openssl.org/)
* Upgrade the [OpenSSL](https://www.openssl.org/) libraries(`libssl.so, libcrypto.so`) using `ldconfig`

## Problem
* `yum`  reported error:
   > librpmio.so: undefined reference to `EVP_md2'
* `ssh` reported error:
   > undefined references to `KDF_ctrl` 

## Root Cause
* Latest [OpenSSL](https://www.openssl.org/) libraries are incompatible with built-in apps on CentOS8
* `yum` needs to config / build openssl with `enable-md2` flag
* `ssh` needs `KDF` functions

## Solution
* Do not upgrade system OpenSSL libraries
```
sudo rm /etc/ld.so.conf.d/openssl.conf
sudo ldconfig
```

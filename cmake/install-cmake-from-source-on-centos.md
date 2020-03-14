# Install [CMake](https://cmake.org/) from Source on CentOS

## Install Dependencies
* [OpenSSL](https://www.openssl.org/)
   * [Install Latest Release of OpenSSL from Source on CentOS](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos.md)

## Get Source Code
* A. From [Offical Site](https://cmake.org/download/)
* B. From [GitHub](https://github.com/Kitware/CMake/releases)

```
cd ~/download
wget https://github.com/Kitware/CMake/releases/download/v3.15.4/cmake-3.15.4.tar.gz
tar -xzvf cmake-3.15.4.tar.gz
cd cmake-3.15.4
```

## Configure
```
OPENSSL_ROOT_DIR=/usr/local/openssl \
./configure --prefix=/usr/local/cmake
```

## Make and Install
```
gmake

sudo make install
```

## Add New Binary Path
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of CMake
      export PATH=/usr/local/cmake/bin:$PATH

* `source /etc/profile`


## Check
```
// Check version
cmake --version
```

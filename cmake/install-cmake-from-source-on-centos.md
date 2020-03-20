# Install CMake from Source on CentOS

## Install Dependencies
* [zlib](https://www.zlib.net/)
  * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)
* [cURL](https://curl.haxx.se/) 
  * [Install Latest cURL from Source on CentOS](https://github.com/northbright/Notes/blob/master/curl/install-latest-curl-from-source-on-centos.md)

## Get Source Code
* Download from [GitHub](https://github.com/Kitware/CMake/releases)

```
cd ~/download
wget https://github.com/Kitware/CMake/releases/download/v3.15.4/cmake-3.15.4.tar.gz
tar -xzvf cmake-3.15.4.tar.gz
cd cmake-3.15.4
```

## Configure
```
ZLIB_ROOT=/usr/local/zlib/ \
CURL_ROOT=/usr/local/curl/ \
./bootstrap --prefix=/usr/local/cmake \
--system-zlib \
--system-curl
```

## Make and Install
```
make

sudo make install
```

## Check RPATH and linked libraries
```
readelf -d /usr/local/cmake/bin/cmake
ldd /usr/local/cmake/bin/cmake
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

## References
* [Specify `--system-zlib` or `--system-curl` Will Enable `RPATH` When Compiling CMake from Source](specify-system-zlib-or-curl-will-enable-rpath-when-build-cmake-from-source.md)

# Install libtiff from Source on CentOS 7

## Install Dependencies
* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)

* [libjpeg](http://www.ijg.org/)
   * [Install libjpeg from Source on CentOS](https://github.com/northbright/Notes/blob/master/libjpeg/install-latest-libjpeg-on-centos.md) 

* [WebP](https://github.com/webmproject/libwebp)
   * [Install WebP from Source on CentOS](https://github.com/northbright/Notes/blob/master/webp/install-webp-from-source-on-centos.md)

## Download Source Code
* Get source code from [offical site](http://download.osgeo.org/libtiff/)

      cd download
      wget http://download.osgeo.org/libtiff/tiff-4.0.10.tar.gz
      tar -xzvf tiff-4.0.10.tar.gz
      cd tiff-4.0.10

## Configure
```
LDFLAGS="-Wl,-rpath=/usr/local/zlib/lib \
-Wl,-rpath=/usr/local/libjpeg/lib \
-Wl,-rpath=/usr/local/libwebp/lib \
-Wl,-rpath=/usr/local/libtiff/lib" \
\
./configure --prefix=/usr/local/libtiff \
\
--with-zlib-include-dir=/usr/local/zlib/include \
--with-zlib-lib-dir=/usr/local/zlib/lib \
--with-jpeg-include-dir=/usr/local/libjpeg/include \
--with-jpeg-lib-dir=/usr/local/libjpeg/lib \
--with-webp-include-dir=/usr/local/libwebp/include \
--with-webp-lib-dir=/usr/local/libwebp/lib
```

## Make and Install

    make
    sudo make install


## Check RPATH and linked libraries
```
readelf -d /usr/local/libtiff/bin/tiffcmp
ldd /usr/local/libtiff/bin/tiffcmp

readelf -d /usr/local/libtiff/lib/libtiff.so
ldd /usr/local/libtiff/lib/libtiff.so
```

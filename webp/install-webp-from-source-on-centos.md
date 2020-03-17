# Install WebP from Source on CentOS

## Tested CentOS Versions
* CentOS 7
* CentOS 8

## Install Dependencies
* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)
* [libpng](http://www.libpng.org/pub/png/libpng.html)
   * [Install libpng from Source on CentOS](https://github.com/northbright/Notes/blob/master/libpng/install-libpng-from-source-on-centos.md)

* [libjpeg](http://www.ijg.org/)
   * [Install libjpeg from Source on CentOS](https://github.com/northbright/Notes/blob/master/libjpeg/install-latest-libjpeg-on-centos.md) 

## Download Source on [Github Mirror](https://github.com/webmproject/libwebp/releases)
```
cd download
wget https://github.com/webmproject/libwebp/archive/v1.0.2.tar.gz
tar -xzvf v1.0.2.tar.gz
cd libwebp-1.0.2
```

## Configure
```
./autogen.sh
```

```
LDFLAGS="-Wl,-rpath=/usr/local/zlib/lib \
-Wl,-rpath=/usr/local/libpng/lib \
-Wl,-rpath=/usr/local/libjpeg/lib \
-Wl,-rpath=/usr/local/libwebp/lib" \
\
./configure --prefix=/usr/local/libwebp \
--with-pngincludedir=/usr/local/libpng/include/ \
--with-pnglibdir=/usr/local/libpng/lib/ \
--with-jpegincludedir=/usr/local/libjpeg/include/ \
--with-jpeglibdir=/usr/local/libjpeg/lib/
```

## Make and Install
```
make
sudo make install
```

## Check RPATH and linked libraries
```
readelf -d /usr/local/libwebp/bin/cwebp
ldd /usr/local/libwebp/bin/cwebp

readelf -d /usr/local/libwebp/lib/libwebp.so
ldd /usr/local/libwebp/lib/libwebp.so
```

# Install libgd from Source on CentOS

## Install Dependencies
* [libXpm](https://www.x.org/wiki/Releases/Download/)
  * [Install libXpm on CentOS 7](https://github.com/northbright/Notes/blob/master/libxpm/install-libxpm-devel-on-centos7.md)

* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)

* [libpng](http://www.libpng.org/pub/png/libpng.html)
   * [Install libpng from Source on CentOS](https://github.com/northbright/Notes/blob/master/libpng/install-libpng-from-source-on-centos.md)

* [libjpeg](http://www.ijg.org/)
   * [Install libjpeg from Source on CentOS](https://github.com/northbright/Notes/blob/master/libjpeg/install-latest-libjpeg-on-centos.md) 

* [WebP](https://github.com/webmproject/libwebp)
   * [Install WebP from Source on CentOS](https://github.com/northbright/Notes/blob/master/webp/install-webp-from-source-on-centos.md)

* [libtiff](http://www.simplesystems.org/libtiff/)
  * [Install libtiff from Source on CentOS](https://github.com/northbright/Notes/blob/master/libtiff/install-libtiff-from-source-on-centos.md)

## Download Latest Source from [github](https://github.com/libgd/libgd/releases)
```
cd download
wget https://github.com/libgd/libgd/archive/gd-2.2.5.tar.gz
tar -xzvf gd-2.2.5.tar.gz
cd libgd-gd-2.2.5
```

## Bootstrap
```
./bootstrap.sh
```
     
## Configure
```
// Set zlib, libjpeg, libpng, libwebp dirs if using non-standard dirs
// Warn: it's special for libpng
// It will link against -lpng15 automatically even if you specify --with-png and rpath for libpng
// Solution: set LIBPNG_CFLAGS and LIBPNG_LIBS

LIBPNG_CFLAGS="-I/usr/local/libpng/include" \
LIBPNG_LIBS="-lpng" \
\
LDFLAGS="-L/usr/local/libpng/lib \
-Wl,-rpath=/usr/local/zlib/lib \
-Wl,-rpath=/usr/local/libpng/lib \
-Wl,-rpath=/usr/local/libjpeg/lib \
-Wl,-rpath=/usr/local/libwebp/lib \
-Wl,-rpath=/usr/local/libtiff/lib \
-Wl,-rpath=/usr/local/libgd/lib" \
\
./configure --prefix=/usr/local/libgd \
--with-zlib=/usr/local/zlib \
--with-png=/usr/local/libpng \
--with-jpeg=/usr/local/libjpeg \
--with-webp=/usr/local/libwebp \
--with-tiff=/usr/local/libtiff \
--with-xpm
```

## Make and Install
```
make
sudo make install
```

## Check RPATH and linked libraries
```
readelf -d /usr/local/libgd/bin/gd2topng
ldd /usr/local/libgd/bin/gd2topng

readelf -d /usr/local/libgd/lib/libgd.so
ldd /usr/local/libgd/lib/libgd.so
```

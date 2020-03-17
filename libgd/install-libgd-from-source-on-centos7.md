# Install libgd from Source on CentOS 7

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
  * [Install libtiff from Source on CentOS](https://github.com/northbright/Notes/blob/master/libtiff/install-libtiff-from-source-on-centos7.md)

## Download Latest Source from [github](https://github.com/libgd/libgd/releases)

    cd download
    wget https://github.com/libgd/libgd/archive/gd-2.2.5.tar.gz
    tar -xzvf gd-2.2.5.tar.gz
    cd libgd-gd-2.2.5

## Bootstrap

    ./bootstrap.sh
     
## Configure

    // Set zlib, libjpeg, libpng, libwebp dirs if using non-standard dirs

    ./configure --prefix=/usr/local/libgd \
    --with-zlib=/usr/local/zlib \
    --with-jpeg=/usr/local/libjpeg \
    --with-png=/usr/local/libpng \
    --with-webp=/usr/local/libwebp \
    --with-tiff=/usr/local/libtiff \
    --with-xpm \

## Make and Install

    make
    sudo make install

## Add New Shared Libraries Path

    su
    echo '/usr/local/libgd/lib/' > /etc/ld.so.conf.d/libgd.conf
    exit
    sudo ldconfig
      
    # Check
    ldconfig -p | grep libgd

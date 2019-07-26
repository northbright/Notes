# Install [libtiff](http://www.simplesystems.org/libtiff/) from Source on CentOS 7

## Install Dependencies
* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)

* [libjpeg](http://www.ijg.org/)
   * [Install libjpeg from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/libjpeg/install-latest-libjpeg-on-centos7.md) 

* [WebP](https://github.com/webmproject/libwebp)
   * [Install WebP from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/webp/install-webp-from-source-on-centos7.md)

## Download Source Code
* Get source code from [offical site](http://download.osgeo.org/libtiff/)

      cd download
      wget http://download.osgeo.org/libtiff/tiff-4.0.10.tar.gz
      tar -xzvf tiff-4.0.10.tar.gz
      cd tiff-4.0.10

## Configure

    // Specify include / lib path if need

    ./configure --prefix=/usr/local/libtiff \
    --with-zlib-include-dir=/usr/local/zlib/include \
    --with-zlib-lib-dir=/usr/local/zlib/lib \
    --with-jpeg-include-dir=/usr/local/libjpeg/include \
    --with-jpeg-lib-dir=/usr/local/libjpeg/lib \
    --with-webp-include-dir=/usr/local/libwebp/include \
    --with-webp-lib-dir=/usr/local/libwebp/lib \

## Make and Install

    make
    sudo make install

## Add New Shared Libraries Path

    su
    echo '/usr/local/libtiff/lib/' > /etc/ld.so.conf.d/libtiff.conf
    exit
    sudo ldconfig
    
    # Check
    ldconfig -p | grep libtiff


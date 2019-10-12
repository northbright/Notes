# Install WebP from Source on CentOS 7

## Install Dependencies
* [libpng](http://www.libpng.org/pub/png/libpng.html)
   * [Install libpng from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/libpng/install-libpng-from-source-on-centos-7.md)

* [libjpeg](http://www.ijg.org/)
   * [Install libjpeg from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/libjpeg/install-latest-libjpeg-on-centos7.md) 

## Download Source on [Github Mirror](https://github.com/webmproject/libwebp/releases)

    cd download
    wget https://github.com/webmproject/libwebp/archive/v1.0.2.tar.gz
    tar -xzvf v1.0.2.tar.gz
    cd libwebp-1.0.2

## Configure

    // Generate files

    ./autogen.sh

    // Set libpng, libjpeg dirs if the libraries are installed in **non-standard** directories

    ./configure --prefix=/usr/local/libwebp \
    --with-pngincludedir=/usr/local/libpng/include/ \
    --with-pnglibdir=/usr/local/libpng/lib/ \
    --with-jpegincludedir=/usr/local/libjpeg/include/ \
    --with-jpeglibdir=/usr/local/libjpeg/lib/ \
    
## Make and Install

    make
    sudo make install


## Add New Shared Libraries Path

    su
    echo '/usr/local/libwebp/lib/' > /etc/ld.so.conf.d/libwebp.conf
    exit
    sudo ldconfig
      
    # Check
    ldconfig -p | grep libwebp

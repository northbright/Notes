# Install [FreeType](https://www.freetype.org/) from Source on CentOS 7

## Install Dependencies
* [bzip2](http://www.bzip.org)
  * [Install bzip2-devel on CentOS 7](https://github.com/northbright/Notes/blob/master/bzip2/install-bzip2-devel-on-centos7.md)

* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)

* [libpng](http://www.libpng.org/pub/png/libpng.html)
   * [Install libpng from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/libpng/install-libpng-from-source-on-centos-7.md)

## Download Source on [Official Site](https://sourceforge.net/projects/freetype/files/)

    cd download
    wget https://nchc.dl.sourceforge.net/project/freetype/freetype2/2.10.0/freetype-2.10.0.tar.gz
    tar -xzvf freetype-2.10.0.tar.gz
    cd freetype-2.10.0

## Configure

    // Specify zlib, libpng dirs if need(non-standard dirs)
    // --enable-freetype-config will generate freetype-config

    ZLIB_CFLAGS="-I/usr/local/zlib/include" \
    ZLIB_LIBS="-L/usr/local/zlib/lib" \
    LIBPNG_CFLAGS="-I/usr/local/libpng/include" \
    LIBPNG_LIBS="-L/usr/local/libpng/lib" \
    ./configure --prefix=/usr/local/freetype \
    --with-bzip2=yes \
    --enable-freetype-config \
    
## Make and Install

    make
    sudo make install

## Add New Shared Libraries Path

    su
    echo '/usr/local/freetype/lib/' > /etc/ld.so.conf.d/freetype.conf
    exit
    sudo ldconfig
      
    # Check
    ldconfig -p | grep libfreetype

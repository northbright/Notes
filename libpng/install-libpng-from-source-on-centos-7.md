# Install libpng from Source on CentOS 7

## Install Dependencies
* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)

## Download Latest Source from <https://sourceforge.net/projects/libpng/files/>

    cd download
    wget https://nchc.dl.sourceforge.net/project/libpng/libpng16/1.6.37/libpng-1.6.37.tar.gz
    tar -xzvf libpng-1.6.37.tar.gz
    cd libpng-1.6.37

## Configure

    // export CPPFLAGS and LDFLAGS before run ./configure
    // if zlib is installed in the **non-standard** directory

    CPPFLAGS="-I/usr/local/zlib/include" \
    LDFLAGS="-L/usr/local/zlib/lib \
    -Wl,-rpath=/usr/local/zlib/lib \
    -Wl,-rpath=/usr/local/libpng/lib" \
    \
    ./configure --prefix=/usr/local/libpng

## Make & Make Install

    make
    sudo make install

## Check RPATH and linked libraries
```
readelf -d /usr/local/libpng/lib/libpng.so
ldd /usr/local/libpng/lib/libpng.so
```

## References
* [libpng](http://www.libpng.org/pub/png/libpng.html)

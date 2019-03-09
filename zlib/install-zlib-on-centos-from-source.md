# Install zlib on CentOS from Source

## Download Latest Release

    cd ~/download
    wget https://www.zlib.net/zlib-1.2.11.tar.gz
    tar -xzvf zlib-1.2.11.tar.gz

## Configue, Make and Install

    cd zlib-1.2.11
    ./configure --prefix=/usr/local/zlib
    make
    sudo make install

## Add New Shared Libraries Path of zlib

    su
    echo '/usr/local/zlib/lib/' > /etc/ld.so.conf.d/zlib.conf
    ldconfig
      
    # Check if libssl.so.x is in the output
    ldconfig -p | grep libz

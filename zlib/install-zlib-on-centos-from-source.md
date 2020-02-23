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

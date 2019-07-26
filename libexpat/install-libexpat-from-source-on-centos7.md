# Install [libexpat](https://libexpat.github.io/) from Source on CentOS 7

## Download
* Get source on [github](https://github.com/libexpat/libexpat/releases)

       cd download
       wget https://github.com/libexpat/libexpat/releases/download/R_2_2_7/expat-2.2.7.tar.gz
       tar -xzvf expat-2.2.7.tar.gz
       cd expat-2.2.7

## Configure

    ./configure --prefix=/usr/local/libexpat

## Make and Install

    make
    sudo make install

## Add New Shared Libraries Path

    su
    echo '/usr/local/libexpat/lib/' > /etc/ld.so.conf.d/libexpat.conf
    exit
    sudo ldconfig
      
    # Check
    ldconfig -p | grep libexpat

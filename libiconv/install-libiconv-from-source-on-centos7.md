# Install [libiconv](https://www.gnu.org/software/libiconv/) from Source on CentOS 7

## Download
* Get source code on [offical site](https://ftp.gnu.org/pub/gnu/libiconv/)

       cd download
       wget https://ftp.gnu.org/pub/gnu/libiconv/libiconv-1.16.tar.gz
       tar -xzvf libiconv-1.16.tar.gz
       cd libiconv-1.16

## Configure

    ./configure --prefix=/usr/local/libiconv

## Make and Install

    make
    sudo make install

## Add New Shared Libraries Path

    su
    echo '/usr/local/libiconv/lib/' > /etc/ld.so.conf.d/libiconv.conf
    exit
    sudo ldconfig
      
    # Check
    ldconfig -p | grep libiconv

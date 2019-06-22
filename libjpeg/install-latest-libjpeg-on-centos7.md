# Install libjpeg from Source on CentOS 7

## Download Latest Source from <http://www.ijg.org/files/>

    cd download
    wget http://www.ijg.org/files/jpegsrc.v9c.tar.gz
    tar -xzvf jpegsrc.v9c.tar.gz

## Configure

     ./configure --prefix=/usr/local/libjpeg

## Make & Make Install

    make
    sudo make install

## Add New Shared Libraries Path

    su
    echo '/usr/local/libjpeg/lib/' > /etc/ld.so.conf.d/libjpeg.conf
    exit
    sudo ldconfig
      
    # Check
    ldconfig -p | grep libjpeg

## References
* <http://www.ijg.org/>

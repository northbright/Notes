# Install Latest readline on CentOS from Source

## Download Latest Release on <ftp://ftp.gnu.org/gnu/readline/>

    wget ftp://ftp.gnu.org/gnu/readline/readline-8.0.tar.gz
    tar -xzvf readline-8.0.tar.gz

## Configure, Make and Install

    cd readline-8.0
    ./configure --prefix=/usr/local/readline
    make
    sudo make install

## Add New Shared Libraries Path of readline

    su
    echo '/usr/local/readline/lib/' > /etc/ld.so.conf.d/readline.conf
    exit
    sudo ldconfig
      
    # Check if libreadline.so.x is in the output
    ldconfig -p | grep libreadline

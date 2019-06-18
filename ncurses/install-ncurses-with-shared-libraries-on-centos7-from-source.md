# Install ncurses with shared libraries on CentOS from Source

 
## Download latest release on [offical site](ftp://ftp.gnu.org/gnu/ncurses/)

    cd ~/download
    wget ftp://ftp.gnu.org/gnu/ncurses/ncurses-6.1.tar.gz
    tar -xzvf ncurses-6.1.tar.gz
    cd ncurses-6.1
      
## Configure, compile and install
      
    // make sure `--with-shared` option is specified to generate libcurses.so libraries
    ./configure --prefix=/usr/local/ncurses --with-shared
    make
    sudo make install


## Add New Shared Libraries Path of ncurses

    su
    echo '/usr/local/ncurses/lib/' > /etc/ld.so.conf.d/ncurses.conf
    ldconfig
      
    # Check if libncurses.so is in the output
    ldconfig -p | grep libncurses

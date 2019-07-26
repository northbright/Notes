# Install [gperf](https://www.gnu.org/software/gperf/) from Source on CentOS 7

## Download Source Code
* Get source code on [offical site](https://ftp.gnu.org/pub/gnu/gperf/)

       cd download
       wget https://ftp.gnu.org/pub/gnu/gperf/gperf-3.1.tar.gz
       tar -xzvf gperf-3.1.tar.gz
       cd gperf-3.1

## Configure

    ./configure --prefix=/usr/local/gperf

## Make and Install

    make
    sudo make install

## Add New Binary Path
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of gperf
      export PATH=/usr/local/gperf/bin:$PATH

* `source /etc/profile`

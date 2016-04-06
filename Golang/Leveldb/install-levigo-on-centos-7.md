
# Install levigo on CentOS 7

#### Install GO on Linux
[Install GO on Linux](https://github.com/northbright/Notes/blob/master/Golang/Install/Install_GO_on_Linux.md)

#### Compile and Install [snappy](https://github.com/google/snappy)
* [Install snappy from Source on CentOS 7](install-snappy-from-source-on-centos-7.md)

#### Compile and Install [leveldb](https://github.com/google/leveldb):  

1. Download `leveldb` from <https://github.com/google/leveldb/archive/master.zip>  

        wget https://github.com/google/leveldb/archive/master.zip
        unzip master.zip

2. Compile `leveldb`:  

        cd leveldb-master
        make

3. Install libs
   * Copy files
   
            sudo cp include/leveldb /usr/local/include -rf
            sudo cp out-shared/libleveldb.* /usr/local/lib   

   * Create a conf file for `/etc/ld.so.conf`:
   
            sudo vi /etc/ld.so.conf.d/usrlocallib.conf
            ## add below line:
            /usr/local/lib

   * Reload `ldconfig` cache  
     
            sudo ldconfig

* Finally, run `go get` to install `levigo`:  
`CGO_CFLAGS="-I/usr/local/include" CGO_LDFLAGS="-L/usr/local/lib -lsnappy" go get github.com/jmhodges/levigo`

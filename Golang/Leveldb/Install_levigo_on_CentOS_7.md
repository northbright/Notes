
# Install levigo on CentOS 7

* Compile and Install [leveldb](https://github.com/google/leveldb):  
   * Install `gcc=c++`:  
     `sudo yum install gcc-c++`
   * `make`

   * `ldconfig` for leveldb:  
     * `su`
     * `echo '/home/XX_ACCOUNT/LEVELDB_PATH' > /etc/ld.so.conf.d/leveldb.conf`
     * `sudo ldconfig`
     * `sudo ldconfig -p` to check if leveldb library is in cache
     * For more, see [Fix error while loading shared libleveldb.so](./Fix_error_while_loading_shared_libraries_libleveldb.so.1)

* Compile and Install [snappy](https://github.com/google/snappy)
  1. Download [snappy](https://github.com/google/snappy):  
     `wget https://github.com/google/snappy/archive/master.zip`

  2. Install `unzip`:  
     `sudo yum install unzip`

  3. Unzip `master.zip`:  
     `unzip master.zip`

  4. `cd snappy-master`

  5. Run `./autogen.sh` and you'll find some pkgs were not installed.  
     Use `yum provides xx` to get the package name.

     * Install `automake`:  
       `sudo yum install automake`

     * Install `libtool`:  
       `sudo yum install libtool`

     * `./autogen.sh`
     * `./configure`
     * `make`
     * `sudo make install`

  6. Check `/usr/local/include` and `/usr/local/lib` to see if snappy header and libraries are copied successfully  

  7. For more, see:  
  [Compile and install snappy on CentOS 7](Compile_and_install_snappy_on_CentOS_7.md)

* Finally, run `go get` to install `levigo`:  
`CGO_CFLAGS="-I/home/XX/download/leveldb-1.18/include/ -I/usr/local/include" CGO_LDFLAGS="-L/home/XX/download/leveldb-1.18 -L/usr/local/lib -lsnappy" go get github.com/jmhodges/levigo`
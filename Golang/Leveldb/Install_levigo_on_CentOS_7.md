
# Install levigo on CentOS 7

#### Compile and Install [snappy](https://github.com/google/snappy)
1. Download [snappy](https://github.com/google/snappy):  

        wget https://github.com/google/snappy/archive/master.zip

2. Install `unzip` and [git](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git):  

        sudo yum install unzip
        sudo yum install git

3. Unzip `master.zip`:  
   
        unzip master.zip

4. `cd snappy-master`

5. Run `./autogen.sh` and you'll find some pkgs were not installed.  
   Use `yum provides xx` to get the package name.

        // Install `automake`:  
        sudo yum install automake

        // Install `libtool`:  
        sudo yum install libtool

        ./autogen.sh
        ./configure
        make
        sudo make install

6. Check `/usr/local/include` and `/usr/local/lib` to see if snappy header and libraries are copied successfully  

7. For more, see:  
[Compile and install snappy on CentOS 7](Compile_and_install_snappy_on_CentOS_7.md)

#### Compile and Install [leveldb](https://github.com/google/leveldb):  

1. Download `leveldb` from <https://github.com/google/leveldb/archive/master.zip>  

        wget https://github.com/google/leveldb/archive/master.zip
        unzip master.zip

2. Compile & Install `leveldb`:  

        cd leveldb-master
        make
        sudo cp libleveldb.* /usr/local/lib
        sudo cp include/leveldb /usr/local/include -rf
        sudo ldconfig


* Finally, run `go get` to install `levigo`:  
`CGO_CFLAGS="-I/usr/local/include" CGO_LDFLAGS="-L/usr/local/lib -lsnappy" go get github.com/jmhodges/levigo`
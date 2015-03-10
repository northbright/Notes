
# Install Levigo on Ubuntu

#### Install leveldb on Ubuntu

[Compile and Install leveldb on Ubuntu 12.04](https://github.com/northbright/Notes/blob/master/Golang/Leveldb/Compile_and_Install_leveldb_on_Ubuntu_12.04.md)

#### Install GO
[Install GO on Linux](https://github.com/northbright/Notes/blob/master/Golang/Install/Install_GO_on_Linux.md)

#### Finally, run `go get` to install [levigo](https://github.com/jmhodges/levigo):  

        CGO_CFLAGS="-I/usr/local/include" CGO_LDFLAGS="-L/usr/local/lib -lsnappy" go get github.com/jmhodges/levigo

        
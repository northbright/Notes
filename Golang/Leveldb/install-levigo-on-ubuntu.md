# Install Levigo on Ubuntu

#### Steps
* [Install LevelDB from Source on Ubuntu 12.04](https://github.com/northbright/Notes/blob/master/leveldb/install-leveldb-from-source-on-ubuntu-12.04.md)

* [Install GO on Linux](https://github.com/northbright/Notes/blob/master/Golang/Install/Install_GO_on_Linux.md)

* Finally, run `go get` to install [levigo](https://github.com/jmhodges/levigo):  

        GO_CFLAGS="-I/path/to/leveldb/include -I/path/to/snappy/include"
        CGO_LDFLAGS="-L/path/to/leveldb/lib -L/path/to/snappy/lib -lsnappy" go get github.com/jmhodges/levigo

        // Ex: in this case, snappy and leveldb have the same include / lib path:
        CGO_CFLAGS="-I/usr/local/include" CGO_LDFLAGS="-L/usr/local/lib -lsnappy" go get github.com/jmhodges/levigo

#### References
* [Building levigo](https://github.com/jmhodges/levigo#building)

        

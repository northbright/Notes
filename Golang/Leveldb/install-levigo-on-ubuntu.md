# Install Levigo on Ubuntu

#### Install leveldb on Ubuntu

[Install leveldb on Ubuntu 12.04](./install-leveldb-on-ubuntu-12.04.md)

#### Install GO
[Install GO on Linux](https://github.com/northbright/Notes/blob/master/Golang/Install/Install_GO_on_Linux.md)

#### Finally, run `go get` to install [levigo](https://github.com/jmhodges/levigo):  

        CGO_CFLAGS="-I/usr/local/include" CGO_LDFLAGS="-L/usr/local/lib -lsnappy" go get github.com/jmhodges/levigo

#### References
* [Building levigo](https://github.com/jmhodges/levigo#building)

        


# Install levigo on CentOS 7

#### Install GO on Linux
[Install GO on Linux](https://github.com/northbright/Notes/blob/master/Golang/Install/Install_GO_on_Linux.md)

#### Compile and Install [snappy](https://github.com/google/snappy)
* [Install snappy from Source on CentOS 7](install-snappy-from-source-on-centos-7.md)

#### [Install LevelDB on CentOS 7](https://github.com/northbright/Notes/blob/master/leveldb/install-leveldb-on-centos-7.md)

4. Finally, run `go get` to install `levigo`:  

        CGO_CFLAGS="-I/path/to/leveldb/include -I/path/to/snappy/include"
        CGO_LDFLAGS="-L/path/to/leveldb/lib -L/path/to/snappy/lib -lsnappy" go get github.com/jmhodges/levigo

        // Ex: in this case, snappy and leveldb have the same include / lib path.
        CGO_CFLAGS="-I/usr/local/include" CGO_LDFLAGS="-L/usr/local/lib -lsnappy" go get github.com/jmhodges/levigo

#### References
* [Building levigo](https://github.com/jmhodges/levigo#building)


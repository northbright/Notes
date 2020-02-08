# Install [libevent](http://libevent.org/) from Source on CentOS 7

## Install Dependencies
* [OpenSSL](https://www.openssl.org/)
  * [Install Latest Release of OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos-7.md)

## Configure

```
CPPFLAGS="-I/usr/local/openssl/include/ -I/usr/local/zlib/include/" \
LDFLAGS="-L/usr/local/openssl/lib/ -L/usr/local/zlib/lib/" \
./configure --prefix=/usr/local/libevent
```

## Make and Install
```
make
sudo make install
``` 

## Add New Shared Libraries Path
```
su
echo '/usr/local/libevent/lib/' > /etc/ld.so.conf.d/libevent.conf
exit
sudo ldconfig
```
        
## Check
```
ldconfig -p | grep libevent
```


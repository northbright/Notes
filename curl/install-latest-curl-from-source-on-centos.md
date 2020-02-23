# Install Latest cURL from Source on CentOS

## Install Dependencies

* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md) 
      * It'll install latest zlib to a new path: `/usr/local/zlib` which is the value of `--with-zlib` option

* [OpenSSL](https://www.openssl.org/)
   * [Install Latest Release of OpenSSL from Source on CentOS](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos.md)
      * It'll install latest OpenSSL to a new path: `/usr/local/openssl` which is the value of `--with-ssl`

## Download Latest Source from <https://github.com/curl/curl/releases>

    cd download
    wget https://github.com/curl/curl/archive/curl-7_68_0.tar.gz
    tar -xzvf curl-7_68_0.tar.gz
    cd curl-curl-7_68_0

## Configure
```
./buildconf
```

```
LDFLAGS="-Wl,-rpath=/usr/local/zlib/lib \
-Wl,-rpath=/usr/local/openssl/lib" \
\
./configure \
--prefix=/usr/local/curl \
--enable-shared \
--with-ssl=/usr/local/openssl \
--with-zlib=/usr/local/zlib \
```

## Make & Make Install
```
make
sudo make install
```

## Check RPATH using `readelf`
```
readelf -d /usr/local/curl/bin/curl
readelf -d /usr/local/curl/lib/libcurl.so
```

## Check linked libraries using `ldd`
```
ldd /usr/local/curl/bin/curl
ldd /usr/local/curl/lib/libcurl.so
```

## Add New Binary Path of cURL(Optional)
* `sudo vi /etc/profile`

       # Append these lines:
       # Use New Version of cURL
       export PATH=/usr/local/curl/bin:$PATH

* `source /etc/profile`
         
## Check cURL Version
```
curl --version
```

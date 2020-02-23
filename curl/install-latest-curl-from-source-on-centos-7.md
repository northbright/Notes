# Install Latest cURL from Source on CentOS 7

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
./configure \
--prefix=/usr/local/curl \
--enable-shared \
--with-ssl=/usr/local/openssl \
--with-zlib=/usr/local/zlib \
```

## Make & Make Install

    make
    sudo make install

## Add New Binary Path of cURL
* `sudo vi /etc/profile`

       # Append these lines:
       # Use New Version of cURL
       export PATH=/usr/local/curl/bin:$PATH

* `source /etc/profile`

## Install(update) Latest [pycURL](http://pycurl.io/) from Source
* Problem
  * [yum Failed after Install cURL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/CentOS/yum/yum-failed-after-install-curl-from-source-on-centos-7.md)
* Solution
  * [Install Latest pycURL from Source On CentOS 7](https://github.com/northbright/Notes/blob/master/python/install-latest-pycurl-from-source-on-centos-7.md)

## Add New Shared Libraries Path of cURL
      
       su
       echo '/usr/local/curl/lib/' > /etc/ld.so.conf.d/curl.conf
       exit
       sudo ldconfig
            
       # Check if libcurl* is in the output
       ldconfig -p | grep libcurl
         
* Check cURL Version
   
       curl --version

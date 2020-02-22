# Multiple RPATH

## Problem
* Want to specify multiple paths in `-Wl,-rpath=`

## Solution
* Use `:` to separate paths like $PATH

## Example
```
// Configure curl with customized zlib and openssl
LDFLAGS="-Wl,-rpath=/usr/local/openssl/lib:/usr/local/zlib/lib:/usr/local/curl/lib" ./configure --prefix=/usr/local/curl --enable-shared --with-ssl=/usr/local/openssl --with-zlib=/usr/local/zlib

make
sudo make install


// Check rpath and linked runtime libraries for curl binary
readelf -d /usr/local/curl/bin/curl
ldd /usr/local/curl/bin/curl

// Check rpath and linked runtime libraries for libcurl.so
readelf -d /usr/local/curl/lib/libcurl.so
ldd /usr/local/curl/lib/libcurl.so
```

## References
* [Re: Multiple -rpaths](https://lists.gnu.org/archive/html/libtool/2008-11/msg00007.html)

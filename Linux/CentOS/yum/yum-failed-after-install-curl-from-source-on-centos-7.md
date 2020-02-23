# yum Failed after Install cURL from Source on CentOS 7

## Problems
* Compile latest cURL lib and add the lib path to system library search path(`ldconfig`)
* All `yum` commands(e.g. `yum list installed)` failed with these error messages:

   > There was a problem importing one of the Python modules
   required to run yum. The error leading to this problem was:
   /usr/lib64/python2.7/site-packages/pycurl.so: undefined symbol: CRYPTO_num_locks

## Root Cause
* cURL compiled with latest openssl which removed deprecated APIs like `CRYPTO_num_locks`
* The path of latest `libcurl.so` was **inserted** into the library search path and override the old version via `ldconfig`
* `yum` was written in Python with [pycURL](http://pycurl.io/) which is a Python interface to [libcurl](https://curl.haxx.se/libcurl/)
* The original built-in [pycURL](http://pycurl.io/) was incompatible with the latest `libcurl.so`

## Solution
* Remove new added `/etc/ld.so.conf.d/curl.conf` which content is `/usr/local/curl/lib/`

       sudo rm /etc/ld.so.conf.d/curl.conf
       sudo ldconfig
       // Make sure `/usr/local/curl/lib` does not exist in the library search path
       ldconfig -p | grep libcurl
* Use `rpath` to specify the lib to load when compile latest cURL

## References
* [Error while using libcrypto.so](https://github.com/openssl/openssl/issues/8573)

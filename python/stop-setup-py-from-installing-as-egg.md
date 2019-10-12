# Stop `setup.py` from Installing as Egg

## Problem
* [Install Latest cURL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/curl/install-latest-curl-from-source-on-centos-7.md)
* [yum Failed after Install cURL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/CentOS/yum/yum-failed-after-install-curl-from-source-on-centos-7.md)
* Solution is: compile and install [pycurl](https://github.com/pycurl/pycurl) with the same [OpenSSL](https://www.openssl.org/) libraries as compiled with [cURL](https://github.com/curl/curl/).
* It'll install as the Egg using `python setup.py install` and updated `pycurl.so` will NOT recognized by `yum`. So yum still does not work.

## Solution
* Run `pip install` under the root dir of source

```
cd ~/download/pycurl-REL_7_43_0_3

// Clean
sudo make clean

// Generate Files
make gen

// Compile and Install Files
sudo PYCURL_CURL_CONFIG=/usr/local/curl/bin/curl-config PYCURL_SSL_LIBRARY=openssl CPPFLAGS="-I/usr/local/openssl/include" LDFLAGS="-L/usr/local/openssl/lib" pip install . --ignore-installed
```

## References
* [stopping setup.py from installing as egg](https://stackoverflow.com/questions/6301003/stopping-setup-py-from-installing-as-egg/33791008#33791008)
* [How to write setup.py for installing python module without making .egg file](https://stackoverflow.com/questions/28827933/how-to-write-setup-py-for-installing-python-module-without-making-egg-file)
* [`pip install` Failed with "Cannot uninstall x" Error](pip-install-failed-with-cannot-uninstall-x-error.md)


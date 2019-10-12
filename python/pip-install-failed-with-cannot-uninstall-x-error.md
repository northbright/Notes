# `pip install` Failed with "Cannot uninstall x" Error

## Problem
* Want to compile and install [pycurl](https://github.com/pycurl/pycurl) from source
* Run `pip install` and got error message:

  > ERROR: Cannot uninstall 'pycurl'. It is a distutils installed project and thus we cannot accurately determine which files belong to it which would lead to only a partial uninstall.

## Solution
* Use `--ignore-installed` for `pip install`

## Example
```
sudo PYCURL_CURL_CONFIG=/usr/local/curl/bin/curl-config PYCURL_SSL_LIBRARY=openssl CPPFLAGS="-I/usr/local/openssl/include" LDFLAGS="-L/usr/local/openssl/lib" pip install . --ignore-installed
```

## References
* [pip 10 and apt: how to avoid “Cannot uninstall X” errors for distutils packages](https://stackoverflow.com/questions/49932759/pip-10-and-apt-how-to-avoid-cannot-uninstall-x-errors-for-distutils-packages)
* [Upgrading to pip 10: It is a distutils installed project and thus we cannot accurately determine which files belong to it which would lead to only a partial uninstall. #5247](https://github.com/pypa/pip/issues/5247#issuecomment-443398741)
* [pip cannot uninstall: “It is a distutils installed project”](https://stackoverflow.com/questions/53807511/pip-cannot-uninstall-package-it-is-a-distutils-installed-project)

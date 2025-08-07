# Add Shared Library Path Using `ldconfig`

## Problem
* Build apps with dependent libraries from source
  * Existed Open Source Projects
  * Our New Projects
* Need to make system search the dependent libraries path while run the apps

## Solution
* Add the path of library in `xx.conf`
* Put the `xx.conf` to `/etc/ld.so.conf.d`
* Run `ldconfig`

## Example
* Make latest zlib library from source
* Add the new zlib lib path(e.g. /usr/local/zlib/lib)

```
echo "/usr/local/zlib/lib/" | sudo tee /etc/ld.so.conf.d/zlib.conf
sudo ldconfig
````

```
// Check if libz.so.x is in the output
ldconfig -p | grep libz
```

## Warning
* This will upgrade system library if system has a default one(e.g. zlib)
* It may cause issue that built-in apps crashes because of incompatible with the latest(customized build) version
* e.g. `yum` and `ssh` on CentOS 8 will fail if you update latest OpenSSL libraries)

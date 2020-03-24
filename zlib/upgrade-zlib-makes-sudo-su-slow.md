# Upgrade zlib Makes `sudo` / `su` Slow

## Problem
* `sudo` and `su` command takes a long time(25 seconds)

## Root Cause
* Installed latest zlib from source
  * Installed to `/usr/local/zlib`
  * Upgrade the zlib libraries
    * `echo '/usr/local/zlib/lib/' > /etc/ld.so.conf.d/zlib.conf`
    * `ldconfig`
* When run `sudo`, `/usr/lib/systemd/systemd-logind` failed to load the latest `libz.so` 
* check `/var/log/messages`
* There are many error messages of `libz`:
   > localhost systemd[1]: Starting Login Service...
   > localhost systemd-logind[2710]: /usr/lib/systemd/systemd-logind: error while loading shared libraries: libz.so.1: failed to map segment from shared object

## Solution
Remove the latest zlib libraries

```
sudo rm /etc/ld.so.conf.d/zlib.conf
sudo ldconfig
```

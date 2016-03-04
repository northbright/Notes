# Get Error Messages of Netowrk Service

## Problem
* How to get error messages of network service(Ex: failed to restart network service)?

## Solution
* `sudo cat /var/log/messages | grep network > ~/log.txt`

## References
* [linux系统/var/log目录下的信息详解 ](http://blog.chinaunix.net/uid-26569496-id-3199434.html)
* [Job for network.service failed](http://my.oschina.net/u/1169607/blog/345921)
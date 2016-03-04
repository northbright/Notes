# Job for `network.service` failed

## Problem
* After configured `/etc/sysconfig/network-scripts/ifcfg-eXX`, it failed to restart `network.service`.
* Run `sudo journalctl -xn` and find the errors:
  
    `RTNETLINK answers: File exists`

## Solution
* Try to find network related error messages in `/var/log/messages`

    * `sudo cat /var/log/messages | grep network > ~/log.txt`
    * Now we can get more detailed message:  
      `network: Bringing up interface enp0s3:  Error: no device found for connection 'enp0s3'.`

* The hardware address of `ethXX` returned from `ifconfig -a`(ether xx:xx:xx:xx:xx:xx) is different from `HWADDR` in `/etc/sysconfig/network-scripts/ifcfg-ethXX`

* Copy the hardware address of `ethXX` returned from `ifconfig -a` to `HWADDR` in `/etc/sysconfig/network-scripts/ifcfg-ethXX`

* Restart network service:  
  `sudo service network restart`

## References
* [Job for network.service failed](http://my.oschina.net/u/1169607/blog/345921)
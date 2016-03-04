# Set Static IP for Centos 7

## Steps
* `sudo vi /etc/sysconfig/network-scripts/ifcfg-eXX`(XX is your network interface).

        BOOTPROTO=static
        ONBOOT="yes"
        IPADDR=192.168.1.104
        NETMASK=255.255.255.0
        GATEWAY=192.168.1.1
        DNS1=192.168.1.1

* Restart `network.service`:  
  `sudo service network restart`
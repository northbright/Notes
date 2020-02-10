# Enable Port Range in firewalld

## Problem
* Install coturn server on CentOS
* Need to open port 49152 - 65535 for UDP relay

## Solution
```
sudo firewall-cmd --permanent --zone=public --add-port=49152-65535/udp
sudo firewall-cmd --reload
sudo firewall-cmd --list-all
```

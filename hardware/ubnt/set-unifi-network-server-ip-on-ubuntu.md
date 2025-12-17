# Set Unifi Network Server IP on Ubuntu

## Problem
* Install Unifi Network Application on an Ubuntu PC
* The PC has multiple ethernet interfaces(e.g. eno1, ens1f0, ens1f1)
* Need to change Unifi Network Server IP 

## Solution
Modify `/usr/lib/unifi/data/system.properties`.

```sh
sudo vi /usr/lib/unifi/data/system.properties
```

Append this line:

```sh
......
system_ip=10.0.2.3
```

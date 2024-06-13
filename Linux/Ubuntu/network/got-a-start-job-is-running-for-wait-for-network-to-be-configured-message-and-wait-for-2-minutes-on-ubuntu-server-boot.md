# Got "A start job is running for wait for network to be configured" Message and Wait for 2 Minutes on Ubuntu Server Boot

## Problem
* Installed Ubuntu Server 22.04 on a Server
* The Server Has 2 Ethernet Adapters
  * Built-in Ethernet Interface on Mainboard
  * Additional PCI x 4 Ethernet Card with Intel 82576(Dual Ports)
* Got "A start job is running for wait for network to be configured" Message and It Stayed About 2 Minutes on Boot

## Root Cause
* There're 3 Ethernet Interfaces
* Only One is UP(with Ethernet Cable Plugged)
* Other 2 Ethernet Interfaces(Ports / Devices) are DOWN(No Ethernet Cable Plugged)
* System Waits Other 2 Ethernet Devices to Be Configured

## Solution
Add `optional: true` to any devices that may not always be available in netplan config file(e.g. `/etc/netplan/00-installer-config.yaml` or `/etc/netplan/50-cloud-init.yaml`)

* Backup netplan Config File(e.g. `/etc/netplan/50-cloud-init.yaml`)

  ```
  sudo cp /etc/netplan/50-cloud-init.yaml /etc/netplan/50-cloud-init.yaml.bk
  ```

* Edit `/etc/netplan/xx.yaml`

  ```
  # This is the network config written by 'subiquity'
  network:
    ethernets:
      # 1st Device
      eno1:
        dhcp4: true
        optional: true
      # 2nd Device
      enp1s0f0:
        addresses:
        - 10.0.10.92/24
        # gateway4: 10.0.10.1
        routes:
        - to: default
          via: 10.0.10.1
        nameservers:
          addresses:
          - 223.5.5.5
          - 223.6.6.6
          search: []
      # 3rd Device
      enp1s0f1:
        dhcp4: true
        optional: true
    version: 2  
  ```

## References
* [A start job is running for wait for network to be configured. Ubuntu server 17.10](https://askubuntu.com/questions/972215/a-start-job-is-running-for-wait-for-network-to-be-configured-ubuntu-server-17-1)

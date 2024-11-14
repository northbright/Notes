# Intel 82576 Ethernet Card Does Not Work on Ubuntu 24.04.1

## Problem
* Plug an Intel 82576 ethernet card(dual ports) on the PCIE x 16 slot of the mainboard
* Installed Ubuntu 24.04.1 via USB disk
* Plug the cable to the port of Intel 82576 ethernet card and the LED does not blink
* `ip addr` shows the states of the interfaces of Intel 82576 ethernet card are **DOWN**

  > enp1s0f0: ...... DOWN ......
  > enp1s0f1: ...... DOWN ......

## Root Cause
The ethernet interfaces of Intel 82576 ethernet card are not delcared in the `netplan` config file(e.g. `/etc/netplan/50-cloud-init.yaml`).

## Solution
Add ethernet interfaces configuration of Intel ethernet card in the `netplan` config file.

#### Open `netplan` Config File

```bash
sudo vi /etc/netplan/50-cloud-init.yaml
```

#### Add Configuration

```bash
network:
    ethernets:
        eno1:
            dhcp4: true

        # This is port 0(upper) of Intel 82576
        enp1s0f0:
            dhcp4: true

        # This is port 1(lower) of Intel 82576
        enp1s0f1:
            dhcp4: true
    version: 2
```

#### Apply the Configuration

```bash
sudo netplan try
```

## References
* [intel 82576网卡折腾-sr-iov使用](https://yanke.info/?id=127)

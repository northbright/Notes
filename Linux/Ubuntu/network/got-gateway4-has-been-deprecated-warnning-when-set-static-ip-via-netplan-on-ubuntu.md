# Got`gateway4 has been deprecated` Warnning when Set Static IP via `netplan` on Ubuntu

## Problem
* Need to set static IP on Ubuntu 22.04
* Set the IP of gateway in `00-installer-config.yaml` via `gateway4: GATEWAY_IP`
* Got `gateway4 has been deprecated` warnning when run `sudo netplan try`

## Root Cause
`gateway4` option has been deprecated in latest `netplan`

## Solution
Use `routes` option instead

```
routes:
  - to: default
    via: 
```

## Example
```
sudo vi 00-installer-config.yaml
```

```
network:
  ethernets:
    enp0s31f6:
      addresses:
        - 10.0.10.100/24
      routes:
        - to: default
          via: 10.0.10.1
      nameservers:
        addresses:
          - 223.5.5.5
          - 223.6.6.6
  version: 2
```

## References
* [How to Configure Static IP Address on Ubuntu 20.04](https://www.rosehosting.com/blog/how-to-configure-static-ip-address-on-ubuntu-20-04/)
* [netplan generate: `gateway4` has been deprecated, use default routes instead](https://unix.stackexchange.com/questions/681220/netplan-generate-gateway4-has-been-deprecated-use-default-routes-instead)
* [Ubuntu netplan gateway4 has been deprecated](https://tizutech.com/ubuntu-netplan-gateway4-has-been-deprecated/)

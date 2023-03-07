# Set Static IP on Ubuntu

## Problem
* Ubuntu Server's Installed with DHCP Enabled
* Need to Use Static IP Now

## Get the Ethernet Interface that We Want to Configure IP for

```
ip a

// Output:
1: lo: ......
2: enp0s31f6: ......
3: wlp0s20f3: ......
```

In this case, `enp0s31f6` is the ethernet interface.

## Replace `dhcp4` with Static IP Settings
* Backup Config File(`/etc/netplan/00-installer-config.yaml`)

  ```
  sudo cp /etc/netplan/00-installer-config.yaml /etc/netplan/00-installer-config.yaml.bk
  ```

* Disable DHCP and Set Static IP

  ```
  sudo vi /etc/netplan/00-installer-config.yaml
  ```

  ```
  # This is the network config written by 'subiquity'
  network:
    ethernets:
      enp0s31f6:
        # dhcp4: true
        # Set stasic IP
        addresses:
          - 10.0.10.155/24
        routes:
          - to: default
            via: 10.0.10.1
        nameservers:
          addresses:
            - 223.5.5.5
            - 223.6.6.6
    version: 2
  ```

* Save and Try to Apply New `netplan` Settings 

  ```
  sudo netplan try
  ```

## References
* [How to Configure Static IP Address on Ubuntu 20.04](https://www.rosehosting.com/blog/how-to-configure-static-ip-address-on-ubuntu-20-04/)
* [netplan generate: `gateway4` has been deprecated, use default routes instead](https://unix.stackexchange.com/questions/681220/netplan-generate-gateway4-has-been-deprecated-use-default-routes-instead)
* [Ubuntu netplan gateway4 has been deprecated](https://tizutech.com/ubuntu-netplan-gateway4-has-been-deprecated/)

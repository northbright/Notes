# Set Static IP on CentOS 8

## Modifiy `/etc/sysconfig/network-scripts/ifcfg-XX`
* XX is your ethernet adpater name(e.g. `ifcfg-enp0s3`)

```
sudo vi /etc/sysconfig/network-scripts/ifcfg-enp0s3
```

```
BOOTPROTO=static
ONBOOT="yes"
IPADDR=192.168.1.18
NETMASK=255.255.255.0
GATEWAY=192.168.1.1
DNS1=192.168.1.1
```

## Reload NetworkManager Service
```
// 1. Reload all ifcfg-XX
sudo nmcli c reload
```

```
// 2. Reapply ifcfg-XX / reconnect
sudo nmcli c up enp0s3
```

```
// 3. check
nmcli
```

## References
* [基于RHEL8/CentOS8的nmcli常用命令总结](https://blog.51cto.com/cyent/2332161)


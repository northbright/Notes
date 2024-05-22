# Failed to Ping IP of Other Vlanif due to Both Physical and Protocol of Vlanif are Down

## Problem
* Huawei S5735S Switch
* Create VLAN 10 20 and Vlanif
  ```
  vlan batch 10 20
  ```

  ```
  interface vlanif 10
  ip address 10.0.10.1 24
  quit
  ```

  ```
  interface vlanif 20
  ip address 10.0.20.1 24
  ```

* Create DHCP Server on Vlanif 10

  ```
  dhcp enable
  ```

  ```
  interface Vlanif 10
  dhcp select interface

  // Reserve IP addresses.
  dhcp server excluded-ip-address 10.0.10.1 10.0.10.50 

  // Set DNS servers. 
  dhcp server dns-list 223.5.5.5 223.6.6.6

  // Set lease time.
  // Lease time for PC is UNLIMITED.
  dhcp server lease unlimited

  quit
  ```

* Config GE0/0/4 as Access Port(VLAN 10)
* Connect PC to GE0/0/4
* Got IP via DHCP(e.g. `10.0.10.205`)
* PC Faied to ping IP of Vlanif20(`10.0.20.1`)

## Root Cause
Physical and protocol of Vlanif 20 is down.

```
display ip interface brief

Interface                         IP Address/Mask      Physical   Protocol
Vlanif10                          10.0.10.1/24         up         up 
Vlanif20                          10.0.20.1/24         down       down
```

If PC or Other device of Vlanif 20 is connected, the physical and protocol of Vlanif 20 will be up.

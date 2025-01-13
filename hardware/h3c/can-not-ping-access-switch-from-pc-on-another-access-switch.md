# Can Not ping Access Switch from PC

## Problem
* H3C Core Switch
  * Vlanif1: `10.0.1.1/24`
  * Vlanif10: `10.0.10.1/24`
  * Enable DHCP server on VLAN 10
    * Gateway: `10.0.10.1`
  * GE1/0/1 -> Access Switch GE1/0/48(trunk port, permit vlan 1 10)

* H3C Access Switch
  * Vlanif: `10.0.1.11/24`
  * GE1/0/23 -> PC(access vlan 10)

* Run `ping 10.0.10.1` successfully on PC
* Failed to run `ping 10.0.1.1` on PC

## Root Cause
PC pings access switch from VLAN 10 and access switch needs a route to VLAN 10 from VLAN 1(ping back to PC).
* PC IP: `10.0.10.x` -> `10.0.10.1`(Gateway) on core switch

## Solution
create a default route to core switch for all VLAN on access switch.

```
ip route-static 0.0.0.0 0.0.0.0 10.0.1.1

## References
* [交换机管理VLAN1的ip不能ping通](https://zhiliao.h3c.com/questions/dispcont/115478)
```

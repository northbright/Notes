# Mi TV DHCP Does NOT work

## Problem
* All Mi TVs connected to the switch ports which are **ACCESS** type(VLAN 20)
* Already created a DHCP server for VLAN 20(H3C S5500 Switch)
  * Network: `10.0.20.0/24`
  * Subnet Mask: `255.255.255.0`
  * Gateway: `10.0.20.1`
  * DNS List: `10.0.100.2`
* Mi TV can not obtain IP via DHCP
* But Red Mi TV(x55) works at the same time
* If we turn off DHCP and set a static IP first manually then turn on DHCP again, it can obtain IP via DHCP. But DHCP still does NOT work after Mi TV reboots.

## Solution
Use static IP
* Set "Settings" > "Network" > "Manual Setting" > "On"
* Set an unused static IP

# H3C Switch Ports Should be Set to Trunk to Connect to UBNT AP

## Problem
* Some H3C switch ports are used to connect UBNT UAPs 
* VLAN 2(10.0.2.0/24) is used for UBNT UAP and there's DHCP server to assign IPs for UAP.
* VLAN 10(10.0.10.0/24) is used for guest WLAN clients and there's a DHCP server to assign IPs.
* VLAN 20(10.0.20.0/24) is used for work WLAN clients and there's a DHCP server to assign IPs
* There're 2 SSIDs created via UNBT Unifi Controller

  | SSID | Description | VLAN |
  | :--: | :--: | :--: |
  | guest | for guest use only | 20 |
  | employee | for employee use | 10 |

* H3C switch ports connected to UBNT APs are set to "access" link type(VLAN 20)
* Clients of emplyee SSID can not obtain IPs

## Solution
* H3C switch ports connected to UBNT APs should be set to **Trunk**(permit VLANs: 1 2 10 20)
* Set trunk PVID to 2, so UAP can get IPs(DHCP)

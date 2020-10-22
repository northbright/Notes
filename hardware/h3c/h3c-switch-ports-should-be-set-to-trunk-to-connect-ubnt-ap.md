# H3C Switch Ports Should be Set to Trunk to Connect to UBNT AP

## Problem
* There're 2 SSIDs created via UNBT Unifi Controller

  | SSID | Description | VLAN |
  | :--: | :--: | :--: |
  | guest | for guest use only | 30 |
  | employee | for employee use | 3 |

* H3C switch ports connected to UBNT APs are set to "access" link type(VLAN 3)
* DHCP pools of VLAN 3, 30 are created on H3C switch 
* Clients of emplyee SSID can not obtain IPs

## Solution
* H3C switch ports connected to UBNT APs should be set to **Trunk**(permit VLANs: 3, 30)

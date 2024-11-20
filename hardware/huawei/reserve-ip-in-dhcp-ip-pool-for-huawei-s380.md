# Reserve IP in DHCP IP Pool for Huawei S380

## Problem
* Huawei S380 S8P2T(V600R024C00SPC100)
* Created VLANIF(e.g. VLAN 2 `10.0.2.1/24`) and enabled DHCP server
* Need to reserve first 50 IPs in DHCP IP Pool for VLAN 2

## Solution
* Configuration > Device List > S380 > LAN > VLAN
* Click ">" icon in front of VLAN 21 and it shows "IP Pool" settings
* Select the IPs to reserve > Reserve IP

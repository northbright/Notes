# Failed to Mirror iPad to Xiaomi TV due to Incorrect Static IP Setting

## Problem
* Failed to Mirror iPad to Xiaomi TV
* Xiaomi TV Uses Ethernet Cable to Connect to the Local Network(VLAN 20: `10.0.20.1/24`)
* iPad Connects the WLAN which VLAN is also VLAN 20

## Root Cause
* DHCP Server is Enabled on VLAN 20
* Static IPs for TVs are Reserved: `10.0.20.3` to `10.0.20.40`
* TCP / IP Settings: Static
* The IP is Set to `10.0.20.243` which May Conflict with Other Device's IP Obtained via DHCP

## Solution
* Set Static IP of Xiaomi TV in the Reserved IP Range(e.g. `10.0.10.14`)

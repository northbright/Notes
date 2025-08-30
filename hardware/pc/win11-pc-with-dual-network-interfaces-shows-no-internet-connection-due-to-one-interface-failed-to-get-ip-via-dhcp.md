# Win11 PC with Dual Network Interfaces Shows No Internet Connection due to One Interface Failed to Get IP via DHCP

## Problem
* Dell T3460 has 2 network interfaces: WLAN and ethernet
* Both WLAN and ethernet interfaces are on and get IP via DHCP
* Windows 11 shows no internet connection

## Root Cause
* WLAN interface faied to get IP via DHCP(DHCP pool is full)

## Solution
Turn off WLAN and reboot PC to use ethernet only.

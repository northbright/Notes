# Fix WLAN Bridged Network Unreachable issue for VirtualBox

## Background
* Host Machine: MacBook Pro
* Client OS: CentOS 8
* Vritual Box Network Configuration
  * Bridged
  * Adapter: Wireless

## Problem
* Run `ip addr` and there's no IP address
* Run `nmcli`, show : `enp0xx: connecting... getting IP address...`
* Network is unreachable

## Root Cause
* DHCP may not work due to need WiFi password

## Solution
* [Set static IP on CentOS 8](set-static-ip-on-centos-8.md)

## References
* [How To Use Your Wireless Adapter With VirtualBox Bridge Mode](https://www.revolutionweb.com.au/computer-security/use-wireless-adapter-virtualbox-bridge-mode/)
* [Unable to bridge WIFI](https://forums.virtualbox.org/viewtopic.php?t=84831#p402720)


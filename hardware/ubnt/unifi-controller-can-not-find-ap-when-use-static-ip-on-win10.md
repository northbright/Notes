# Unifi Controller Can Not Find AP when Use Static IP on Win10

## Problem
* UBNT APs are connected to the ports on the switch
  * Trunk port: Permit VLAN 1 2
  * VLAN 2: 10.0.2.0/24 network
* Run Unifi Controller on a PC
  * Windows 10 Home
  * Connect the PC to the port of on the same switch
    * Access port: VLAN 2
  * Set static IP:
    * IP: 10.0.2.8
    * Subnet Mask: 255.255.255.0
    * Gateway: 10.0.2.1
    * DNS: 10.0.2.2
* Can not find any APs

## Root Cause
* The network name is "Undefined Network" when use static IP
* Default network profile of "Undefined Network" is set to "Public"
* Default firewall settings for "Public" network profile are strict and make the tool **NOT** work

## Solution
* [Set Network Profile to Private when Set Static IP on Win10 Home](https://github.com/northbright/Notes/blob/master/Windows/network/set-network-profile-to-private-when-set-static-ip-on-win10-home.md)


# No Internet Connection Using DHCP due to Previous Incorrect Static IP Settings on Win11

## Problem
* OS: Windows 11 Home Edition
* Use Static IP for the First Time
  * Static IP: `192.168.2.171`
  * Subnet Mask: `255.255.255.0`
  * Gateway: `192.168.2.1`
  * DNS: `192.168.2.171`(This is incorrect)
* PC Has No Internet Connection and Can Visit PCs in LAN Only
* Use DHCP for the Second Time
  * IP: `192.168.2.183`
  * Subnet Mask: `255.255.255.0`
  * Gateway: `192.168.2.1`
  * DNS: `192.168.100.2`(via DHCP: Router as DNS Relay Server)
* PC Still Has No Internet Connection
* Try Following Methods and None of them Works:
  * Run `ipconfig /renew`
  * Run `ipconfig /flushdns`
  * Settings > Reset Network Settings
  * Reboot PC

## Solution
Re-use static IP with correct DNS to make internet connection work and switch to DHCP again.

* Static IP Settings
  * Static IP: `192.168.2.8`
  * Subnet Mask: `255.255.255.0`
  * Gateway: `192.168.2.1`
  * DNS: `223.5.5.5`(Use Aliyun DNS)
* It Works and the PC Has Internet Connection
* Then Obtain IP via DHCP Again
* The PC Still Has Internet Connection when Using DHCP

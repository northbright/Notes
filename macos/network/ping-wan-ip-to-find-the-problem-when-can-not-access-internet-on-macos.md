# Ping WAN IP to Find the Problem when Can Not Access Internet on macOS

## Problem
* H3C ER5200G2 Router may be incorrectly configured
* WAN 1 is configured to obtain IP via DHCP from ISP
* MacBook connected to the router can not access internet
* Need to find out the problem

## Solution
Run `ping WAN IP` on macOS to test if WAN can be reached.

* It failed to ping WAN IP

  * Check macOS Preferences > Network > Select an Ethernet Interface > Details > Router(it's the gateway) and it is incorrect: `223.5.5.5`(Aliyun DNS)
  * Set it to `10.0.1.x`(IP of the router) and it can ping WAN IP successfully.
  * Find the next hop in router's route table of WAN IP
  * It succeeded to ping next hop of WAN IP

* Try to ping `baidu.com` and it fails

  * Check Preferences > Network > Select an Ethernet Interface > Details > DNS on the left column and it is not set
  * Set it to `10.0.1.x`(IP of the router) and it can ping `baidu.com` successfully.

# Can Not Access LAN or Internet after Connected to WiFi on Specified UAP Because the Speed of Interface Connected to UAP on Switch is 100M

## Problem
* Deploy U6 Lite UAPs(about 13 UAPs)
* Configured the site using UBNT Unifi Controller(or Unifi Network)
* Works fine for a long time
* The clients(phones, laptop) in one office(1st floor) can not access LAN or internet suddenly
* All clients can connect to the WiFi SSID and obtain IP successfully via DHCP which configured on H3C S5500 switch
* The clients can access LAN or internet in other office(2nd floor) or other areas far away from the office

## Root Cause
* Login UBNT Unifi Controller and find the UAP is offline
* Click "click to resolve" > "Advanced Adoption" > Input username and password to adopt
* Failed to adopt the UAP repeatly
* Log in the POE switch which used to connect UBNT UAP
* The speed of interface(port) which connect the UAP installed in the office is 100M and others
are 1G
* Ethernet cable / RJ45 jack connected to UAP or POE switch may have problem

## Solution
* Method A

  Just remove the UAP if there're UAPs nearby.
  * Remove the UAP in Unifi Controller
  * Unplug the cable connected to the UAP and the POE switch

* Method B
  Check / replace the ethernet cable and RJ45 jack to make sure the interface speed is 1G

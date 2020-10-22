# Connect H3C Switch to H3C Router

## Devices

| Device | Use |
| :--: | :--: |
| H3C ER8300G2-X Router | Create PPPOE Dial Connection |
| H3C S5500 Switch | Connect Switches, PCs, Printers |

## Hardware Setup
* Connect router's WAN port to modem which provided by ISP
* Connect one port of switch to one LAN port of router

## H3C S5500v2 Switch Setup
* Create VLANs(e.g. 1, 2, 3)
* Create a specified VLAN(e.g. 100) to connect to the router
* Set the IP of VLAN 100 interface(e.g. 192.168.100.1)
* Create a static route: all VLANs IP up-link to the router's IP of VLAN 100(e.g. 192.168.100.2)

      // ip route-static IP MASK NextHOP_IP_Address
      ip route-static 0.0.0.0 0.0.0.0 192.168.100.2
* Set the link-type of the port connected to the router to `trunk`(permite all VLANs)

## H3C ER8300G2-X Router Setup
* Create VLANs which are the same as the one of H3C S5500v2(e.g. 1, 2, 3) and set IPs(make sure there's no conflict)
* Create a specified VLAN(e.g. 100) to connect to the switch
* Set the IP of VLAN 100 interface(e.g. 192.168.100.2)
* Set the link-type of the LAN port which connected to the switch to `trunk`(permit all VLANs)
* Add static route for all VLANs: Next hop is the IP of VLAN 100 of the switch(e.g. 192.168.100.1)

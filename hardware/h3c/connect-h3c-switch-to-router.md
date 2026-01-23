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
* Create business Vlanif on switch(VLAN10: `192.168.10.1`, VLAN20: `192.168.20.1`)

  ```sh
  vlan 10 20
  interface vlan 10
  ip address 192.168.10.1 24
  quit
  
  interface vlan 20
  ip address 192.168.20.1 24
  quit  
  ```

* Create a specified Vlanif100(`192.168.100.1`) used to communicate with router

  ```sh
  vlan 100
  interface vlan 100
  ip address 192.168.100.1 24
  quit
  ```

* Create a default(static) route on switch

  ```sh
  ip route-static 0.0.0.0 0.0.0.0 192.168.100.2
  ```

  * Note:
  
    If Vlanif1(e.g. `192.168.1.1`) is created on the switch,
    it may failed to ping router's Vlanif1(e.g. `192.168.1.2`) from business VLAN(e.g. VLAN10).
    Because the static route(pre:60) is overrided by the direct route(pre:0) for `192.168.1.0/24`:

    ```sh
    display ip routing-table

    0.0.0.0/0          Static  60  0           192.168.100.2   Vlan100
    ......
    192.168.1.0/24     Direct  0   0           192.168.1.1     Vlan1
    ```

    * Method A: delete Vlanif1 on switch

      ```sh
      undo interface vlan 1
      ```

    * Method B
    Create a static route: dest: Vlanif1 of router(subnet mask:32), next hop: Vlanif100 of router. 

    ```sh
    ip route-static 192.168.1.2 32 192.168.100.2
    ```

* Set the link-type of the port connected to the router to `trunk`

  ```sh
  // Permit VLAN 100 only and block all other VLANs
  // to avoid switch flooding to router.
  interface ge1/0/24
  port link-type trunk
  port trunk permit vlan 100
  quit
  ```

  * It should config the link type of both ports to **ACCESS**
  * H3C ER5200, ER8200 can only configure LAN as **TRUNK** port only
  * So we have to configure the port on switch as **TRUNK** port too
  * Huawei S380 can configure LAN as **ACCESS** port 

## H3C ER8300G2-X Router Setup
* Create a specified Vlanif100(`192.168.100.2`) used to communicate with switch
* Set the link-type of the LAN port which connected to the switch to `trunk`(permit VLAN100)
* Add static routes for all business VLANs

  Set next hot to Vlanif100 of switch(`192.168.100.1`) and set out interface to Vlan100.

  ```sh
  Dest: `192.168.10.0`
  Subnet Mask: `255.255.255.0`
  Next Hop: `192.168.100.1`
  Out Interface: `VLAN100`

  Dest: `192.168.20.0`
  Subnet Mask: `255.255.255.0`
  Next Hop: `192.168.100.1`
  Out Interface: `VLAN100`  
  ```

# Network Example

## Network Topology
```
+-----------------------+
| H3C ER8300G2 X Router |
+-----+-----------------+
      |
      |
+-----+-----+
| H3C S5500 |
++--+---+-+-+
 |  |   | |
 |  |   | |
 |  |   | |   +-----------+
 |  |   | +---+ H3C S5120 +-----------------------------+
 |  |   |     +--+---+----+                             |
 |  |   |        |   |                                  |
 |  |   |        |   +------------+                     |
 |  |   |        |                |                     |
 |  |   |     +--+----+  +--------+-----------+  +------+---------+
 |  |   |     | Mi TV |  | Panasonic KX NS300 |  | Phone Recorder |
 |  |   |     +-------+  +--------------------+  +----------------+
 |  |   |
 |  |   |
 |  |  ++----------+
 |  |  | H3C S5120 +-------------------+
 |  |  +-+---+-----+                   |
 |  |    |   |                         |
 |  |    |   +------------+            |
 |  |    |                |            |
 |  |    |   +----+   +---+----+   +---+-----+
 |  |    +---+ PC |   | Server |   | Printer |
 |  |        +----+   +--------+   +---------+
 |  |
 |  |
 | ++--------------+
 | | H3C S5120 POE |
 | +--------+------+
 |          |
 |    +-----+------------+
 |    | UBNT UAP AC Lite |
 |    +------------------+
 |
 |
++--------------+
| H3C S5120 POE +-----------------+
+------+--------+                 |
       |                          |
       |                          |
    +--+---------------+   +------+--------+
    | Hikvision Camera |   | Hikvision NVR |
    +------------------+   +---------------+
```

## Devices

| Device | Num | Desc |
| :--: | :--: | :--: |
| H3C ER8200G2-X | 1 | Router |
| H3C S5500V2-28C-EI | 1 | Core Switch |
| H3C S5120V2-52P-SI | 2 | Access Switch |
| H3C S5120V2-28P-HPWR-LI | 3 | POE Access Switch |
| UBNT UAP AC Lite | 17 | AP |
| Hikvision Camera | 32 | Camera |
| Hikvision NVR | 2 | NVR |
| Panasonic KX-NS300 | 1 | PBX |
| Shenou SOC Phone Recording System | 1 | Phone Recording |
| HP Z240 Workstation | 1 | Shared Server |

## Purchase Internet / Telephone Service from ISP

Before setting up network, we need to purchase Internet / Telephone service and make sure the fiber optic cable that comes to the equiment room.

## Configure Gateway of ISP
* Ask ISP to set the mode of Gateway to bridge mode(default is router)

  Use H3C ER8200G2-X router to create a PPPOE Dial-up connection with the account / password given by the ISP.

## Apply Caller ID Display service

To make Phone Recording System can record the caller ID(number), make sure to apply Caller ID Display service from ISP.

## VLAN Plan

| VLAN ID | Netowork | Desc | Create DHCP server |
| :--: | :--: | :--: | :--: |
| 1 | 10.0.1.0/24 | For Network device management. e.g. SSH to switches | No |
| 2 | 10.0.2.0/24 | For UNBT UAPs | Yes |
| 3 | 10.0.3.0/24 | For Hikvision Network Cameras(#1 - #16) and NVR(#1)  | No |
| 5 | 10.0.5.0/24 | For Hikvision Network Cameras(#17 - #32) and NVR(#2) | No |
| 6 | 10.0.6.0/24 | For Panasonic KX-NS300 PBX and Shenou SOC Phone Recording System | No |
| 10 | 10.0.10.0/24 | For PCs, server, printers and laptops | Yes |
| 20 | 10.0.20.0/24 | For mobile phones, TVs(Airplay) | Yes |
| 100 | 10.0.100.0/24 | For communication between H3C S5500 core switch and H3C ER8200G2 X router | No |

## H3C S5500 Core Switch Settings
* Disable terminal moniter

  ```
  undo terminal moniter
  ```
* Enter System View

  ```
  system-view
  ```
* Create VLAN interfaces

  ```
  vlan 1 2 3 5 6 10 20 100
  ```
* Set IP for VLAN interfaces

  ```
  interface vlan 1
  ip address 10.0.1.1 24
  quit
  
  interface vlan 2
  ip address 10.0.2.1 24
  quit

  interface vlan 3
  ip address 10.0.3.1 24
  quit
   
  interface vlan 5
  ip address 10.0.5.1 24
  quit

  interface vlan 6
  ip address 10.0.6.1 24
  quit
   
  interface vlan 10
  ip address 10.0.10.1 24
  quit

  interface vlan 20
  ip address 10.0.20.1 24
  quit

  interface vlan 100
  ip address 10.0.100.1 24
  quit
  ```

* Create DHCP Servers on H3C S5500 Core Switch

  ```
  dhcp enable

  dhcp server ip-pool vlan2
  network 10.0.2.0 mask 255.255.255.0
  gateway-list 10.0.2.1
  // Use DNS relay on H3C ER8200G2-X router(IP: 10.0.100.2)
  dns-list 10.0.100.2
  quit

  dhcp server ip-pool vlan10
  network 10.0.10.0 mask 255.255.255.0
  gateway-list 10.0.10.1
  // Use DNS relay on H3C ER8200G2-X router(IP: 10.0.100.2)
  dns-list 10.0.100.2
  quit

  dhcp server ip-pool vlan20
  network 10.0.20.0 mask 255.255.255.0
  gateway-list 10.0.20.1
  // Use DNS relay on H3C ER8200G2-X router(IP: 10.0.100.2)
  dns-list 10.0.100.2
  quit
  ```

* Set forbidden IP range of DHCP ip pool

  ```
  // Reserve first 20 IPs
  dhcp server forbidden-ip 10.0.2.1 10.0.2.20
  dhcp server forbidden-ip 10.0.10.1 10.0.10.20
  dhcp server forbidden-ip 10.0.20.1 10.0.20.20
  ```

* Trunk Ports

| Port | Connected Device | Permit VLANs | PVID | Desc |
| :--: | :--: | :--: | :--: | :--: |
| GE1/0/1 | H3C S5120 Access Switch(#1) | 1 6 20 100 | 1(default) | connect TVs(VLAN 20), Panasonic KX-NS300(VLAN 6), Shenou Phone Recording System(VLAN 6) |
| GE1/0/2 | H3C S5120 Access Switch(#2) | 1 10 100 | 1(default) | connect PCs, servers and printers(VLAN 10) |
| GE1/0/3 | H3C S5120 POE Switch(#1) | 1 2 10 20 100 | 1(default) | connect UBNT UAPs(VLAN 2), TVs(Airplay), mobile phones(VLAN 20), Laptops which need to access local servers, printers(VLAN 10) |
| GE1/0/4 | H3C S5120 POE Switch(#2) | 1 5 100 | 1(default) | connect Hikvision Network Cameras(#1 - #16), NVR(#1) |
| GE1/0/5 | H3C S5120 POE Switch(#3) | 1 3 100 | 1(default) | connect Hikvision Network Cameras(#17 - #32), NVR(#2) |
| GE1/0/28 | H3C ER8200G2-X Router | 1 2 3 5 6 10 20 100 | 1(default) | Static Route to Router |

| Wireless Network | VLAN Only network | Desc |
| :--: | :--: | :--: |
| Mobile | 20 | TVs(Airplay), mobile phones |
| Work | 10 | Laptops which need to access local servers, printers |

Commands:

```
interface ge1/0/1
port link-type trunk
port trunk permit vlan 1 6 20 100 

interface ge1/0/2
port link-type trunk
port trunk permit vlan 1 10 100
  
interface ge1/0/3
port link-type trunk
port trunk permit vlan 1 2 10 20 100

interface ge1/0/4
port link-type trunk
port trunk permit vlan 1 5 100

interface ge1/0/5
port link-type trunk
port trunk permit vlan 1 3 100

interface ge1/0/28
port link-type trunk
port trunk permit vlan 1 2 3 5 6 10 20 100
```

* Static Route to H3C ER8200G2-X Router

  Create a static route: all VLANs IP up-link to the router's IP of VLAN 100(10.0.100.2/24)
  Provide Internet service

  ```
  // ip route-static IP MASK NextHOP_IP_Address 
  ip route-static 0.0.0.0 0.0.0.0 10.0.100.2
  ```

## H3C S5120 Access Switch(#1) Settings --> connect TVs(VLAN 20), Panasonic KX-NS300(VLAN 6), Shenou Phone Recording System(VLAN 6)

* Create VLAN interfaces

  ```
  vlan 1 6 20
  ```
* Set IP for VLAN interfaces

  ```
  // VLAN 1 for management
  interface vlan 1
  ip address 10.0.1.11 24
  ```

* Access Ports

  | Port | Access VLAN | Connected Device |
  | :--: | :--: | :--: |
  | GE1/0/1 - GE1/0/45 | 20 | Connect to TVs, mobile phones(VLAN 20) can project to TV via Airplay |
  | GE1/0/46 | 6 | Connect to Shenou Phone Recording System |
  | GE1/0/47 | 6 | Connect to Panasonic KX-NS300 PBX |

  ```
  vlan 20
  port ge1/0/1 to ge1/0/45
  quit

  interface ge1/0/46
  port link-type access
  port access vlan 6
  quit

  interface ge1/0/47
  port link-type access
  port access vlan 6
  ```

* Trunk Ports

  | Port | Connected Device | Permit VLANs | PVID | Desc |
  | :--: | :--: | :--: | :--: | :--: |
  | GE1/0/48 | H3C S5500 Core Switch | 1 6 20 100 | 1 | link back to H3C S5500 Core Switch |


  ```
  interface ge1/0/48
  port link-type trunk
  port trunk permit vlan 1 6 20 100
  ```

## H3C S5120 Access Switch(#2) Settings --> connect PCs, servers, printers

* Create VLAN interfaces

  ```
  vlan 1 10
  ```
* Set IP for VLAN interfaces

  ```
  // VLAN 1 for management
  interface vlan 1
  ip address 10.0.1.12 24
  ```

* Access Ports

  | Port | Access VLAN | Connected Device |
  | :--: | :--: | :--: |
  | GE1/0/1 - GE1/0/47 | 20 | Connect to PCs, servers, printers |

  ```
  vlan 10
  port ge1/0/1 to ge1/0/45
  quit
  ```

* Trunk Ports

  | Port | Connected Device | Permit VLANs | PVID | Desc |
  | :--: | :--: | :--: | :--: | :--: |
  | GE1/0/48 | H3C S5500 Core Switch | 1 10 100 | 1 | link back to H3C S5500 Core Switch |


  ```
  interface ge1/0/48
  port link-type trunk
  port trunk permit vlan 1 10 100
  ```

## H3C S5120 POE Switch(#1) Settings --> connect UBNT UAP

* Create VLAN interfaces

  ```
  vlan 1 2 10 20
  ```
* Set IP for VLAN interfaces

  ```
  // VLAN 1 for management
  interface vlan 1
  ip address 10.0.1.13 24
  ```

* Access Ports

  | Port | Access VLAN | Connected Device |
  | :--: | :--: | :--: |
  | GE1/0/18 - GE1/0/27 | 2 | Connect to Laptop to run Unifi Controller. To make Unifi Controller discover UAPs, the laptop and UAPs should be in the same VLAN(2). |

  ```
  vlan 2
  port ge1/0/18 to ge1/0/27
  quit
  ```

* Trunk Ports

  | Port | Connected Device | Permit VLANs | PVID | Desc |
  | :--: | :--: | :--: | :--: | :--: |
  | GE1/0/1 to GE1/0/17 | UBNT UAPs | 1 2 10 20 100 | 2 | The port connected to UAP should be trunk port with PVID 2 that UAPs can get IPs by DHCP(VLAN 2). Permitted VLANs include the VLAN used by UAPs(VLAN 2) and the Wireless Networks(VLAN 10, 20) |
  | GE1/0/28 | H3C S5500 Core Switch | 1 2 10 20 100 | 1 | link back to H3C S5500 Core Switch |


  ```
  interface rage ge1/0/1 to ge1/0/17
  port link-type trunk
  port trunk permit vlan 1 2 10 20 100
  port trunk pvid 2
  quit

  interface ge1/0/28
  port link-type trunk
  port trunk permit vlan 1 6 20 100
  ```

## H3C S5120 POE Switch(#2) Settings --> connect Hikvision network cameras, NVR

* Create VLAN interfaces

  ```
  vlan 1 5
  ```
* Set IP for VLAN interfaces

  ```
  // VLAN 1 for management
  interface vlan 1
  ip address 10.0.1.14 24
  ```

* Access Ports

  | Port | Access VLAN | Connected Device |
  | :--: | :--: | :--: |
  | GE1/0/1 - GE1/0/27 | 5 | Connect to Hikvision network cameras, NVR(ge1/0/26) |

  ```
  vlan 5
  port ge1/0/1 to ge1/0/27
  quit
  ```

* Trunk Ports

  | Port | Connected Device | Permit VLANs | PVID | Desc |
  | :--: | :--: | :--: | :--: | :--: |
  | GE1/0/28 | H3C S5500 Core Switch | 1 5 100 | 1 | link back to H3C S5500 Core Switch |


  ```
  interface ge1/0/28
  port link-type trunk
  port trunk permit vlan 1 5 100
  ```

## H3C S5120 POE Switch(#3) Settings --> connect Hikvision network cameras, NVR

* Create VLAN interfaces

  ```
  vlan 1 3
  ```
* Set IP for VLAN interfaces

  ```
  // VLAN 1 for management
  interface vlan 1
  ip address 10.0.1.15 24
  ```

* Access Ports

  | Port | Access VLAN | Connected Device |
  | :--: | :--: | :--: |
  | GE1/0/1 - GE1/0/27 | 5 | Connect to Hikvision network cameras, NVR(ge1/0/26) |

  ```
  vlan 3
  port ge1/0/1 to ge1/0/27
  quit
  ```

* Trunk Ports

  | Port | Connected Device | Permit VLANs | PVID | Desc |
  | :--: | :--: | :--: | :--: | :--: |
  | GE1/0/28 | H3C S5500 Core Switch | 1 3 100 | 1 | link back to H3C S5500 Core Switch |


  ```
  interface ge1/0/28
  port link-type trunk
  port trunk permit vlan 1 3 100
  ```

## H3C ER8200G2-X Router Settings
* Create VLAN interfaces and IPs(via GUI)

  | VLAN | IP | Desc |
  | :--: | :--: | :--: |
  | 1 | 10.0.1.2 | Default VLAN and LAN to manage router |
  | 2 | 10.0.2.2 | UBNT UAP |
  | 3 | 10.0.3.2 | Hikvision network camera, NVR |
  | 5 | 10.0.5.2 | Hikvision netowrk camera, NVR |
  | 6 | 10.0.6.2 | Panasonic KX-NS300 PBX, Shenou Phone Recording System |
  | 10 | 10.0.10.2 | PCs, servers and printers |
  | 20 | 10.0.20.2 | Mobile clients connected to the WLAN provides by UBNT UAPs |
  | 100 | 10.0.100.2 | Static route for H3C ER8200G2-X and H3C S5500 Core Switch |

* Trunk Ports

  | LAN | PVID | Permit VLAN | Connected Device |
  | :--: | :--: | :--: | :--: |
  | 1 | 1 | 1 2 3 5 6 10 20 100 | H3C S5500 Core Switch |

* Static Routes

  Advanced Settings > Static Routes:

  | Destination IP | Subnet Mask | Next Hop | Out Interface |
  | :--: | :--: | :--: | :--: |
  | 10.0.1.0 | 255.255.255.0 | 10.0.100.1 | VLAN 1 |
  | 10.0.2.0 | 255.255.255.0 | 10.0.100.1 | VLAN 2 |
  | 10.0.3.0 | 255.255.255.0 | 10.0.100.1 | VLAN 3 |
  | 10.0.5.0 | 255.255.255.0 | 10.0.100.1 | VLAN 5 |
  | 10.0.6.0 | 255.255.255.0 | 10.0.100.1 | VLAN 6 |
  | 10.0.10.0 | 255.255.255.0 | 10.0.100.1 | VLAN 10 |
  | 10.0.20.0 | 255.255.255.0 | 10.0.100.1 | VLAN 20 |

## Panasonic KX-NS300 PBX Settings
* Network Service > IP Address/Ports

  * LAN Setting
    * Use the following IP address
    * IP Address: `10.0.6.3`
    * Subnet Mask: `255.255.255.0`
    * Default Gateway: `10.0.6.1`
    
## Shenou Phone Recording System Settings
* Settings > Network

  * IP Address: `10.0.6.4`
  * Subnet Mask: `255.255.255.0`
  * Default Gateway: `10.0.6.1`
  * DNS: `10.0.100.2`

## Hikvision NVR(#1) Setings
* Settings > Network > Basic Settings

  * IPv4 IP Address: `10.0.5.3`
  * Subnet Mask: `255.255.255.0`
  * Default Gateway: `10.0.5.1`
  * DNS: `10.0.100.2`

## Hikvision NVR(#2) Setings
* Settings > Network > Basic Settings

  * IPv4 IP Address: `10.0.3.3`
  * Subnet Mask: `255.255.255.0`
  * Default Gateway: `10.0.3.1`
  * DNS: `10.0.100.2`

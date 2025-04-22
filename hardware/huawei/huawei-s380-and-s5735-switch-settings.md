# Huawei S380 and S5735 Switch Settings

## Network Topology
```
                                           +-----------------------+                   
                                           |       S380-S8P2T      |                   
                                           +-+-----------------+---+                   
                                             |                 |                       
                                      LAN 1  |                 |WAN 1                  
                                             |                 |                       
                                             +------+          +----------------+      
                                                    |GE0/0/24                   | LAN 8
                                                    |                           |      
                             +----------------------+--+         +--------------+----+ 
                             |   S5735S Core Switch    |         |  Shanghai Telecom | 
                             +--+------------+------+--+         |   Gateway         | 
                        GE0/0/1 |            |      |            +-------------------+ 
                                |            |      |                                  
                                |            |      |                                  
                                |            |      |                                  
                       GE0/0/24 |            |      +--------+                         
                                |            |               |                         
        +-----------------------+--+   +-----+------+     +--+------+                  
        |    S5735 POE Switch      |   |    PC      |     |   TV    |                  
        ++--------+-----------+----+   +------------+     +---------+                  
         |        |           |                                                        
         |        |           |                                                        
+--------++   +---+---+   +---+--------------+                                         
| AP 160  |   | AP 362|   | HikVision Camera |                                         
+---------+   +-------+   +------------------+                                         

```

## VLAN Plan

| VLAN ID | Description |
| :--: | :--: |
| 1 | AC and AP. Wireless manager address of Huawei S380 must be VlanIf1 |
| 3 | HikVision NVR and Camera |
| 6 | IP PBX and IP Phone |
| 10 | PC and printer |
| 20 | Phone and TV |
| 30 | Guest |
| 100 | Used to connect Huawei core switch and S380. Set static routes on core switch and set way back routes on S380 via VlanIf100. |

## S380 Settings
#### Web Portal
* Default manage IP(VlanIf1): `192.168.112.1`(web portal: `https://192.168.112.1`)
* Register admin account and login
* Select "Local Management" > next

#### Internet Access Configuration
* Internet Access Configuration > Broadband Internet Access
* Select Internet access port(e.g. `GE0/0/10`
* Interface Configuration: select access mode(e.g. PPPoE)
  
  You may choose DHCP firstly if you have not get PPPoE account.
  Switch access mode to PPPoE when you get the account.

* Click "Deliver Configuration"
* Click "Run to Dashboard"

#### Software Upgrade
Huawei upgrades the software frequently and many new features require new version of software.

* Download latest software and patch
  * Visit <https://support.huawei.com/enterprise> and login Huawei account
  * Input "S380" and search > select "Software" category
  * Click latest software(e.g. "S100&S200&S300&S500&S600 V600R024C10SPC100")
  * Check sofware and patches and click download
  * You may asked to register the product("s380") before download
  * Input S380 for the product name and the S/N to register the product
  * Now we can download the software and patches

* Click top menu > Configuration > Device List
* Go to S380-S8P2T record > operation > Set Parameter
* Select System Management Tab > Software Upgrade > Local Upgrade > Click "Local Upgrade"
* Click "Upload" button > select downloaded software(e.g. `S380_V600R024C10SPC100.cc`)
* Select the latest software for next startup > OK > Save and Restart

#### Set Parameter for S380
Top menu > Configuration > Device List > go to the S380 record > Operation > Set Parameter

#### VLAN Configuration
Create a VLAN: LAN  > VLAN > Create > Input VLAN ID and Check "Create a VLANIF interface"

* Edit VLAN 1(AC and AP management VLAN)
  * IP: `192.168.112.1` / `255.255.255.0`
  * DHCP server > enable
  * Reserved IPs
    * Click the arrow before VLAN 1 > show IP pool > select IPs(e.g. `192.168.112.2` - `192.168.112.10`
    * Click "Reserve IP"

* VLAN 3(NVR and camera)
  * IP: `10.0.3.2` / `255.255.255.0`
  * DHCP server > disabled

* VLAN 6(IPPBX and IP phone)
  * IP: `10.0.6.2` / `255.255.255.0`
  * DHCP server > disabled

* VLAN 10(PC and printer)
  * IP: `10.0.10.2` / `255.255.255.0`
  * DHCP server > disabled

* VLAN 20(phone and TV)
  * IP: `10.0.20.2` / `255.255.255.0`
  * DHCP server > disabled
 
* VLAN 30(guest)
  * IP: `10.0.30.2` / `255.255.255.0`
  * DHCP server > disabled

* VLAN 100(Connect core switch to s380)
  * IP: `10.0.100.2` / `255.255.255.0`
  * DHCP server > disabled

#### Static Route
VLAN 3, 6, 10, 20, 30's next hop is `10.0.100.1`(VlanIf100 on core switch).

Create a staic route: LAN > Route > Static Routing Tab > Create

* VLAN 3
  * Destination IP address: `10.0.3.0`
  * Subnet mask: `255.255.255.0(24)`
  * Outbound interface: `VlanIf100`
  * Next hop: `10.0.100.1`

* VLAN 6
  * Destination IP address: `10.0.6.0`
  * Subnet mask: `255.255.255.0(24)`
  * Outbound interface: `VlanIf100`
  * Next hop: `10.0.100.1`

* VLAN 10
  * Destination IP address: `10.0.10.0`
  * Subnet mask: `255.255.255.0(24)`
  * Outbound interface: `VlanIf100`
  * Next hop: `10.0.100.1`

* VLAN 20
  * Destination IP address: `10.0.20.0`
  * Subnet mask: `255.255.255.0(24)`
  * Outbound interface: `VlanIf100`
  * Next hop: `10.0.100.1`

* VLAN 30
  * Destination IP address: `10.0.30.0`
  * Subnet mask: `255.255.255.0(24)`
  * Outbound interface: `VlanIf100`
  * Next hop: `10.0.100.1`

#### LAN Interface Settings
Use LAN 1 to connect Huawei core switch and Huawei S380.

LAN > LAN Interface > Select LAN 1 > Phyical Interface Configuration
* Interface mode: Trunk
* Default VLAN: 1
* Allowed VLAN: 1,100

#### Wireless Management
* Wireless Management Address

  Wireless Management > Wireless Management Address
  * Enable wireless managment
  * Wireless management address: `192.168.112.1`(same as VlanIf1)

* Wireless Service

  Wireless Management > Wireless Service > create

  * Input SSID, Service VLAN ID and go next.

  | SSID | Service VLAN ID | Description |
  | :--: | :--: | :--: |
  | xx-pc | 10 | for PC |
  | xx | 20 | for phone and TV |
  | guest | 30 | for guest |
  
  * Set Security Authentication and go next.
  * Select AP group(`default`) and radio to apply(`5G`, `5GHz/6GHz`)
  * SSID-based rate limiting for uplink / downlink
    * Unlimited(default) or User-defined(e.g. `8Mbit/s` for downlink and `2Mbit/s` for uplink)

#### Rate Limit Based on IP(VLAN)
Set rate limit for VLAN 30(guest) for downloading and uploading.

* Set Download Rate Limit

  Download rate limit: 8Mbps(direction: outbound. S380 -> core switch)

  * Create Access Control Policy
    * Security Policy > Access Control Policy > Configure Access Control Policy Tab > create
    * Name: guest-download
    * Control policy type: IP-based
    * Description: guest download

  * Create Rule
    * Go to the access control policy record and click "Create Rule" Icon on the right
    * Rule type: Permit
    * Protocol: All
    * Source IP address/wildcard: `0.0.0.0` / `255.255.255.255`(be careful: it's wildcard but NOT subnet mask)
    * Destination IP address/wildcard: `10.0.30.0` / `0.0.0.255`(be careful: it's wildcard but NOT subnet mask)
    * Effective time rage: All
    * Description: guest download

  * Apply Access Control Policy
    * Security Policy > Access Control Policy > Apply Access Control Policy Tab > create
    * Access control policy: `guest-download`
    * Application object: `Specified interface` > LAN 1
    * Direction: Outbound(S380 -> core switch)
    * Application mode: Rate limiting
    * Rate: 8 Mbit/s

* Set Upload Rate Limit

  Upload rate limit: 5Mbps(direction: inbound. core switch -> S380)

  * Create Access Control Policy
    * Security Policy > Access Control Policy > Configure Access Control Policy Tab > create
    * Name: guest-upload
    * Control policy type: IP-based
    * Description: guest upload

  * Create Rule
    * Go to the access control policy record and click "Create Rule" Icon on the right
    * Rule type: Permit
    * Protocol: All
    * Source IP address/wildcard: `10.0.30.0` / `0.0.0.255`(be careful: it's wildcard but NOT subnet mask)
    * Destination IP address/wildcard: `0.0.0.0` / `255.255.255.255`(be careful: it's wildcard but NOT subnet mask)
    * Effective time rage: All
    * Description: guest upload

  * Apply Access Control Policy
    * Security Policy > Access Control Policy > Apply Access Control Policy Tab > create
    * Access control policy: `guest-upload`
    * Application object: `Specified interface` > LAN 1
    * Direction: Inbound(core switch -> S380)
    * Application mode: Rate limiting
    * Rate: 5 Mbit/s

#### Save Configuration
Click top-right "Save" icon.

## Huawei Core Switch Settings
#### Create Initial Password
Create a password when log on the switch for the first time.

#### Basic Settings
```
// Go to System View
system-view
```

```
// Disable Info Center
undo info-center enable
```

```
// Set Device Name
sysname sw-core
```

#### Create VLAN
```
vlan batch 3 6 10 20 30 100
```

#### Create VLAN Interface
```
interface Vlanif 1
ip address 192.168.112.2 24
quit
```

```
interface Vlanif 3
ip address 10.0.3.1 24
quit
```

```
interface Vlanif 6
ip address 10.0.6.1 24
quit
```

```
interface Vlanif 10
ip address 10.0.10.1 24
quit
```

```
interface Vlanif 20
ip address 10.0.20.1 24
quit
```

```
interface Vlanif 30
ip address 10.0.30.1 24
quit
```

```
interface VlanIf 100
ip address 10.0.100.1 24
quit
```

#### Create DHCP Server
```
dhcp enable
```

* Set DHCP Server for Vlanif 10: PC

```
interface Vlanif 10
dhcp select interface

// Reserve IP addresses.
dhcp server excluded-ip-address 10.0.10.1 10.0.10.50

// Set DNS servers. 
dhcp server dns-list 223.5.5.5 223.6.6.6

// Set lease time.
// Lease time for PC is 8 days.
dhcp server lease day 8 hour 0 minute 0

quit
```

* Set DHCP Server for Vlanif 20: Phone & Pad

```
interface Vlanif 20
dhcp select interface

// Reserve IP addresses.
dhcp server excluded-ip-address 10.0.20.1 10.0.20.50

// Set DNS servers.
dhcp server dns-list 223.5.5.5 223.6.6.6

// Set lease time.
// Lease time for Phone & Pad is 8 hours.
dhcp server lease day 0 hour 8 minute 0
 
quit
```

* Set DHCP Server for Vlanif 30: Guest

```
interface Vlanif 30
dhcp select interface

// Reserve IP addresses.
dhcp server excluded-ip-address 10.0.30.1 10.0.30.10

// Set DNS servers.
dhcp server dns-list 223.5.5.5 223.6.6.6

// Set lease time.
// Lease time for guest is 2 hours.
dhcp server lease day 0 hour 2 minute 0

quit
```

* Check DHCP Pool

```
// Show all IP pool.
display ip pool

// Show IP pool info on Vlanif(e.g. 10)
display ip pool interface Vlanif10

// Show Used IPs of IP Pool
display ip pool interface Vlanif10 used
```

#### LAN Interface to Connect to POE Switch
```
// GE0/0/1: connect to GE0/0/24 of POE switch
interface GigabitEthernet 0/0/1
port link-type trunk
port trunk allow-pass vlan 1 3 6 10 20 30
quit
```
#### LAN Interface to Connect to PC and Printer
* GigabitEthernet0/0/2 - GigabitEthernet0/0/20: connect PC and printer.

```
port-group 2
group-member GigabitEthernet0/0/2 to GigabitEthernet0/0/20
port link-type access
port default vlan 10
quit
```

#### LAN Interface to Connect to NVR
``` 
// GE0/0/21: connect LAN 1 of HikVision NVR
interface GigabitEthernet0/0/21
port link-type access
port default vlan 3
quit
```

#### LAN Interface to Connect to Samba Server(Dual Ethernet Interfaces)
* GigabitEthernet0/0/22: connect to enp1s0f0 of samba server(VLAN 10)

```
interface GigabitEthernet0/0/22
port link-type access
port default vlan 10
quit
```

* GigabitEthernet0/0/23: connect to enp1s0f1 of samba server(VLAN 20)

```
interface GigabitEthernet0/0/23
port link-type access
port default vlan 20
quit
```

#### Static Route

```
// Create a default route.
ip route-static 0.0.0.0 0.0.0.0 10.0.100.2
```

#### LAN Interface to Connect to S380
```
interface GigabitEthernet 0/0/24
port link-type trunk
port trunk allow-pass vlan 1 100
port trunk pvid vlan 1
quit
```

```
// Show ip routing table.
display ip routing-table
```

#### Check IP Interface
```
display ip interface brief
```

#### Save Settings
```
quit
save
```

## Huawei POE Swich Settings
#### Create Initial Password
Create a password when log on the switch for the first time.

#### Basic Settings
```
// Go to System View
system-view
```

```
// Disable Info Center
undo info-center enable
```

```
// Set Device Name
sysname sw-poe
```

#### Create VLAN
```
vlan batch 3 6 10 20 30
```

#### LAN Interface to Connect to Camera

```
// GE0/0/1 - GE0/0/12: for NVR and camera
port-group 1
group-member GigabitEthernet0/0/1 to GigabitEthernet0/0/12
port link-type access
port default vlan 3
quit
```

#### LAN Interface to Connect to AP

```
// GE0/0/13 - GE0/0/23: for AP
port-group 2
group-member GigabitEthernet0/0/13 to GigabitEthernet0/0/23
port link-type trunk
port trunk allow-pass vlan 1 10 20 30
port trunk pvid vlan 1
quit
```

#### LAN Interface to Connect to Core Switch 
GE0/0/24 of POE switch --> GE0/0/1 of core switch

```
interface GigabitEthernet0/0/24
port link-type trunk
port trunk allow-pass vlan 1 3 6 10 20 30
quit
```

#### Save Settings
```
quit
save
```

## References
* [S380 Product Documentation](https://support.huawei.com/hedex/hdx.do?docid=EDOC1100409535&tocURL=resources%2Fhedex-homepage.html)

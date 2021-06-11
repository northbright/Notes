# H3C Switch Commands

## Help
* Type `?` to show help

## Disable Logs to Terminal
* Under `user-view`

      undo terminal monitor

## Enter System-View

    system-view

## Display Current Configuration

    display current-configuration

## Display Current VLANs

    display vlan
    
    // Output:
    // Total VLANs: 3
    // The VLANs include:
    // 1(default), 20, 30

## Delete Exists VLANs

    // Delete VLAN 20, 30
    
    undo vlan 20
    undo vlan 30

##  Diplay Current Configuration of VLAN

    display vlan 20
    
    // Output:
    // ....
    // Tagged ports:
    //     GigabitEthernet1/0/29
    // Untagged ports:
    //     GigabitEthernet1/0/23

* Tagged ports means the port's link type is **Trunk**
* Untagged ports means the port's link type is **Access**

## Create VLANs

    // Create VLAN 20, 30
    vlan 20
    vlan 30

## Display Current Configuration of  Interface

    display current interface
    
    // Output:
    // ...
    // interface GigabitEthernet1/0/1
    // ...

## Display Status of Interface

    display interface

    // or just show brief information
    display interface brief

##  Access Port Settings

    // 1. Select interface
    interface GigabitEthernet1/0/1

    // or use short name gx/x/x for GigabitEthernet and ex/x/x for Ethernet
    interface g1/0/1

    // 2. Set port link type to access
    port link-type access
    
    // 3. Add port to VLAN 20
    port access vlan 20

    // 4. Check VLAN
    display vlan 20

    // Output:
    // ...
    // Untagged ports:
    //     GigabitEthernet1/0/1

## Batch Access Ports Settings(Add Ports to VLAN)

    // 1. Select VLAN ID(e.g. VLAN 20)
    vlan 20

    // 2. Add ports range(e.g. GigabitEthernet1/0/1 - GigabitEthernet1/0/23)
    port G1/0/1 to G1/0/23

    // 3. Check
    display vlan 20

    // Output:
    // ...
    // Untagged ports:
    //     GigabitEthernet1/0/1
    //     ...
    //     GigabitEthernet1/0/23
    
## Trunk Port Settings

    // 1. Select interface
    interface GigabitEthernet1/0/29

    // or use short name gx/x/x for GigabitEthernet and ex/x/x for Ethernet
    interface g1/0/29

    // 2. Set port link type to access
    port link-type trunk
    
    // 3. Set PVID of VLAN(e.g. vlan 20)
    // If PVID is not set, it's 1 by default.
    port trunk pvid vlan 20

    // 4. Permite trunk VLAN 20 and 30
    port trunk permit vlan 20 30

    // 5. Check VLANs
    display vlan 20

    // Output:
    // ...
    // Tagged ports:
    //     GigabitEthernet1/0/29

    display vlan 20

    // Output:
    // ...
    // Tagged ports:
    //     GigabitEthernet1/0/29

* Trunk ports are used to connect 2 switches, make sure the permit VLANs of trunk ports of each side switch are the **SAME**

   | Switch | Port | Link Type | Trunk Permit VLANs |
   | :--: | :--: | :--: | :--: |
   | SW1 | G1/0/29 | Trunk | VLAN 20 30 |
   | SW2 | G1/0/48 | Trunk | VLAN 20 30 |

## Batch Interfaces(Ports) Settings

    // e.g. Set Trunk Ports: GE1/0/1 to GE1/0/47
    interface range GE1/0/1 to GE1/0/47
    port link-type trunk
    port trunk pvid vlan 2
    port trunk permit vlan 1 2

## Set IP Address of VLAN Interface

    // 1. Select VLAN interface(e.g. 20)
    interface vlan 20

    // 2. Set IP address with subnet mask
    ip address 192.168.20.1 24

    // 3. Check
    display interface Vlan-interface brief
    display ip interface brief

## Create DHCP IP Pool

    // 1. Enable DHCP server
    dhcp enable

    // 2. Create DHCP IP pool with given pool name
    // e.g. create a IP pool for VLAN 1. "vlan1" here is the pool name(string).
    dhcp server ip-pool vlan1

    // 3. Set DCHP network and mask(e.g. 192.168.1.0)
    network 192.168.1.0 mask 255.255.255.0

    // 4. Add Gateway(e.g. 192.168.1.1)
    gateway-list 192.168.1.1

    // 5. Add DNS(e.g. 114.114.114.114 & 8.8.8.8)
    dns-list 114.114.114.114 8.8.8.8

    // 6. Add an forbidden IP(optional)
    // Warning: this command will add single IP but NOT IP range,
    // to add forbidden IP range, quit to system-view
    // and use "dhcp server forbidden-ip LOW-IP HIGH-IP")
    forbidden-ip 192.168.1.4 192.168.1.5

    // 7. Add forbidden IP range(optional)
    // quit to system-view first
    quit

    // Use "dhcp server forbidden-ip LOW-IP HIGH-IP"(e.g. 192.168.1.2 - 192.168.1.20)````
    dhcp server forbidden-ip 192.168.1.2 192.168.1.20

## Add Static Route

    // under system-view
    // ip route-static IP MASK NextHOP_IP_Address
    ip route-static 0.0.0.0 0.0.0.0 192.168.100.2

## Search Port by Client MAC

    // go to system view
    sys

    // MAC: 00:a1:b2:c3:d4:f5
    display mac-address | in d4f5

    // Output
    // 00:a1:b2:c3:d4:f5 xx LEARNED GigabitEthernet1/0/1

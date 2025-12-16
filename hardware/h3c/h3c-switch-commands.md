# H3C Switch Commands

## Help
* Type `?` to show help

## Disable Logs to Terminal
```sh
// Under `user-view`
undo terminal monitor
```

## Enter System-View

```sh
system-view
```

## Display Current Configuration
```sh
display current-configuration
```

## Save Current Configuration
```sh
save
```

## Reset Configuration(Clear Saved Configuration and reboot)
```sh
reset saved-configuration
// Choose "n" when ask save current configruation?
reboot
```

## Display Current VLANs

```sh
display vlan
    
// Output:
// Total VLANs: 3
// The VLANs include:
// 1(default), 20, 30
```

## Delete Exists VLANs

```sh
// Delete VLAN 20, 30
undo vlan 20
undo vlan 30
```

##  Diplay Current Configuration of VLAN

```sh
display vlan 20
    
// Output:
// ....
// Tagged ports:
//     GigabitEthernet1/0/29
// Untagged ports:
//     GigabitEthernet1/0/23
```

* Tagged ports means the port's link type is **Trunk**
* Untagged ports means the port's link type is **Access**

## Create VLANs

```sh
// Create VLAN 20, 30
vlan 20
vlan 30
```

## Display Current Configuration of  Interface

```sh
display current interface
    
// Output:
// ...
// interface GigabitEthernet1/0/1
// ...
```

## Display Status of Interface

```sh
display interface

// or just show brief information
display interface brief
```

##  Access Port Settings

```sh
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
```

## Batch Access Ports Settings(Add Ports to VLAN)

```sh
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
```
    
## Trunk Port Settings

```sh
// 1. Select interface
interface GigabitEthernet1/0/29

// or use short name gx/x/x for GigabitEthernet and ex/x/x for Ethernet
interface g1/0/29

// 2. Set port link type to access
port link-type trunk
    
// 3. Permite trunk VLAN 20 and 30
port trunk permit vlan 20 30

// 4. Set PVID of VLAN(optional)
// If PVID is not set, it's VLAN 1 by default.
// Use case:
//   H3C switch trunk port --> UBNT UAP
//
//   VLAN 2(10.0.2.0/24) is used for UBNT UAP and 
//       there's a DHCP server to assign IPs for UAPs.   
//
//   VLAN 10(10.0.10.0/24) is used for guest WLAN and
//       there's a DHCP server to assign IPs for cliens connected to the UAP.
//
//   VLAN 20(10.0.20.0/24) is used for work WLAN and
//       there's a DHCP server to assign IPs for clients connected to the UAP.
//
//   UBNT UAP is configured in Unifi Controller Software:
//         Guest WLAN(SSID: guest) connects Network VLAN 10 Only: 10.0.10.0/24
//         Work WLAN(SSID: work) connects Network VLAN 20 only: 10.0.20.0/24
//   Trunk port settings:
//     Permit VLAN: vlan 1 2 10 20
//     PVID: vlan 2
port trunk pvid vlan 2

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
```

* Trunk ports are used to connect 2 switches, make sure the permit VLANs of trunk ports of each side switch are the **SAME**

   | Switch | Port | Link Type | Trunk Permit VLANs |
   | :--: | :--: | :--: | :--: |
   | SW1 | G1/0/29 | Trunk | VLAN 20 30 |
   | SW2 | G1/0/48 | Trunk | VLAN 20 30 |

## Batch Interfaces(Ports) Settings

```sh
// e.g. Set Trunk Ports: GE1/0/1 to GE1/0/47
interface range GE1/0/1 to GE1/0/47
port link-type trunk
port trunk pvid vlan 2
port trunk permit vlan 1 2
```

## Set IP Address of VLAN Interface(create Vlanif)

```sh
// 1. Select VLAN interface(e.g. 20)
interface vlan 20

// 2. Set IP address with subnet mask
ip address 192.168.20.1 24

// 3. Check
display interface Vlan-interface brief
display ip interface brief
```

## Create DHCP IP Pool

1. Enable DHCP server

   ```sh
   dhcp enable
   ```

2. Create DHCP IP pool with given pool name
   
   e.g. create a IP pool for VLAN 2. "vlan2" here is the pool name(string).
    
   ```sh
   dhcp server ip-pool vlan2
   ```

3. Set DCHP network and mask

   ```sh
   network 10.0.2.0 mask 255.255.255.0
   ```

4. Add Gateway

   ```sh
   gateway-list 10.0.2.1
   ```

5. Add DNS(e.g. aliyun public DNS: 223.5.5.5 and 223.6.6.6)

   ```sh
   dns-list 223.5.5.5 223.6.6.6
   ```

6. Set the DHCP Expiration Time(Lease Time)

   * The DHCP Expiration Time is Set to 1 Day by Default
   * e.g. Change it to 12 Hour

   ```sh
   expired day 0 hour 12
   ```

7. Add forbidden IP range(optional)
   * quit to system-view first

     ```sh
     quit
     ```

   * Use "dhcp server forbidden-ip LOW-IP HIGH-IP"
    
     ```sh
     dhcp server forbidden-ip 10.0.2.1 10.0.2.50
     ```

8. Apply IP-Pool on Vlanif by pool name

  ```sh
  interface vlan2
  // vlan2 is the name of pool created previously.
  dhcp server apply ip-pool vlan2
  ```

## Check DHCP

* Check DHCP Free IPs

   ```sh
   display dhcp server free-ip
   ```

* Check DHCP IP in Use

  * Show DHCP Server's IP in Use for All Pools

    ```sh
    display dhcp server ip-in-use
    ```
  * Show DHCP Server's IP in Use for Specified Pool

    ```sh
    display dhcp server ip-in-use pool <POOL_NAME>
    ```
    e.g.
    ```sh
    display dhcp server ip-in-use pool vlan30
    ```

## Get DHCP Pool Settings

* Get All DHCP Pool Settings

  ```sh
  display dhcp server pool
  ```

* Get Specified DHCP Pool Settings by VLAN Name

  ```sh
  display dhcp server pool vlan30
  // Output:
  Pool name: vlan30
  Network: 192.168.30.0 mask 255.255.255.0
  dns-list 192.168.100.2
  expired 0 12 0 0
  gateway-list 192.168.30.1
  ```

## Reset(Clean) DHCP IP in Use

```sh
// Quit to user-view
quit
reset dhcp server ip-in-use
```

## Reset DHCP Server's IP in Use for Pool

```sh
// Quit to user-view
quit
reset dhcp server ip-in-use pool <POOL_NAME>
```
e.g. Reset DHCP Server's IP in Use for Pool：VLAN30
```sh
reset dhcp server ip-in-use pool vlan30
```

## Add Static Route

```sh
// under system-view
// ip route-static IP MASK NextHOP_IP_Address
ip route-static 0.0.0.0 0.0.0.0 10.0.100.2
```

## Search Port by Client MAC

```sh
// go to system view
sys

// MAC: 00:a1:b2:c3:d4:f5
display mac-address | in d4f5

// Output
// 00:a1:b2:c3:d4:f5 xx LEARNED GigabitEthernet1/0/1
```

## Display Device Manufacture Info
```sh
display device manuinfo
```

## Delete Local User
```sh
// Need to add "class manage" after username.
undo local-user XX class manage
```

## References
* [04-三层技术-IP业务命令参考](https://www.h3c.com/cn/d_201901/1150027_30005_0.htm)
* [华三交换dhcp+接口下没有引用地址池](https://zhiliao.h3c.com/questions/dispcont/266765)
* [H3C交换机怎么配置VLAN和DHCP](https://zhuanlan.zhihu.com/p/6230350609)

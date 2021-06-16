# Switch Can Not Ping Other VLAN IP Successfully but PC Connected to The Switch Can

## Problem
* H3C S5500 Core Switch connects a H3C S5120 Access Switch(Trunk port, permit vlan 1 2)
* H3C S5500 Core Switch Settings
  * Creates 2 VLAN interfaces(vlan 1 / vlan 2)
    ```
    vlan 1 2
    ```

  * Set IPs for 2 VLAN interfaces
    ```
    interface vlan 1
    ip address 10.0.1.1 24
    quit
  
    interface vlan 2
    ip address 10.0.2.1 24
    quit
    ```
* H3C S5120 Access Switch Settings
  * Creates 2 VLAN interfaces
    ```
    vlan 1 2
    ```
    
  * No IP is set to the VLAN interfaces
  * Set access ports for GE1/0/1 to GE/10/47
    ```
    vlan 2
    port ge1/0/1 to ge1/0/47
    ```

* In the console, failed to ping `10.0.1.1` or `10.0.2.1`

* A PC connected to the H3C S5120 Access Switch(access port) can ping `10.0.1.1` and `10.0.2.1` successfully
  * Static IP: `10.0.2.50`
  * Default Gateway: `10.0.2.1`
  * Subnet Mask: `255.255.255.0`

## Root Cause
* Like a PC, to interact with other devices, switch need to be recognized to a "PC":
* Need to set IP and gateway

## Solution
* Set IP for VLAN 1
  ```
  interface vlan 1
  ip address 10.0.1.11 24
  quit
  ```
* Set gateway(static route)
  ```
  ip route 0.0.0.0 0.0.0.0 10.0.1.1
  ```

## References
* [交换机下边的PC能ping通，可是在交换机上ping不通](https://bbs.51cto.com/thread-789973-1.html)

# Mi TV and Laptop Failed to Obtain IP via DHCP

## Problem
* H3C S5500 Switch Settings
  * VLAN 30(`192.168.30.0/24`) is created for wireless devices(mobile phone, TV, laptop)
  * DHCP Server is created for VLAN 30
    ```
    dhcp server ip-pool vlan30
    gateway-list 192.168.30.1
    network 192.168.30.0 mask 255.255.255.0
    dns-list 192.168.100.2
    ```
* Mi TVs and Laptop failed to obtain IP via DHCP suddenly

## Root Cause
DHCP IP Pool exhausted.
* Login H3C Switch via console

  ```
  // Check free IP
  display dhcp free-ip
  // no free IP for VLAN 30
  ```

  ```
  // Check IP in use
  display dhcp server ip-in-use
  ......
  192.168.30.253
  192.168.30.254
  ```
## Solution
* Reserve IPs for the Mi TVs

  ```
  dhcp server forbidden-ip 192.168.30.1 192.168.30.50
  save
  ```

* Use Static IP for Mi TVs
* Reset the IP in Use of DHCP IP Pool
  ```
  // in User View(quit System-View)
  reset dhcp server ip-in-use
  ```
* Use Shorter DHCP Expiration Time(Lease Time)
  * The DHCP Expiration Time is Set to 1 Day by Default(H3C Switch)
  * Set It to 12 Hours

    ```
    dhcp server ip-pool vlan30
    expired day 0 hour 12
    save
    ```

* Check

  ```
  display dhcp server pool vlan30
  
  // Output:
  Pool name: vlan30
  Network: 192.168.30.0 mask 255.255.255.0
  dns-list 192.168.100.2
  expired 0 12 0 0
  gateway-list 192.168.30.1
  ```

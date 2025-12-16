# Show H3C Router IP in Console

## Problem
* Need to login web management of H3C router but does not know the IP

## Solution
* Login H3C router using console cable
* Run `ip address` command to get the configured Vlanif(IP)

  ```sh
  <H3C>ip address

  // Output:
  The LAN interface information:
  IP address: 192.168.1.1 
  Mask: 255.255.255.0
  The VLAN3 information:
  IP address: 192.168.3.1 
  Mask: 255.255.255.0
  The VLAN2 information:
  IP address: 192.168.2.1 
  Mask: 255.255.255.0
  ```

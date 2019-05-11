# Set Web User for H3C Switch

## Setup IP Address
* Select VLAN Interface(e.g. VLAN Interface 1)

       interface vlan 1
       ip address 192.168.1.240 24

        // Check
        display vlan 1

        // Outpout:
        // ...
        // IPv4 address: 192.168.1.240
        // IPv4 subnet mask: 255.255.255.0

## Enable HTTP Server
* Check HTTP Server Status

       display ip http

* Enable HTTP Server

       ip http enable

## Create SSH User

    // Create user xx
    local-user xx
    
    // Set password for xx
    password

    // Set service type of the user
    // use "service-type ?" to show all types
    service-type http

    // Set user role to network-admin
    // use "authorization-attribute user-role ?" to show all roles
    // the role: network-operator(default) can NOT modify settings,use network-admin if you need
    authorization-attribute user-role network-admin

    // Check
    display this

## Test
* Open a browser(e.g. Firefox) on PC and go to the IP

## References
* [H3C S5130S-EI系列以太网交换机 - 配置指导 - 01基础配置指导](http://www.h3c.com/cn/d_201710/1038061_30005_0.htm)

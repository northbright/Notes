# Win10 PC Can't Access Shared Folder by Name after 3 H3C Switches Stacked

## Problem
* The network topological graph looks this:

   ```
                        +--------------------------+
                        | H3C Router(DHCP Server)  |
                        +--------------------------+
                            |LAN1  |LAN2  |LAN3                LAN1, LAN2, LAN3 -> VLAN1: 192.168.1.x
           +----------------+      |      +--------------+
           |                       |                     |
     +------------+         +-------------+        +-------------+
     | H3C Switch |         | H3C Switch  |        | H3C Switch  |
     +------------+         +-------------+        +-------------+
     |  |   |   |           |    |   |   |           |    |    |
     |  PC ... PC         Server PC ...  PC          PC  ...  PC       
     +------------+      
     | H3C Switch |
     +------------+
     |  |   |   |
     |  PC ... PC
     +------------+
     | H3C Switch |
     +------------+
     |     |      |
     PC   ...    PC <- Win10(ver 1803) PCs here can't access shared folder on Server
  ```   

* All PCs are in default **WORKGROUP**
* All PCs are in the same VLAN: 192.168.1.x
* Win10 PC can't access shared folder by **Name** on Server after 3 H3C switches stacked
* But access shared folder by **IP** is OK
* `ping server` failed but `ping server -4` is OK
* `nslookup server` failed but `nslookup xx.com` is OK

## Root Cause
* It failed to resolve server name to IP due to latency of connection to DNS caused by stacked switches

## Workaround
1. Use **IP** to access shared folder on server
2. Add a record in `C:\Windows\System32\drivers\etc\hosts` and reboot:
 
       xx.xx.xx  server

## References
* [How many switches can be stacked/interconnected?](https://serverfault.com/questions/167559/how-many-switches-can-be-stacked-interconnected)


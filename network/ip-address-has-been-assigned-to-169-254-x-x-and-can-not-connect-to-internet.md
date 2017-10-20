# IP Address has been assigned to 169.254.x.x and Can not Connect to Internet

#### Problem
* IP Address has been assigned to `169.254.x.x` and can not connect to internet.

#### About `169.254.x.x`

>When a DHCP client boots up, it first looks for a DHCP server in order to obtain an IP address and subnet mask. If the client is unable to find the information, it uses APIPA (Automatic Private IP Addressing) a feature in Windows Vista to automatically configure itself with an IP address and subnet mask when a DHCP server isn't available. The IP address range is 169.254.0.1 through 169.254.255.254, a range that has been reserved especially for Microsoft. 

#### Root Cause
* **Cable** issue which cause client can not find DHCP server.

#### Solution
* Replace a new cable.

#### References
* [169.254.x.x IP Address](https://www.pctechbytes.com/networking/169-254-address/)


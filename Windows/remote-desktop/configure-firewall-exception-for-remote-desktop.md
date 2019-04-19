# Configure Firewall Exception for Remote Desktop

## Problem
* One Windows 7 PC was configured to allow Remote Desktop connection and works well
* It failed to create remote desktop connection suddenly
* There's a warning under "System Properties" -> "Advanced" ->  "Remote" -> "Remote Desktop":

   > To enable remote connections, you must configure a Windows Firewall exception for Remote Desktop

## Root Cause
* The network location type was changed from "Work" to "Public"
* No firewall exception for Remote Desktop on "Public" network location type

## Solution
* Set the network location type of the network you want(e.g. "Work")
* Configure and check firewall exception for Remote Desktop
   * Goto "Control Panel" -> "System and Security" -> "Windows Firewall" -> "Allow a Program or Feature Through Windows Firewall"
   * Scroll down and find "Remote Desktop", make sure select the checkbox for network location types: "Home/Work(private)" or "Public"

## References
* [无法连接远程桌面--必须为远程桌面启用Windows防火墙例外](https://blog.csdn.net/cage_z/article/details/52815727)

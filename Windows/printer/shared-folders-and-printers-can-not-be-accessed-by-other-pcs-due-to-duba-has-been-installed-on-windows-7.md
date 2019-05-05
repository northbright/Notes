# Shared Folders / Printers can not be Accessed by Other PCs Due to [Duba](http://www.duba.net/) has been Installed on Windows 7

## Problem
* Windows 7 PC has shared folders / printers
* Other PCs can access the shared folders / printers successfully
* Suddenly, the shared folders / printers can not be accessed by other PCs
* Other PCs can NOT ping the Windows 7 PC successfully
* Windows Firewall service has been stopped
* It failed to start Windows Firewall(Service)  with error code: 13

## Root Cause
* [Duba](http://www.duba.net/) has been Installed on Windows 7 PC
* Windows Firewall has been messed up by [Duba](http://www.duba.net/) 

## Solution
1. Uninstall [Duba](http://www.duba.net/)
2. Repair and start Windows Firewall
    * Run `regedit` and **DELETE** all sub keys under `"HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\services\SharedAccess\Parameters\FirewallPolicy"` but **keep** `FirewallPolicy` key itself
    * Run `services.msc` and start `Windows Firewall` service(it can be started now)
    * Run `cmd` as administrator, type `netsh advfirewall reset`
3. Configure Windows Firewall
    * Goto "Control Panel" -> "System and Security" -> "Windows Firewall" -> Check "Network Location Type"(`Work/Home` or `Public`) of connected network
    * Click "Allow a program or feature through Windows Firewall", find `"File and Printer Sharing"` in the list and enable it
4. Test
    * Run `ping` from other PCs to test if it's OK
    * Try to access shared folders and printers from other PCs

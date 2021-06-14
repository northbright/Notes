# Run Remote Desktop for Mac OS Host and Windows Guest

## Background
* Hardware: Macbook Pro 2016 16"
* Host: Mac OS BigSur 11.2.3
* Installed VirtualBox
* Want to run Windows 7 as guest OS

## Problem
* Want to enable RDP on Windows 7

## Solution
VirtualBox starts a VRDP server and users run the RDP client to connect to the server. The VRDP server forwards its port(e.g. 5000) to the guest OS(Windows 7) RDP default port: 3389. It'll use Windows 7(guest OS) authentication for RDP clients.

* Create a Windows 7 Professional VM in VirtualBox
* Settings
  * Display > Remote Display
    * Enable Server
    * Server Port: unused port on Mac OS other than 3389(e.g. 5000)
    * Authentication Method: Null
  * Networt > Adapter 1
    * Enable Network Adapter
    * Attached to: NAT
    * Advanced > Click "Port Forwarding" bottom
      * Create a new rule
      * Protocol: TCP
      * Host IP: leave blank
      * Host Port: the save server port specified in Display setting(e.g. 5000)
      * Guest IP: leave blank
      * Guest Port: 3389(default for Windows)
   
* Download Microsoft Remote Desktop for MacOS
  * [Microsoft Mac Downloads](https://macadmins.software/)

* Run Microsoft Remote Desktop
  * Add a new PC
    * PC Name: `localhost:5000`
  * Start Connection and input the username and password of the Windows 7

## References
* [Windows Remote Desktop client fails to connect to VRDP with authentication](https://www.virtualbox.org/ticket/3487#comment:16)
* [Unable to connect to Remote Desktop when using NAT](https://forums.virtualbox.org/viewtopic.php?t=50024&start=0)

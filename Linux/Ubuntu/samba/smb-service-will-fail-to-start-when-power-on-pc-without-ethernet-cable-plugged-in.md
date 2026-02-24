# SMB Service will Fail to Start when Power on PC without Ethernet Cable Plugged in

## Problem
* Configured SMB service on a Ubuntu 24.04 PC
* Power on the PC without ethernet cable plugged in
* Plug in the ethernet cable after a while
* SMB service is not started

## Root Cause
SMB service failed to start due to failed to find address of bound interface(e.g. eno1).

Check `/var/log/samba/smb.log`:

> lib/util/util_net.c:255(interpret_string_addr_internal)
> interpret_string_addr_internal: getaddrinfo failed for name eno1 (flags 32) [Temporary failure in name resolution]
> interpret_interface: Can't find address for eno1
> added interface lo ip=127.0.0.1 bcast=127.255.255.255 netmask=255.0.0.0

## Solution
Plug in the ethernet cable BEFORE power on the PC.

Check `/var/log/samba/smb.log`:

> added interface eno1 ip=10.0.10.3 bcast=10.0.10.255 netmask=255.255.255.0 

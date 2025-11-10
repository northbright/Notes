# L6168 Prints White Paper because that L6268 Driver is Installed

## Problem
* L6268 driver(conncect to LAN) was installed on a PC
* L6268 IP: `192.168.2.4`
* L6268 was replaced by a L6168(IP: `192.168.2.14`)
* Go to Control Panel > Devices and Printers > L6268 > Properties > Port > Edit > Set the IP of L6168
* Print Test Page > L6168 output a white papaer

## Root Cause
L6268 driver does not work for L6168.

## Solution
Remove L6268 printer in Control Panel > Devices and Printers.
Install L6168 driver on the PC.

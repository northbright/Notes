# Failed to Boot from USB Disk when using USB 3.0 Port on HP Z240

## Problem
* Plug an USB disk with WinPE installed to an USB 3.0 port on HP Z240
* Power on PC and press F9 to enter boot menu
* USB disk is not found in the boot device list

## Root Cause
HP Z240 may have compatibility issue with USB 3.0 port during boot.

## Solution
* Method A: Update BIOS
* Method B: Use USB 2.0 port instead 

## References
* [HP Z238 Failed to Boot from USB Disk when It is Plugged into USB 3.0 Port](https://github.com/northbright/Notes/blob/master/hardware/hp/hp-z238-failed-to-boot-from-usb-disk-when-it-is-plugged-into-usb-3-port.md)

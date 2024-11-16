# HP Z238 Failed to Boot from USB Disk when It is Plugged into USB 3.0 Port

## Problem
* HP Z238 with BIOS version: 2016/XX/XX
* Create a bootable WinPE USB disk via [WePE](https://www.wepe.cn/)
* Legacy boot is enabled and secure boot is disabled in BIOS
* Plugged USB disk to the USB 3.0 port(blue)
* Press F9 to enter the boot menu when power on the pc
* It failed to find USB disk in the boot menu

## Solution A
Update latest HP Z238 BIOS.
* [Update BIOS of HP Z238](https://github.com/northbright/Notes/blob/master/hardware/hp/update-bios-of-hp-z238.md)

## Solution B(workaround)
Plug the USB disk to USB 2.0 port of HP Z238

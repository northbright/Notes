# Got "Inaccessible Boot Device" Error when Boot Windows 10 due to Incorrect SATA Mode

## Problem
* Installed Windows 10 on HP Z228 workstation with SATA mode set to "Raid"
* Did a factory reset for BIOS to fix some problem and set SATA mode to "AHCI"
* Got "Inaccessible Boot Device" when boot Windows 10

## Root Cause
* No AHCI controller driver is installed before switching SATA mode from Raid to AHCI

## Solution
Set SATA mode back to "Raid"

## References
* [Switch RAID to AHCI without reinstalling Windows 10](https://superuser.com/questions/1280141/switch-raid-to-ahci-without-reinstalling-windows-10)

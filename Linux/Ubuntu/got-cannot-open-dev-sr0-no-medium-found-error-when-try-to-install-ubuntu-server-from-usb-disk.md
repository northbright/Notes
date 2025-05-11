# Got "can't open /dev/sr0: no medium found" Error when Try to Install Ubuntu Server from USB Disk

## Problem
* Boot HP Z228 workstation from USB disk with Ubuntu Server 22.04.02 live image
* Got "can't open /dev/sr0: no medium found" Error

## Root Cause
USB disk is plugged in one of front USB 3.0 ports on HP Z223 workstation.
This front USB 3.0 port may have problem.

## Solution
Use another USB 3.0 port instead and it works.

## References
* [How do I fix "can't open /dev/sr0: No medium found" on USB boot?](https://askubuntu.com/questions/47076/how-do-i-fix-cant-open-dev-sr0-no-medium-found-on-usb-boot)

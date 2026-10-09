# dxgmms2.sys BSOD

## Problem
* Nvidia GeForce 1060 Graphic Card
* Windows 10 Enterprise LTSC
* Got dxgmms2.sys BSOD

## Solution
* Download latest Nvidia driver for Geforce 1060(e.g. 582.78)
* Download [DDU](https://www.wagnardsoft.com/display-driver-uninstaller-ddu)
* [Reboot PC in safe mode](../boot/start-windows-10-in-safe-mode.md)
* Run [DDU](https://www.wagnardsoft.com/display-driver-uninstaller-ddu) to uninstall GPU driver
  * Select GPU > Nvidia
  * Click "Clean and Restart"
* It'll reboot after all done
* Install latest Nvidia driver

## References
* [BSOD dxgmms2.sys](https://learn.microsoft.com/en-us/answers/questions/5681434/bsod-dxgmms2-sys)
* [Dxgmms2.sys Blue Screen on Laptops? 5 Quick Fixes](https://thegeekpage.com/dxgmms2-sys-blue-screen-on-laptops-5-quick-fixes/)
* [Start Windows 10 in Safe Mode](../boot/start-windows-10-in-safe-mode.md)

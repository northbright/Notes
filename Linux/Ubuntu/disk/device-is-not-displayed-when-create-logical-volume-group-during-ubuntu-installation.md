# Device is Not Displayed when Create Logical Volume Group during Ubuntu Installation

## Problem
* Install Ubuntu 24.04.1 on VirtualBox Virtual Disk.
* Have 3 Virtual Disks(HDD0, HDD1, HDD2)
* HDD0 is used as boot device.
* Want to select HDD1 and HDD2 to create a Logical Volume Group
* But HDD2 can not be displayed in the device list when create a new Logical Volume Group

## Root Cause
* HDD2 is set "Add as Another Boot Device" previously
* Boot device can not be used(displayed) to create Logical Volume Group

## Solution
* Go to "Available Devices" > "HDD02" > "Stop Using as Boot Device"
* HDD2 can be displayed and selected when create a new Logical Volume Group

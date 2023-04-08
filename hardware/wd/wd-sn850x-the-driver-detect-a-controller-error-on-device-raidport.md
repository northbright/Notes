# WD SN850x the Driver Detect a Controller Error on `\Device\Raidport1`

## Problem
* A Clean Installed Windows 11 PC
* SSD: WD SN850x 1 TB
* Find Critical Errors which Category is `stornvme` in Windows Event Viewer

  > the driver detect a controller error on `\Device\Raidport1`

## Root Cause
* SN850x's Firmware Version is `620311WD` which Cause the Problem

## Solution
* Install WD Dashboard on [Official Site](https://support-cn.wd.com/app/answers/detailweb/a_id/7622) 
* Update Firmware to `620331WD` or Later

## References
* [[Finally new firmware released][SN850X] The driver detected a controller error on \Device\RaidPort0](https://community.wd.com/t/finally-new-firmware-released-sn850x-the-driver-detected-a-controller-error-on-device-raidport0/281205)
* [SSD Dashboard Unknown Error(0x2efd) during install](https://community.wd.com/t/ssd-dashboard-unknown-error-0x2efd-during-install/252696)

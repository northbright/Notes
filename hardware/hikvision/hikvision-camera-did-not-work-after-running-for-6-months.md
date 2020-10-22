# Hikvision Camera Did Not Work After Running 6 Months

## Problem
* There're 2 cameras missing in the Yingshiyun App which can monitor the cameras online
* Go to the equipment room
  * Unplug the 2 cables for the 2 cameras from the switch
  * Use ethernet cable diagnostic tool to test the 2 cables
  * Only 4 PINs are tested OK for both 2 cables
* Plug the cables back to the switch and unplug the ethernet cables connected to the cameras
  * Use ethernet cable diagnostic tool again
  * All 8 PINs are tested OK

## Root Cause
* The Hikvision cameras hung

## Solution
* Reboot the Hikvision
* The 2 cameras works

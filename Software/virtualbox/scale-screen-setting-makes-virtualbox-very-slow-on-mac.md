# Scale Screen Setting Makes VirtualBox Very Slow on Mac

## Background
* Host OS: OS X 10.15.4(Catalina) on a MBP 16"(3K resolution)
* Guest OS: Windows 7 x64 SP1

## Problem
* Settings > "Display" > Set "Scale Factor" to `200%`
* Windows 7 UI responses are very slow
* VirtualBox CPU usage is very high(>=100%)

## Root Cause
* Scale performance is low

## Solution
* Set "Scale Factor" to `100%`

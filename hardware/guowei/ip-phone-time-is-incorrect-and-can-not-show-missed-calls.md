# IP Phone Time is Incorrect and Can Not Show Missed Calls

## Problem
* Unplug the ethernet cable of the IP phone
* Can not show missed calls

## Root Cause
* The time of the IP phone is not correct

## Solution
Set IP phone time correctly.

* Login IP phone web management
* Go to Phone Settings > Date / Time Settings
* Check "Sync time using SNTP"
* Set NTP server: `ntp.aliyun.com`
* Click "Apply" button
* Check time on the IP phone

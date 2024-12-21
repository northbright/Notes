# Laptop Can Not Find SSID due to Not-Supporting 5G WiFi

## Problem
* Lenovo laptop(old model)
* WLAN: `CMCC-XX-5G` created China Mobile Wireless Router
* The laptop can not find the SSID but all phones can

## Root Cause
* The old laptop does not support 5G WiFi and only support 2.4G WiFi
* 2.4G radio is NOT applied for the WLAN: `CMCC-XX-5G`

## Solution
Apply 2.4G radio for the WLAN or create a new WLAN(e.g. `CMCC-XX`) for 2.4G WiFi.

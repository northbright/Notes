# Redmi TV Can Not Connect to WiFi

## Problem
* Redmi TV A43
* 43", 1GB RAM, 8GB storage, support 2.4G WiFi only
* Huawei S380 as AC to create Wireless Service
  * Auth method: PSK-SAE(WPA2 WPA3 mixed)
  * Crypto method: WPA2-WPA3(mixed)
* Go to Redmi TV > Settings > Network > WiFi
* Select the SSID created by AC and input Password
* It displays "Saved" but failed to get IP / gateway / DNS from DHCP server

## Root Cause
* Incorrect password
  * May be "incorrect" password(typo) was set on Huawei S380
  * Or may be user input incorrect password on Redmi TV
* Latest version(2025/05) of Redmi TV does not promt "incorrect password" but still shows "saved" for incorrect password

## Solution
* Re-set Wireless Service password on Huawei S380 AC
* Re-input password on Redmi TV

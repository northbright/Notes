# My iPhone Has No Internet Connection but Others are OK when We Connected to the Same SSID

## Problem
* Huawei S380 as router and AC
* 2 Huawei AP362E as APs
* Huawei S380 settings
  * VLANs

    | VLAN ID | Description |
    | :--: | :--: |
    | 1 | Default VLAN(management) |
    | 2 | for PCs, phones, printers |

  * Enable DHCP servers on VLAN 1 and 2
* My iPhone has no internet connection and can not get IP via DHCP
* Others' phones are OK

## Root Cause
* The AP(AP1) my iPhone connected and the AP(AP2) others connected are **NOT** the same
  * Web Management > Web Monitor > Users
  * AP1 -> Connected VLAN ID: 2
  * AP2 -> Connected VLAN ID: 1

* The port used to connect AP1 are configured incorrectly
  * Type: trunk
  * Permitted VLANs: 1, 2
  * Default VLAN ID(PVID): 2(**INCORRECT**)

## Solution
Set PVID of this port to 1(management VLAN of S380)

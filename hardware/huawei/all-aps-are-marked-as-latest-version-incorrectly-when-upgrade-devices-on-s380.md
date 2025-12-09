# All APs are Marked as Latest Version Incorrectly when Upgrade Devices on S380

## Problem
* Huawei S380 S2P2T as AC
* AP: AP160 and AP362E using R023 version
* Upgrade Huawei S380 to latest version(V600R025C00SPC100) using Local Ugrade
* Use Online Upgrade（整网在线设备升级） to upgrade all APs
* It shows all APs are using latest version and can not be upgraded(已使用最新版本)

## Root Cause
* Online Upgrade needs the time difference between APs and S380 is not significant

## Solution
Setting the Entire-Network Time（整网时间配置）。

* System > Entire Network Management > Entire Network Time Configuration > Change
* Set Time Zone
* Setting Mode: Automatic
  * Turn Off "Key configuration" 
  * Input NTP server IP(e.g. `203.107.6.88` for `ntp.aliyun.com`)
  * Server source port: `Vlanif1`
* Click OK

* Go to Online Upgrade and all APs are ready to upgrade

## Warning
Online upgrade for all APs may take a very long time.
Local AP upgrade（本地AP升级） is highly recommended.

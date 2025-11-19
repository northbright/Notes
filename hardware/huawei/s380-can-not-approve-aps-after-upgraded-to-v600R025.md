# S380 Can Not Approve APs after Upgraded to V600R025

## Problem
* S380 L4T1T as AC managed 5 AP362E
* S380 was damaged suddenly and replaced by a new one
* Upgraded the new S380 from V600R024 to V600R025
* Can not approve AP and got the error:

  > 请在审批列表中添加WAC，或跳转登录到本机设备使能无线管理
* Reboot APs by reset POE switch does not work

## Root Cause
* S380 V600R025 may have problem with Wireless Management
* Huawei service engineer said it's a known issue and the workaround is turn off / on Wireless Management

## Solution
Disable Wireless Management and enable it again.

* Go to Wireless Management
* Disable
* Enable
* Reboot S380

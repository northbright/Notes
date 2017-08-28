# Ignore the IP Confict Warning when Use Static IP for UBNT UAP

## Problem
* Using static IP for each UAP AC Lite in Unifi Controller.
* `192.168.1.2` - `192.168.1.5` is OK.
* `192.168.1.6` and later, it'll pop up a warning:
  
   `There may be a conflict between the Static IP from the Network settings and the assignable DHCP range from the USG.`

## Root Cause
* The range of DHCP pool of USG(Unifi Security Gateway) is `192.168.1.6` - `192.168.1.254` by default.

## Solution
* If you do **NOT** have any USG device in your network, just **IGNORE** the warning.

--------------------

# 可以忽略UBNT UAP的网络设置中使用静态IP后提示的IP冲突警告

## 问题
* 在Unifi Controller的设置中，每个UAP AC Lite的网络设置使用静态IP。
* `192.168.1.2` - `192.168.1.5`是没有问题的。
* `192.168.1.6`开始，会提示如下警告:

   `There may be a conflict between the Static IP from the Network settings and the assignable DHCP range from the USG.`

## 原因
* USG(Unifi Security Gateway)的默认DHCP池的范围是：`192.168.1.6` - `192.168.1.254`。

## 解决方案
* 如果你的网络中没有USG，直接忽略即可。


# Devices Can Not Connect AP Managed by s380 after Telecom Gateway Replaced

## Problem
* AC: Huawei S380, AP: Huawei AP362 and devices works fine
* Old Telecom broadband service(`KDXXXX`) was canceled
* Applyed a new Telecom broadband service
* Telecom gateway device was replaced by a new one
* Update new PPPOE account and password in Huawei S380 settings
* It's OK to get WAN IP by PPPOE
* PCs on LAN can access internet
* iPhone 7 plus(iOS 15) and Mi TV can not connect the SSID
  * iPhone 7 plus reported the error:

    > Unable to Join the Network
    > "This network is operating on Wi-Fi channels in use by several other nearby networks." 

  * Mi TV's WiFi network status: "already saved" but not "connected"
    * Mi Engineer indicates that "already saved" means incorrect password
* iPhone 14(iOS 18) keeps connection before and after the gateway replaced
* Reboot S380 and AP but not work

## Root Cause
* S380 may run into problem

## Solution
Reset the password(keep the same as old one is OK) of WLAN on S380.

----------------

# 在更换了电信网关后，设备无法连接到 S380 管理的 AP

## 问题
* AC: 华为 S380, AP: 华为 AP362，工作正常
* 旧的宽带服务(`KDXXXX`)被拆机取消
* 申请了一个新的宽带服务
* 电信网关设备也被新的替换
* 在 S380 的设置中更新了 PPPOE 拨号的账号和密码信息
* 成功获取到 WAN 的 IP
* 局域网的电脑可以正常访问外网
* iPhone 7 plus(iOS 15)和小米电视不能再正常连接到 SSID
  * iPhone 7 plus 报告错误:

    > 无法加入网络
    > 此网络运行的无线局域网频段正被附近多个其他网络使用。

  * 小米电视的无线网络状态："已保存"而不是“已连接”
    * 小米工程师提示“已保存”通常意味着密码不正确
* iPhone 14(iOS 18)在更换网关前后均可以持续连接到 SSID
* 重启 S380 和 AP 没有效果

## 原因
* S380 可能运行有问题

## 解决方法
重置 S380 WLAN 的密码（即使和之前的一样也没问题)。

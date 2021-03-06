# One UAP Can Only Be Managed by One Controller

## Problem
* Unifi Controller Software installed on a PC
* All UAP has been already adopted and managed by this Unifi Controller
* Want to migrate all UAP to a new laptop with new version of Unifi Controller installed
* Can not find any UAP when lauch Unifi Controller on the laptop

## Root Cause
* One UAP can only be adopted and managed by one Unifi Controller
* The UAP has been adopted and managed by one Unifi Controller can not be found by other Unifi Controllers

## Solution
* Turn off the old Unifi Controller
* You can see the UAP now(gray) in new Unifi Controller on the laptop
* Click the UAP > "+" >  "Advanced Adopt"
* Input the user name and password of the device
* The user name and password is set in the "Settings > Site > Device Authentication" of old Unifi Controller

## References
* [UniFi - 如何向 UniFi 控制器中添加新设备](https://help.ui.com.cn/articles/360000227321/)

------------------

# 1个 UAP 只能被1个 Unifi Controller 管理

## 问题
* 1台PC上安装了 Unifi Controller
* 所有 UAP 已经被这个 Unifi Controller 采用和管理
* 希望将所有 UAP 迁移到另外一台安装了新版 Unifi Controller的笔记本上进行采用和管理
* 在 Unifi Controller 中，找不到任何 UAP

## 原因
* 1个 UAP 只能被1个 Unifi Controller 采用和管理
* 已经被1个 Unifi Controller 采用和管理的 UAP 不能再被其他 Unifi Controller 发现

## 解决方案
* 关闭退出原先的 Unifi Controller
* 现在笔记本上的新版 Unifi Controller 可以发现 UAP（灰色）
* 点击 UAP > "+" > "高级采用"
* 输入UAP的用户名和密码
* 用户名和密码就是原先 Unifi Controller 的"Settings > Site > Device Authentication"

## 参考资料
* [UniFi - 如何向 UniFi 控制器中添加新设备](https://help.ui.com.cn/articles/360000227321/)

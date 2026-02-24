# Hikvision NVR will Use Admin Password as Default Password when Add Channel

## Problem
* Hikvision NVR
* Add Cameras(Channels) in bulk
* Channel status is failed: username and password are incorrect

## Root Cause
* NVR's admin's password and Camera's password are NOT same
* NVR will use admin's password as default password when add channel

## Solution
Set default channel password to the same of of camera.

* Go to Preferences（配置) > Channel Management(通道管理) > IPC Channel(IPC 通道) > More(更多配置) > Default Channel Password Management(默认通道密码管理)
* Set default channel password
* Select channels > Edit > Select "Use Default Channel Password"(勾选使用默认通道密码)

------------------

# 海康威视录像机在添加通道时使用管理员的密码作为默认通道密码

## 问题
* 海康威视 NVR
* 批量添加通道（摄像头）
* 通道状态失败: 用户名和密码错误

## 原因
* NVR 的管理员(admin)密码和摄像头的密码不一致
* NVR 在添加通道时使用管理员的密码作为默认通道密码

## 解决方法
将通道默认密码设置为和摄像头一致。

* 配置 > 通道管理 > IPC 通道 > 更多配置 > 默认通道密码管理
* 设置默认通道密码
* 中通道，编辑 > 勾选使用默认通道密码



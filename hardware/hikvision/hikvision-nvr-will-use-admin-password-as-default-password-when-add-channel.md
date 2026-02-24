# Hikvision NVR will Use Admin Password as Default Password when Add Channel

## Problem
* Hikvision NVR
* Add Cameras(Channels) in bulk
* Channel status is failed: username and password are incorrect

## Root Cause
* NVR's admin's password and Camera's password are NOT same
* NVR will use admin's password as default password when add channel

## Solution
Set default password when add channel.

* Go to Preferences（配置) > Channel Management(通道管理) > IPC Channel(IPC 通道) > More(更多配置) > Default Channel Password Management(默认通道密码管理)
* Set default channel password
* Select channels > Edit > Select "Use Default Channel Password"(勾选使用默认通道密码)

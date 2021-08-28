# Hikvison Camera Does NOT Work Even Channel Is Added on Recorder Due to Duplicated IP Address

## Problem
* Hikvision camera(channel) is added on the recorder(username, password, IP address are configured)
* Can not preview / playback this camera

## Root Cause
* The IP address of the camera is used by other camera(duplicated)
* The channel is overrided by other camera

## Solution
* Set a unique IP address fot the camera and re-add the channel of the camera to the recorder

-------------------

# 海康威视摄像头因为重复的 IP 不能正常工作（预览和回放）即使已经添加通道到录像机中

## 问题
* 海康威视摄像头（通道）已经被添加到录像机中（用户名，密码，IP 地址已经配置）
* 不能预览和回放该摄像头

## 原因
* 摄像头的 IP 地址已经被其他摄像头占用（重复）
* 摄像头的通道被其他摄像头的覆盖

## 解决方法
* 重新分配一个没有使用过的 IP 地址，重新添加摄像头的通道到录像机中



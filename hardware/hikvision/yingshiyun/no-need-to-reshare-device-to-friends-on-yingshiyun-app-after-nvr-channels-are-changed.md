# No Need to Re-Share Device(NVR and Its Channles) to Friends on Yingshiyun App after NVR's Channels are Changed

## Problem
* Use Yingshiyun App to Add the NVR Device by Scanning QRCode of the NVR
* Share NVR with Its Channels to Friends
* On Yingshiyun App, the Order of Channels are Not Expected

  e.g. Channel 1 -> Camera of Classroom 2(Camera of Classroom 1 is expected)

## Root Cause
* Cameras of Some Channels are Not Expected on NVR
* The NVR Channels Displayed on Yingshiyun are Sorted by Channel ID(e.g. D1 - D64 for 64 channels NVR) and It's Fixed

## Solution
* Need to Delete and Re-Add Some Cameras to NVR Channels on NVR to Make the Order Right
* No Need to Remove the Shared NVR and Re-Share It to Friends
* The Channels of the NVR on Yingshiyun App will Keep Updated with Local NVR

--------------------

# 海康威视 NVR 的通道改变后，无需在萤石云 App 上再次分享给朋友

## 问题
* 通过萤石云扫描 NVR 的二维码添加 NVR 设备到萤石云 App
* 分享 NVR 和其包括的通道给朋友
* 萤石云 App 上，发现视频通道的顺序和期望不一样

  e.g. 通道 1 -> 教室 2 的摄像头（期望的是教室 1 的摄像头）

## 原因
* 在 NVR 上，一些通道的摄像头和期望的摄像头不匹配
* 萤石云上是按照通道 ID 的固定顺序（e.g. D1 - D64 for 64 路 NVR)

## 解决方法
* 需要在 NVR 上删除通道中的摄像头，然后重新添加摄像头到通道来确保期望的顺序
* 不需要删除 / 重新共享 NVR 给朋友
* 萤石云 App 上 NVR 的通道会自动和本地 NVR 保持同步更新

# Hikvision Network Camera Can NOT Record Video to NVR

## Problem
* Log in NVR web admin page > Play Back > Select one channel > select date > click "Query" button
* Got the "no video file" warnning
* Camera Model: DS-IPC-K34HV2-LT, T14HV3-LA 4MM

## Root Cause
* All channels' record plan are set to "Motion Detection"
* "Motion Detection" of the network camera(channel) is not enabled

## Solution
Turn on "Motion Detection" for the channels.

#### Method A: Turn on "Motion Detection" of the channels on NVR web portal
* Go to NVR Settings > Event > Select Channel > Normal Event > Motion Detection Tab
* Select the channel(network camera)
* Enable "Motion Detection"，"Dynamic Analysis"

#### Method B: Turn on "Motion Detection" of the channels on camera web portal
* Get the IP of the channel in NVR settings > Channels
* Visit the camera IP to login camera web portal
* Go to preferences > Event > Motion Detection > Turn On > Save
* Reboot Camera to take effect!
  * Maintanence > Reboot

----------------

# 海康威视摄像头不能在 NVR 上录像

## 问题
* 登陆 NVR 的网络管理页面 > 回放 > 选择一个通道 > 选择日期 > 查询
* 提示 “没有文件” 警告

## 原因
* 所有通道的存储计划都设置为“移动侦测”
* 该通道（摄像头）没有启用“移动侦测”

## 解决方案
为通道启用“移动侦测”的事件。

#### 方法 A: 在 NVR 的设置上启用移动侦测
* 设置 > 事件 > 普通事件 > 移动侦测 Tab
* 选择该通道（摄像头）
* 启用“移动侦测”，“动态分析”

#### 方法 B: 在摄像头的设置中启用移动侦测
* 在 NVR 配置 > 通道 > 获取摄像头的 IP
* 访问摄像头的 IP，登录管理页面
* 配置 > 配置 > 事件 >事件监测 > 移动侦测卡项 >启用
* 重启摄像头后开始录像
  * 维护 > 重启

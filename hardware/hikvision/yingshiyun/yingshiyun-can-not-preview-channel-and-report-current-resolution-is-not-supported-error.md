# Yingshiyun Can Not Preview Channel and Report Current Resolution is Not Supported Error

## Problem
* Open Yingshiyun（萤石云）App
* Can Not Preview Some Channels of the NVR
* Report Error:

  > Current resolution is not supported. Please try to change resolution.

## Root Cause
* Video Stream Settings of Some Channels(Cameras) Have Problem
* NVR Hangs(no response after mouse clicks)
* Login NVR via Web Portal
* Find All Channels are Offline
  * Got Error:
    > Failed to Get Video Stream - 0x1b01043
* Find Video Stream Incorrent Settings
  * Max Bitrate is set to 32Kbps

## Solution
Re-Set Video Stream Settings for All Channels(Cameras) 

* Reset NVR via Web Portal
* Go to Settings > Video Settings > Video Tab
* Set First Channel's Video(Both Main Stream and Event Stream)
  * Resolution: 1920x1080P
  * Max Bitrate: 4096Kbps
* Copy to All Channels
* Click "Apply"

-----------------

# 萤石云不能预览通道，提示“不支持当前清晰度，请尝试切换清晰度”错误

## 问题
* 打开萤石云 App
* 不能预览 NVR 的某些通道
* 提示错误：

  > 不支持当前清晰度，请尝试切换清晰度

## 原因
* NVR 的某些通道的视频设置有问题
* NVR 死机（鼠标点击无响应）
* 从网页登录 NVR
* 所有通道不在线
  * 提示错误：

    > 不在线(通道取流失败！-0x1b01043)
* 发现一些通道（摄像头）的视频设置不正确
  * 码率上限设置为 32Kbps

## 解决方法
重新设置所有通道的视频设置

* 在网页登录 NVR 后，重启 NVR
* 配置 > 视音频 > 视频
* 先设置第 1 个通道的视频设置（主码流和事件码流保持一致）
  * 分辨率：1920x1080p
  * 码率上限：4096Kbps
* 复制到所有通道
* 应用

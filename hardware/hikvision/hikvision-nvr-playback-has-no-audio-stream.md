# Hikvision NVR Playback Has No Audio Stream

## Problem
* All Old Cameras Can NOT Record Audio
* Add a New Camera(Channel) which Can Record Audio
* Playback of the New Camera Has No Audio

## Root Cause
* Cause A: NVR Settings > Storage Plan > New Channel(Camera) > Advanced Options > Record Audio is NOT enabled.
* Cause B: NVR Settings > Video and Audio > Video Type of the Channel's Main Stream is NOT "Video & Audio”

## Solution
* NVR Settings > Storage Plan > New Channel(Camera) > Advanced Options > Enable "Record Audio"
* NVR Settings > Video and Audio > Channel > Main Stream
  * Set Video Type to "Video & Audio"(Settings of Camera will be Overrided by NVR's Settings)
  * Check Bitrate of the Video is Set Properly(e.g. 2048Kbps)
* Save

# 海康威视 NVR 回放录像没有音频

## 问题
* 所有旧摄像头不带拾音功能
* 新增 1 个通道（摄像头）带有拾音功能
* 在 NVR 上回放录像时，新的通道（摄像头）没有声音

## 原因
* A: NVR 设置 > 存储 > 计划配置 > 新添加的通道 > 高级参数 > 没有勾选“记录音频”
* B: NVR 设置 > 音视频 > 通道 > 视频 > 主码流 > 码流类型 > 没有设置为“复合流”

## 解决方法
* NVR 设置 > 存储 > 计划配置 > 新添加的通道 > 高级参数 > 没有勾选“记录音频”
* NVR 设置 > 音视频 > 通道 > 视频 > 主码流
  * 码流类型 > 设置为“复合流”（摄像头的设置将会被 NVR 的设置覆盖）
  * 设置合适的视频码率(e.g. 2048Kbps)
* 保存

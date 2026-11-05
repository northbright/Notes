# Hikvision DS-8632N Playback Videos Have No Audio

## Problem
* Hikvision DS-8632N NVR
* One camera supports audio recording and others do not support
* The preview of the camera has audio
* The playback videos of the camera have no audio
* In Video/Audio setting, video type is set to "Video & Audio"

## Root Cause
* "Record Audio"(in storage settings) is not enabled

## Solution
Enable "Record Audio".

* Settings > Storage > Schedule Configuration > Right Top "Advanced Options"
* Enable "Record Audio"

-----------------------------

# 海康威视 DS-8632N 回放视频没有声音

## 问题
* 海康威视 DS-8632N NVR
* 1 个摄像头支持录音，其他都不支持
* 预览时有声音
* 回放录像没有声音
* 视音频 > 码流类型已经设置为“复合流”

## 原因
* “记录音频”（在计划配置中）没有启用

## 解决方法
启用“记录音频”。

* 配置 > 存储 > 计划配置 > 选中通道（摄像头） > 右上角的“高级参数”
* 启用“记录音频”


# Hikvision NVR Playback Has No Audio Stream

## Problem
* All Old Cameras Can NOT Record Audio
* Add a New Camera(Channel) which Can Record Audio
* Playback of the New Camera Has No Audio

## Root Cause
Settings > Storage Plan > New Channel(Camera) > Advanced Options > Record Audio is NOT enabled.

## Solution
* Settings > Storage Plan > New Channel(Camera) > Advanced Options > Enable "Record Audio"
* Save

# 海康威视 NVR 回放录像没有音频

## 问题
* 所有旧摄像头不带拾音功能
* 新增 1 个通道（摄像头）带有拾音功能
* 在 NVR 上回放录像时，新的通道（摄像头）没有声音

## 原因
设置 > 存储 > 计划配置 > 新添加的通道 > 高级参数 > 没有勾选“记录音频”

## 解决方法
* 设置 > 存储 > 计划配置 > 新添加的通道 > 高级参数 > 没有勾选“记录音频”
* 保存

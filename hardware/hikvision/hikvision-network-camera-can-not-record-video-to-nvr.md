# Hikvision Network Camera Can NOT Record Video to NVR

## Problem
* Log in NVR web admin page > Play Back > Select one channel > select date > click "Query" button
* Got the "no video file" warnning

## Root Cause
* All channels' record plan are set to "Motion Detection"
* "Motion Detection" of the network camera(channel) is not enabled

## Solution
* Goto Settings > Event > Select Channel > Normal Event > Motion Detection Tab
* Select the channel(network camera)
* Enable "Motion Detection"，"Dynamic Analysis"

----------------

# 海康威视摄像头不能在 NVR 上录像

## 问题
* 登陆 NVR 的网络管理页面 > 回放 > 选择一个通道 > 选择日期 > 查询
* 提示 “没有文件” 警告

## 原因
* 所有通道的存储计划都设置为“移动侦测”
* 该通道（摄像头）没有启用“移动侦测”

## 解决方案
* 设置 > 事件 > 普通事件 > 移动侦测 Tab
* 选择该通道（摄像头）
* 启用“移动侦测”，“动态分析”

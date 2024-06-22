# Hikvision NVR 5 Motion Detection Event Settings

## Problem
* Hikvision NVR: DS-8632N-I16-V3 with NVR Version 5.0
* SW Version: V5.0 build 240226
* Found Storage Plan Settings of NVR 5.0 is Different from NVR 4.0
* Need to Set Storage Plan of All Channels to Event(Motion Detection)

## Solution
1. Set Storage Plan to Events for All Channels
  * Storage Plan > Video > Plan Details > Click "Events" Brush and Select 00:00 - 24:00 for Monday to Sunday(drag the brush from left-top to right-bottom)
  * Make Sure Storage Plan for Each Channel is "On"
  * Save

2. Batch Turn On Motion Detection Event for All Channels
  * Event Center > Event Config > Batch Config
  * Events Column > Select Motion Detection > Click Column Head of "Enable Event" > All Channels are Selected
  * Save

3. Check
  * Playback > Select One Channel > Select the Date with Purple Flag(means Event Storage Plan) > Search
  * Red Rectangles in the Timeline are Recorded Videos for Motion Detection

--------

# 海康威视 NVR 5.0 移动侦测设置

## 问题
* 海康威视 NVR: DS-8632N-I16-V3，软件版本：NVR 5.0
* 编码版本：V5.0 build 240226
* NVR 5.0的存储计划和NVR 4.0 不同
* 需要设置存储计划为事件存储（移动侦测）

## 解决方法
1. 为所有通道设置为事件的存储计划
  * 存储管理 > 存储计划 > 录像 > 计划详情 > 点击“事件”刷子 > 为周一到周日选择 00:00 - 24:00（左上角拖动刷子到右下角）
  * 确认所有通道都“启用”
  * 保存

2. 批量为所有通道启用移动侦测事件
  * 事件中心 > 事件配置 > 批量配置 > 移动侦测 > 点击“事件启动”列头 > 所有通道都启动事情（移动侦测）
  * 保存

3. 确认
  * 回放 > 选择 1 个通道 > 选择有紫色标记的日期(说明使用事件存储计划) > 查找
  * 时间线的红色矩形表示移动侦测的录像

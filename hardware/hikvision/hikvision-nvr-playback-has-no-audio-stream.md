# 海康威视 NVR 回放录像没有音频

## Problem
* 摄像头带有拾音功能
* 在 NVR 上回放录像时，没有声音

## Solution
需要确认视频类型为“复合流”

配置 > 视音频 > 视频 Tab > 视频类型 > 选择“复合流”（如果通道对应的摄像头不支持拾音，只能选视频流）

# Hikvision Camera Status in NVR is Offline after Reset Camera's Password

## Problem
* Login the camera's web admin URL
* Reset a camera's password
* After some days, the status of the camera in NVR is OFFLINE(username and password are not matched)

## Root Cause
* Need to modify the password of the camera in the channel settings of NVR

## Solution
* Goto `Channel Management` in NVR
* Select the channel of the camera, click "modify"
* Reset the camera's password
* The status of the camera should be ONLINE(refresh the page)
* You may need to reset the camera and NVR if it's still OFFLINE
* You may need to set the record stragety(e.g. motion detection) again for all channels

---------------

# 重置海康威视摄像头的密码后， NVR 中摄像头的状态为“不在线”

## 问题
* 登陆摄像头的网络管理页面
* 重置摄像头的密码
* 海康威视 NVR 中该摄像头通道的状态显示为“不在线（用户名和密码不正确）”

## 原因
* 同样需要在 NVR 中的通道设置中，重置该摄像头的密码

## 解决方法
* 在 NVR 的菜单中，选择“通道管理”
* 勾选摄像头，点击“修改”
* 重置摄像头的密码
* 摄像头的状态应该就变为“在线”（刷新页面）
* 如果状态还是“不在线”，可能需要重启摄像头和 NVR
* 可能需要重新设置所有通道的存储策略（e.g. 移动侦测）

# Can not Save Screenshot or Video when Replaying via Web Admin of Hikvision Recorder

## Problem
* Login web admin of Hikvision recorder using Internet Explorer
* Select one channel and replay
* Take screenshot or video(cut) during the replay
* It showes screenshot or video has been save to "C:\User\xx\Web\PlaybackPictures\xxxx" successfully"
* Click the link and can **NOT** find the picture or video

## Root Cause
* Internet Explorer has no privilege to save files in such path as "C:\User\xx\xx"

## Solution
* Run Internet Explorer as **Administrator**
* Login and save again

------

# 登录海康威视网络管理后台，回放时不能保存截图和视频

## 问题
* 使用Internet Explorer登录海康威视网络管理后台
* 选择一个通道，开始回放
* 保存截图和视频(使用`剪刀`icon进行剪辑的)
* 提示成功保存截图和视频到"C:\User\xx\Web\PlaybackPictures\xxxx"
* 点击链接，不能找到保存的截图和视频

## 原因
* Internet Explorer没有保存至"C:\User\xx\xx"的权限

## 解决方案
* **以管理员身份运行**Internet Explorer
* 重新登录，保存

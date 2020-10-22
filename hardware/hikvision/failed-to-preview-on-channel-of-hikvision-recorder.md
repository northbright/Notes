# Failed to Preview One Channel of HikVision Recorder

## Problem
* Login web admin page of HikVision Recorder
* Goto "Preview" and click the **ICON** of selected channel to preview
* It failed to preview and popped up a "Failed to Preview" notification on right-bottom
* But when login web admin page of HikVsion **Camera**, it can preview successfully

## Root Cause
* The defaut stream of preview is depend on the way to preview:

| Default Stream Type | Way of Preview |
| :--: | :--: |
| Sub-Stream | Web admin of recorder |
| Main-Stream | Web admin of camera |
| Main-Stream | Login recorder directly | 

* It can preview successfully via web admin of camera means that Main-Stream is OK
* So the Sub-Stream may have problem
* Login web admin pages of other Cameras which can be previewed successfully and compared the settings, found some different settings of "Video Settings" > "Sub-Stream"

| Sub-Stream Settings | Success | Failure |
| :--: | :--: | :--: |
| Resolution | 704 x 576 | 352 x 288 |
| Max Bit Rate | 512 kbps | 4096 kbps |

## Solution
* Follow the settings of other cameras which can preview successfully

-------------------------------------
# 海康威视的录像机的通道预览失败

## 问题
* 登陆海康威视录像机的网络管理界面
* 选择"预览"，点击摄像头图标开始预览
* 预览失败，并且右下角出现"预览失败"的提示
* 但是，当登陆**摄像头**的网络管理页面，能够正常预览

## 原因
* 预览使用的默认码流是根据不同预览方式决定的:

| 默认预览码流 | 预览方式 |
| :--: | :--: |
| 子码流 | 录像机网络管理界面 |
| 主码流 | 摄像头网络管理界面 |
| 主码流 | 直接在录像机管理 | 

* 摄像头网络见面能正常预览说明主码流是正常工作的
* 子码流可能出问题
* 登陆其他正常预览的摄像头的网络管理界面，发现在"音视频" > "子码流"的设置中，有不同的设置

| 子码流设置 | 成功的| 失败的|
| :--: | :--: | :--: |
| 分辨率| 704 x 576 | 352 x 288 |
| 码率上限 | 512 kbps | 4096 kbps |

## 解决方法
* 按照那些正常预览的摄像头，设置"子码流"的相关参数

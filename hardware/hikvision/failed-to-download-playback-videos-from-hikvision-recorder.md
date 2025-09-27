# Failed to Download Playback Videos from Hikvision Recorder

## Problem
* Login the admin site of Hikvision recorder remotely via IP address by using IE
* In "Settings" -> "Local Settings", path of download playback files is set to `C:\Users\xx\Web\DownloadFiles` or `C:\Users\xx\WebPlugins\DownloadFiles` by default
* Can't find the `C:\Users\xx\Web` or `C:\Users\xx\WebPlugins` folder and downloaded playback video files after it indicated "Download Successfully"

## Solution
* Running IE as **administrator** then login the admin site of Hikvision recorder
* It'll create `C:\Users\xx\Web\DownloadFiles` or `C:\Users\xx\WebPlugins\DownloadFiles` folder and download video files successfully

## References
* [海康威视web管理端下载录像失败原因分析](https://jingyan.baidu.com/article/0aa223757b2efe88cd0d644a.html)

-------

# 从海康威视录像机下载回放视频文件失败

## 问题
* 使用IE通过IP地址远程登录海康威视的管理页面
* 在"设置" -> "本地"中，"回放文件下载地址"默认设置为: `C:\Users\xx\Web\DownloadFiles` 或 `C:\Users\xx\WebPlugins\DownloadFiles`
* 在提示"下载完成"后，没有找到`C:\Users\xx\Web` 或 `C:\Users\xx\WebPlugins` 文件夹和下载的回放视频文件

## 解决方案
* 以**管理员**运行IE，然后远程登录海康威视的管理页面
* `C:\Users\xx\Web\DownloadFiles` 或 `C:\Users\xx\WebPlugins\DownloadFiles`，视频文件成功下载

## 参考
* [海康威视web管理端下载录像失败原因分析](https://jingyan.baidu.com/article/0aa223757b2efe88cd0d644a.html)

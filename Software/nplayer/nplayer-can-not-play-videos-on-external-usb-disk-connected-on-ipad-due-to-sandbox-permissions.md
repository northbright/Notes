# nPlayer Can Not Play Videos on External USB Disk Connected on iPad due to Sandbox Permissions

## Problem
* nPlayer 3.13.0
* iPad(iPadOS 16), iPad Pro M5(iPad OS 26.5)
* It's OK to play videos on external disk on iPadOS 25.5
  * Run nPlayer > External Files > Select External USB Disk > Select one folder > Right-Top "Open" button > List Videos > Select one video and play 
* It failed to play videos on external disk on iPadOS 16
  * Run nPlayer > External Files > Select External USB Disk > Select one folder
  * There's NO "Open" button on right-top

## Root Cause
* For iPadOS 16, the app which runs in sandbox has no permission to enumerate external disk files directly
* iPadOS 26 improves the sandbox permission of external storage

## Solution
Upgrade iPadOS to 26.5 or later.

## References
* Visit [qwen](https://www.qianwen.com/) and input "nplayer 在 iPad 上打开外部存储的文件夹，右上角没有“打开”按钮，不能播放文件夹中的视频。这个是什么原因？"
* Input "方法二：借助系统“文件”App 调起播放，这个可以解决。那如果在 nPlayer 或者 iPad OS 上如何设置来解决"
* Input "2. 在 nPlayer 内手动添加外部存储路径，解决此问题。这台是 iPad OS 16, nPlayer 3.13.0。
另外一台 iPad Pro M5, iPad OS 26.5，nPlayer 3.13.0 不用手动添加外部存储路径也可以直接访问外部存储。这个是因为 iPad OS 版本的问题吗"

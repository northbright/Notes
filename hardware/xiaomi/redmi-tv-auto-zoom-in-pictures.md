# Redmi TV Auto Zoom in Pictures

## Problem
* Redmi TV X55 2022
* Copy Some Large Pictures(Resolution: 3930x2267) to a USB Drive or a SMB Share
* It'll Make the Pics Fit the Full Screen when Open the Pics in File Manager
* After 1 Year, When Open the Pics Again, It'll Zoom in the Pics Automatically

## Root Cause
* Redmi TV X55's Resolution: 3840x2160(4K)
* Image Resolution: 3930x2267(aspect ratio is NOT 16:9)
* Redmi TV was Updated to a New Version Automatically
* The New File Manager(Image Viewer) Can Not Resize the Image to Fit Full Screen and Keep Its Aspect Ratio

## Solution A(Recommended)
Resize the images to TV's resolution(4K).
* [Resize Image Using FFmpeg](https://github.com/northbright/Notes/blob/master/Software/ffmpeg/resize-image-using-ffmpeg.md#solutionbatch-resize)


## Solution B
* Do a Factory Restore
* The System ROM Version is Restored to MIUI TV 2.28.6129
* Disable Automatic Update

------------------

# 红米电视在播放图片时自动放大

## 问题
* 红米电视 X55 2022
* 复制一些大尺寸图片（分辨率：3930x2267）到 U 盘或者 SMB 共享文件夹
* 当文件管理应用打开这些图片时，会自动将图片尺寸适应屏幕
* 1 年后，当重新打开这些图片时，会自动放大这些图片导致不能看全图片

## 原因
* 红米 X55 电视的分辨率：3840x2160(4K)
* 图片分辨率：3930x2267(比例不是 16:9)
* 红米电视自动更新到 1 个新的版本（智能更新：开）
* 新的文件管理应用打开这些大尺寸图片会有一些问题，不能重新调整图片大小，在保持原始比例的情况下，全屏显示

## 解决方法 A（推荐）
重新调整图片的分辨率到电视的分辨率：3840x2160(4K)。
* [Resize Image Using FFmpeg](https://github.com/northbright/Notes/blob/master/Software/ffmpeg/resize-image-using-ffmpeg.md#solutionbatch-resize)

## 解决方法 B
* 恢复出厂设置
* 将系统版本恢复至 MIUI TV 2.28.6129（稳定版）
* 关闭“智能更新”

# Adjust Video Bitrate to Fix Blurry Hikvision Camera

## Problem
* User reported that the camera is blurry when preview via browser

## Root Cause
* The bitrate is limited up to 128 Kbps in video settings

## Solution
* Set the max bitrate to 4096 Kbps(default value) in video settings

-----------------

# 通过设置视频码率来解决海康威视摄像头模糊的问题

## 问题
* 用户在浏览器预览时，摄像头模糊

## 原因
* 配置 > 视音频 > 视频 > 码率上限 设置为 128 Kbps

## 解决方法
* 配置 > 视音频 > 视频 > 码率上限 设置为 4096 Kbps(默认值)

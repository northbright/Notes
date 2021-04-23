# Can Not Ping Hikvision Camera Successfully Due to Incorrect Gateway

## Problem
* Login web admin of Hikvision Recorder(NVR)
* Found one camera's status is offline
* Failed to ping the IP address of the camera

## Root Cause
* Connect a cable from PC to the camera directly
* Run [SADP Tool](https://www.hikvision.com/cn/download_more_393.html) on the PC
* Find the camera in the tool and its gateway is incorrect

## Solution
* Set the gateway of the camera correctly in [SADP Tool](https://www.hikvision.com/cn/download_more_393.html)
* Then the status of the camera in the NVR will also be ONLINE

----------------

# 因为错误的 Gateway，导致不能成功 ping 通海康威视摄像头

## 问题
* 从网络登陆海康威视录像机(NVR)的管理页面
* 发现一个摄像头的状态是 offline
* 不能 ping 通该摄像头的 IP 地址

## 原因
* 使用网线直接连接一台 PC 和摄像头
* 在 PC 上运行 [SADP Tool](https://www.hikvision.com/cn/download_more_393.html)
* 在软件中发现该摄像头，但是摄像头的 Gateway 没有被正确设置

## 解决方法
* 使用 [SADP Tool](https://www.hikvision.com/cn/download_more_393.html) 正确设置摄像头的 Gateway
* 海康威视录像机(NVR)中，该摄像头的状态就为 ONLINE 了

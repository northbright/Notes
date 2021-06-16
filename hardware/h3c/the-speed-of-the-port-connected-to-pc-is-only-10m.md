# The Speed of Port Connected to a PC is Only 10M

## Problem
* A PC is connected to a port(access) on the H3C S5120 access switch
* Use console cable to login the switch
* Run `display interface brief` and shows the port speed is only 10M

## Root Cause
* The PC is in sleep mode and the ethernet card also works in sleep mode
* It'll be 1000M when the PC awakes

---------

# H3C交换机连接电脑的端口显示只有 10M 的速度

## 问题
* 1 台PC连接到 H3C S5120 接入交换机的 1 个端口
* 使用 Console 线连接交换机登陆
* 运行 `display interface brief` 显示连接 PC 的端口的速度只有 10M

## 原因
* PC 长时间不运行，进入睡眠模式，网卡也运行在睡眠模式
* 唤醒 PC 后，正常运行显示端口速度为 1000M

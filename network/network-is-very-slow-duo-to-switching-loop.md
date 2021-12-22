# Network is Very Slow Due To Switching Loop

## Problem
* Users reported network became very slow suddenly
* To diagnostic the problem, we ping gateway and found many packets loss

## Root Cause
* There is switching loop
  * After we removed some cables form the switch, `ping` works well and no packet loss
  * We locate Ethernet Port 1 and 2 on the switch
    * The network is very slow when cables of Port 1 and 2 are pluged at the same time on the switch
    * Remove the cable of Port 1 or 2, the network become normal and **BOTH** indicator LEDs of Port 1 and 2 are **OFF**
    * There's a switching loop when cables of Port 1 and 2 are pluged at the s
ame time on the switch

## Solution
* Remove the cables of Port 1 and 2，make sure there's NO switching loop

-------------

# 网络回路造成网络非常缓慢

## 问题
* 用户反应网络突然非常缓慢
* 使用 `ping` 来诊断网络，发现很多丢包

## 原因
* 存在网络回路
  * 在移除了交换机的网线后，发现 `ping` 工作的很好，也没有丢包了
  * 定位到交换机上的 Ethernet Port 1 和 Port 2 网口
    * 当 Port 1 和 2 口同时插了网线后，网络就十分缓慢
    * 当 移除 Port 1 或者 2 任意 1 个网口的网线，网络就正常了。Port 1 和 2 的 LED 指示灯**同时**熄灭
    * 当 Port 1 和 2 口同时连接了网线后，网络存在回路

## 解决
* 移除 Port 1 和 2 口的网线，确保没有网络回路

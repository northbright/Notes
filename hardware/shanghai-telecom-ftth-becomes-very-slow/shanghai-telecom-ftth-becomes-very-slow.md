# Shanghai Telecom FTTH(commercial) Becomes Very Slow

## Background
* Local network connected to internet via FTTH(100Mbps) provided by Shanghai Telecom
* Network Topological
   ![](img/01.svg)
* Raisecom MSG2200-T4 was set to bridge mode
  * LAN 8 was connected to H3C ER3260 to PPPOE dial up
     ![](img/01.jpg)
* It works well for a long time

## Problem
* Network became very slow suddenly
* Find continuous Incoming Bandwidth usage is almost 100%(100Mbps) in the router's log
   ![](img/02.png)
   ![](img/03.png)

## Steps to find out root cause
1. Connect LAN 8 of Raisecom MSG2200-T4 to one PC directly
2. Create a PPPOE dial up connection
3. Run "Performace Monitor" of Windows
    * Find stable / continuous incoming bandwidth usage(12Mbps)
4. Install and run [Wireshark](https://www.wireshark.org/) to see what's happening on the network
    * Captured stable / continuous UDP multicasting packets(130Mbps)
       ![](img/04.jpg)
5. Report the problem to Shanghai Telecom and ask them to replace the Raisecom MSG2200-T4 with a modem(not gateway, only have one LAN interface)
6. Run [Wireshark](https://www.wireshark.org/) again and there's no such multicasting packets

## Root Cause
* Raisecom MSG2200-T4 has some problems

## Solution
* Replace the Gateway(Raisecom MSG2200-T4) with a modem(not gateway, only have one LAN interface)

---------------
# 上海电信光纤宽带（商用）变得非常慢

## 背景
* 本地网络通过上海电信光纤宽带(100Mbps)连接到Internet
* 网络拓扑图
   ![](img/01.svg)
* 电信网关Raisecom MSG2200-T4已经设置为桥接模式
   * LAN 8口连接到H3C ER3260路由器进行PPPOE拨号
      ![](img/01.jpg)
* 正常使用很长一段时间

## 问题
* 网络突然变的非常缓慢
* 在路由器的日志中发现持续的流入流量几乎占满带宽的100%(100Mbps)
   ![](img/02.png)
   ![](img/03.png)

## 排除问题的步骤
1. 将Raisecom MSG2200-T4的LAN 8口直接连接至1台PC的网口
2. 创建PPPOE拨号网络连接至Internet
3. 运行Windows自带的"性能"
    * 发现稳定持续的流入带宽占用(12Mbps)
4.  安装和运行 [Wireshark](https://www.wireshark.org/)来查看网络问题
     * 捕捉到稳定持续的UDP组播的包(130Mbps)
     ![](img/04.jpg)
5. 向上海电信报修要求更换Raisecom MSG2200-T4为单口光猫（不是网关，只有1个LAN口的单口光猫）
6. 再次运行[Wireshark](https://www.wireshark.org/)，发现流入的流量正常，且没有UDP的组播的包了

## 解决方案
* 更换Raisecom MSG2200-T4为单口光猫（不是网关，只有1个LAN口的单口光猫）

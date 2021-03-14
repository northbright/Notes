# Can Not Discover UAPs in Unifi Controller Due to Set Network Profile to Public on Windows 10

## Problem
* Installed Unifi Controller on a server 3 years ago
* All UBNT UAP were managed by this Unifi Controller
* Installed latest Unifi Controller on a laptop
* Want to migrate all UAPs from old Unifi Controller to the new one
* Can not discover any UAPs in the new Unifi Controller on the laptop
* But it's OK when installed the same version of Unifi Controller on another PC(All UAPs can be discovered and the status is "managed by other")

## Root Cause
* The laptop's network profile is "Public"
* The PC's network profile is "Private"
* The firewall policies of "Public" profiles make UAPs undiscoverable in the Unifi Controller

## Solution
* Set laptops' network profile to "Private" and it works

## References
* [Make a Wi-Fi network public or private in Windows 10](https://support.microsoft.com/en-us/windows/make-a-wi-fi-network-public-or-private-in-windows-10-0460117d-8d3e-a7ac-f003-7a0da607448d)

------------

# 当 Windows 10 的网络配置文件设置为“公共”时 Unifi Controller 不能发现 UAP

## 问题
* 3 年前在1台服务器上安装了 Unifi Controller
* 所有的 UAP 都被这个 Unifi Controller 管理
* 现在在 1 台笔记本上安装最新版的 Unifi Controller
* 希望将所有的 UAP 从老版本的 Unifi Controller 迁移到新版本上（笔记本上的）
* 笔记本上的 Unifi Controller 不能发现任何 UAP
* 但是当在 1 台台式机上安装同样版本的 Unifi Controller 时，UAP 可以被发现（显示 "manage by other"）

## 原因
* 笔记本的网络配置文件为“公共”
* 台式机的网络配置文件为“专用”
* “公共”网络配置文件的防火墙策略导致 UAP 不能被 Unifi Controller 发现

## 参考
* [在 Windows 10 中将 Wi-Fi 网络设置为公共或专用网络](https://support.microsoft.com/zh-cn/windows/%E5%9C%A8-windows-10-%E4%B8%AD%E5%B0%86-wi-fi-%E7%BD%91%E7%BB%9C%E8%AE%BE%E7%BD%AE%E4%B8%BA%E5%85%AC%E5%85%B1%E6%88%96%E4%B8%93%E7%94%A8%E7%BD%91%E7%BB%9C-0460117d-8d3e-a7ac-f003-7a0da607448d)

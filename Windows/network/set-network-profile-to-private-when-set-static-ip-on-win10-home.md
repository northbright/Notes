# Set Network Profile to `Private` when Set Static IP on Win10 Home

## Problem
* Set static IP for the ethernet on Windows 10
  
  * IP: 10.0.2.8
  * Subnet Mask: 255.255.255.0
  * Gateway: 10.0.2.1
  * DNS: 10.0.2.2
* Network **NAME** is **`Undefined Network`**
* The network profile of `Undefined Network` is set to `Public` by default
* The default firewall settings of `Public` network profile are strict and make some apps / tools not work
  * e.g. [UBNT Unifi Controller](https://www.ui.com/download-software/) can not find any APs on the network due to the default firewall settings
* Can not run `secpol.msc` to make `Undefined Network` to use `Private` profile on Windows 10 **Home**(available on Windows Pro)
* Want to make these apps / tools work **WITHOUT** turning **OFF** or make changes to default firewall settings for `Public` network profile

## Solution
Run PowerShell command to set the profile of **`Undefined Network`** to **`Private`**
* Type "PowerShell" in Search > right click on "PowerShell" > Run as administrator
* Get the name of the network connection and check the profile

  ```
  Get-NetConnectionProfile

  // Output:
  Name:      Undefined Network
  ......
  NetworkCategory: Public
  ```
* Set network profile to `Private` by name(copy and paste the name in previous step)

  ```
  // xx is the name in previous step, copy and paste it
  Set-NetConnectionProfile -Name “xx” -NetworkCategory Private
  ```
* Check the network type again

  ```
  Get-NetConnectionProfile

  // Output:
  Name:      Undefined Network
  ......
  NetworkCategory: Private

* The apps / tools should work now

## References
* [Unidentified Network, Static IP, LAN Ok](https://www.windows10forums.com/threads/unidentified-network-static-ip-lan-ok.13846/)

---------------------

# 当在 Win10 Home 上设置静态 IP 时，设置网络配置文件为“专用”

## 问题
* 在 Win10 Home 上设置静态 IP

  * IP: 10.0.2.8
  * Subnet Mask: 255.255.255.0
  * Gateway: 10.0.2.1
  * DNS: 10.0.2.2

* 网络名字为：“未识别的网络”
* “未识别的网络”的网络配置文件默认为“公用”
* “公用”网络配置文件对应的防火墙的设置比较严格，导致一些应用和工具不能工作
  * e.g. [UBNT Unifi Controller](https://www.ui.com/download-software/) 在默认防火墙的设置下，不能找到任何 AP
* 不能在 Win10 Home 上运行 `secpol.msc` 来设置“未识别的网络”的网络配置文件为“专用”(Win10 专业版上可以)
* Want to make these apps / tools work **WITHOUT** turning **OFF** or make changes to default firewall settings of `Public`
* 希在不关闭防火墙和修改默认针对"Public"网络配置文件的防火墙设置的情况下，应用和工具能工作

## 解决方法
运行 PowerShell 命令来设置“未识别的网络”的网络配置文件为“专用”
* 在搜索框输入 "PowerShell" > 右键点击 "PowerShell" > 以管理员运行
* 获取网络连接的名字和检查网络配置文件

  ```
  Get-NetConnectionProfile

  // Output:
  Name:      未识别的网络
  ......
  NetworkCategory: Public
  ```
* 根据名字来设置网络配置文件为“专用”(复制和粘贴上一步的名字)

  ```
  // xx 为上一步的 Name, copy and paste it，这里应该为"未识别的网络"
  Set-NetConnectionProfile -Name "xx" -NetworkCategory Private
  ```
* 检查网络配置文件是否已经被修改

  ```
  Get-NetConnectionProfile

  // Output:
  Name:      未识别的网络
  ......
  NetworkCategory: Private

* 应用和工具应该能够正常工作了

## 参考资料
* [Unidentified Network, Static IP, LAN Ok](https://www.windows10forums.com/threads/unidentified-network-static-ip-lan-ok.13846/)

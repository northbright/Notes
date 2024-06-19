# Set Bridge Mode for Raisecom Gateway

## Steps
1. Get Password of "telecomadmin"

  * Send Last 8 Letters / Numbers of SN of Raisecom Gateway(on the back) to Telecom Engineer
  * He'll Send the Password to You

2. Login to Raisecom Gateway

  * Connect PC to Raisecom Gateway's LAN
  * PC Ethernet Adapter Uses DHCP
  * Visit Default Raisecom Gateway Management IP: `http://192.168.1.1`(VLAN 1)
  * Login with Username: `telecomadmin` and the Password

3. Set Bridge Mode

  * Go to "Basic Settings" Tab > WAN Settings
  * PON Uplink Settings > Select `"1_Internet_R_"` Connection > Operation > Edit
  * WAN0 > Set Connection Mode to "Bridge"
  * Set Service Binding to "Internet"(default)
  * Add "Vlan1" to Interface Group
  * Confirm

4. Add LAN 8 to VLAN for Bridge Mode

  * Go to "Quick Wizard" Tab > "Bridge Mode Settings"
  * Binding Interfaces to VLAN > Check "LAN 8"
  * Confirm

5. Turn Off DHCP Server

  * Go to "Basic Settings" Tab > LAN Settings
  * "VLAN Interface" Tab > Server > Turn Off
  * Confirm

------

# 设置电信的 Raisecom 网关为桥接模式

## 方法
1. 得到 "telecomadmin" 的密码

  * 发送 Raisecom 网关的设备标识的最后 8 位字母 / 数字（在背面）给电信工程师
  * 他会发送对应的密码给你

2. 登录 Raisecom 网关

  * 连接 PC 到 Raisecom 的 LAN 口
  * PC 的网卡设置为 DHCP
  * 访问 Raisecom 网关的默认管理地址 IP: `http://192.168.1.1`(VLAN 1)
  * 使用 "telecomadmin" 和刚才的到的密码登录

3. 设置桥接模式

  * 基础配置 > WAN 接口配置 > PON 上行接口配置
  * 连接名称：`_Internet_R_` > 操作
  * WAN0 修改 > 连接模式 > 桥模式
  * 将接口列表中的 `vlan1` 加入到组接口列表中
  * 确定

4. 添加 LAN 8 到 VLAN 端口绑定列表中

  * 快速向导 > 桥接上网配置 > VLAN 端口绑定列表
  * 勾选 LAN 8
  * 确定

5. 关闭 DHCP 服务器

  * 基础配置 > LAN 接口配置 > 服务器 > 关闭
  * 确定

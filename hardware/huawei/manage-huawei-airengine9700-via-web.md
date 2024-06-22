# Manage Huawei AirEngine9700 via Web

## Default Manage IP
* Huawei AirEngine9700 Use `169.254.1.1/24`(Vlanif1) as Manage IP by Default
* If You've Changed the Manage IP and Forget It, You May Do a Factory-Recovery by Keep Pressing "RST" Button for 5 Seconds

## Connect PC to Huawei AirEngine9700
* Configure PC Network Adapter to Use Static IP
  * Huawei AirEngine9700 Does NOT Enable DHCP Server on VLAN 1
  * We Need to Use a Static IP for PC(e.g. `169.254.1.10/255.255.255.0`)
* Connect PC to any LAN(e.g. GE0/0/1)
* Open a Browser Window and Visit `https://169.254.1.1`

## Disable Password Policy(Optional)
* Go to Maintenance > Administrator > Password Policy > Turn Off

## Upload / Download Files via File Manager
* Go to Maintenance > System > File Management

  | File Type | Example |
  | :--: | :--: |
  | System File | `airengine9700s-s_v200r020c00spc300.cc` |
  | Patch File | `AirEngine9700S-S_V200R020C00SPH003.pat` |
  | Current Config File | `vrpcfg.zip` |
  | License File | `LIC20240525XX.dat` | 

## Install License
#### Activate License and Download License File
* [Active and Download License as End User](activate-and-download-license-as-end-user.md)

#### Upload the License File to Device
* Go to Maintenance > System > File Management
* Upload the Downloaded License File

#### Load the License
* Go to Maintenance > License > License File Information
* Click "Load" and Select the Uploaded License(e.g. `flash:/LIC20240525XX.dat`)
* It Shows the License Details after It Succeeded
  * The Device ESN and License File ESN are the Same
  * AP resources license

    | Item | Value |
    | :--: | :--: |
    | Control item current status | Normal |
    | Control item expiration time | Permanent |
    | Number of licenses | 16 |

## Upgrade AC

#### Save Current Configuration
* Click Right-Top "Save" Icon to Save Current Configration

#### Backup
* Backup Startup Files
  * Go to Maintenance > Device Upgrade > AC Upgrade > Export Startup Files
* Backup Configuration File(`vrpcfg.zip`)
  * Click Export Configuration File(Optional)
* Backup License File
  * Go to Maintenance > System > File Management
  * Find the License File(e.g. `LIC20240525XX.dat`) and Download

#### Download New System File and Patch File
* [Download New System File and Patch File](download-system-file-and-patch-of-huawei-device.md)

#### Upload New System File and Patch File
* Go to Maintenance > System > File Management
* Upload the Downloaded System / Patch File to the Device
  * It'll Take a Few Time(About 5 Minutes) to Upload System File(About 127MB), Please be Patient

#### Select Next Startup System / Patch File
* Go to Maintenance > Device Upgrade > AC Upgrade > Next Startup Information
* Select Next Startup System / Patch File
* Apply

#### Reboot Device
* Go to Maintenance > AC Restart > Restart Device

#### Check Version
* You Can Check the Log of Console
* Login after Reboot
* Check Version
  ```
  display version
  ```

## Configure AC

Network Topology

+------------------------------------------------------------------------+
|                                                                        |
|            +------------+                                              |
|            |  Gateway   |                                              |
|            +-----+------+                                              |
|                  |                                                     |
|                  |       VLAN 2: AC,AP Management                      |
|                  |       VLANIF: 10.0.2.1/24, DHCP server is enabled.  |
|            +-----+-----+                                               |
|            |Core Switch| VLAN 10: WLAN Service for laptop.             |
|            +-----+-----+ VLANIF: 10.0.10.1/24, DHCP server is enabled. |
|                  |                                                     |
|                  |       VLAN 20: WLAN Service for mobile device.      |
|                  |       VLANIF: 10.0.20.1/24, DHCP server is enabled. |
|                  |                                                     |
|                  |VLAN 2,10,20                                         |
|                  |                                                     |
|             +----+-----+  VLAN 2  +----+                               |
|             |POE Switch+----------+ AC | VLANIF: 10.0.2.3/24           |
|             +----+-----+          +----+                               |
|     VLAN 2,10,20 |                                                     |
|                +-+--+                                                  |
|      +---------+ AP +--------------+                                   |
|      |         +----+              |                                   |
|      |                             |                                   |
|   +--v---+                      +--v---------+                         |
|   |Laptop|IP:10.0.10.60/24      |Mobile Phone| IP:10.0.20.60/24        |
|   +------+                      +------------+                         |
|                                                                        |
+------------------------------------------------------------------------+

#### Create Mangement VLAN and VLANIF
* Go to Configuration > AC Config > VLAN > Create(e.g. `VLAN 2`)
* VLAN ID: 2
* Description: "AC-AP-Management"
* Add Interfaces(e.g. `GE0/0/10`) to List
  * Set Link-Type to "Trunk"
* Check "Create VLANIF"
* Input IP of VLANIF(e.g. `10.0.2.3/255.255.255.0`)

#### Configure Port Interface which is Connected to Switch
* Go to Configuration > AC Config > Interface > Select the Interface(e.g. `GE0/0/10`)
* Set Link-Type to `Trunk`
* Set Allowed VLANs(e.g `2`)
* Set Default VLAN(PVID)(e.g. `2`)

#### Create Static Route(from AC to Switch)
* Configuration > AC Config > IP > Route > Static Root Configuration Table > Create
* Destination IP / Subnet Mask: `0.0.0.0/0.0.0.0`
* Next Hoop Address: Switch Vlanif IP Address(e.g. `10.0.2.1`)
* Outbound Interface: Management Vlanif(e.g. `Vlanif2`)

#### Set AC source address
* Go to Configuration > AC Config > Basic Config > AC source address
* Select Vlanif(e.g. `Vlanif2`)
* Click "+" Button to Add the IP of Vlanif2 as AC Source Address

#### Set AP Authentication Mode
* Go to Configuration > AC Config > Basic Config
* Set "AP authentication mode" to "Non-authentication"
* Apply
* You'll be Asked to Create AP Account and Offline VAP Key

## Configure AP
Use Config Wizard for AP.

#### Create AP Group
We can use `default` AP Group for APs.

To Create a New AP Group:

* Go to AP Config > AP Group > Create
* AP Group Name: XX(e.g. `group1`)
* Copy parameters from other groups: `default`

#### AP Going Online
Go to Config Wizard > AP Going Online.

1. APs Go Online
  * AP authentication mode: Non-authentication(Already Set via AC Config)
  * Check Total Number of APs
  * Check Status is `normal` of APs in the List
  * Click Next

2. Group APs
  * Select an AP Group(e.g. `default`) and Its APs
  * Click Next

3. Confirm Configurations
  * Click "Done"

#### Wireless Service Configuration
Create a new SSID

Go to Config Wizard > Wireless Service > Create

1. Basic Information
  * SSID Name: e.g. `huawei`(VLAN 20) or `huawei-pc`(VLAN 10)
  * Service VLAN: Single VLAN
  * Service VLAN ID: e.g. `20` or `10`
  * Forwarding Mode: Direct
  * Next

2. Security Authentication
  * Security Settings: Key
  * Authentication Policy: PSK
  * Encryption Mode: WPA-WPA2
  * WPA Encryption Algorithm: AES
  * WPA2 Encryption Algorithm: AES
  * Key Type: PASS-PHRASE
  * Key: YOUR-KEY
  * Click Next

3. Access Control
  * Binding the AP Group: Select `default`
  * Valid Radio: Specify Which Radio Profile to Use(Default is `All`: `0`, `1`, `2`)
    * `0`: Radio Profile 0: 2.4G
    * `1`: Radio Profile 1: 5G / 6G
    * `2`: Radio Profile 2: 5G / 6G

    Using 2 Different SSIDs for 2.4G and 5G is recommended(e.g. `XX-2.4G`, `XX-5G`).

  * Finish

#### Radio Planning / Calibration(Optional)
1. Turn On Calibration
  * Go to AP Config > Radio Planning / Calibration > Radio Calibration Configuration Tab
  * Turn On "Calibration"
  * Set Triggering condition to "Scheduled"

2. 2.4G / 5G DCA Channel Set
  * Go to AP Config > Radio Planning / Calibration > Radio Planning Tab
  * Go to 2.4 GHz DCA Channel Set
    * Channel Set: `1`, `6`, `11`(recommended)
  * Go to 5 GHz DCA Channel Set
    * Frequency bandwidth: `20 MHz`(recommended)
    * Channel Set: All Channels(recommended)
  * Apply and Save

3. Turn Off Forcibly Disconnecting STAs(强制用户下线) and Dynamic Load Balancing(动态负载均衡)
  * Go to AP Config > Profile > Radio Management > 2G / 5G Radio Profile > default > RRM Profile
  * Go to Forcibly Disconnecting STAs > Turn Off
  * Go to Dynamic Load Balancing > Turn Off
  * Apply and Save

4. Radio Calibration
  * 2G Radio Calibration
    * Go to AP Config > Profile > Radio Management > 2G Radio Profile > default > RRM Profile
    * Go to Advanced Configuration Tab > Radio Calibration
    * Set "2.4G Upper calibration power threshold (dBm)" to `12`
    * Set "2.4G Lower calibration power threshold (dBm)" to `9`
  * 5G Radio Calibration
    * Go to AP Config > Profile > Radio Management > 5G Radio Profile > default > RRM Profile
    * Go to Advanced Configuration Tab > Radio Calibration
    * Set "5G Upper calibration power threshold (dBm)" to `17`
    * Set "5G Lower calibration power threshold (dBm)" to `13`
  * Apply and Save

5. Storm Suppression（风暴抑制）
  * Go to AP Config > Profile > Wireless Service > Traffic Profile > default > Advanced Configuration
  * Go to Storm Suppression
  * Set "Broadcast packet rate limit (pps)" to `128`
  * Set "Multicast packet rate limit (pps)" to `128`
  * Set "Unknown unicast packet rate limit (pps)" to `64`

Please check [WLAN网络优化三板斧](https://support.huawei.com/enterprise/zh/doc/EDOC1100260922#ZH-CN_TOPIC_0000001225645370) for more information.

#### Transfer All APs from One Group to Another(Optional)
* Go to AP Config > AP Group
* Select the Record of AP Group which Binds APs Already > Click the Number of Binded APs(e.g. 10)
* It'll Pop a Dialog > Transfer All APs > Confirm


## References
* [Web示例(V2R19C00版本)：旁挂二层组网直接转发【AP+L3+旁挂AC+出口网关】](https://forum.huawei.com/enterprise/zh/thread/580934502589546496)
* [AirEngine 9700-射频资源管理（SmartRadio）](https://support.huawei.com/enterprise/zh/doc/EDOC1100278107/c349ef2)
* [WLAN网络优化三板斧](https://support.huawei.com/enterprise/zh/doc/EDOC1100260922#ZH-CN_TOPIC_0000001225645370)

---------------------

# 通过网页管理华为 AirEngine9700

## 默认管理接口的 IP
* 华为 AirEngine9700 使用 `169.254.1.1/24`(Vlanif1) 作为默认管理接口的 IP
* 如果更改管理 IP 后忘记，按下 "RST" 按钮 5 秒来回复出厂设置

## 连接 PC 和华为 AirEngine9700
* 将 PC 网卡设置使用静态 IP
  * 华为 AirEngine9700 在 VlAN 1 上未开启 DHCP 服务
  * 为 PC 网卡设置静态 IP(e.g. `169.254.1.10/255.255.255.0`)
* 将 PC 连接到 AirEngine9700 的任一 LAN 口(e.g. GE0/0/1)
* 打开浏览器，输入 `https://169.254.1.1`

## 禁用密码策略(可选)
* 维护 > 管理员 > 密码策略 > 管理员密码策略 > 关闭

## 通过"文件管理"来上传和下载文件
* 维护 > 系统管理 > 文件管理

  | 文件类型 | 例子 |
  | :--: | :--: |
  | 系统文件 | `airengine9700s-s_v200r020c00spc300.cc` |
  | 补丁文件 | `AirEngine9700S-S_V200R020C00SPH003.pat` |
  | 当前配置文件 | `vrpcfg.zip` |
  | License 文件 | `LIC20240525XX.dat` | 

## 安装 License
#### 激活 License 和下载 License 文件
* [Active and Download License as End User](activate-and-download-license-as-end-user.md)

#### 上传 License 文件到设备上
* 维护 > 系统管理 > 文件管理
* 上传之前已经下载好的 License 文件

#### 加载 License
* 维护 > License 管理 > License 文件信息
* 加载 > 选择上传好的 License 文件(e.g. `flash:/LIC20240525XX.dat`)
* 加载成功后会显示 License 的具体信息
  * 设备 ESN 和 License 文件 ESN 相同
  * AP 资源授权 License

    | 项目 | 值 |
    | :--: | :--: |
    | 控制项当前状态 | 正常 |
    | 控制项过期时间 | 永久有效 |
    | 资源数 | 16 |

## 升级 AC 固件

#### 保存当前配置
* 点击右上角的“保存配置”

#### 备份
* 备份启动文件
  * 维护 > 设备升级 > AC 升级 > 导出启动文件
* 备份配置文件(`vrpcfg.zip`)
  * 导出配置文件
* 备份 License 文件
  * 维护 > 系统管理 > 文件管理
  * 找到 License 文件然后下载(e.g. `LIC20240525XX.dat`)

#### 下载新的系统文件和补丁文件
* [Download New System File and Patch File](download-system-file-and-patch-of-huawei-device.md)

#### 上传新的系统文件和补丁文件到设备
* 维护 > 系统管理 > 文件管理
* 上传新的系统文件和补丁文件到设备
  * 需要花一些时间（大约 5 分钟）来上传系统文件(大约 127MB), 请耐心等待

#### 选择下次启动的系统文件和补丁文件
* 维护 > 设备升级 > 下次启动信息
* 选择刚才上传好的系统文件和补丁文件作为下次启动的系统文件和补丁文件
* 应用

#### 重启设备
* 维护 > 设备重启 > 重启设备

#### 检查版本
* 可以通过调试口的 Log 查看
* 重启后通过调试口登录
* 显示版本
  ```
  display version
  ```

## 配置 AC

网络拓扑图

+------------------------------------------------------------------------+
|                                                                        |
|            +------------+                                              |
|            |  Gateway   |                                              |
|            +-----+------+                                              |
|                  |                                                     |
|                  |       VLAN 2: AC,AP Management                      |
|                  |       VLANIF: 10.0.2.1/24, DHCP server is enabled.  |
|            +-----+-----+                                               |
|            |Core Switch| VLAN 10: WLAN Service for laptop.             |
|            +-----+-----+ VLANIF: 10.0.10.1/24, DHCP server is enabled. |
|                  |                                                     |
|                  |       VLAN 20: WLAN Service for mobile device.      |
|                  |       VLANIF: 10.0.20.1/24, DHCP server is enabled. |
|                  |                                                     |
|                  |VLAN 2,10,20                                         |
|                  |                                                     |
|             +----+-----+  VLAN 2  +----+                               |
|             |POE Switch+----------+ AC | VLANIF: 10.0.2.3/24           |
|             +----+-----+          +----+                               |
|     VLAN 2,10,20 |                                                     |
|                +-+--+                                                  |
|      +---------+ AP +--------------+                                   |
|      |         +----+              |                                   |
|      |                             |                                   |
|   +--v---+                      +--v---------+                         |
|   |Laptop|IP:10.0.10.60/24      |Mobile Phone| IP:10.0.20.60/24        |
|   +------+                      +------------+                         |
|                                                                        |
+------------------------------------------------------------------------+

#### 创建 AC 管理 VLAN 和 VlANIF
* 配置 > AC 配置 > VLAN > 新建(e.g. `VLAN 2`)
* VLAN ID: 2
* 描述: "AC-AP-Management"
* 添加绑定的接口(e.g. `GE0/0/10`) 到接口列表
  * 设置链路类型为“Trunk”
* 勾选 "创建 VLANIF 接口"
* 输入 VLANIF(e.g. `10.0.2.3/255.255.255.0`)

#### 配置连接到交换机的端口的接口
* 配置 > AC 配置 > 接口管理 > 物理接口 > 选择一个接口(e.g. `GE0/0/10`)
* 设置链路类型为 `Trunk`
* 设置允许通过的 VLAN(e.g `2`)
* 设置缺省 VLAN(PVID)(e.g.`2`)

#### 创建从 AC 到 交换机的静态路由
* 配置 > AC 配置 > IP > 路由 > 静态路由配置表 > 新建
* 目的IP地址 / 子网掩码: `0.0.0.0/0.0.0.0`
* 下一跳: 交换机的 VLAN 2 的 Vlanif(e.g. `10.0.2.1`)
* 出接口: AC 管理 VLAN 的 VLANIF(e.g. `Vlanif2`)

#### 设置 AC 源地址
* 配置 > AC 配置 > 基本配置 > AC 基本信息 > AC 源地址
* 选择 Vlanif(e.g. `Vlanif2`)
* 点击 "+" 添加刚才选择好的 Vlanif2 作为 AC 源地址

#### 设置 AP 认证方式为“不认证”
* 配置 > AC 配置 > 基本配置 > AC 基本信息
* AP 认证方式:“不认证”
* 应用
* 会要求创建 AP 账户和离线 VAP Key

## 配置 AP
使用配置向导来配置 AP

#### 创建 AP 组（可选）
通常使用默认的 `default` AP 组。

创建新的 AP 组：
* AP 配置 > AP 组配置 > 新建
* AP 组名称: XX(e.g. `group1`)
* 从其他组复制参数: `default`

#### AP 上线
配置向导 > AP 上线

1. AP 上线
  * AP 认证方式：不认证（已经通过 AC 设置好）
  * 检查 AP 的数量和状态
  * 下一步

2. AP 分组
  * 选择 AP 组(e.g. `default`)和对应的 AP
  * 下一步

3. 确认配置
  * 点击 "完成"

#### 无线业务配置
创建一个 SSID。

配置向导 > 无线业务 > SSID 列表 > 新建

1. 基本信息
  * SSID 名称: e.g. `huawei`(VLAN 20) or `huawei-pc`(VLAN 10)
  * 业务 VLAN: 单个 VLAN
  * 业务 VLAN ID: e.g. `20` or `10`
  * 转发模式: 直接转发
  * 下一步

2. 安全认证
  * 安全配置: 密钥认证（个人网络适用）
  * 认证方式: PSK
  * 加密方式: WPA-WPA2
  * WPA 加密算法: AES
  * WPA2 加密算法: AES
  * 密钥类型: PASS-PHRASE
  * 密钥: YOUR-KEY
  * 下一步

3. 接入控制
  * 绑定 AP 组: e.g. `default`
  * 生效射频: `0`, `1`, `2`（默认）
    * `0`: Radio Profile 0: 2.4G
    * `1`: Radio Profile 1: 5G / 6G
    * `2`: Radio Profile 2: 5G / 6G

    推荐为 2.4G 和 5G 使用不同的 SSID(`XX-2.4G`, `XX-5G`)。

  * 完成

#### 射频规划 / 调优（可选）
1. 打开调优
  * AP 配置 > 射频规划 / 调优 > 调优配置 Tab
  * 调优开关：打开
  * 出发条件：定时

2. 2.4G / 5G DCA 信道集合
  * AP 配置 > 射频规划 / 调优 > 射频规划
  * 2.4 GHz DCA 信道集合
    * 信道集合: `1`, `6`, `11`(推荐)
  * 5 GHz DCA Channel 信道集合
    * 频宽: `20 MHz`(推荐)
    * 信道集合: 所有信道(推荐)
  * 应用，保存配置

3. 关闭“强制用户下线”和“动态负载均衡”
  * AP 配置 > 模板管理 > 射频管理 > 2G 射频模板 / 5G 射频模板 > default > RRM 模板
  * 强制用户下线 > 关闭
  * 动态负载均衡 > 关闭
  * 应用，保存配置

4. 射频调优
  * 2G 射频调优
    * AP 配置 > 模板管理 > 射频管理 > 2G 射频模板 > default > RRM 模板
    * 高级配置 Tab > 射频调优
    * “2.4G调优功率上限(dBm)”: `12`
    * “2.4G调优功率下限(dBm)”: `9`
  * 5G 射频调优
    * AP 配置 > 模板管理 > 射频管理 > 5G 射频模板 > default > RRM 模板
    * 高级配置 Tab > 射频调优
    * “5G调优功率上限(dBm)”: `17`
    * “5G调优功率下限(dBm)”: `13`
  * 应用，保存配置

5. 风暴抑制
  * AP 配置 > 模板管理 > 无线业务 > 流量模板 > default > 高级配置 > 风暴抑制
  * “广播报文速率抑制(pps)”: `128`
  * “组播报文速率抑制(pps)”: `128`
  * “未知单播报文速率抑制(pps):”: `64`

参考 [WLAN网络优化三板斧](https://support.huawei.com/enterprise/zh/doc/EDOC1100260922#ZH-CN_TOPIC_0000001225645370) 获取更多信息。

#### 转移 AP 组内的 AP 到另一个 AP 组（可选）
* AP 配置 > AP 组配置
* 选择已经绑定 AP 的 AP 组 > 点击已绑定 AP 的数量(e.g. 10)
* 显示对话框 > 移动所有 > 确认


## 参考资料
* [Web示例(V2R19C00版本)：旁挂二层组网直接转发【AP+L3+旁挂AC+出口网关】](https://forum.huawei.com/enterprise/zh/thread/580934502589546496)
* [AirEngine 9700-射频资源管理（SmartRadio）](https://support.huawei.com/enterprise/zh/doc/EDOC1100278107/c349ef2)
* [WLAN网络优化三板斧](https://support.huawei.com/enterprise/zh/doc/EDOC1100260922#ZH-CN_TOPIC_0000001225645370)

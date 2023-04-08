# Enable TLS 1.2 to Fix 0x2f7d Error when Install WD Dashboard

## Problem
* A Clean Installed Windows 11 PC
* Need to Update WD SSD Firmware
* Download [WD Dashboard](https://wddashboarddownloads.wdc.com/wdDashboard/DashboardSetup.exe)
* Got 0x2f7d Error(`lista_updater.xml`) when Run `DashboardSetup.exe`

## Solution
* Method A
  * Go to Control Panel > Network and Internet
  * Click Internet Options > Advance Tab > Check "Use TLS 1.2"
  * Reboot the PC and Run the Installer Again

* Method B
  Download [the standalone installer](https://wddashboarddownloads.wdc.com/wdDashboard/DashboardSetupSA.exe)

## References
* [SSD Dashboard Unknown Error(0x2efd) during install](https://community.wd.com/t/ssd-dashboard-unknown-error-0x2efd-during-install/252696) 

-------

# 启用 TLS 1.2 来修复安装 WD Dashboard 时遇到的 0x2f7d 错误

## 问题
* 1 台全新安装 Windows 11 的 PC
* 需要更新 WD SSD 的固件
* 下载 [WD Dashboard](https://wddashboarddownloads.wdc.com/wdDashboard/DashboardSetup.exe) 
* 运行 `DashboardSetup.exe` 遇到 0x27fd 错误

## 解决方法
* 方法 A
  * 打开控制面板 > 网络和共享 > 网络和 Internet
  * 点击 Internet 选项 > 高级 > 勾选 "使用 TLS 1.2"
  * 重启 PC，再次运行 `DashboardSetup.exe`

* 方法 B
  下载[离线安装包](https://wddashboarddownloads.wdc.com/wdDashboard/DashboardSetupSA.exe)

## 参考资料
* [SSD Dashboard Unknown Error(0x2efd) during install](https://community.wd.com/t/ssd-dashboard-unknown-error-0x2efd-during-install/252696)

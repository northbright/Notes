# Install Standalone UFRII Driver of Canon iR2204n when Failed to Run MF Driver Guide to Install Drivers

## Problem
* Canon iR2204n drivers(UFRII and Scan) were installed successfully via MF Driver Guide
* Set static IP address for the printer
* Using "Network Connection" option during the installation
* Need to change the IP of the printer
* Need to re-install printer driver with new IP address
* Failed to uninstall Canon iR2204n driver from Control Panel
  * Got error message: "Can not uninstall because other applications are running..."
* Failed to re-install drivers via MF Driver Guide(`DRIVERS\simplified_chinese\x64\Setup.exe`)
  * Got error message: "Can not install driver because the driver was already installed"

## Solution
Install standalone URFII driver of Canon iR2204n instead

* Run `intdrv\UFRII\simplified_chinese\x64\Setup.exe` for URFII printer driver

--------------------

# 当使用驱动向导安装 Canon iR2204n 驱动失败时，安装独立 UFRII 驱动

## 问题
* Canon iR2204n 驱动（UFRII 和扫描）通过驱动向导成功安装
* 打印机使用静态 IP 地址
* 在安装驱动时，选择“网络连接”的选项
* 需要重新设置打印机的 IP 地址
* 需要使用新的 IP 地址来重新安装打印机的驱动
* 从控制面板卸载 Canon iR2204n 驱动失败
  * 错误信息：”其他应用程序正在运行，不能卸载“
* 重新使用驱动向导安装打印机驱动（`DRIVERS\simplified_chinese\x64\Setup.exe`）也失败
  * 错误信息：“打印机驱动已经安装”

## 解决方法
安装独立的 URFII 驱动

* 运行 `intdrv\UFRII\simplified_chinese\x64\Setup.exe` 来安装 URFII 驱动

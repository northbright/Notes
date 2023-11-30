# Got "M.2 genie error" on Boot

## Problem
* MSI B460 Mainboard
* Kingston SATA SSD with Windows 10 Installed
* Purchased a 2nd SSD(M.2 NVME) and Plug It on the Mainboard
* Failed to Boot and Got "M.2 genie error"

## Root Cause
* SATA Mode of M.2 SSD is Set to "RAID / Optane Mode" in BIOS Settings

## Solution
1. Power on and Press "Delete" Key to Enter BIOS Setup Menu
2. Press "F7" to Switch "Advanced" Mode
3. Go to BIOS > SETTINGS > Advanced > Integrated Peripherals > SATA Mode
4. Change setting from "RAID/ Optane Mode" to "SATA Mode"
5. Press "F10" > Save and Exit > Reboot

## References
* [聊聊微星主板的M.2/Optane Genie功能](https://zhuanlan.zhihu.com/p/568030208)
* [MAG B460 TOMAHAWK Manual](https://download.msi.com/archive/mnu_exe/mb/E7C81v1.2.pdf)

--------

# 开机遇到 "M.2 genie error" 错误

## 问题
* MSI B460 主板
* 已安装 Windows 10 的 Kingston SATA SSD
* 新购买第 2 SSD(M.2 NVME) 然后插在主板上
* 开机失败，提示 "M.2 genie error"

## 原因
* BIOS 设置中，M.2 SSD 的 SATA 模式被设置为 "RAID / Optane Mode"

## 解决方法
1. 开机按下 "Delete" 键进入 BIOS 设置
2. 按下 "F7" 进入高级设置
3. 进入 BIOS > SETTINGS > Advanced > Integrated Peripherals > SATA Mode
4. 将设置从 "RAID/ Optane Mode" 改为 "SATA Mode"
5. 按下 "F10" 保存设置退出 > 重启

## 参考资料
* [聊聊微星主板的M.2/Optane Genie功能](https://zhuanlan.zhihu.com/p/568030208)
* [MAG B460 TOMAHAWK Manual](https://download.msi.com/archive/mnu_exe/mb/E7C81v1.2.pdf)

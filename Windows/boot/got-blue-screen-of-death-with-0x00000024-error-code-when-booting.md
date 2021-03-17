# Got Blue Screen of Death with 0x00000024 Error Code when Booting

## Problem
* Press the power button to power on the HP Z240 workstation
* Blue Screen of Death with 0x00000024 error code when Windows 7 is booting

## Root Cause
Hard disk corruption 
* Boot the PC via USB Disk with WinPE
* Run the HDTune to check disk health and reported bad blocks

## Solution
* Replace the hard disk

## References
* [Bug Check 0x24: NTFS_FILE_SYSTEM](https://docs.microsoft.com/en-us/windows-hardware/drivers/debugger/bug-check-0x24--ntfs-file-system)

-----------

# Windows 启动时蓝屏，错误代码 0x00000024

## 问题
* 按下电源键启动 HP Z240 工作站
* 在 Windows 7 启动时，蓝屏，错误代码为 0x00000024

## 原因
硬盘故障
* 使用 WinPE 的 U盘，启动 PC
* 运行 HDTune 来进行硬盘健康检测，报告损坏的 Block

## 解决方法
* 更换硬盘

## 参考
* [Bug Check 0x24: NTFS_FILE_SYSTEM](https://docs.microsoft.com/en-us/windows-hardware/drivers/debugger/bug-check-0x24--ntfs-file-system)

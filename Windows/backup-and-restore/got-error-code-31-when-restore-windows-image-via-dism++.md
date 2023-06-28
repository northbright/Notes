# Got Error Code 31 when Restore Windows Image via Dism++

## Problem
* Boot PC with WinPE USB Disk
* Use "diskpart" Tool to Create Partition on a New SSD
  * Convert to GPT
  * Create an EFI Partition(size=360M)
  * Create a MSR Partition(size=128M)
  * Create a Primary Partition(all left size)
* Use Dism++ to Restore Previous Windows 10 Image
* Got "Failed to Repair Bootmgr" Error(Code: 31)
* Try to Repair Bootmgr
  * Go to "Recovery" > "Bootmgr Repair"
  * Got the Same Error

## Root Cause
The EFI Partition is RAW FS.
It should be formated to FAT32.

* Run "diskpart" Tool in CMD
* Type "select disk x", x is The ID of SSD
* Type "select partition 1"(The first partition is EFI Partition)
* Type "detail partition" to Show Detail
* The FS of EFI Partition is "RAW FS"

## Solution
Format the EFI partition to FAT32

* Type "format quick fs=fat32"

--------------

# 使用 Dism++ 恢复 Windows 镜像时，出现错误 31

## 问题
* 使用 WinPE U 盘启动电脑
* 使用 diskpart 工具来为新的 SSD 创建分区
  * 转换为 GPT 分区
  * 创建 1 个 EFI 分区（大小 = 360M）
  * 创建 1 个 MSR 分区（大小 = 128M）
  * 创建 1 个 Primary 分区（所有剩下的空间）
* 使用 Dism++ 来恢复 Windows 镜像时，出现“引导修复失败“的错误（错误代码： 31）
* 尝试单独修复 Windows 的引导
  * 恢复功能 > 引导修复
  * 出现相同的错误

## 原因
EFI 分区的文件系统为 RAW FS。
应该被格式化为 FAT32。

* 在 CMD 中运行 diskpart
* 输入 "select disk x", x 是 SSD 的 ID
* 输入 "select partition 1"（第 1 个分区为 EFI 分区)
* 输入 "detail partition" 来显示详情
* 显示 EFI 分区的文件系统为 RAW FS

## 解决方法
将 EFI 分区格式化为 FAT32。

* 输入 "format quick fs=fat32"

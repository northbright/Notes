# [WePE](http://www.wepe.com.cn/) Can not Recognize M.2 NVME SSD

## Problem
* Added a M.2 NVME SSD on Dell Precision 3431 workstation
* Boot the PC from USB disk with [WePE](http://www.wepe.com.cn/) installed
* Run `diskpart` and there's no M.2 NVME SSD Disk found

## Root Cause
* In BIOS settings, `SATA Operation` was set to `RAID` by default
* [WePE](http://www.wepe.com.cn/) can not work with the `RAID` option

## Solution
Set `SATA Operation` to `AHCI`

* Boot the PC and press `F2` to enter in BIOS Settings
* Goto `Settings` > `System Configuration` > `SATA operation`
* Set `SATA Operation` to `AHCI`
* Save and Reboot

## References
* [微PE2.0下不认NVME固态](https://tieba.baidu.com/p/5791118821?pid=127884329247&cid=0&red_tag=0378724665#127884329247)

------

# [WePE](http://www.wepe.com.cn/) 不能识别 M.2 NVME SSD

## 问题
* Dell Precision 3431 工作站安装了 1 个 M.2 NVME SSD
* 从安装了[WePE](http://www.wepe.com.cn/) 的U盘启动工作站
* 运行`diskpart`，但是没有发现 M.2 NVME SSD 硬盘

## 原因
* 在 BIOS 的设置中，`SATA Operation` 默认为 `RAID`
* [WePE](http://www.wepe.com.cn/) 不能识别 `RAID` 模式的 SATA 硬盘

## 解决方案
将 `SATA Operation` 设置成 `AHCI`

* 开机按 `F2` 进入 BIOS 设置
* 进入 `Settings` > `System Configuration` > `SATA operation`
* 设置 `SATA Operation` 为 `AHCI`
* 保存并重启

## 参考 
* [微PE2.0下不认NVME固态](https://tieba.baidu.com/p/5791118821?pid=127884329247&cid=0&red_tag=0378724665#127884329247)

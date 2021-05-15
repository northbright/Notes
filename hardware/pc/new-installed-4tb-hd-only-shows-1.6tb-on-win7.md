# New Installed 4 TB HD Only Shows 1.6 TB on Win7

## Problem
* Windows 7 installed on an old HD(1 TB) using Legacy BIOS Boot + MBR
* Installed a new 4 TB HD
* Run `diskpart` and it only shows 1.6 TB(`list disk`)
* Hope that Windows 7 can recognize the size correctly and keep Legacy BIOS Boot + MBR（without re-install Windows 7 using UEFI boot + GPT）

## Root Cause
* Legacy BIOS boot only supports MBR
* To use 2 TB + HD, use UEFI + GPT

## Solution
Boot WePE from UEFI(with GPT support) and re-partition the HD

* Download and run [WePE](http://www.wepe.com.cn/)
* Install WePE on the old HD(`c:`) or USB disk
* Make sure UEFI boot is enabled
* Boot PC from WePE(UEFI)
* Open a CMD window and run `diskpart`
* It shows 3.6 TB now
* Intialize the HD
  ```
  select disk x(x = number of the 4TB HD)
  clean
  convert gpt
  create partition primary
  format quick
  exit
  ```

* Reboot Windows（Legacy BIOS Boot + MBR)
* Now Windows can also recognize the HD size correctly

--------------------

# 新安装的 4 TB 硬盘在 Windows 7 上只能识别出 1.6 TB

## 问题
* Windows 7 使用 Legacy BIOS + MBR 分区的方式安装在旧硬盘（1 TB）上
* 新装1个 4 TB 的硬盘
* 在 Windows 7 上，运行 `diskpart` 只能识别出 1.6 TB（`list disk`）
* 期望 Windows 7 能正确识别容量，并且依然使用 Legacy BIOS Boot + MBR 分区（不重新使用 UEFI + GPT 分区重新安装 Windows 7）

## 原因
* 从 Legacy BIOS boot 只支持 MBR 分区
* 要使用 2 TB 以上的硬盘，使用 UEFI + GPT 方式启动

## 解决方法
从 UEFI（支持 GPT 分区）启动 WinPE，重新分区

* 下载安装[WePE](http://www.wepe.com.cn/)
* 安装[WePE](http://www.wepe.com.cn/) 到本地老硬盘（`c:\`）或者 U 盘上
* 确认启用 UEFI boot
* 使用 WinPE(UEFI) 启动
* 打开一个 CMD 窗口，运行 `diskpart`
* 现在显示 3.6 TB
* 初始化硬盘
  ```
  select disk x(x = number of the 4TB HD)
  clean
  convert gpt
  create partition primary
  format quick
  exit
  ```
* 重启 Windows （Legacy BIOS Boot + MBR）
* 现在 Windows 也能正确识别硬盘的容量

## 参考资料
* [win7识别不出来4T硬盘](https://tieba.baidu.com/p/4594948977?pn=2)

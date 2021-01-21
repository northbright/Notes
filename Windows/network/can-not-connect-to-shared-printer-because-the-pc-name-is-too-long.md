# Can Not Connect to Shared Printer Because The PC Name is Too Long

## Problem
* Connected an EPSON 730KII Printer to PC A via USB
* PC A configured the printer as shared printer to the network
* PC B can see the shared printer of PC A by accessing the shared resource of PC A(`\\PC A name`)
* When right clicked the shared printer and choosed "Connect" to add the shared printer for PC B, it reported error

  > Windows can not connect to the printer

## Root Cause
* PC A's name is too long that cause the shared printer's name too long
  * PC A's name is `Qinghuatongfang-0160`
  * The shared printer's name will be `Qinghuatongfang-0160 上的 EPSON LQ-730KII ESC/P2`
* [A Printer Share Name that contains spaces or that is longer than 31 characters may cause certain Windows API calls to fail](https://support.microsoft.com/en-us/help/2444599/a-printer-share-name-that-contains-spaces-or-that-is-longer-than-31-ch)

## Solution
* Make PC A's name short: `qhtf-0160` and then it works

## References
* [A Printer Share Name that contains spaces or that is longer than 31 characters may cause certain Windows API calls to fail](https://support.microsoft.com/en-us/help/2444599/a-printer-share-name-that-contains-spaces-or-that-is-longer-than-31-ch)

-------------------

# 电脑名称太长导致共享打印机不能被访问

## 问题
* 电脑 A 通过 USB 连接到一台 EPSON 730KII 打印机
* 电脑 A 将打印机设置成共享打印机
* 电脑 B 可以通过访问电脑 A 的共享资源(`\\电脑 A 的名字`)看到电脑 A 的共享打印机
* 当在电脑 B 上，右键点击共享打印机，选择“连接”的时候，提示“Windows不能连接到此打印机”的错误

## 原因
* 电脑 A 的名称太长导致了共享打印机的名字太长
  * 电脑 A 的名称：`Qinghuatongfang-0160`
  * 共享打印机的名称：`Qinghuatongfang-0160 上的 EPSON LQ-730KII ESC/P2`
* [打印机共享名包含空格，则长度超过 31 个字符可能会导致某些 Windows API 调用失败](https://support.microsoft.com/zh-cn/help/2444599/a-printer-share-name-that-contains-spaces-or-that-is-longer-than-31-ch)

## 解决方法
* 缩短电脑 A 的名称：`qhtf-0160`，可以成功连接共享打印机

## 参考资料
* [打印机共享名包含空格，则长度超过 31 个字符可能会导致某些 Windows API 调用失败](https://support.microsoft.com/zh-cn/help/2444599/a-printer-share-name-that-contains-spaces-or-that-is-longer-than-31-ch)

# There is a Blank Area in the Middle of Printed Image after KB5000808 Installed Automatically on Windows 10

## Problem
* There's a blank area in the middle of printed image
* Three PCs in one office have the same problem
* This issue has been reported since 2021/03/12

## Root Cause
* KB5000802(20H2) / KB5000808(1909) was installed automatically on Windows 10
* It will cause printer issues
  * Crash when printing
  * Blank area issue

## Solution
* Uninstall KB5000802 and KB5000808
  
  ```
  wusa /uninstall /kb:5000802
  wusa /uninstall /kb:5000808
  ```

## References
* [Windows 10 crashes when printing due to Microsoft March updates](https://www.bleepingcomputer.com/news/microsoft/windows-10-crashes-when-printing-due-to-microsoft-march-updates/)
* [Win10系统配合M1005打印机，换了硒鼓还是无法正常显示怎么办？](https://tieba.baidu.com/p/7256965185)
* [打印机正常，打印预览正常，打印中间有个大片空白，请问要怎么解决？](https://www.zhihu.com/question/448743998/answer/1776337075)
* [临时解决方案：如何修复Windows 10更新导致打印蓝屏问题](https://www.cnbeta.com/articles/tech/1101069.htm)

--------

# Windows 10 自动更新 KB5000808 后，打印图片中间有空白区域

## 问题
* 打印出的图片中中间，有一大块空白区域
* 同一办公室的3台电脑，均出现这个问题
* 2021/03/12开始报告此问题，之前均正常

## 原因
* Windows 10 自动更新了 KB5000802(20H2) / KB5000808(1909)
* 这个更新导致
  * 打印时蓝屏
  * 打印出现空白区域

## 解决方法
* 卸载 KB5000802(20H2) / KB5000808(1909)

  ```
  wusa /uninstall /kb:5000802
  wusa /uninstall /kb:5000808
  ```

## 参考资料
* [Windows 10 crashes when printing due to Microsoft March updates](https://www.bleepingcomputer.com/news/microsoft/windows-10-crashes-when-printing-due-to-microsoft-march-updates/)
* [Win10系统配合M1005打印机，换了硒鼓还是无法正常显示怎么办？](https://tieba.baidu.com/p/7256965185)
* [打印机正常，打印预览正常，打印中间有个大片空白，请问要怎么解决？](https://www.zhihu.com/question/448743998/answer/1776337075)
* [临时解决方案：如何修复Windows 10更新导致打印蓝屏问题](https://www.cnbeta.com/articles/tech/1101069.htm)

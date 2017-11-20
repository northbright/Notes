# Unable Print to EPSON Dot Matrix Printer on Windows 7

#### Details
* EPSON dot matrix printers work fine on Windows 7 before.
* It can not print to EPSON printers suddenly(November, 2017).
* Reinstall printer drivers does **NOT** work.

#### Root Cause
* After installing Windows Update [KB4048957](https://support.microsoft.com/en-us/help/4048957/windows-7-update-kb4048957), [KB4048960](https://support.microsoft.com/en-us/help/4048960/windows-7-update-kb4048960), EPSON printers can not work.

#### Solution
* Uninstall Windows Update [KB4048957](https://support.microsoft.com/en-us/help/4048957/windows-7-update-kb4048957), [KB4048960](https://support.microsoft.com/en-us/help/4048960/windows-7-update-kb4048960).

        wusa /uninstall /kb:4048957 /quiet /warnrestart
        wusa /uninstall /kb:4048960 /quiet /warnrestart

#### References
* [Unable to Print to Epson Dot Matrix printers after Windows Updates](https://www.tachytelic.net/2017/11/unable-print-dot-matrix-printers-windows-updates/)
* [Microsoft confirms Epson Printer bug caused by November 2017 updates](https://www.ghacks.net/2017/11/17/microsoft-confirms-epson-printer-bug-caused-by-november-2017-updates/)

----------------

# EPSON针式打印机突然在Windows 7上不能工作

#### 细节
* EPSON针式打印机之前在Windows 7上工作一直很好。
* 2017年11月突然不能正常工作。
* 重新安装打印机驱动依然不能解决问题。

#### 原因
* 在安装了Windows更新[KB4048957](https://support.microsoft.com/en-us/help/4048957/windows-7-update-kb4048957), [KB4048960](https://support.microsoft.com/en-us/help/4048960/windows-7-update-kb4048960)后，EPSON打印机不能正常工作了。

#### 解决方案
* 卸载Windows更新[KB4048957](https://support.microsoft.com/en-us/help/4048957/windows-7-update-kb4048957), [KB4048960](https://support.microsoft.com/en-us/help/4048960/windows-7-update-kb4048960)。

        wusa /uninstall /kb:4048957 /quiet /warnrestart
        wusa /uninstall /kb:4048960 /quiet /warnrestart

#### 参考资料
* [Unable to Print to Epson Dot Matrix printers after Windows Updates](https://www.tachytelic.net/2017/11/unable-print-dot-matrix-printers-windows-updates/)
* [Microsoft confirms Epson Printer bug caused by November 2017 updates](https://www.ghacks.net/2017/11/17/microsoft-confirms-epson-printer-bug-caused-by-november-2017-updates/)


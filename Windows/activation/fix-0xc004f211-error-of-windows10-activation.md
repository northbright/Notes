# Fix 0xC004F211 Error of Windows 10 Activation

## Problem
* Purchased some HP Z238 workstations(Windows 10 home preinstalled)
* Purchased SSDs(each Z238 will have one SSD)
* Create partition C on SSD to install Windows 10
* Downloaded latest Windows 10 ISO(v1903 home VOL version)
* Installed Windows 10 on **First** PC with [WePE](http://www.wepe.com.cn/) and [Dism++](https://www.chuyu.me/en/index.html)
* Activated Windows 10 on **First** PC **Successfully**
* Pre-installed some apps, printer drivers and made customizations on **First** PC
* Backup the partition C of **First** PC to a **WIM** file using [WePE](http://www.wepe.com.cn/) and [Dism++](https://www.chuyu.me/en/index.html)
* Batch installed Windows 10 on the **Rest** PCs via restore this **WIM** file using [WePE](http://www.wepe.com.cn/) and [Dism++](https://www.chuyu.me/en/index.html)
* Got 0xC004F211 error(Windows reported that the hardware of your device has changed) on Settings > Update & Security > Activation

## Solution
* Start button > Settings > Update & Security > Activation , and then select **Troubleshoot**

## References
* [Get help with Windows activation errorsGet help with Windows activation errors](https://support.microsoft.com/en-us/help/10738/windows-10-get-help-with-activation-errors)

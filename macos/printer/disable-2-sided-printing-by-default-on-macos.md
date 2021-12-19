# Disable 2-Sided Printing By Default on MacOS

## Problem
* Hardwares: iMac and EPSON L6168 printer
* When select and print multiple PDF files, it always defaults to 2-sided printing
* Want to disable 2-sided printing(using 1-sided) by default

## Solution
* Turn on "[CUPS](https://www.cups.org/) WebInterface"
  * Open Terminal
  * Run `sudo cupsctl WebInterface=yes`
* Open a browser and visit `http://localhost:631`
* Goto "Administration" > "Printers" > "Manage Printers" > Select your printer
* Drop down "Administration" menu and select "Set Default Options" > Set "2-Sided Printing" to "Off(1-Sided)"
* Turn off "[CUPS](https://www.cups.org/) WebInterface"
  * Open Terminal
  * Run `sudo cupsctl WebInterface=no`

## References
* [How to STOP default two sided printing](https://discussions.apple.com/thread/5244577)
* [How to Stop Two-Side Printing From Being the Default in macOS](https://www.howtogeek.com/309677/how-to-stop-two-side-printing-from-being-the-default-in-macos/)

----------------

# 在 MacOS 禁用默认双面打印

## 问题
* 硬件：iMad 和 EPSON L6168 打印机
* 批量选择 PDF 文件进行打印时，默认使用双面打印
* 希望默认禁用双面打印，使用单面打印

## 解决方法
* 打开 "[CUPS](https://www.cups.org/) WebInterface"
  * 打开终端
  * 运行 `sudo cupsctl WebInterface=yes`
* 打开浏览器，访问 `http://localhost:631`
* 点击 "Administration" > "Printers" > "Manage Printers" > 选择需要的打印机
* 下拉 "Administration" 的菜单，选择 "Set Default Options"，将 "2-Sided Printing" 设置为："Off(1-Sided)"
* 关闭 "[CUPS](https://www.cups.org/) WebInterface"
  * 打开终端
  * 运行 `sudo cupsctl WebInterface=no`

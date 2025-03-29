# Setup Windows 11 without a Microsoft Account

## Update
* `bypassnro.cmd` was removed in Windows 11 since Build 26200.5516
* Run `reg add HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\OOBE /v BypassNRO /t REG_DWORD /d 1 /f shutdown /r /t 0` instead
* See [微软承认移除 OOBE bypassnro 脚本，强制要求 Win11 设备联网激活](https://m.ithome.com/html/841597.htm)

## Problem
* Microsoft Forcing Microsoft Account Login at OOBE After a Windows 11 Clean Install
* Need to Bypass the Microsoft Account Requirement

## Solution
* Follow OOBE Flow until "Choose a country" Screen Shows
* Press "Shift + F10" to Open a CMD Window
* ~Type `OOBE\BYPASSNRO` to Disable the Internet Connection Requirement~
  
  Update:
  
  * `bypassnro.cmd` was removed in Windows 11 since Build 26200.5516 
  * Run `reg add HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\OOBE /v BypassNRO /t REG_DWORD /d 1 /f shutdown /r /t 0` instead

* The PC Will Reboot and Return to the Screen
* Press "Shift + F10" to Open a CMD Window Again
* Type `ipconfig /release` to Disable the Internet.
* Close the CMD Window and Continue with the Installation
* A screen saying "Let's connect you to a network" Appears
* Click "I don't have Internet" to Continue

## References
* [How to Install Windows 11 Without a Microsoft Account](https://www.tomshardware.com/how-to/install-windows-11-without-microsoft-account)
* [微软承认移除 OOBE bypassnro 脚本，强制要求 Win11 设备联网激活](https://m.ithome.com/html/841597.htm)

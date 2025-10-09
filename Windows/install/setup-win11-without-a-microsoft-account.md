# Setup Windows 11 without a Microsoft Account

## Update(2025/10/07)
* `bypassnro.cmd` was removed in Windows 11 since Build 26200.5516
* `start ms-cxh:localonly` does not work

## Problem
* Microsoft Forcing Microsoft Account Login at OOBE After a Windows 11 Clean Install
* Need to Bypass the Microsoft Account Requirement

## Solution
#### Method A - Add BypassNRO in registry
* Disconnect from the internet first
* Press "Shift + F10" to Open a CMD Window
* Run `reg add HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\OOBE /v BypassNRO /t REG_DWORD /d 1 /f shutdown /r /t 0` instead

#### Method B - Add Local User
* Disconnect from the internet first
* Press "Shift + F10" to Open a CMD Window
* Run `net user "User Name" /addnet localgroup "Administrators" "User Name" /addcd OOBEmsoobe && shutdown -r`

## References
* [How to Install Windows 11 Without a Microsoft Account](https://www.tomshardware.com/how-to/install-windows-11-without-microsoft-account)
* [微软承认移除 OOBE bypassnro 脚本，强制要求 Win11 设备联网激活](https://m.ithome.com/html/841597.htm)
* [仍可绕过：新变通方案可实现微软 Win11 装机 OOBE 创建本地账号](https://m.ithome.com/html/888130.htm)

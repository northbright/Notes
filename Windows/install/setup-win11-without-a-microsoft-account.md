# Setup Windows 11 without a Microsoft Account

## Update(2025/10/07)
* `bypassnro.cmd` was removed in Windows 11 since Build 26200.5516
* `start ms-cxh:localonly` does not work

## Problem
* Microsoft Forcing Microsoft Account Login at OOBE After a Windows 11 Clean Install
* Need to Bypass the Microsoft Account Requirement

## Solution
#### Method A - Add BypassNRO in registry(recommended)
* Disconnect from the internet first
* Go through OOBE to set country and keyboard layout(input method)
* Press "Shift + F10" to Open a CMD Window when it asks you to connect a network
* Run the commands:

  * Add Registry Key
  
    ```sh
    reg add HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\OOBE /v BypassNRO /t REG_DWORD /d 1 /f
    ```

  * Reboot
  
    ```sh
    shutdown /r /t 0
    ```  
* It'll run OOBE again
* But it shows a "I have no internet connection" link when asking to connect a network
* Click it
* Now you can input USER and PASSWORD and go through

#### Method B - Add a Local User
* 2026/10/31 Update:
  * Not recommended
  * You'll got the issue: [Ctrl + Alt + Delete Not Working due to Creating a Local User when Install Windows 11](../issues/ctrl-alt-delete-not-working-due-to-creating-a-local-user-when-install-windows-11.md)
* Disconnect from the internet first
* Press "Shift + F10" to Open a CMD Window
* Run following commands:

  ```sh
  net user "User Name" "Password" /add
  net localgroup "Administrators" "User Name" /add
  cd OOBE
  msoobe && shutdown /r /t 0
  ```sh

## References
* [How to Install Windows 11 Without a Microsoft Account](https://www.tomshardware.com/how-to/install-windows-11-without-microsoft-account)
* [微软承认移除 OOBE bypassnro 脚本，强制要求 Win11 设备联网激活](https://m.ithome.com/html/841597.htm)
* [仍可绕过：新变通方案可实现微软 Win11 装机 OOBE 创建本地账号](https://m.ithome.com/html/888130.htm)
* [Ctrl + Alt + Delete Not Working due to Creating a Local User when Install Windows 11](../issues/ctrl-alt-delete-not-working-due-to-creating-a-local-user-when-install-windows-11.md)

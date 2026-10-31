# Ctrl + Alt + Delete Not Working due to Creating a Local User when Install Windows 11

## Problem
* Install Windows 11 using a USB disk with WinPE and Windows 11 ISO
* Add a local user to skip connecting to a network and login Microsoft Account during OOBE
  * Press Shift + F10
  * Run the commands

    ```sh
    net user "User Name" "Password" /add
    net localgroup "Administrators" "User Name" /add
    cd OOBE
    msoobe && shutdown /r /t 0
    ```sh
* Ctrl + Alt + Delete not working(should launch Task Manager but not)

## Solution
Use Methed A: Add BypassNRO in registry instead.

## References
* [Setup Windows 11 without a Microsoft Account](../install/setup-win11-without-a-microsoft-account.md)

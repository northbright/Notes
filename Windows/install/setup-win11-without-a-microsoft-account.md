# Setup Windows 11 without a Microsoft Account

## Problem
* Microsoft Forcing Microsoft Account Login at OOBE After a Windows 11 Clean Install
* Need to Bypass the Microsoft Account Requirement

## Solution
* Follow OOBE Flow until "Choose a country" Screen Shows
* Press "Shift + F10" to Open a CMD Window
* Type `OOBE\BYPASSNRO` to Disable the Internet Connection Requirement 
* The PC Will Reboot and Return to the Screen
* Press "Shift + F10" to Open a CMD Window Again
* Type `ipconfig /release` to Disable the Internet.
* Close the CMD Window and Continue with the Installation
* A screen saying "Let's connect you to a network" Appears
* Click "I don't have Internet" to Continue

## References
* [How to Install Windows 11 Without a Microsoft Account](https://www.tomshardware.com/how-to/install-windows-11-without-microsoft-account)

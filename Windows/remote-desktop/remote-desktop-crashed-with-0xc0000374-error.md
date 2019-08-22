# Remote Desktop Crashed with 0xc0000374 Error

## Problem
* Remote Desktop crashed after input username and password
* Error code: 0xc0000374

## Root Cause
* CSR harmony bluetooth driver was installed recently

## Solution
* Solution A

  Uninstall CSR harmony bluetooth driver

* Solution B
  * Goto `C:\Program Files\CSR\CSR Harmony Wireless Software Stack`
  * Rename `BLEtokenCredentialProvider.dll` to `BLEtokenCredentialProvider.dll.bak`

## References
* [远程桌面连接已停止工作](https://bbs.51cto.com/thread-1122311-1.html)
* [RDP Crashes After Entering Password](https://serverfault.com/questions/758919/rdp-crashes-after-entering-password)

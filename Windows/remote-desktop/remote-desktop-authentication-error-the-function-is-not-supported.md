# Remote Desktop Authentication Error: The Function is Not Supported

## Root Cause
* [CVE-2018-0886 的 CredSSP 更新](https://support.microsoft.com/zh-cn/help/4093492/credssp-updates-for-cve-2018-0886-march-13-2018)

## Solution A(recommended)
This solution will set registry parameters and it does not require to run `gpedit.msc` which is not included in Home Edition of Windows 7 / 10.

* Open a CMD window as adimistrator
* Run following command:

      reg add "HKLM\Software\Microsoft\Windows\CurrentVersion\Policies\System\CredSSP\Parameters" /f /v AllowEncryptionOracle /t REG_DWORD /d 2

## Solution B
Change the Group Policy on your local client to use the vulnerable setting.

* Run `gpedit.msc`
* Goto `Computer Configuration` -> `Administrative Templates` -> `System` -> `Credentials Delegation` -> `Encryption Oracle Remediation`
* Choose `Enable` and set `Protection Level` to `Vulnerable`

## References
* [Remote desktop connection error after updating Windows 2018/05/08 - CredSSP updates for CVE-2018-0886Remote desktop connection error after updating Windows 2018/05/08 - CredSSP updates for CVE-2018-0886](https://superuser.com/questions/1321418/remote-desktop-connection-error-after-updating-windows-2018-05-08-credssp-upda)
* [Remote Desktop Authentication Error Has Occurred. The function requested is not supported. CredSSP Workaround](http://blog.fmsinc.com/remote-desktop-authentication-error-function-requested-is-not-supported-credssp/)
* [CVE-2018-0886 的 CredSSP 更新](https://support.microsoft.com/zh-cn/help/4093492/credssp-updates-for-cve-2018-0886-march-13-2018) 
* [Remote Desktop Authentication Error Has Occurred. The function requested is not supported](https://social.technet.microsoft.com/Forums/windows/en-US/46e1cd52-52b3-4427-88a3-200f87319e23/remote-desktop-authentication-error-has-occurred-the-function-requested-is-not-supported)
* [远程桌面，身份验证错误：要求的函数不正确等解决办法](http://www.cnblogs.com/LuckWJL/p/9018710.html)

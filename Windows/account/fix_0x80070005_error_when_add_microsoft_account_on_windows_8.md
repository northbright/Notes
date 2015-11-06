# Fix 0x80070005 Error When Add Microsoft Account on Windows 8

#### Problem

* Try to add Microsoft Account on Windows 8
* Email, password are correct
* Input the security code from the mail
* Encounter the error code: 0x80070005

#### Root Cause

* The security policy of blocking Microsoft Accounts is enabled

#### Solution

* Windows 8 Standard

    Set the following registry key's value to 0:

        HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\Policies\System
        NoConnectedUser DWORD

        0 = Allow Microsoft Accounts
        1 = Users can't add Microsoft Accounts
        3 = Users can't add or Sign in with Microsoft Accounts

    * Open a CMD window as administrator then run the following command:       
      `reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\Policies\System" /v "NoConnectedUser" /t REG_DWORD /d 0 /f`

* Windows 8 Pro / Enterprise

    There's another easy way for Windows 8 Pro / Enterprise:  

    * Press `Windows Key` + `R`
    * Run `"secpol.msc"` as administrator
    * Find `Local Policies` -> `Security Options` -> `Accounts: Block Microsoft accounts`
    * Select `This policy is disabled`
    * Click `OK` and `Apply`
    * Try to add Microsoft Account again

#### References

* [Cannot switch to a Microsoft Account, error 0x80070005](http://www.eightforums.com/user-accounts-family-safety/50308-cannot-switch-microsoft-account-error-0x80070005.html)
* [Microsoft Accounts - Allow or Block in Windows 8](http://www.eightforums.com/tutorials/8085-microsoft-accounts-allow-block-windows-8-a.html)
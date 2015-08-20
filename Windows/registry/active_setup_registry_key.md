
# Active Setup Registry Key

#### About Active Setup Key

* The Active Setup key in Local Machine is read when a user logs in to the system.
* Every time a user logs in, the contents of this key is compared against the SAME key in HKCU.
* If the HKCU key does not exist and/or the "version" value is less than that in HLKM, the appropriate "StubPath" command is run and the key copied to HKCU so it is not run again.
* Effectively, this is one way to customize (or completely remove) an installation on a per-user basis, assuring that a program is executed exactly once per user.

#### Steps

* Create **Unique** Key under `[HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components]`  
  Ex: `[HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components\TrustedSites]`

* Add `StubPath` Value(string) under the key
  * Could be an app to execute, script, other cmd to be run when a user logs in
  * Ex: `"D:\\add_trusted_sites.bat"`, `"notepad"`, `"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v Flags /d 67 /t REG_DWORD /f"`

* Add `Version` Value(string) under the Key
  * **MUST** use comma(Ex: `1,0`, `1,3,6`)
  * "StubPath" command will NOT be run again if `Version` in HKCU and HLKM are the same
  * To run the "StubPath" command again, increase the `Version` in HLKM

#### Example

Here's the example used to:

* add https://*.netflix.com to trusted sites zone
* uncheck "Requre Server Verification" in "Internet Settings"->"Security"->"Trusted Sites".  

It works for all users(each time a user logs in, it'll take effect).  
Registry File:

    Windows Registry Editor Version 5.00

    [HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components\TrustedSites]
    "Version"="1,0"

    [HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components\TrustedSites]
    "StubPath"="reg add \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Domains\\netflix.com\" /v https /d 2 /t REG_DWORD /f"

    [HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components\UncheckRequireServerVerification]
    "Version"="1,0"

    [HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components\UncheckRequireServerVerification]
    "StubPath"="reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v Flags /d 67 /t REG_DWORD /f"

#### References
* [Active Setup Registry Keys and their Purpose](http://bonemanblog.blogspot.com/2004/12/active-setup-registry-keys-and-their.html)
* [Windows 7 Trusted Sites for all users - Active Setup](http://didyourestart.blogspot.com/2012/05/windows-7-trusted-sites-for-all-users.html)
* [Add Trusted Sites for Current User and All Users on Windows 7 and Later](https://github.com/northbright/Notes/blob/master/Windows/trusted_sites/add_trusted_sites_for_all_users_on_windows_7_and_later/add_trusted_sites_for_current_user_and_all_users_on_windows_7_and_later.md)
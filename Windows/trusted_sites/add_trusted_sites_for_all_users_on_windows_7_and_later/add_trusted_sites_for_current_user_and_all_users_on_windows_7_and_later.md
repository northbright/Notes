
# Add Trusted Sites for Current User and All Users on Windows 7 and Later

## Part I - Add Trusted Sites for Current User

Adding trusted sites for current user is very easy.

#### Create registry keys under:  
**`[HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains]`**

* Each registry key that is below this key in the registry hierarchy is a Web site domain.
* Each of these keys has values which indicate the allowed protocol(`http`, `https`) and the zone to which that protocol belongs for the domain. 
* A value of 0x001 indicates the Intranet zone and a value of 0x002 indicates the Trusted sites zone.

#### Example  
* We want to add below sites into the trusted sites zone:
  
  * `github.com`(https)  
  * `cnbeta.com`(http)  

* Here's the [registry file](./files/trusted_sites_for_current_user.reg):  

        Windows Registry Editor Version 5.00

        [HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains\github.com]
        "https"=dword:00000002

        [HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains\cnbeta.com]
        "http"=dword:00000002  

## Part II - Add Trusted Sites for All Users

#### About Active Setup

* The **Active Setup key** in **Local Machine** is read when a user **logs in** to the system.
* Every time a user logs in, the contents of this key is compared against the SAME key in HKCU. 
* If the HKCU key does not exist and/or the "version" value is **less** than that in HLKM, the appropriate "StubPath" command is run and the key copied to HKCU so it is **not run again**.
* Effectively, this is one way to customize (or completely remove) an installation on a **per-user** basis, assuring that a program is executed exactly once per user.

#### How to

* Create a [batch file](./files/add_trusted_sites.bat) to add trusted sites like PART I:
        
        @echo off
        reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains\github.com" /v https /d 2 /t REG_DWORD /f
        reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains\cnbeta.com" /v http /d 2 /t REG_DWORD /f

* Create **Unique** Key Under `[HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components]`  
  Ex: `[HKEY_LOCAL_MACHINE\Software\Microsoft\Active Setup\Installed Components\TrustedSites]`

* Add `StubPath` Value under the key
  * Could be an app to execute, script, other cmd to be run when a user logs in
  * Here we set it to the bat file.  
    `"D:\\add_trusted_sites.bat"`

* Add `Version` Value under the Key
  * **MUST** use comma(Ex: `1,0`, `1,3,6`)
  * "StubPath" command will NOT be run again if `Version` in HKCU and HLKM are the same
  * To run the "StubPath" command again, increase the `Version` in HLKM

#### Example

* [Batch File to Add Trusted Sites](./files/add_trusted_sites.bat)
* [Reg File](./files/trusted_sites_for_all_users.reg)

## References
* [Adding Sites to the Enhanced Security Configuration Zones](https://msdn.microsoft.com/en-us/library/ms537181(v=VS.85).aspx)
* [Active Setup Registry Keys and their Purpose](http://bonemanblog.blogspot.com/2004/12/active-setup-registry-keys-and-their.html)
* [Windows 7 Trusted Sites for all users - Active Setup](http://didyourestart.blogspot.com/2012/05/windows-7-trusted-sites-for-all-users.html)
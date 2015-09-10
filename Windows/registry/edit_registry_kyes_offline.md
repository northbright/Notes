
# Edit Registry Keys Offline

#### Steps
* `REG LOAD`: load HIVE
* Modify Registry Keys
* `REG UNLOAD`: unload HIVE

#### Example
Here's the example to [Add Trusted Sites](https://github.com/northbright/Notes/tree/master/Windows/trusted_sites/add_trusted_sites_for_all_users_on_windows_7_and_later):

    echo Load HKLM\TEMPHIVE
    REG LOAD HKLM\TEMPHIVE "C:\windows\system32\config\software"
    REG ADD "HKLM\TEMPHIVE\Microsoft\Active Setup\Installed Components\TrustedSites" /v Version /d 1,0,0,0 /t REG_SZ /f
    REG ADD "HKLM\TEMPHIVE\Microsoft\Active Setup\Installed Components\TrustedSites" /v StubPath /d "reg add \"HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains\netflix.com\" /v https /d 2 /t REG_DWORD /f" /t REG_SZ /f
    echo Unload HKLM\TEMPHIVE
    REG UNLOAD HKLM\TEMPHIVE
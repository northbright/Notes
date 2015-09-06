
# Edit the Registry on a Mounted WIM

* Mount the WIM file to a local folder using ImageX

        C:\ImageX>imagex /mountrw install.wim 1 c:\mount

* Load the registry hive you want to edit(Ex: `HKLM\Software`)

        C:\mount>reg load HKLM\test c:\mount\windows\system32\config\software

    It will load `windows\system32\config\software`(hive) to the new registry key(`HKLM\test`)

* Add or Modify the key you want

        // Ex:
        // Add some new key
        reg add "HKLM\test\MyCompany\MyProduct" /v Flags /d 1 /t REG_DWORD /f

        // Dump after modify, add '/y' to avoid block the command(input "yes"/"no"):
        reg export "HKLM\test\MyCompany\MyProduct" "d:\1.reg" /y

* Unload registry hive

        reg unload HKLM\test

* Unload WIM file

        C:\ImageX>imagex /unmount /commit c:\mount

#### References
* [Edit the Registry on a Mounted WIM](http://blogs.technet.com/b/migreene/archive/2006/12/07/edit-the-registry-on-a-mounted-wim.aspx)
* [Load registry hive for offline registry editing](http://smallvoid.com/article/winnt-offline-registry-edit.html)
* [Reg Load](https://technet.microsoft.com/en-us/library/cc742053.aspx)
# Failed to Start VirtualBox on Mac OS EI Capitan with ns_error_factory_not_registered Error

#### Problem
* It' failed to start VirtualBox on EI Capitan with `ns_error_factory_not_registered` error
* System log

        tail -n 200 /var/log/system.log
        
        output:
        VBoxXPCOMIPCD(453) System Policy: deny file-write-create /private/tmp/.vbox-xxu-ipc

#### Root Cause
* `/private/tmp` permission is incorrent(not 1777).
* `sudo chmod 1777 /private/tmp` will fail due to [System Integrity Protection](https://support.apple.com/en-us/HT204899).

#### Solution
1. Disable [System Integrity Protection](https://support.apple.com/en-us/HT204899).
    * Reboot Mac into `Recovery Mode by pressing `Command + R`.
    * Click "Utilities" -> "Terminal".
    * type `csrutil disable`
    * Reboot Mac

2. Run `sudo chmod 1777 /private/tmp` after reboot.

3. Enable [System Integrity Protection](https://support.apple.com/en-us/HT204899) again.
    * Reboot Mac into `Recovery Mode by pressing `Command + R`.
    * Click "Utilities" -> "Terminal".
    * type `csrutil enable`
    * Reboot Mac 

#### References
* [Fix private/tmp Permission Issue on Mac OS EI Capitan](https://github.com/northbright/Notes/blob/master/macos/fix-private-tmp-permission-issue-on-mac-os-ei-capitan.md)
* [http://stackoverflow.com/questions/39857643/unable-to-reset-permissions-on-mac-el-capitan-for-tmp-folder](http://stackoverflow.com/questions/39857643/unable-to-reset-permissions-on-mac-el-capitan-for-tmp-folder)
* [Virtualbox installation error on Mac OS 10.11](https://forums.virtualbox.org/viewtopic.php?f=8&t=80134)


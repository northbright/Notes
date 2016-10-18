# Fix `private/tmp` System Policy Issue on Mac OS EI Capitan

#### Problem
* It' failed to start VirtualBox on EI Capitan with `ns_error_factory_not_registered` error
* System log

        tail -n 200 /var/log/system.log
        
        output:
        VBoxXPCOMIPCD(453) System Policy: deny file-write-create /private/tmp/.vbox-xxu-ipc

#### Root Cause
* [](https://en.wikipedia.org/wiki/System_Integrity_Protection) protects system files and dirs(links) include `/tmp`, `/private/tmp`.
    * Files inside `/private/tmp` had the restrict flag.
    * [Wikipedia](https://en.wikipedia.org/wiki/System_Integrity_Protection#Functions) says that only the symbolic link `/tmp` itself should be restricted.
* `sudo chmod 1777 /private/tmp` and `sudo chflags -R norestricted /private/tmp/` will fail due to [System Integrity Protection](https://en.wikipedia.org/wiki/System_Integrity_Protection#Functions).

#### Solution
1. Disable [System Integrity Protection](https://en.wikipedia.org/wiki/System_Integrity_Protection#Functions).
    * Reboot Mac into Recovery Mode by pressing `Command + R`.
    * Click "Utilities" -> "Terminal".
    * type `csrutil disable`
    * Reboot Mac

2. Run these commands after reboot in termial:

        sudo chmod 1777 /private/tmp
        sudo chflags -R norestricted /private/tmp/


3. Enable [System Integrity Protection](https://en.wikipedia.org/wiki/System_Integrity_Protection#Functions) again.
    * Reboot Mac into Recovery Mode by pressing `Command + R`.
    * Click "Utilities" -> "Terminal".
    * type `csrutil enable`
    * Reboot Mac 

#### References
* [Getting an error message on startup (CoreTelephony tracing has failed), can't open Ableton Live? (El Capitan 10.11.16) ](https://www.reddit.com/r/mac/comments/55s9yg/getting_an_error_message_on_startup_coretelephony/)
* [System Integrity Protection](https://en.wikipedia.org/wiki/System_Integrity_Protection)

# Boot Manager: Windows Failed to Start with Status: 0xc000000f

#### Problem
* PC did not shutdown properly due to power fail
* Failed to start windows and got the message: Boot Manager: Windows Failed to Start with Status: 0xc000000f

#### Root Cause
* MBR was damaged

#### Solution
* Boot PC via a USB disk with [WePE](http://www.wepe.com.cn/) installed
* Run "DiskGenius" -> "Select hard disk" -> "Rebuild MBR"
* Reboot PC

# FRP(Factory Reset Protection) on Android L 5.1

FRP will be take effect in case:  

* Google Account has been logged in
* Untrusted factory reset: 
  reboot after erased user data partition via fastboot or recovery mode.

When FRP is enabled, you will have to set WiFi connection and use previous Google Account to login the device.

If you are the engineer of the ODM, you can erase the partition which stores the FRP information to disable FRP:

* Reboot to fastboot mode.
* Erase the parition which stores FRP information.  
      
        fastboot erase <Partition Name>
        fastboot reboot
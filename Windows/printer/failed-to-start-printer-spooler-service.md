# Failed to Start Printer Spooler Service

#### Problem
* Failed to find installed Canon ir2320L printer
* Failed to uninstall / reinstall Canon ir2320L driver due to "Printer Spooler" serivce is stopped
* Failed to start "Printer Spooler" service with error 0x800706b9: not enough resource

#### Solution
* Run cmd as administrator
* input `netsh winsock reset`
* Restart the "Printer Spooler" service

#### References
* [记一次Win10打印机无法打印的情况及解决办法](http://blog.51cto.com/fjfhxd/2050572)


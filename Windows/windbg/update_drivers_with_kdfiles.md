# Update Drivers with kdfiles

We can use `.kdfiles` to map new driver on host PC to the old one on the target PC.


`.kdfiles -m system32\drivers\acpi.sys d:\acpi.sys`

* first path is the driver file path under %systemroot%(almost `c:\`)
* second path is the **ABS** path of the new driver on host PC.
* To take effect:
  * "Control Panel" -> "Device Manager" -> "Select The Device" - > "Disable" -> "Enable"
  * or reboot the target PC(run `.reboot` in windbg)

#### Reference
[.kdfiles (Set Driver Replacement Map)](https://msdn.microsoft.com/en-us/library/windows/hardware/ff563848(v=vs.85).aspx)
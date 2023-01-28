# Hide ACPI Errors on Ubuntu Boot

## Problem
* Dell Precision T3460 Workstation
* Installed Ubuntu 22.04 Server
* Got ACPI errors on boot

## Solution

Hide the ACPI errors

* Edit `/etc/default/grub` and set `"GRUB_CMDLINE_LINUX_DEFAULT"` to `quiet splash loglevel=3`

  ```
  sudo vi /etc/default/grub
  ```

  ```
  ......
  GRUB_CMDLINE_LINUX_DEFAULT="quiet splash loglevel=3"
  ......
  ```

* Update grub

  ```
  sudo update-grub
  ```

* Try reboot to see if there's no errors

## References
* [Ubuntu 22.04 ACPI BIOS ERROR (BUG)](https://askubuntu.com/questions/1411354/ubuntu-22-04-acpi-bios-error-bug)
* [ACPI error after installing Ubuntu 22.04](https://linux.org/threads/acpi-error-after-installing-ubuntu-22-04.40993/)
* [ACPI BIOS error on Ubuntu](https://www.dell.com/community/Inspiron/ACPI-BIOS-error-on-Ubuntu/td-p/8249583)
* [ACPI BIOS errors when trying to install Ubuntu from an USB Stick](https://community.acer.com/en/discussion/566320/acpi-bios-errors-when-trying-to-install-ubuntu-from-an-usb-stick)
* [How do I disable ACPI when booting?](https://askubuntu.com/questions/160036/how-do-i-disable-acpi-when-booting)

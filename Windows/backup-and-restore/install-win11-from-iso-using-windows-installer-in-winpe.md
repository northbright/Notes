# Install Win11 from ISO Using Windows Installer in WinPE

## Steps

* Install WinPE on a USB Disk with UEFI Boot Support
  * [Install WinPE on a USB Disk with UEFI Boot Support](https://github.com/northbright/Notes/blob/master/Windows/backup-and-restore/install-winpe-on-a-usb-disk-with-uefi-boot-support/install-winpe-on-a-usb-disk-with-uefi-boot-support.md)

* Download Windows 11 ISO
  * Visit [Download Windows 11](https://www.microsoft.com/en-us/software-download/windows11)
  * Download Windows 11 ISO
  * Copy the ISO to an USB disk or an USB drive

* Boot PC from the USB disk with WinPE installed

* Run "Windows Installer"(Windows 安装器) on the desktop
  * Select the ISO to install(e.g. `e:\iso\win11.iso`)
  * Select EFI partition(e.g. `disk 0, partition 1`)
  * Select partiton to install Windows 11(e.g. `disk 0, partition 3`)
  * Click "Install" button
  * Reboot the PC

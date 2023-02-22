# Ubuntu Server Install Does Not Use All Disk Space

## Problem
* Install Ubuntu Server 22.04 on a 2TB SSD(use entire disk)
* It Does Not Use All Disk Space But Only About 100GB for `/`

  Run `df -h`:

  ```
  Filesystem                         Size  Used Avail Use% Mounted on
  ......
  /dev/mapper/ubuntu--vg-ubuntu--lv   98G   21G   73G  23% /
  ......
  ```

  Only 100GB is used on the 2TB SSD.

## Root Cause
It's by design. See [How is the size of the LVM container decided?](https://discourse.ubuntu.com/t/how-is-the-size-of-the-lvm-container-decided/24608)

## Solution
Extend the Logical Volume(LV).

* Display VG and LV info(Optional)

  Run `sudo vgdisplay -v` and check `Total PE`, `Alloc PE` and `Free PE`.

  ```
  sudo vgdisplay -v

  --- Volume group ---
  VG Name               ubuntu-vg
  ......
  VG Size               <1.82 TiB
  PE Size               4.00 MiB
  Total PE              476150
  Alloc PE / Size       25600 / 100.00 GiB
  Free  PE / Size       450550 / <1.72 TiB
  ```

* Extend the LV

  ```
  sudo lvextend -l +100%FREE /dev/mapper/ubuntu--vg-ubuntu--lv
  ```

  Run `sudo vgdisplay -v` and check `Total PE`, `Alloc PE` and `Free PE` again.

  ```
  sudo vgdisplay -v

  --- Volume group ---
  VG Name               ubuntu-vg
  ......
  VG Size               <1.82 TiB
  PE Size               4.00 MiB
  Total PE              476150
  Alloc PE / Size       476150 / <1.82 TiB
  Free  PE / Size       0 / 0 
  ```

  You can see `Total PE` = `Alloc PE` and `Free PE` = 0

* Resize Filesystem

  ```
  sudo resize2fs /dev/mapper/ubuntu--vg-ubuntu--lv
  ```

  Run `df -h` agian.

  ```
  df -h

  Filesystem                         Size  Used Avail Use% Mounted on
  ......
  /dev/mapper/ubuntu--vg-ubuntu--lv  1.8T   21G  1.7T   2% /
  ```

## References
* [Ubuntu Server 20.04.1 LTS, not all disk space was allocated during installation?](https://askubuntu.com/questions/1269493/ubuntu-server-20-04-1-lts-not-all-disk-space-was-allocated-during-installation)
* [How is the size of the LVM container decided?](https://discourse.ubuntu.com/t/how-is-the-size-of-the-lvm-container-decided/24608)
* [How To Use LVM To Manage Storage Devices on Ubuntu 18.04](https://www.digitalocean.com/community/tutorials/how-to-use-lvm-to-manage-storage-devices-on-ubuntu-18-04)

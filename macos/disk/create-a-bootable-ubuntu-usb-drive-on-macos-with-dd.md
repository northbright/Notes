# Create a Bootable Ubuntu USB Drive on macOS with `dd`

## Get USB drive identifier
```
diskutil list

// Output:
/dev/disk3 (external, physical):
   #: TYPE                   NAME      SIZE       IDENTIFIER
   0: FDisk_partition_scheme           *61.9 GB   disk3
   1: Windows_FAT_32         KINGSTON  61.9 GB    disk3s1
```

e.g. `KINGSTON` is the USB drive volume name and `disk3s1` is the identifier

## Unmount the target USB drive volume
```
sudo umount /dev/IDENDITIFER
```

e.g.

```
sudo umount /dev/disk3s1
```

* If you got the error: "Resource busy -- try 'diskutil unmount'"

  Run `sudo diskutil unmount /dev/IDNEDIFIER`

  e.g. `sudo diskutil unmount /dev/disk3s1`

## Copy disk image to USB drive

```
sudo dd if=PATH/TO/IMAGE of=/dev/rIDENDIFIER bs=1m
```

e.g.

```
sudo dd if=/Users/xx/iso/ubuntu-22.04.1-live-server-amd64.iso of=/dev/rdisk3s1 bs=1m
```

* `if` specify the path of disk image file
* `of` specify the target USB volume
  * The `r` in front of IDNEIFIER means using "raw" device and will speed it up
* `bs=1m` sets the block size and it aslo make the process faster

When if finishes, it will show:
```
xxxx records in
xxxx records out
```

## Eject the USB volume
```
diskutil eject /dev/IDENDIFIER
```

e.g.

```
diskutil eject /dev/disk3s1
```

## References
* [How to Copy an ISO to a USB Drive from Mac OS X with dd](https://osxdaily.com/2015/06/05/copy-iso-to-usb-drive-mac-os-x-command/)
* [Fix "Resource Busy" Issue when Unmount USB Drive Volume via umount](https://github.com/northbright/Notes/blob/master/macos/disk/fix-resource-busy-issue-when-unmount-usb-drive-volume-via-umount.md)

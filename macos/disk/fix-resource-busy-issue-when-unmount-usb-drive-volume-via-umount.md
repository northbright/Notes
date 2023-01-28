# Fix "Resource Busy" Issue when Unmount USB Drive Volume via `umount`

## Problem
* Need to unmount the USB drive volume(`/dev/disk3s1`)
* Got error when run `sudo umount /dev/disk3s1`:

  > Resource busy -- try 'diskutil unmount'

## Solution
Use `diskutil unmount` command instead of `umount`

```
sudo diskutil unmount /dev/disk3s1
```

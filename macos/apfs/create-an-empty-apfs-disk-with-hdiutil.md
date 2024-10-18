# Create an Empty APFS Disk with hdiutil

## Problem
* Need to create an empty APFS disk for test.

## Solution
Use `hdiutil` to create an empty APFS disk image get automatically mounted as `/Volumes/untitled`.

```bash
hdiutil create -fs apfs -size 10m -type UDIF -attach ~/apfs.dmg
```

## References
* [Vido of Jonathan Levin demonstrated in this lecture](http://docs.macsysadmin.se/2018/video/Day4Session2.mp4)

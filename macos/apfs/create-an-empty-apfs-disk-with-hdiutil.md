# Create an Empty APFS Disk with hdiutil

## Problem
* Need to create an empty APFS disk for test.

## Solution
Use `hdiutil` to create an empty APFS disk image get automatically mounted as `/Volumes/untitled`.

```bash
hdiutil create -fs apfs -size 10m -type UDIF -attach ~/apfs.dmg
```

* Use `diskutil` to list APFS disks

```bash
diskutil apfs list

// Output:
Container disk4
APFS Container Reference:     disk4
    Size (Capacity Ceiling):      10444800 B (10.4 MB)
    Capacity In Use By Volumes:   442368 B (442.4 KB) (4.2% used)
    Capacity Not Allocated:       10002432 B (10.0 MB) (95.8% free)
    |
    +-< Physical Store disk3s1 FC54185B-E681-4DFB-9BF2-5BE33A0C5B10
    |   -----------------------------------------------------------
    |   APFS Physical Store Disk:   disk3s1
    |   Size:                       10444800 B (10.4 MB)
    |
    +-> Volume disk4s1 3AC0BFEB-175E-4CDE-812D-BF2062D48E1B
        ---------------------------------------------------
        APFS Volume Disk (Role):   disk4s1 (No specific role)
        Name:                      untitled (Case-insensitive)
        Mount Point:               Not Mounted
        Capacity Consumed:         90112 B (90.1 KB)
        Sealed:                    No
        FileVault:                 No
```

## Detach and Attach

* Detach:

```bash
hdiutil detach <device_name>
```

e.g.
```bash
hdiutil detach /dev/disk4
```

* Attach
```bash
hdiutil attach <image>
```

e.g.
```bash
hdiutil attach ~/apfs.dmg
```

## References
* [Vido of Jonathan Levin demonstrated in this lecture](http://docs.macsysadmin.se/2018/video/Day4Session2.mp4)

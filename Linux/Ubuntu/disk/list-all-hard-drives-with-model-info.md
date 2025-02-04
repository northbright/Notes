# List All Hard Drives with Model Info

## Problem
* Ubuntu 24.04
* Need list all hard drives with model info

## Solution
Run `lsblk` to show block devices.

```
lsblk -io KNAME,TYPE,SIZE,MODEL

// Output:
KNAME     TYPE   SIZE MODEL
sda       disk   1.8T ST2000DM008-2UB1
sda1      part   350M
sda2      part   128M
sda3      part   1.8T
sda4      part   990M
sda5      part   1.5G
dm-0      lvm  928.5G
nvme0n1   disk 931.5G Samsung SSD 970 EVO Plus 1TB
nvme0n1p1 part     1G
nvme0n1p2 part     2G
nvme0n1p3 part 928.5G
```

```
// Don't show slaves or holders(show just "disk" type)
lsblk -dio KNAME,TYPE,SIZE,MODEL

// Output:
KNAME   TYPE   SIZE MODEL
sda     disk   1.8T ST2000DM008-2UB1
nvme0n1 disk 931.5G Samsung SSD 970 EVO Plus 1TB
```

## References
* [How do I find out what hard disks are in the system?](https://unix.stackexchange.com/questions/4561/how-do-i-find-out-what-hard-disks-are-in-the-system)

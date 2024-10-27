# Recovered Files by PhotoRec Lost File Names

## Problem
* Use PhotoRec to recover deleted JPG files.
* The JPG files under recovered dir are named to "f000XXXX.jpg" but lost their original names.

## Root Cause
It's by design.
> PhotoRec ignores the file system and goes after the underlying data, so it will still work even if your media's file system has been severely damaged or reformatted.

TestDisk's Undelete can recover the original filenames, PhotoRec can't.

TestDisk can undelete files from FAT12/16/32, NTFS, exFAT and ext2, PhotoRec isn't limited to these filesystem and can work even if the filesystem is corrupted.

## References
* [Photorec files recovered but lost names](https://forum.cgsecurity.org/phpBB3/viewtopic.php?t=9894)
* [PhotoRec](https://www.cgsecurity.org/wiki/PhotoRec)
* [TestDisk](https://www.cgsecurity.org/wiki/TestDisk)
* [TestDisk Documentation](https://www.cgsecurity.org/testdisk.pdf)

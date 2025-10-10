# Failed to Boot Ubuntu Because that Root Filesystem Requires a Manual `fsck`

## Problem
* Ubuntu 24.04
* Failed to boot and it shows errors:

  > /dev/sda2 contains a file system with errors, check forced.
  > Inodes that were part of a currupted orphan linked list found.
  > /dev/sda2: UNEXPECTED INCONSISTENCY; RUN fsck MANUALLY.
  > fsck exited with status code 4
  > done.
  > Failure: File system check of the root filesystem failed
  > The root filesystem on /dev/sda2 requires a manual fsck
  >
  > BusyBox v1.36.1 (...) built-in shell (ash)
  > Enter 'help' for a list of built-in commands.
  > (initramfs)

## Root Cause
* Root filesystem on `/dev/sda2` has one or more inconsistencies and need to run `fsck` manually

## Solution
Run `fsck` manually in `initramfs`.

* Type `fsck -yf /dev/sda2`
* Type `exit` to login as usual

## References
* [Root file system requires manual fsck](https://askubuntu.com/questions/885062/root-file-system-requires-manual-fsck)
* [How to Fix fsck File System errors in Ubuntu?](https://www.geeksforgeeks.org/techtips/how-to-fix-fsck-errors-in-ubuntu/)

# macOS Can Read Corrupt USB Hard Drive while Windows Can Not

## Problem
* A portable USB hard drive formatted with NTFS
* Windows PC(or WinPE) can not recognize the disk and its partitions
* Plug the USB hard drive to an iMac
* macOS can recognize the disk and its partitions included all files
* Can copy some dirs(files) to mac successfully

## Root Cause
* The ways to detecting / recognizing NTFS partition on Windows and macOS may be different

## Solution
Try to read / copy files of external hard drive formatted with NTFS on macOS when it fails to detect the hard drive on Windows.

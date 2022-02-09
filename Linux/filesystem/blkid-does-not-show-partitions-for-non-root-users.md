# `blkid` Does not Show Partitions for Non-Root Users

## Problem
* Create a GPT partition and format the partition to XFS(`/dev/vdb1`)
* Run `blkid` to show the UUID and type of the new created partition and there's no output of `/dev/vdb1` as non-root user

## Solution
* Run `sudo blkid` and it works

## References
* [command blkid don't show my partitions UUID](https://stackoverflow.com/questions/30558050/command-blkid-dont-show-my-partitions-uuid)

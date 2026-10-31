# Format Bitlocker Encrpted Partition with "override" Parameter

## Problem
* Run `diskpart` and `format` to format a partition which installed Windows 11 previously
* Got error:

  > The partition you selected to format contains a volume that has been encrypted with BitLocker Drive Encryption.
  > If you format the partition, all data in the volume will be lost.
  > To proceed with the deletion, run FORMAT again using the OVERRIDE parameter.

## Solution
Run `format` with `override` parameter.

```sh
format quick override
```

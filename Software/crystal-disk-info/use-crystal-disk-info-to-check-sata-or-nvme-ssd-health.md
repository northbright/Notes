# Use CrystalDiskInfo to Check SATA or NVME SSD Health

## Problem
* Need to check SATA or NVME SSD health

## Solution
Use [CrystalDiskInfo](https://crystalmark.info/en/software/crystaldiskinfo/) to detect SSD health by reading S.M.A.R.T.

* Run [CrystalDiskInfo](https://crystalmark.info/en/software/crystaldiskinfo/)
* Set raw values to DEC(10)
  * Go to Function > Advanced Feature > Raw Values > 10[DEC]
* For SATA SSD

  Check these values:
  * `05` - Reallocated Sector Count, should be `0`
  * `BB` - Uncorrectable Error Count, should be `0`
  * `C3` - ECC Error Rate, should be `0`

* For NVME SSD

  Check these values:
  * `03` - Available Spare, should be `0`
  * `0E` - Media and Data Integrity Errors, should be `0`

## References
* [crystalinfo 软件问题 怎么调出0E 03](https://tieba.baidu.com/p/8553773709)

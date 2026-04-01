# iPhone Backup Location on macOS

## Problem
* Backup iPhone data using Finder on macOS
* Need to know where the backup location on macOS

## Solution

```sh
~/Library/Application Support/MobileSync/Backup/
```

To get the size of the backup, run:

```sh
du -sh ~/Library/Application Support/MobileSync/Backup/
```

## References
* [查找并管理 iPhone、iPad 和 iPod touch 的备份](https://support.apple.com/zh-cn/108809)
* [如何在Mac上查找和更改iPhone备份位置](https://juejin.cn/post/7423537261076234267)

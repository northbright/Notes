# Case Sensitive File Name Change Not Recognized in Git

## Problem
* Change File Name from Lowercase to Uppercase on macOS
* Git Can NOT Detect the Change of File Name

## Solution A(Recommended)
Use a new temp(bridged) file name.

* Example
  * We Want to Rename `FILE.txt` to `file.txt`
  * Rename `FILE.txt` to `file_tmp.txt`
  * Run `git add .` to track the change
  * Reanme `file_temp.txt` to `file.txt`
  * Run `git add .` to track again, you may see `FILE.txt` -> `file.txt`

## Solution B(NOT Recommended)
Set `core.ignorecase` to `false`

```
git config --global core.ignorecase false
```

## References
* [git修改文件名大小写踩坑记录](https://www.jianshu.com/p/73e4e1330f46)
* [Git is case-sensitive and your filesystem may not be - Weird folder merging on Windows](https://www.hanselman.com/blog/git-is-casesensitive-and-your-filesystem-may-not-be-weird-folder-merging-on-windows)


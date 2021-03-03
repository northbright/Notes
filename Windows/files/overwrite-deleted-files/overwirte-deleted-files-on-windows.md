# Overwrite Deleted Files on Windows

## Problem
* Want to make sure that deleted files can NOT be recovered by any tools

## Solution
* Run built-in tool - `Cipher.exe`
  * Press `win` + `R` to open a CMD window
  * Input `Cipher /w: <FOLDER>` to overwrite deallocated space on the volume which <FOLDER> is in the volume.  

## Example
```
Cipher /w: d:\my-folder
```

## References
* [Use Cipher.exe to overwrite deleted data in Windows Server 2003](https://docs.microsoft.com/en-us/troubleshoot/windows-server/windows-security/use-cipher-to-overwrite-deleted-data)

---------

# 在 Windows 上彻底粉碎已经删除文件

## 问题
* 希望已经删除的文件不能被工具恢复

## 解决方案
* 运行 Windows 自带的工具 - `Cipher.exe`
  * 按下 `Win` + `R` 打开命令行窗口
  * 输入 `Cipher /w: <文件夹>` 来覆盖<文件夹>所在盘的空闲空间

## 例子
```
Cipher /w: d:\my-folder
```

## 参考资料
* [Use Cipher.exe to overwrite deleted data in Windows Server 2003](https://docs.microsoft.com/en-us/troubleshoot/windows-server/windows-security/use-cipher-to-overwrite-deleted-data)



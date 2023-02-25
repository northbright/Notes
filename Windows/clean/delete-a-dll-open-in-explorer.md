# Delete a DLL Open in Explorer

## Problem
Get "the file is open in explorer" error when delete a dll file.

## Solution A
* Copy the path of DLL file
* Press "Ctrl" + "Alt" + "Delete" to open task manager
* Kill all "explorer" processes
* Goto task manager > file > new task > input "cmd", check "Run as Administrator" and Run
* Input "del PATH/to/DLL" to delete the DLL file
* Input "start explorer" to start Window Explorer again

## Solution B
* Download and Install [WinPE](http://wepe.cn/)
* Boot PC to WinPE
* Open Explorer in WinPE and delele the DLL file

## References
* [删除.dll文件时遇到的一点问题（操作无法完成因为在资源管理器中打开、系统找不到指定路径）](https://blog.csdn.net/royalcatnap/article/details/116570220)

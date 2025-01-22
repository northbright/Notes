# Got "System can not find path specified" Error when Delete Folder on Windows

## Problem
* User put a folder on the desktop
* The folder has a long name which contains Chinese characters(e.g. `“2024年秋季学期幼儿园中班第二次课小海豚和小企鹅的故事-涂色和造型xxxx”)`
* Got "System can not find path specified" error when delete the folder

## Root Cause
* The path is longer than the `MAX_PATH` on Windows
* The maximum length for a path is `MAX_PATH`, which is defined as 260 characters.

See [Maximum Path Length Limitation](https://learn.microsoft.com/en-us/windows/win32/fileio/maximum-file-path-limitation?tabs=registry).

## Solution
Use `\\?\` prefix to specify an extended-length path.

Run `rd /s /q \\?\LONG_PATH` to delete the folder.

```
rd /s /q \\?\C:\Users\XX\Desktop\2024年秋季学期幼儿园中班第二次课小海豚和小企鹅的故事-涂色和造型xxxx
```

## References
* [Maximum Path Length Limitation](https://learn.microsoft.com/en-us/windows/win32/fileio/maximum-file-path-limitation?tabs=registry)
* [Force Deletion of Files Using BAT](https://github.com/northbright/Notes/blob/master/Windows/files/force-deletion-of-files-using-bat.md)

# Delete File or Dir which Name Ends with Dots

## Problem
* Can't Delete Dir: `d:\美丽的长颈鹿...` which was Generated via WPS(save PPTX to JPG files)
* Got Error: "The system cannot find the path specified."
* Drag the File on the `del.bat` Does NOT Work:

  "del.bat":

  ```bat
  DEL /F /A /Q \\?\%1
  RD /S /Q \\?\%1
  ```

## Solution A
Run `del` or `rd` command with adding `\\?\` prefix to the file name in a CMD Window directly.

```bash
del /a /f /q "\\?\<FILE_NAME>"
```

e.g.
```
del /a /f /q "\\?\C:\cygwin\usr\share\texmf-dist\doc\latex\hausarbeit-jura."
```

```bash
rd /s /q "\\?\<DIR_NAME>"
```

e.g.
```bash
rd /s /q "\\?\d:\美丽的长颈鹿..."
```

## Solution B
Use `dir /x` to get the short name(e.g. `d:\美丽~1`) then run `del` and `rd` command with the short name.

```bash
dir /x

// output:
d:\美丽~1   d:\美丽的长颈鹿...
```

```bash
rd /s /q d:\美丽~1
```

## References
* [Force Deletion of Files Using BAT](https://github.com/northbright/Notes/blob/master/Windows/files/force-deletion-of-files-using-bat.md)
* [How to remove folders or files whose name ends with dots in Windows](https://ourcodeworld.com/articles/read/465/how-to-remove-folders-or-files-whose-name-ends-with-dots-in-windows)
* [How to delete a file ending in a dot in Windows 7?](https://superuser.com/questions/494959/how-to-delete-a-file-ending-in-a-dot-in-windows-7)
* [del](https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/del)
* [rd](https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/rd)

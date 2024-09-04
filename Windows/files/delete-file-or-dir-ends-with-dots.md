# Delete File or Dir which Name Ends with Dots

## Problem
* Can't Delete Files or Dirs which Name Ends with Dots(e.g. `d:\美丽的长颈鹿...`)
* Got Error: "The system cannot find the path specified."

## Solution A
Add `"\\?\"` path prefix for `del` and `rd` command.

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
rd /s /q "\\?\E:\Our Code World\Workspace\folder_invalid.."
```

## Solution B
Use `dir /x` to get the short name(e.g. `d:\美丽~1`) then run `del` and `rd` command with the short name.

```bash
dir /x

// output:
d:\美丽~1   d:\美丽的长颈鹿...
```

```bash
rd /s d:\美丽~1
```

## References
* [How to remove folders or files whose name ends with dots in Windows](https://ourcodeworld.com/articles/read/465/how-to-remove-folders-or-files-whose-name-ends-with-dots-in-windows)
* [How to delete a file ending in a dot in Windows 7?](https://superuser.com/questions/494959/how-to-delete-a-file-ending-in-a-dot-in-windows-7)
* [del](https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/del)
* [rd](https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/rd)

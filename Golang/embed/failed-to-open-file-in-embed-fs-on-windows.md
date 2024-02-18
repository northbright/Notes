# Failed to Open File or Dir in embed.FS-on Windows

## Problem
* Need to Read File / Dir in embed.FS
* Use [filepath.Join](https://pkg.go.dev/path/filepath#Join) to Make a File Path(e.g. `p := filepath.Join(dir, filename)`)
* Call [fs.ReadFile(fsys, p)](https://pkg.go.dev/io/fs#ReadFile) or [fs.ReadDir(fys, p)](https://pkg.go.dev/io/fs#ReadDir) and `fsys` is [embed.FS](https://pkg.go.dev/embed#FS)
* Got Error:

  > open templates\latex\chapters: file does not exist

## Root Cause
* For embed.FS, the path separator is a forward slash(`/`), even on Windows systems. See [Directives](https://pkg.go.dev/embed#hdr-Directives) for more information.
* [filepath.Join](https://pkg.go.dev/path/filepath#Join) Uses OS-Specified Path Separator. For Windows, It's `\`.

## Solution
Use [path.Join](https://pkg.go.dev/path#Join) instead of [filepath.Join](https://pkg.go.dev/path/filepath#Join).
[path.Join](https://pkg.go.dev/path#Join) always use forward slash(`/`) as path separator.  

## References
* [embed: embed path on different OS cannot open file #45230](https://github.com/golang/go/issues/45230)

# Embeding Empty Dirs is Not Supported

## Problem
* Use `//go:embed` Directive to Embed a Dir(`assets`)

  ```go
  //go:embed assets
  var embededFiles embed.FS
  ```

* The Empty Dirs in `assets` are Not Embeded

## Root Cause
Embeding empty directories is not supported.

> each pattern in a //go:embed line must match at least one file or non-empty directory.

## References
* [How to Use go:embed in Go](https://blog.jetbrains.com/go/2021/06/09/how-to-use-go-embed-in-go-1-16/) 

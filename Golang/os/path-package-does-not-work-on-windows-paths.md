# `path` Package Does Not Work on Windows Paths

## Problem
Use [path.Dir](https://pkg.go.dev/path#Dir) to get the dir of a temporary file.
It works OK on macOS and Linux but it returns "." on Windows.

```golang
package main

import (
	"fmt"
	"os"
	"path"
	"path/filepath"
)

func main() {
	f := filepath.Join(os.TempDir(), "MY_APP", "README.md")
	fmt.Printf("f: %v\n", f)

	// Get parent dir of f via path.Dir.
	dir := path.Dir(f)
	fmt.Printf("get dir using path.Dir(), dir: %v\n", dir)

	dir = filepath.Dir(f)
	fmt.Printf("get dir using filepath.Dir(), dir: %v\n", dir)

}
```

```bash
// Output on macOS

f: /var/folders/rw/0gwtqtr55hdbnkwp7bt6pkb00000gn/T/MY_APP/README.md
get dir using path.Dir(), dir: /var/folders/rw/0gwtqtr55hdbnkwp7bt6pkb00000gn/T/MY_APP
get dir using filepath.Dir(), dir: /var/folders/rw/0gwtqtr55hdbnkwp7bt6pkb00000gn/T/MY_APP
```

```bash
// Output on Windows

f: C:\Users\RUNNER~1\AppData\Local\Temp\MY_APP\README.md
get dir using path.Dir(), dir: .
get dir using filepath.Dir(), dir: C:\Users\RUNNER~1\AppData\Local\Temp\MY_APP
```

## Root Cause
Package [path](https://pkg.go.dev/path) should be used for paths separated by forward slashes.

> This package does not deal with Windows paths with drive letters or backslashes; to manipulate operating system paths, use the path/filepath package.

## Solution
Use package [path/filepath](https://pkg.go.dev/path/filepath) instead.

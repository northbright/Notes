# Get a Path Using OS-Specific Separator

## Problem
* [path.Join](https://pkg.go.dev/path#Join) returns a path using slash(`/`)
* Want to get a path using OS-Specific separator(`\` for Windows and `/` for Unix and Linux)

## Solution
* Use [path/filepath](https://pkg.go.dev/path/filepath) package
* [filepath.Join](https://pkg.go.dev/path/filepath#Join) returns a path using OS-Specific separator

## References
* [path/filepath](https://pkg.go.dev/path/filepath)
* [filepath.Join](https://pkg.go.dev/path/filepath#Join)


# Get File Base Name without Ext Name

## Solution
```
// BaseNameWithoutExt returns file base name without ext name.
func BaseNameWithoutExt(fileName string) string {
        base := filepath.Base(fileName)
        ext := filepath.Ext(fileName)

        return base[:len(base)-len(ext)]
}
```

## References
* [How to get a filename without extension in Go](https://freshman.tech/snippets/go/filename-no-extension/)
* [BaseNameWithoutExt](https://pkg.go.dev/github.com/northbright/pathelper@v1.0.6#BaseNameWithoutExt)

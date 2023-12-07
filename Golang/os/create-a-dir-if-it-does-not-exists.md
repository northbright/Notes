# Create a Dir if It Does Not Exists

## Solution
```
// FileExists returns if given file exists or not.
func FileExists(f string) bool {
        _, err := os.Stat(f)
        return !errors.Is(err, fs.ErrNotExist)
}
```

```
// CreateDirIfNotExists creates the directory if it does not exists.
func CreateDirIfNotExists(dir string, perm os.FileMode) error {
        if !FileExists(dir) {
                return os.MkdirAll(dir, perm)
        }
        return nil
}
```

## References
* [CreateDirIfNotExists](https://pkg.go.dev/github.com/northbright/pathelper#CreateDirIfNotExists)
* [How to create a directory if it does not exist in Go](https://freshman.tech/snippets/go/create-directory-if-not-exist/)

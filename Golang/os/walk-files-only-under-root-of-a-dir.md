# Walks Files Only under Root of a Dir

## Method A(recommended)
Use [os.ReadDir](https://pkg.go.dev/os#ReadDir).

```go
// Use os.ReadDir to read files under ROOT of dir.
entries, err := os.ReadDir(dir)
if err != nil {
    return fmt.Errorf("os.ReadDir(%s) error: %v", err)
}

for _, e := range entries {
    // Skip dirs under root.
    if e.IsDir() {
        continue
    }
    
    // Read files under root.
    name := e.Name()
    fmt.Printf("file name: %s\n", name)
}
```

If you need to walk sub dirs recursively, [os.ReadDir](https://pkg.go.dev/os#ReadDir) is also recommend(faster).

```go
func listAllFiles(dir string) ([]string, error) {
    entries, err := os.ReadDir(dir)
    if err != nil {
        return nil, err
    }

    var all []string

    for _, e := range entries {
        if e.IsDir() {
            // Walk sub dirs.
            sub, err := listAllFiles(filepath.Join(dir, e.Name()))
            if err != nil {
                return nil, err
            }

            all = append(all, sub...)
        } else {
            all = append(all, filepath.Join(dir, e.Name()))
        }
    }
    return all, nil
}
```

## Method B(older and slower)
Use [filepath.WalkDir](https://pkg.go.dev/path/filepath#WalkDir) with [filepath.SkipDir](https://pkg.go.dev/path/filepath#pkg-variables).

```go
err := filepath.WalkDir(root, func(path string, d fs.DirEntry, err error) error {
    // Check err first.
    // d is nil while the err is "no such file or directory".
    if err != nil {
        return err
    }
    
    // Allow root dir itself.
    if path == root {
        return nil
    }

    // d is a dir.
    if d.IsDir() {
        // Skip all sub-dirs and do not walk dir recursively.
        return filepath.SkipDir
    }
            
    // d is a file.
    fmt.Printf("file name: %s\n", path)
    ......
    return nil
}

if err != nil {
    fmt.Printf("WalkDir(%s) error: %v", root, err)
    return
}
```


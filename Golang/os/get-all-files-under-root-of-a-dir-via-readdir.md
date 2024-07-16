# Get All Files under Root of a Dir via ReadDir

## Problem
* Need to Get File Name of All ".jpg" File under Root of One Dir(`DIR/*.jpg`)
* [WalkDir](https://pkg.go.dev/path/filepath#WalkDir) Walks All Sub Dirs. We Need to Check if Dir is Root Dir and Skip All Sub Dirs.

## Solution
Get all files under a dir via [ReadDir](https://pkg.go.dev/os#ReadDir)

```go
func GetImgFileNames(dir string) error {
        entries, err := os.ReadDir(dir)
        if err != nil {
                return err
        }

        for _, entry := range entries {
                if entry.IsDir() {
                        continue
                }

                filename := entry.Name()
                if filepath.Ext(filename) == ".jpg" {
                        fmt.Printf("image file name: %v", filename)
                        ......
                }
        }
}
```

## References
* [You Don't Need a Library for File Walking in Go](https://engineering.kablamo.com.au/posts/2021/quick-comparison-between-go-file-walk-implementations/)

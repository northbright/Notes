# Use os.ReadDir to Walk Dir

[os.ReadDir](https://pkg.go.dev/os#ReadDir) and [filepath.WalkDir](https://pkg.go.dev/path/filepath#WalkDir) are added since Go 1.16.

They are much faster than [filepath.Walk](https://pkg.go.dev/path/filepath#Walk):

os.ReadDir and filepath.WalkDir avoid system `stat` calls and traverse a directory several times as fast.
They use [DirEntry](https://pkg.go.dev/io/fs#DirEntry) instead of [fs.FileInfo](https://pkg.go.dev/io/fs#FileInfo).

## References
* [Coming in Go 1.16: ReadDir and DirEntry](https://benhoyt.com/writings/go-readdir/)
* [You Don't Need a Library for File Walking in Go](https://engineering.kablamo.com.au/posts/2021/quick-comparison-between-go-file-walk-implementations/)

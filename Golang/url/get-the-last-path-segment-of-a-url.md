# Get the Last Path Segment of a URL

## Solution
Use [path.Base](https://pkg.go.dev/path#Base) to get the last path segment of a URL.

```go
fmt.Printf(path.Base("https://golang.google.cn/dl/go1.23.1.darwin-amd64.pkg"))
// Output:
// go1.23.1.darwin-amd64.pkg
```

## References
* [How to get the last path segment of a URL in Go](https://freshman.tech/snippets/go/get-last-path-url/)

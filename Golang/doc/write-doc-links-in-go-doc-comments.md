# Write Doc Links in Go Doc Comments

## Solution
* Doc links are links of the form “[Name1]” or “[Name1.Name2]” to refer to exported identifiers in current pacakge
* or “[pkg]”, “[pkg.Name1]”, or “[pkg.Name1.Name2]” to refer to identifiers in other packages
* When referring to other packages, “pkg” can be either a full import path or the assumed package name of an existing import
* A “pkg” is only assumed to be a full import path if it starts with a domain name

```go
// Downloader implements [github.com/northbright/iocopy.Task].
// Pass Downloader to [Do].
type Downloader struct {
}

fun Do() {
......
}
```

## References
* [Go Doc Comments](https://go.dev/doc/comment)
* [How To Write Comments in Go](https://www.digitalocean.com/community/tutorials/how-to-write-comments-in-go)

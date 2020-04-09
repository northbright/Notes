# `GOBIN` is Where `go get` and `go install` Place Binaries

## `GOBIN`
* `GOBIN` is where `go get` and `go install` place binaries after building main packages
* `GOBIN` is set to `""` by default
* If `GOPATH` is set(`~/go` by default) and `GOBIN` is `""`, it should be `GOPATH/bin`

## Check `GOBIN`
```
go env
```

## Get Help of Go Environment
```
go help environment
```

## References
* [GOPATH, GOROOT, GOBIN](https://www.programming-books.io/essential/go/gopath-goroot-gobin-d6da4b8481f94757bae43be1fdfa9e73)
* [How to set GOBIN automatically](https://stackoverflow.com/questions/40067997/how-to-set-gobin-automatically)

# Run [Staticcheck](https://staticcheck.io/)

## Problem
Golint is [deprecated and frozen](https://github.com/golang/go/issues/38968).
There's no drop-in replacement for it, but tools such as [Staticcheck](https://staticcheck.io/)
and `go vet` should be used instead.

## Install [Staticcheck](https://staticcheck.io/)
* Install [Go 1.16 and later](https://golang.google.cn/dl/)
* [Set GOPROXY](https://github.com/northbright/Notes/blob/master/Golang/Install/setup-golang-dev-env-on-mac-os-x.md#set-goproxy) if need
* Run `go install honnef.co/go/tools/cmd/staticcheck@latest`
* [Add go get installed binary path to PATH](https://github.com/northbright/Notes/blob/master/Golang/Install/setup-golang-dev-env-on-mac-os-x.md#add-go-get-installed-binary-path-to-path)

## Run [Staticcheck](https://staticcheck.io/)
```
cd YOUR-GO-PROJECT-DIR
staticcheck
```

## References
* <https://staticcheck.io/docs>

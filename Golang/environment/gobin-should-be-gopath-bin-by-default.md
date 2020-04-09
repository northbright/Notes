# `GOBIN` Should be `GOPATH/bin` by Default

## Go Version
* 1.14.2

## Problem
* After installed Go 1.14.2 on Mac OS X, `GOBIN` is ""
* When [Add vim-go Plugin for VIM on CentOS 7](https://github.com/northbright/Notes/blob/master/Golang/Editor/Add_vim-go_for_vim_on_CentOS_7.md) with run `:GoInstallBinaries`, it downloaded the needed binaries to `~/go/bin`

## Root Cause
* After Go is installed, `GOPATH` is set to `~/go` by default
* If `GOBIN` is ""(by default) and `GOPATH` is set, it's set to `GOPATH/bin` actually
* [vim-go](https://github.com/fatih/vim-go/blob/v1.22/plugin/go.vim#L43) will use `go get` to download the needed packages and install the binaries

## References
* [How to set GOBIN automatically](https://stackoverflow.com/questions/40067997/how-to-set-gobin-automatically)
* [GOPATH, GOROOT, GOBIN](https://www.programming-books.io/essential/go/gopath-goroot-gobin-d6da4b8481f94757bae43be1fdfa9e73)
* [`GOBIN` is Where `go get` and `go install` Place Binaries](gobin-is-where-go-install-and-go-build-place-binaries.md)

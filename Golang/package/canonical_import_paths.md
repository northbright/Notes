# Canonical Import Paths

Go **1.4** introduces an annotation for package clauses in Go source that identify a **canonical import path** for the package.  
If an import is attempted using a path that is **not** canonical, the `go` command will **refuse** to compile the importing package.

## Example
* We want to install [golang.org/x/net/context](https://golang.org/x/net/context)
* But `golang.org` is blocked in China
* Try to install it from mirror: [github.com/golang/net/context](https://github.com/golang/net/tree/master/context)
  * `go get github.com/golang/net/context`
  * It **succeeded** to download all package source code.
  * But we got the error message:

            package github.com/golang/net/context: 
            code in directory /go/src/github.com/golang/net/context
            expects import "golang.org/x/net/context"
* Root Cause
  * The **Canonical** import path of `context` is `golang.org/x/net/context`:  
    in <https://github.com/golang/net/blob/master/context/context.go>

            package context // import "golang.org/x/net/context"

* Workaround
  * Copy `$GOPATH/src/github.com/golang/net/` to `$GOPATH/src/golang.org/x/net`
  * `go build` 
             

# Get Google Golang Packages in China

## Background

Golang.org is blocked in China.

## Problem

Can't run `go get golang.org/x/XX` to get Google Golang packages.

## Solutions

#### Solution A: Use github mirror - <https://github.com/golang>
  1. Get the mirror package name:  
     `golang.org/x/PATH_TO_PACKAGE`  --> `github.com/golang/PATH_TO_PACKAGE`.  
     
            // Ex:
            golang.org/x/net/context --> github.com/golang/net/context
  2. Run 'go get' to download the package source code from github mirror.
  
            // Ex:
            go get github.com/golang/net/context

  3. You'll see error:

            package github.com/golang/net/context: 
            code in directory /go/src/github.com/golang/net/context
            expects import "golang.org/x/net/context"

  4. Don't care about the error.  
     You'll see full source code of the package has been download successfully under `$GOPATH/src/github.com/golang/PATH_TO_PACKAGE`.

  5. Copy `$GOPATH/src/github.com/golang/PATH_TO_PACKAGE` to `$GOPATH/src/golang.org/x/PATH_TO_PACKAGE`.  

          // Ex:
          mkdir $GOPATH/src/golang.org/x -p
          cp $GOPATH/src/github.com/golang/net $GOPATH/src/golang.org/x/ -r

  6. Run `go build` to build the package.

#### Solution B: Use 3rd Party Website - <https://gopm.io/download>
* Just input the package path and download the zip file.

## References
* [Canonical Import Paths(Details of Solution A)](https://github.com/northbright/Notes/blob/master/Golang/package/canonical_import_paths.md)
* [Get Golang Resources Hosted on Golang.org](https://github.com/northbright/bookmarks/blob/master/dev/golang/china/fanqiang/README.md)

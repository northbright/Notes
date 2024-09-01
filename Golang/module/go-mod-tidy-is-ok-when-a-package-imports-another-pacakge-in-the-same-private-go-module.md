# `go mod tidy` is OK when a Package Imports Another Pacakge in the Same Private Go Module

## Description
* `github.com/xx/private_repo` is a Private Repository(Go Module)
* It has a `main` Package(in `/main.go`) and an `util` Package(in `/util/util.go`)
* The `main` Package Imports `util` Package:

  ```go
  package main

  import (
          "fmt"

          "github.com/xx/private_repo/util"
  )

  func main() {
          fmt.Printf("util.Version: %v\n", util.Version()")
  }

  ```
* Run `go build` and `go mod tidy` is OK
  
  Both `main` and `util` packages are in the same Go module even it's private.

## References
* [Using Go Modules with private repositories at Github](https://curiousstuff.eu/post/using-go-modules-with-private-repositories-at-github/)

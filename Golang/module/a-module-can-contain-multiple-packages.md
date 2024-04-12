# A Module Can Contain Multiple Packages

A module can consist of multiple importable packages; each package has its own directory, and can be structured hierarchically. Here’s a sample project structure:

```bash
project-root-directory/
  go.mod
  modname.go
  modname_test.go
  auth/
    auth.go
    auth_test.go
    token/
      token.go
      token_test.go
  hash/
    hash.go
  internal/
    trace/
      trace.go
```

As a reminder, we assume that the module line in `go.mod` says:

```go
module github.com/someuser/modname
```

The modname package resides in the root directory, declares package modname and can be imported by users with:

```go
import "github.com/someuser/modname"
```

Sub-packages can be imported by users as follows:

```go
import "github.com/someuser/modname/auth"
import "github.com/someuser/modname/auth/token"
import "github.com/someuser/modname/hash"
```

## References
* [Organizing a Go module](https://go.dev/doc/modules/layout)

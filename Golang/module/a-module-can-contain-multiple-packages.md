# A Module Can Contain Multiple Packages

A module can contain multiple importable packages.
Each package has its own directory, and can be structued hierachically.

## Example Project

####  Module `task` contains 3 packages:

  * package `task` for generic task, contains the `Task` interface
  * package `copyfile` for copy file task(implements `task.Task` interface)
  * package `download` for download task(implements `task.Task` interface)

#### Structure

```bash
projects-go/task/
  go.mod
  task.go
  task_test.go
  copyfile/
    copyfile.go
    copyfile_test.go
  download/
    download.go
    download_test.go
```

#### `go.mod` in the Module Root Dir

```go
module github.com/xx/task
```

#### Packages Can be Imported as Follows:

```go
import "github.com/xx/task"
import "github.com/xx/task/copyfile"
import "github.com/xx/task/download"
```

## References
* [Organizing a Go module](https://go.dev/doc/modules/layout)

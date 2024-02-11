# Build Go Apps and Test Binaries for Unix-Like OS and Windows

## Problem
* Write a Test / Example Function which Use "fmt.Printf" to Output File Paths
* The Last Comments in the Test Function Starts with "Output:" is Campared Against the Output:

  ```go
  func ExampleMyFunc() {
      ......
      fmt.Printf(file path: %v\n", path)
      ......

      // Output:
      //PATH/To/File
  }
  ```
* Test Fails on Windows due to Different Path Separators("/" for Unix-Like OS and "\" for Windows)

## Solution
Build go apps and test packages binaries for Unix-Like OS and Windows.

1. Use `GOOS` Filename Suffixes

  * For Unix-Like OS:
    * `xx_unix.go`,
    * `xx_unix_test.go`(test package)
  * For Windows:
    * `xx_windows.go`
    * `xx_windows_test.go`(test package)

2. Add "go:build" Tags
  * For Unix-Like OS:
    Because there's no such "unix" GOOS, we need add a build tag to specify GOOS in `_unix.go` or `_unix_test.go`
    ```go
    //go:build !windows && !plan9
    ```
    
    e.g. [path/filepath/example_unix_test.go](https://github.com/golang/go/blob/go1.22.0/src/path/filepath/example_unix_test.go)
    ```go
    //go:build !windows && !plan9

    package filepath_test
    ......
    ```
  * For Windows:
    **NO** need to add a build tag for Windows because the suffix(`_windows`) on the filename sufficed to tell Go which platform the file was meant for.
    So the `_windows.go` or `_windows_test.go` contains no build tags.

    e.g. [path/filepath/export_windows_test.go](https://github.com/golang/go/blob/go1.22.0/src/path/filepath/export_windows_test.go)

## References
* [Building Go Applications for Different Operating Systems and Architectures](https://www.digitalocean.com/community/tutorials/building-go-applications-for-different-operating-systems-and-architectures)
* <https://github.com/golang/go/tree/go1.22.0/src/path/filepath>

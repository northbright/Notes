# Call Code from Local Unpublished Module

## Problem
* Module A Has a Sub Module(sub dir): Module B

  Dir structure looks like:

  ```
  /home/xx/projects/a
  /home/xx/projects/a/b
  ```  

* Module B Needs to Import Module A when Module A is NOT Published

## Solution
* Initialize Module A

  ```
  go mod init github.com/xx/a
  ```

* Add Code in Module B

  ```
  import "github.com/xx/a"

  func B() {
      a.A()
  }
  ```

* Initialize Module B

  ```
  cd /home/xx/projects/a/b
  ```

  ```
  go mod init github.com/xx/a/b
  ```

* Redirect Module A's Path from `"github.com/xx/a"` to Local Path(`"../"`)

  ```
  go mod edit -replace github.com/xx/a=../
  ```

  * `go.mod` of Module B

    ```
    module xx/a/b

    go 1.21.3

    replace github.com/xx/a => ../                         
    ```

* Run `go mod tidy` to Synchronize Module B's Dependencies

  ```
  go mod tidy
  ```

  * `go.mod` of Module B

    ```
    module xx/a/b

    go 1.21.3
  
    replace github.com/xx/a => ../ 

    require github.com/xx/a v0.0.0-00010101000000-000000000000   
    ```

## References
* [Call your code from another module](https://go.dev/doc/tutorial/call-module-code)


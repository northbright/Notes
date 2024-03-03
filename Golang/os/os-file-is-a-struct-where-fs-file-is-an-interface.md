# `os.File` is a Struct where `fs.File` is an Interface

* [os.Open](https://pkg.go.dev/os#Open) Returns a [os.File](https://pkg.go.dev/os#File) which is a Struct
* To Open File in [fs.FS](https://pkg.go.dev/os#File), Call Open() and It Returns a [fs.File](https://pkg.go.dev/io/fs#File) which is an Interface.

## Problem
* Need to Design a Function, Accept the "File" which may be [os.File](https://pkg.go.dev/os#File) or [fs.File](https://pkg.go.dev/io/fs#File) as Parameter
* It'll Call Read() and Close() on the "File" in the Function
* Use Only Parameter to Accept 2 Types of "File"

## Solution
Use [io.ReadCloser](https://pkg.go.dev/io#ReadCloser) interface as the Parameter. 

* Convert [os.File](https://pkg.go.dev/os#File) Struct to `io.ReadCloser`

  ```
  f, _ := os.Open(path)
  readCloser := io.ReadCloser(f)
  ```

* Convert [fs.File](https://pkg.go.dev/io/fs#File) Interface to `io.ReadCloser`

  * Type Convertion
  
    ```
    var fsys fs.FS

    f, _ := fsys.Open(path)
    readCloser := io.ReadCloser(f)
    ```

  * Type Assertion

    ```
    var fsys fs.FS

    f, _ := fsys.Open(path)
    readCloser := f.(io.ReadCloser)
    ```

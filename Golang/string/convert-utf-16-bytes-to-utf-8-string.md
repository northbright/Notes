# Convert UTF-16 Bytes to UTF-8 String

## Problem
* Golang apps calls `os/exec.Command` to run`Powershell` while it returns unicode output in UTF-16
* Golang apps need to parse the output to UTF-8 string

## Details
* [`windows.UTF16ToString()`](https://godoc.org/golang.org/x/sys/windows#UTF16ToString) of [`golang.org/x/sys/windows` ](https://godoc.org/golang.org/x/sys/windows) is the Golang offical implementation
* Souce code of [`UTF16ToString()`](https://github.com/golang/go/blob/release-branch.go1.11/src/syscall/syscall_windows.go#L48)  can be found in [syscall_windows.go](https://github.com/golang/go/blob/release-branch.go1.11/src/syscall/syscall_windows.go):

   ```
   // UTF16ToString returns the UTF-8 encoding of the UTF-16 sequence s,
   // with a terminating NUL removed.
   func UTF16ToString(s []uint16) string {
       for i, v := range s {
       if v == 0 {
           s = s[0:i]
               break
           }
       }
       return string(utf16.Decode(s))
   }
  ```
  * It'll generate the code under `x/sys/windows` package via [`Generate()`](https://github.com/golang/go/blob/release-branch.go1.11/src/syscall/mksyscall_windows.go#L718)

## Solution
* Method A: Copy and paste souce code of [`UTF16ToString()`](https://github.com/golang/go/blob/release-branch.go1.11/src/syscall/syscall_windows.go#L48) into your code is the **simplest** way
* Method B: Import `golang.org/x/sys/windows` and call `UTF16ToString()`
   * It works for the apps build for **Windows** platform **ONLY**

     `env GOOS=windows GOARCH=amd64 go build -v`
   * Packages under `golang.org/x/` can not be download / install via `go get` successfully without V*P*N in China
      But there's a workaround: [Get Golang Packages on Golang.org in China](https://github.com/northbright/Notes/blob/master/Golang/china/get-golang-packages-on-golang-org-in-china.md)  

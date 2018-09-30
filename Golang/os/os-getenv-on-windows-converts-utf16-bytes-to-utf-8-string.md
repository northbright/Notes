# `os.Getenv()` on Windows Converts the UTF-16 Bytes to UTF-8 String

## Details
* [`os.Getenv()`](https://github.com/golang/go/blob/release-branch.go1.11/src/syscall/env_windows.go#L14) will invoke `kernel32.GetEnvironmentVariableW` as syscall for [`GetEnvironmentVariable()`](https://github.com/golang/go/blob/release-branch.go1.11/src/syscall/syscall_windows.go#L189):

      //sys GetEnvironmentVariable(name *uint16, buffer *uint16, size uint32) (n uint32, err error) = kernel32.GetEnvironmentVariableW

* Windows calls `GetEnvironmentVariableW` and pass the env variable in `uint16` buffer(`UTF-16` bytes)
* It calls [utf16.Decode()](https://godoc.org/unicode/utf16#Decode) to do the conversion
  * [utf16.Decode()](https://godoc.org/unicode/utf16#Decode) returns `[]rune`
  * `string([]rune)` converts `[]rune` to a `UTF-8` string

## References
* [Convert UTF-16 Bytes to UTF-8 String](https://github.com/northbright/Notes/blob/master/Golang/string/convert-utf-16-bytes-to-utf-8-string.md)

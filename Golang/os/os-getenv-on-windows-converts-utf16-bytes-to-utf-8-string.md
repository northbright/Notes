# `os.Getenv()` on Windows Converts the UTF-16 Bytes to UTF-8 String

## Details
* [`os.Getenv()`](https://github.com/golang/go/blob/50bd1c4d4eb4fac8ddeb5f063c099daccfb71b26/src/syscall/env_windows.go#L14) will invoke `kernel32.GetEnvironmentVariableW` as syscall for [`GetEnvironmentVariable()`](https://github.com/golang/go/blob/76c45877c9e72ccc84db787dc08299e0182e0efb/src/syscall/syscall_windows.go#L190):

      //sys GetEnvironmentVariable(name *uint16, buffer *uint16, size uint32) (n uint32, err error) = kernel32.GetEnvironmentVariableW

* Windows calls `GetEnvironmentVariableW` and pass the env variable in `uint16` buffer(`UTF-16` bytes)
*  [`os.Getenv()`](https://github.com/golang/go/blob/50bd1c4d4eb4fac8ddeb5f063c099daccfb71b26/src/syscall/env_windows.go#L14) use [UTF16ToString()](https://github.com/golang/go/blob/76c45877c9e72ccc84db787dc08299e0182e0efb/src/syscall/syscall_windows.go#L49) to decode the `UTF-16` bytes to `UTF-8` string:

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
    * [utf16.Decode()](https://godoc.org/unicode/utf16#Decode) is the key function to decode `UTF-16` bytes to `[]rune`
    * `string([]rune)` converts `[]rune` to string directly

# `@` Symbol Means a File Has Extended Attributes

## Problem
* Run `ls` on macOS and got the result:

  ```
  -rw-r--r--@ 1 xxu  staff   675K  3 10 15:39 26.png
  ```
* What does `@` mean in permission?

## Root Cause
`@` Symbol Means a File Has Extended Attributes(metadata).


## Show the Metadata
* Method A

  Run `xattr -l <FILE>` 

  ```
  xattr -l

  com.apple.lastuseddate#PS: a?
  d
  com.apple.quarantine: 0082;640adc62;Preview;
  ```

* Method B

  Run `ls -la@ <FILE>`

  ```
  ls -la@ 26.png 
  
  -rw-r--r--@ 1 xxu  staff   675K  3 10 15:39 26.png
        com.apple.lastuseddate#PS	  16B 
	com.apple.quarantine	  22B 
  ```

## Remove the Metadata
Run `xattr -c <FILE>` to remove the metadata and make it writable again on macOS.

## References
* [File Permissions mode ending in @ or +](https://unix.stackexchange.com/questions/92071/file-permissions-mode-ending-in-or)
* [What does the @ symbol mean in a file's permission settings?](https://serverfault.com/questions/151997/what-does-the-symbol-mean-in-a-files-permission-settings)


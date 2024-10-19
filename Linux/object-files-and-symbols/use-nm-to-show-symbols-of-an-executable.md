# Use nm to Show Symbols of an Executable

## Problem
* Show the functions used by an exectuable but not in the exectuable.
  The functions should be in dynamic libs.

* Show the functions in an executable.

## Solution

#### Show the functions used by an exectuable but not in the exectuable 
Run `nm` with `-u` option to display only **undfined** symbols.

For example:
 
```bash
nm -u ~/fsleuth

// Output:
// _BZ2_bzDecompress
// _BZ2_bzDecompressInit
// ___error
// _atoi
// _calloc
// _close
// _ctime
// _exit
// _fchmod
// _fclose
// _fdopen
......
```

* We may use `otool` to show which libs contain these undefined functions:

```bash
otool -L fsleuth

// Output:
// /Users/xx/fsleuth:
// /usr/lib/libz.1.dylib (compatibility version 1.0.0, current version 1.2.11)
// /usr/lib/libbz2.1.0.dylib (compatibility version 1.0.0, current version 1.0.5)
// /usr/lib/libSystem.B.dylib (compatibility version 1.0.0, current version 1252.200.5)
```

#### Show the functions in an executable
Run `nm` with `-U` to display only **NOT** undefined symbols.

For example:

```bash
nm -U ~/fsleuth

// Output:
// 000000010000f000 T _APFSDumpAllocInfo
// 000000010000f190 T _APFSDumpSpaceMan
// 0000000100021050 S _APFSVolumes
// 0000000100004c20 T _Error
// 000000010000cf80 T _Fletcher64
// ......
```

## References
* [Object Files and Symbols](http://nickdesaulniers.github.io/blog/2016/08/13/object-files-and-symbols/)
* [Static and Dynamic Libraries](http://nickdesaulniers.github.io/blog/2016/11/20/static-and-dynamic-libraries/)

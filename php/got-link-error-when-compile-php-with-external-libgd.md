# Got Link Error when Compile PHP with External libgd

## Problem
* Compiled libgd 2.3.0 from source on CentOS 8
* Compile PHP 7.4.4 from source on CentOS 8
* use `--enable-gd` and `--with-external-gd` options
* Specify `PKG_CONFIG_PATH` to install path of libgd
* Got link error:

  ```
  ext/gd/gd.c:1248: undefined reference to `gdFontCacheShutdown'
  collect2: error: ld returned 1 exit status
  ```

## Root Cause
`gdFontCacheShutdown` not found in `libgd.so`

```
readelf -a /usr/local/libgd/lib/libgd.so | grep gdFontCacheShutdown
```

## Solution
Use bundled libgd instead of external libgd

```
--enable-gd
```
  

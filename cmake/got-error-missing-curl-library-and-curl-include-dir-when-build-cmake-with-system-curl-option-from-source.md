# Got Error: Missing CURL_LIBRARY and CURL_INCLUDE_DIR When Build CMake with --system-curl Option from Source

## Problem
* Compile CMake from source
* Want to use system curl(latest CURL) instead the one provided by CMake itself
* Run `./bootstrap` like this:

  ```
  CURL_LIBRARY=/PATH/to/CURL/LIB \
  CURL_INCLUDE_DIR=/PATH/to/CURL/include \
  ./bootstrap --prefix=/usr/local/cmake \
  --system-curl
  ```
* Got error:

  > Missing CURL_LIBRARY and CURL_INCLUDE_DIR

* It seems setting `CURL_LIBRARY` and `CURL_INCLUDE_DIR`
still not work
* [Modules/FindCURL.cmake](https://github.com/Kitware/CMake/blob/v3.16.5/Modules/FindCURL.cmake) uses [find_library](https://cmake.org/cmake/help/latest/command/find_library.html) to find CURL

## Solution
* Set `CURL_ROOT` instead of `CURL_LIBRARY` and `CURL_INCLUDE_DIR`

## Example
Set `ZLIB_ROOT`, `CURL_ROOT` for `--system-zlib` and `--system-curl`

```
ZLIB_ROOT=/usr/local/zlib/ \
CURL_ROOT=/usr/local/curl/ \
./bootstrap --prefix=/usr/local/cmake \
--system-zlib \
--system-curl
```

## References
* [find_library](https://cmake.org/cmake/help/latest/command/find_library.html)
* [Specify `--system-zlib` or `--system-curl` Will Enable `RPATH` When Compiling CMake from Source](specify-system-zlib-or-curl-will-enable-rpath-when-build-cmake-from-source.md)

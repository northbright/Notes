# Specify `--system-zlib` or `--system-curl` Will Enable `RPATH` When Compiling CMake from Source

## Problem
* Make CMake from source
* Want to use latest zlib or curl(installed from source) instead of the one provided by CMake itself

## Solution
* CMake will enable RPATH only if `CMAKE_USE_SYSTEM_CURL` or `CMAKE_USE_SYSTEM_ZLIB` is set to TRUE
* Check [CMakeLists.txt](https://github.com/Kitware/CMake/blob/v3.16.5/CMakeLists.txt#L750)

  ```
  # The same might be true on other systems for other libraries.
  # Then only enable RPATH if we have are building at least with cmake 2.4,
  # since this one has much better RPATH features than cmake 2.2.
  # The executables are then built with the RPATH for the libraries outside
  # the build tree, which is both the build and the install RPATH.
  if (UNIX)
     if(   CMAKE_USE_SYSTEM_CURL   OR  CMAKE_USE_SYSTEM_ZLIB
         OR  CMAKE_USE_SYSTEM_EXPAT  OR  CURSES_NEED_RPATH  OR  QT_NEED_RPATH)
     set(CMAKE_SKIP_RPATH OFF CACHE INTERNAL "CMake built with RPATH.")
     set(CMAKE_INSTALL_RPATH_USE_LINK_PATH TRUE)
     set(CMAKE_BUILD_WITH_INSTALL_RPATH TRUE)
     endif()
  endif ()   
  ``` 

## Steps
* [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)
* [Install Latest cURL from Source on CentOS](https://github.com/northbright/Notes/blob/master/curl/install-latest-curl-from-source-on-centos.md)
* Configure CMake
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
* [Why is CMake designed so that it removes runtime path when installing](https://stackoverflow.com/questions/32469953/why-is-cmake-designed-so-that-it-removes-runtime-path-when-installing/)
* [CMAKE RPATH not working - could not find shared object file](https://stackoverflow.com/questions/30398238/cmake-rpath-not-working-could-not-find-shared-object-file)

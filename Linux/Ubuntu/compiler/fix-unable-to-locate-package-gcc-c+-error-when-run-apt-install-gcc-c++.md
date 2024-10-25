# Fix "Unable to locate package gcc-c+" Error when Run "apt install gcc-c++"

## Problem
* Ubuntu 24.04 Server
* Follow the instruction to install develop tools for building [APFS FUSE Driver for Linux](https://github.com/northbright/apfs-fuse)
  ```bash
  sudo apt install fuse libfuse3-dev bzip2 libbz2-dev cmake gcc-c++ git libattr1-dev zlib1g-dev
  ```

  Got error:

  > Unable to locate package gcc-c+

## Solution
Separate "gcc-c++" package into "gcc" and "g++" packages.

```bash
sudo apt install gcc g++
```

## References
* [linux安装gcc-c++报错Unable to locate package gcc-c+](https://blog.csdn.net/changyana/article/details/123288128)
* [How to Install G++ (C++ Compiler) on Ubuntu](https://linuxconfig.org/how-to-install-g-the-c-compiler-on-ubuntu-20-04-lts-focal-fossa-linux)
* [How to Install GCC on Ubuntu 24.04, 22.04, or 20.04](https://linuxcapable.com/how-to-install-gcc-compiler-on-ubuntu-linux/)

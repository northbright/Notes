# Reset WSL Linux Distro

## Problem
* Installed Ubuntu-24.04 in WSL
* Need to reset all in Ubuntu

## Solution
* Unregister Linux Distro

  Warning: all data will be removed, please backup if need.

  ```sh
  wsl --unregister <Distro Name>
  ```

  e.g.

  ```sh
  wsl --register Ubuntu-24.04
  ```

* Install Linux Distro Again

  ```sh
  wsl --install -d <Distro Name>
  ```

  e.g.
  ```sh
  wsl --install -d Ubuntu-24.04
  ```

## References
* [WSL 的基本命令](https://learn.microsoft.com/zh-cn/windows/wsl/basic-commands)

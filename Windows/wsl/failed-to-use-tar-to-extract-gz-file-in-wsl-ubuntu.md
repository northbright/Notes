# Failed to Use tar to Extract tar.gz File in WSL Ubuntu

## Problem
* Install WSL on Windows 10
* Install Ubuntu 22.04 Distro for WSL
* Failed to extract *.tar.gz and got "EF not found" error

## Root Cause
* WSL version is 1

## Solution
Set default WSL version and distro(Ubuntu 22.04) WSL version to 2

* Run Powershell as administrator

  ```
  // List installed distro
  wsl -l -v
  // Output:
  NAME         STATE   VERSION
  Ubuntu-22.04 Running 1 
  
  // Set default WSL version to 2
  wsl --set-default-version 2

  // Set distro WSL version to 2
  // wsl --set-version <Distro Name> <version>
  wsl --set-version Ubuntu-22.04 2
  ```

## References
* [gzip from Ubuntu Eoan doesn't execute #4461](https://github.com/microsoft/WSL/issues/4461)
* [How to Convert WSL 1 Linux Distribution to WSL 2 in Windows Subsystem for Linux](https://www.configserverfirewall.com/windows-10/convert-wsl-1-linux-distribution-to-wsl-2/)

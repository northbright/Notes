# Fix "0x80370102" Error when Install Linux Distro for WSL 2

## Problem
* HP Z228 Workstation with Windows 10 Home Installed
* Got "WslRegisterDistribution error 0x80370102" when Install Ubuntu for WSL 2

  * Run Powershell as Administrator
  * Run `wsl --install` or `wsl --install -d ubuntu`

## Root Cause
* Virtualization Techology(VTx) in BIOS Settings is Disabled

## Solution
Enable VTx in BIOS settings. 

* Press F10 > BIOS Settings > System Security > Enable VTx and VTd(Optional) > Save and Reboot

## References
* [Resolving WslRegisterDistribution error 0x80370102 when installing Linux Distro for WSL 2?](https://answers.microsoft.com/en-us/windows/forum/all/resolving-wslregisterdistribution-error-0x80370102/412cf42b-1424-444c-bb95-4aa2b5fe5eaf)

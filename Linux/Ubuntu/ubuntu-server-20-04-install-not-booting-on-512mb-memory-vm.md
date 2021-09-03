# Ubuntu Server 20.04 LTS Not Booting on 512 MB Memory VM

## Problem
* Download the [ubuntu-20.04.3-live-server-amd64.iso](https://ubuntu.com/download/server#downloads)
* Create a new VM and set memory size to 512 MB
* Failed to boot the VM and got kernel error message

## Root Cause
* There're 2 versions of installer(image)
  * The di(debian-installer)
  * The live version which need more RAM
* The only available version of Ubuntu 20.04 is live

## Solution
* Set the memory size to 1 GB and it works

## References
* [20.04 Server Install not booting on low memory VM](https://askubuntu.com/questions/1230191/20-04-server-install-not-booting-on-low-memory-vm)
* [Server installer plans for 20.04 LTS](https://discourse.ubuntu.com/t/server-installer-plans-for-20-04-lts/13631)

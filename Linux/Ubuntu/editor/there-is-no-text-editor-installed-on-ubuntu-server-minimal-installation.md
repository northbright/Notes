# There is No Text Editor Installed on Ubuntu Server Minimal Installation

## Problem
* Install Ubuntu Server 22.04 with Minimal Installation
* Run "sudo update-alternatives --config editor" and got error:

  > update-alternatives: error: no alternatives for editor

## Root Cause

There's no text editor installed on Ubuntu Server 22.04 with minimal installation.

## Solution
Just intall your favorite editor(e.g. vim)

```
sudo apt install vim
```

## References
* [Default text editor for Ubuntu Server 22.04 LTS minimal installation](https://askubuntu.com/questions/1415186/default-text-editor-for-ubuntu-server-22-04-lts-minimal-installation)

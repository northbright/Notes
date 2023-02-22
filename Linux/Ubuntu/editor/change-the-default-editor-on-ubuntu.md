# Change the Default Editor on Ubuntu

## Problem
* The default editor on Ubuntu 22.04 is nano
* Want to use vim as the default editor

## Solution

```
sudo update-alternatives --config editor
```

Type the number of the editor you want and enter.


* You may get the error when you use Ubuntu Server 22.04 minimal install:

  > update-alternatives: error: no alternatives for editor

  Because [There is No Text Editor Installed on Ubuntu Server 22.04 Minimal Installation](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/editor/there-is-no-text-editor-installed-on-ubuntu-server-22-04-minimal-installation.md) 
  You can install your prefered editor(e.g. vim):

  ```
  sudo apt install vim
  ```

## References
* [Change the Default Editor From Nano on Ubuntu Linux](https://www.howtogeek.com/140/change-the-default-editor-from-nano-on-ubuntu-linux/)



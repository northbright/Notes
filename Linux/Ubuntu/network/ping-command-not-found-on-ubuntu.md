# ping Command Not Found on Ubuntu

## Problem
* Installed Ubuntu 24.04.1 on a PC
* Run `ping` and got "command not found" error

## Solution
Run `sudo apt install iputils-ping` to get `ping`.

```bash
sudo apt install iputils-ping -y
```

## References
* [Install ping Command on Ubuntu](https://learnubuntu.com/install-ping/)

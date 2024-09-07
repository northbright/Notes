# Install OpenSSH Server on Ubuntu Desktop

## Problem
* Need to install ssh server on Ubuntu Desktop 24.04.01.

## Solution

```bash
sudo apt install openssh-server
```

```bash
sudo systemctl enable ssh
sudo systemctl start ssh
```

## References
* [Ubuntu Linux install OpenSSH server](https://www.cyberciti.biz/faq/ubuntu-linux-install-openssh-server/)

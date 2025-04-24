# Install Ubuntu Server from USB Disk

## Installation

#### Create Bootable USB Disk with Ubuntu Server ISO
* [Create a Bootable Ubuntu USB Drive on macOS with dd](https://github.com/northbright/Notes/blob/master/macos/disk/create-a-bootable-ubuntu-usb-drive-on-macos-with-dd.md)

#### Customize Storage Layout
* [Configure SSD and HDD Storage When Install Ubuntu Server](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/configure-ssd-and-hdd-storage-when-install-ubuntu-server.md)

#### Create an User(in `sudo` Group)
* Ubuntu Server Disable Root User by Default
* It Requires to Input User Name and Password to Create an User
* The Created User Will be Added to `sudo` Group

#### Install Open SSH Server
* Check "Install Open SSH Server" Option and Continue

#### Remove USB Disk and Reboot
* Remove USB Disk and Reboot the PC

## Configuration

#### Install `vim`
```bash
sudo apt update
sudo apt install vim
```

#### Add a New User(Optional)
* Create an User with Home Dir

  ```bash
  sudo adduser xx
  ```

* Allow Added User to Run Any Commands Anywhere

  ```bash
  sudo visudo
  ```

  ```
  ## Find Allow root to run any commands anywhere
  ## Add xx under root
  root    ALL=(ALL)       ALL
  xx      ALL=(ALL)       ALL
  ```

#### Check and Disable Root SSH Login(Optional)
* Modify `/etc/ssh/sshd_config`.

  ```bash
  sudo vi /etc/ssh/sshd_config
  ```

  ```
  ## Append these lines
  PermitRootLogin no
  ```

* Restart `ssh` Service

  ```bash
  sudo systemctl restart ssh.service
  ```

* Re-login as new user: xx

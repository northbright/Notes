# Disable root SSH Login

## Problem
* To secure the system, it's better to use a separate account to login via SSH and disable `root` SSH login

## Steps

#### Ubuntu
* Add an User

  ```bash
  sudo adduser xx
  ```

* Allow Added User to Run Any Commands Anywhere

  ```
  sudo visudo
  ```

  ```
  ## Find Allow root to run any commands anywhere
  ## Add xx under root
  root    ALL=(ALL)       ALL
  xx      ALL=(ALL)       ALL  
  ```

* Disable Root SSH Login

  Modify `/etc/ssh/sshd_config`.

  ```bash
  vi /etc/ssh/sshd_config
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

#### CentOS
* Login as `root`
* Add User and Set Password

  ```bash
  adduser xx
  passwd xx 
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

* Disable Root SSH Login

  Modify `/etc/ssh/sshd_config`.

  ```bash
  vi /etc/ssh/sshd_config
  ```

  ```
  ## Find PermitRootLogin and set it to no
  PermitRootLogin no
  ```

* Restart `sshd` Service

  ```bash
  sudo service sshd restart
  ```
* Re-login as new user: xx

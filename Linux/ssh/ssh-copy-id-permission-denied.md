# `ssh-copy-id` Permission Denied

## Problem

We want to user public key authentication and disable password authentication

* Configure sshd service on a new server

  ```
  sudo vi /etc/ssh/sshd_config
  ```

  ```
  PermitRootLogin no
  PasswordAuthentication no
  PubkeyAuthentication yes
  AuthorizedKeysFile     .ssh/authorized_keys .ssh/authorized_keys2
  ``` 

  ```
  // Restart sshd service
  sudo service sshd restart
  ```

* Got `permission denied` When Run `ssh-copy-id -i ~/.ssh/id_rsa.pub xx@xx.com` on Client

## Root Cause
* Need to login to copy public key to server via `ssh-copy-id`
* We don't have any access to the remote machine
  * Invalid key
  * Password authentication disabled

## Solution
* Set `PasswordAuthentication` to `yes` first
* Run `ssh-copy-id -i ~/.ssh/id_rsa.pub xx@xx.com` to install the public key
* After run `ssh xx@xx.com` successfully, re-set `PasswordAuthentication` to `no` and restart `sshd` service

## References
* [ssh-copy-id - permission denied (publickey)](https://serverfault.com/questions/684346/ssh-copy-id-permission-denied-publickey)
* [Permission denied (publickey) while copying id](https://askubuntu.com/questions/1356521/permission-denied-publickey-while-copying-id)
* [Congiure Passwordless Login](configure-passwordless-login.md)

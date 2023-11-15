# Meaning of "Connection closed by xxx [preauth]" in SSH Log

## Problem
* Add Mac's Public Key to Remote Server's `~/.ssh/authorized_keys` via `ssh-copy-id`
* Use Public Key Authentication for SSH Login
* Re-Install masOS and Forget to Backup All Private / Public keys under `~/.ssh/`
* Got `public key` Error when SSH Login Remote Server Again
* Find "Connection closed by xxx [preauth]" in SSH Log on Remote Server(`/var/log/auth.log`)

## Root Cause
* `[preauth]` means that the logged event happened before the connection was authenticated — i.e. in this case that the connection is closed before being authenticated.
* The client's `~/.ssh/id_rsa.pub` may be not added to the server's `~/.ssh/authorized_keys`

## Solution
* Re-Generate Client's Private / Pubic Key Pair and Add the Public to Remote Server's `~/.ssh/authorized_keys` 

## References
* [How to View SSH Logs?](https://www.strongdm.com/blog/view-ssh-logs)
* [How to check sshd log?](https://serverfault.com/questions/130482/how-to-check-sshd-log)
* [SSH Permission denied (publickey) - fail at preauth step](https://superuser.com/questions/1337346/ssh-permission-denied-publickey-fail-at-preauth-step)
* [Understanding sshd logs](https://unix.stackexchange.com/questions/499982/understanding-sshd-logs)
* [Meaning of “Connection closed by xxx [preauth]” in sshd logs](https://unix.stackexchange.com/questions/102502/meaning-of-connection-closed-by-xxx-preauth-in-sshd-logs)

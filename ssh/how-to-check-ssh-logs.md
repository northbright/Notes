# How to Check SSH Logs

## Use `journalctl`

* All SSH Logs

```
sudo journalctl -u ssh
```

* Logs since Yesterday

```
sudo journalctl -u ssh --since yesterday
```

* Logs from Last 2 Hours

```
sudo journalctl -u ssh --since -2h
```

## Check `/var/log/auth.log`
```
sudo grep 'sshd' /var/log/auth.log
```

## Meaning of “Connection closed by xxx [preauth]” in sshd logs
* `[preauth]` means that the logged event happened before the connection was authenticated — i.e. in this case that the connection is closed before being authenticated.
* The client's `~/.ssh/id_rsa.pub` may be not added to the server's `~/.ssh/authorized_keys`

## References
* [How to View SSH Logs?](https://www.strongdm.com/blog/view-ssh-logs)
* [How to check sshd log?](https://serverfault.com/questions/130482/how-to-check-sshd-log)
* [SSH Permission denied (publickey) - fail at preauth step](https://superuser.com/questions/1337346/ssh-permission-denied-publickey-fail-at-preauth-step)
* [Understanding sshd logs](https://unix.stackexchange.com/questions/499982/understanding-sshd-logs)
* [Meaning of “Connection closed by xxx [preauth]” in sshd logs](https://unix.stackexchange.com/questions/102502/meaning-of-connection-closed-by-xxx-preauth-in-sshd-logs)

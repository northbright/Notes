# Use `journalctl` to View `systemd` Logs

## Basic Usage
```bash
// Show Nginx service logs since today.
sudo journalctl -u nginx.service --since today
```

## References
* [How To Use Journalctl to View and Manipulate Systemd Logs](https://www.digitalocean.com/community/tutorials/how-to-use-journalctl-to-view-and-manipulate-systemd-logs)
* [Beginner's Guide to Analyzing Logs in Linux With journalctl Command](https://linuxhandbook.com/journalctl-command/)

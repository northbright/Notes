# Failed to Connect Samba Share after Changing IP of Server

## Problem
* Set up a samba share followed [Setup Samba Share on Ubuntu](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/samba/setup-samba-share-on-ubuntu.md)
* `bind interfaces only = true` and `interfaces = lo eno1` which `eno1` is ethernet card
* Change IP of server and run `sudo netplan apply`
* Can not connect to Samba share from other PCs
* Can connect successfully using localhost address via smbclient:

  ```bash
  smbclient //localhost/share --user XX
  ```

## Root Cause
* `smbd.service` failed to get address, see `/var/log/samba/smb.log`:

   > can't find address for eno1

## Solution
* Restart `smbd.service` after IP changed

  ```bash
  sudo systemctl restart smbd
  ```

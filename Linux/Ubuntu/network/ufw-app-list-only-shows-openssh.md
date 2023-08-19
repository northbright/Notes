# `sudo ufw app list` Only Shows OpenSSH

## Problem
* Installed Ubuntu Server 22.04 on a Server
* Minimized Installation(No Applicaton is selected)
* OpenSSH Server is Installed
* Install `ufw` Firewall and Want to Add `Samba` Profile
* Got `ERROR: Could not find profile 'PROFILE'`
* Run `sudo ufw app list` to Show All Profiles / Applications and the Output Only Shows `OpenSSH`

  ```
  sudo ufw app list

  Available applications:
  OpenSSH
  ```

## Root Cause
Upon installation, applications that rely on network communications will typically set up a UFW profile.

The profile will be created under `/etc/ufw/applications.d/{APP_NAME}`(e.g. `/etc/ufw/applications.d/samba`).

## Solution
Install the application(e.g. Samba) and then run `sudo ufw app list`

```
sudo ufw app list

Available applications:
  OpenSSH
  Samba
```

Now, you can find the Samba Application / Profile.

Run `sudo ufw allow APP_NAME`(e.g. sudo ufw allow samba) to Add the Rule.

## References
* [UFW Essentials: Common Firewall Rules and Commands](https://www.digitalocean.com/community/tutorials/ufw-essentials-common-firewall-rules-and-commands)
* [How To Set Up a Firewall with UFW on Ubuntu 18.04](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-firewall-with-ufw-on-ubuntu-18-04)

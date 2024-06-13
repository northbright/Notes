# Change Computer Name on Ubuntu

## Solution
* Disable `preserve_hostname`(set it to `false`) in `/etc/cloud/cloud.cfg`

  ```
  sudo vi /etc/cloud/cloud.cfg
  ```

  ```
  # Set preserve_hostname to false to preserve hostname after hostname is updated
  preserve_hostname: false
  ```

* Run `hostnamectl set-hostname` to change the computer name

  ```
  sudo hostnamectl set-hostname NEW_COMPUTER_NAME
  ```

* Reboot

  To make other PCs can access the pc with the new name(e.g. `ping XX` or visit samba share: `\\XX`), reboot the pc.

  ```
  sudo reboot
  ```

## References
* [How do I change the computer name?](https://askubuntu.com/questions/9540/how-do-i-change-the-computer-name)

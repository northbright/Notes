# Data and Time Need to be Set After Restore Snapshot If ntp Is Not Installed

## Problem
* Restore a snapshot and found data / time is incorrect(time of snapshot created)
* No ntp service is installed and configured

## Solution
* Set data and time
 
      // Set date time
      sudo timedatectl set-time "YYYY-MM-DD HH:MM:SS"
      
      // Check
      timedatectl

## References
* [How to sync your date when you restore a VirtualBox snapshot?](https://mythinkpond.com/2016/11/05/how-to-sync-your-date-when-you-restore-a-virtualbox-snapshot/)
* [Linux Set Date and Time From a Command Prompt](https://www.cyberciti.biz/faq/howto-set-date-time-from-linux-command-prompt/)

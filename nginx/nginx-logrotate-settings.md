# Nginx Logrotate Settings

## Problem
* Installed Nginx on Ubuntu via apt-get
* It rotates log daily and keeps 14 different log files by default
* Want to keep more log files(e.g. 60 files(days))

## Solution
* Nginx uses [logrotae](https://linux.die.net/man/8/logrotate) to rotate the log
* Goto `/etc/logrotate.d/nginx`

  `daily` means it rotates the log daily
  `rotate` is the number of log files you want to keep

  ```
  /var/log/nginx/*.log {
          daily
          missingok
          rotate 60
          compress
          delaycompress
          notifempty
          create 0640 www-data adm
          sharedscripts
          prerotate
                  if [ -d /etc/logrotate.d/httpd-prerotate ]; then \
                          run-parts /etc/logrotate.d/httpd-prerotate; \
                  fi \
          endscript
          postrotate
                  invoke-rc.d nginx rotate >/dev/null 2>&1
          endscript
  }
  ```

## References
* [How to Setup Logrotate on Linux (to Keep Your Server from Running Out of Space)](https://www.howtogeek.com/devops/how-to-setup-logrotate-on-linux-to-keep-your-server-from-running-out-of-space/)
* [How to Install Logrotate and Configure Nginx Log Rotation](https://linoxide.com/install-logrotate-configure-nginx-log-rotation/)

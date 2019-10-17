# PHP-FPM Failed to Start Due to No Unix Sock File after Reboot

## Problem
* Compile and install latest PHP from source
* Using Unix Sock: `/var/run/php-fpm/php-fpm.sock`
* It worked for the first time
* But it failed to start PHP-FPM after reboot:

  > ERROR: unable to bind listening socket for address '/var/run/php-fpm/php-fpm.sock': No such file or directory (2)

## Root Cause
* `/var/run` is a link to `/run`
* A tmpfs filesystem is an in-memory filesystem: anything there disappears when the system reboots

## Solution
CentOS use the systemd-tmpfiles facility to automatically create things like lock directories and other ephemeral storage locations when the system boots.

* Create `/usr/lib/tmpfiles.d/php-fpm.conf`

      sudo vi /usr/lib/tmpfiles.d/php-fpm.conf

      // Copy this line to create dir after each reboot
      d /var/run/php-fpm 0755 nobody nobody -

## References
* [/var/run/postgresql missing after reboot](https://serverfault.com/questions/766287/var-run-postgresql-missing-after-reboot)
* [TMPFILES.D](https://www.commandlinux.com/man-page/man5/tmpfiles.d.5.html)

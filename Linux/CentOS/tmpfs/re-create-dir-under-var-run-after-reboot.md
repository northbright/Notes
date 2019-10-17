# Recreate Dirs under `/var/run` after Reboot

## `/var/run` is `tmpfs`
* `/var/run` is a link to `/run`
* `/run` is mount as `tmpfs`

      mount | grep tmpfs

* A tmpfs filesystem is an in-memory filesystem: anything there disappears when the system reboots.
* CentOS use the systemd-tmpfiles facility to automatically create things like lock directories and other ephemeral storage locations when the system boots.

## Solution
* Create a systemd-tmpfiles configuration files

## Example
* Create `/var/run/php-fpm` after reboot

      sudo vi /usr/lib/tmpfiles.d/php-fpm.conf
      
      // d means create dir
      d /var/run/php-fpm 0755 nobody nobody -

## References
* [/var/run/postgresql missing after reboot](https://serverfault.com/questions/766287/var-run-postgresql-missing-after-reboot)
* [TMPFILE.D](https://www.commandlinux.com/man-page/man5/tmpfiles.d.5.html)


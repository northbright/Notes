# `chmod` `2xxx` on a Dir Means `setgid` Flag is Set on the Dir

When the `setgid` flag is set on a directory the new files created within it inherits the directory group ID (GID), instead of the **PRIMARY** group ID of the user who created the file.

## Example
Set `/samba/frank`'s owner to `frank` and group owner to `sambashare`.

```
sudo chown frank:sambashare /samba/frank
sudo chmod 2770 /samba/frank
```

```
// Show frank's groups
groups frank
frank: sambashare

// Show admin's groups and primary group(first one)
groups admin
admin: admins sambashare
```

If the admin user(`admin`) were to create a new directory in `frank`’s share(`/samba/frank)`, `frank` would be able to read and write to it.

## Set special permissions on a file or directory

Use 4 digits number, the **FIRST** digit has the following meaning:

* `setuid`=4
* `setgid`=2
* `sticky`=1
* `no changes` = 0

e.g. `sudo chmod 2770 /samba/frank`

## References
* [Chmod Command in Linux (File Permissions)](https://linuxize.com/post/chmod-command-in-linux/)
* [Linux permissions: SUID, SGID, and sticky bit](https://www.redhat.com/sysadmin/suid-sgid-sticky-bit)

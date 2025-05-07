# Set Password for Samba User using `smbpasswd` without Prompt in Shell

## Solution

```bash
vi add-smb-user.sh
```

```bash
#!/bin/bash

# Set password
pass=123456
(echo "$pass"; echo "$pass") | smbpasswd -s -a ppt

# Enable user
smbpasswd -e ppt
```

```bash
chmod a+x add-smb-user.sh
sudo ./add-smb-user.sh
```

## References
* [Shell script to set password for samba user](https://unix.stackexchange.com/questions/368729/shell-script-to-set-password-for-samba-user)

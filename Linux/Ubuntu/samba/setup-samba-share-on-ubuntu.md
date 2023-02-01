# Setup Samba Share on Ubuntu

## Update
```
sudo apt update
```

## Install Samba
```
sudo apt install samba
```

It will install BOTH Samba server and Samba NetBIOS server.
For security reason, it's better to stop and disable Samba NetBIOS server:

```
sudo systemctl stop nmbd.service
sudo systemctl disable nmbd.service
```

* Disable Samba NetBIOS Server(optional)

## Install and Configure Firewall(`ufw`)
* [Setup Firewall on Ubuntu Using ufw](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/network/setup-firewall-on-ubuntu-using-ufw.md)

## Samba's Global Settings
* Backup the Samba Config File

  ```
  sudo cp /etc/samba/smb.conf /etc/samba/smb.conf.bk
  ```

* Check Available Interfaces

  ```
  ip link

  // Output:
  1: lo: <LOOPBACK,UP,LOWER_UP> ......
  2: enp0s31f6: <BROADCAST,MULTICAST,UP,LOWER_UP> ......
  3: wlp0s20f3: <BROADCAST,MULTICAST,UP,LOWER_UP> ......
  ```

  Record the interface(e.g. `enp0s31f6`) and it'll be used to bind to Samba server(`YOUR_NETWORK_INTERFACE)`.

* Create `[global]` Section

  ```
  sudo vi /etc/samba/smb.conf
  ```

  ```
  [global]
      server string = YOUR_SERVER
      server role = standalone server

      # Bind ethernet interface
      interfaces = lo YOUR_NETWORK_INTERFACE
      bind interfaces only = yes

      # Disable NetBIOS server
      disable netbios = yes

      smb ports = 445
      log file = /var/log/samba/smb.log
      max log size = 1000
      log level = 3 passdb:5 auth:5

      # Xiaomi TV supports SMBv1 only.
      # Add SMBv1 protocol(optional).
      server min protocol = NT1
  ```

* Test

  ```
  testparm

  // Output:
  Load smb config files from /etc/samba/smb.conf
  Loaded services file OK.
  ```

## Create Users
The samba / system users will be created: `frank`, `sonny`, `admin`.

* Create a Directory to Store Data(`/samba/`) and Set the Group Ownership to `sambashare`

  The user group `sambashare` will be created after `samba` is installed.

  ```
  sudo mkdir /samba/
  sudo chown :sambashare /samba/
  ```

* Create User(e.g. `frank`)

  * Create home directory for `frank`

    ```
    sudo mkdir /samba/frank
    ```

  * Create system user: `frank`

    ```
    sudo adduser --home /samba/frank \
    --no-create-home \
    --shell /usr/sbin/nologin \
    --ingroup sambashare frank
    ```

* Set Ownership and Permissions of `frank`'s Home

  ```
  sudo chown frank:sambashare /samba/frank
  sudo chmod 2770 /samba/frank
  ```

  `2770` means that new files or directories created under `/samba/frank/` will inherit the group ownership of the parent directory rather than the primary group of the user that created the file or directory.

  This means, for example, that if the admin user were to create a new directory in `frank`’s share, `frank` would be able to read and write to it.

* Add `frank` to Samba Server

  ```
  // -a: adds the user to the Samba server without enabling them.
  sudo smbpasswd -a frank

  // -e: enables a previously-added user.
  sudo smbpasswd -e frank
  ```

* Repeat The Process for `sonny`

## Create the `admin` User
* Create Home Directory of `admin`

  ```
  sudo mkdir /samba/everyone
  ```

* Create Samba and System User for `admin`

  ```
  sudo adduser --home /samba/everyone \
  --no-create-home \
  --shell /usr/sbin/nologin \
  --ingroup sambashare admin
  ```

  ```
  sudo chown admin:sambashare /samba/everyone/
  sudo chmod 2770 /samba/everyone/
  ```

  ```
  sudo smbpasswd -a admin
  sudo smbpasswd -e admin
  ```

* Add `admins` System User Group

  ```
  sudo groupadd admins
  sudo usermod -G admins admin
  ```

## Configuring the Samba Shares

```
sudo vi /etc/samba/smb.conf
```

```
[frank]
    path = /samba/frank
    browseable = yes
    read only = no
    force create mode = 0660
    force directory mode = 2770
    valid users = frank @admins

[everyone]
    path = /samba/everyone
    browseable = yes
    read only = no
    force create mode = 0660
    force directory mode = 2770
    valid users = @sambashare @admins
```

* Test the Configuration

  ```
  testparm
  ```

## Start and Enable Samba Service

```
sudo systemctl start smbd.service
sudo systemctl enable smbd.service
```

## References
* [How To Set Up a Samba Share For A Small Organization on Ubuntu 16.04](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-samba-share-for-a-small-organization-on-ubuntu-16-04)

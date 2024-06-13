# Setup Samba Share on Ubuntu

## Update
```
sudo apt update
```

## Install Samba
```
sudo apt install samba
```

* Disable Samba NetBIOS Server(optional)

  NetBIOS(nmbd.service) is enabled by default after Samba is installed.
  It makes other PCs in the same subnets see the name of Ubuntu Server(hostname).
  
  * It will install BOTH Samba server(`smbd`) and Samba NetBIOS server(`nmbd`).
  * It brings network and printer browsing capabilities.
  * It also cause noisy network broadcasts

    > Any NetBIOS capable machine will broadcast their NetBIOS computer name every 60 seconds

    See [Do I need NetBIOS?](https://blogs.msmvps.com/acefekay/2013/03/02/do-i-need-netbios/)

  * Disable Samba NetBIOS server

    1. Disable `nmbd` Serivce

    ```
    sudo systemctl stop nmbd.service
    sudo systemctl disable nmbd.service
    ```

    2. Add `disable netbios = yes` in `[global]` Section of `/etc/samba/smb.conf`

  * Re-Enable NetBIOS

    1. Remove `disable netbios = yes` in `[global]` Section of `/etc/samba/smb.conf`
    2. Enable `nmbd` Service

       ```
       sudo systemctl enable nmbd.service
       sudo systemctl start nmbd.service
       ```

       Unmask `nmbd` service if it failed to enable the service with error: `Unit nmbd.service is masked.`
       See [Failed to Enable a Service due to It is Masked](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/service/failed-to-enable-a-service-due-to-it-is-masked.md) for more information.

       ```
       sudo systemctl nmask nmbd.service
       ```

## Install and Configure Firewall(`ufw`)
* [Setup Firewall on Ubuntu Using ufw](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/network/setup-firewall-on-ubuntu-using-ufw.md)

* Run `sudo ufw status verbose` to check

  ```
  sudo ufw status verbose
  Status: active
  Logging: on (low)
  Default: deny (incoming), allow (outgoing), disabled (routed)
  New profiles: skip

  To                         Action      From
  --                         ------      ----
  22/tcp                     ALLOW IN    Anywhere                  
  137,138/udp (Samba)        ALLOW IN    Anywhere                  
  139,445/tcp (Samba)        ALLOW IN    Anywhere                  
  22/tcp (v6)                ALLOW IN    Anywhere (v6)             
  137,138/udp (Samba (v6))   ALLOW IN    Anywhere (v6)             
  139,445/tcp (Samba (v6))   ALLOW IN    Anywhere (v6)  
  ```

  If NetBIOS is enabled, port 137, 138 and 139 are open.

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
  2: eno1: <BROADCAST,MULTICAST,UP,LOWER_UP> ......
  3: enp1s0f0: <BROADCAST,MULTICAST,UP,LOWER_UP> ......
  4: enp1s0f1: <BROADCAST,MULTICAST,UP,LOWER_UP> ......
  5: wlp0s20f3: <BROADCAST,MULTICAST,UP,LOWER_UP> ......
  ```

  Record the interfaces(e.g. `enp1s0f0` and `enp1s0f1`) and they'll be used to bind to Samba server(`YOUR_NETWORK_INTERFACE)`.

* Create `[global]` Section

  ```
  sudo vi /etc/samba/smb.conf
  ```

  ```
  [global]
      workgroup = WORKGROUP
      server string = YOUR_SERVER
      server role = standalone server

      # Bind ethernet interface
      # e.g. interfaces = lo enp1s0f0 enp1s0f1
      interfaces = lo YOUR_NETWORK_INTERFACE
      bind interfaces only = yes

      # Disable NetBIOS server(optional)
      disable netbios = no

      smb ports = 445
      log file = /var/log/samba/smb.log
      max log size = 1000
      log level = 3 passdb:5 auth:5

      # Xiaomi TV supports SMB1 only.
      # Add SMB1 protocol(optional).
      client min protocol = NT1
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

* Create a Directory to Store Data(`/data/samba/`) and Set the Group Ownership to `sambashare`

  The user group `sambashare` will be created after `samba` is installed.

  ```
  sudo mkdir /data/samba/
  sudo chown :sambashare /data/samba/
  ```

* Create User(e.g. `frank`)

  * Create home directory for `frank`

    ```
    sudo mkdir /data/samba/frank
    ```

  * Create system user: `frank`

    ```
    sudo adduser --home /data/samba/frank \
    --no-create-home \
    --shell /usr/sbin/nologin \
    --ingroup sambashare frank
    ```

    Input password and press `y` to create the user.

* Set Ownership and Permissions of `frank`'s Home

  ```
  sudo chown frank:sambashare /data/samba/frank
  sudo chmod 2770 /data/samba/frank
  ```

  The first digit: `2` of `2770` means that new files or directories created under `/samba/frank/` will inherit the group ownership of the parent directory rather than the **PRIMARY** group of the user that created the file or directory.

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
  sudo mkdir /data/samba/everyone
  ```

* Create Samba and System User for `admin`

  ```
  sudo adduser --home /data/samba/everyone \
  --no-create-home \
  --shell /usr/sbin/nologin \
  --ingroup sambashare admin
  ```

  ```
  sudo chown admin:sambashare /data/samba/everyone/
  sudo chmod 2770 /data/samba/everyone/
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
    path = /data/samba/frank
    browseable = yes
    read only = no
    force create mode = 0660
    force directory mode = 2770
    valid users = frank @admins

[everyone]
    path = /data/samba/everyone
    browseable = yes
    read only = no
    force create mode = 0660
    force directory mode = 2770
    valid users = @sambashare @admins
```

* Hide Samba Share from Browse List for Unauthorized Users(Optional)
  * [Hide Samba Share from Browse List for Unauthorized Users](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/samba/hide-samba-share-from-browse-list-for-unauthorized-users.md)

* Test the Configuration

  ```
  testparm
  ```

## Start and Enable Samba Service

```
sudo systemctl start smbd.service
sudo systemctl enable smbd.service
```

## Restart Samba Service(optional)

```
sudo systemctl restart smbd.service
```

## Change Samba User Password(optional)
Use `sudo sambapasswd -U USER_NAME` command to reset password for user.

```
// e.g. Reset password for frank.
sudo sambapasswd -U frank
```

## Delete / Disable Samba User(optional)

```
// Disable user frank.
sudo sambapasswd -d frank
```

```
// Delete user frank.
sudo sambapasswd -x frank
```

## References
* [How To Set Up a Samba Share For A Small Organization on Ubuntu 16.04](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-samba-share-for-a-small-organization-on-ubuntu-16-04)
* [Do I need NetBIOS?](https://blogs.msmvps.com/acefekay/2013/03/02/do-i-need-netbios/)
* [Samba 4, shares, wsdd and Windows 10 – how to list Linux Samba servers in the Win 10 Explorer](https://linux-blog.anracom.com/2020/05/24/samba-4-shares-wsdd-and-windows-10-how-to-list-linux-samba-servers-in-the-win-10-explorer/)
* [samba 4.11 or newer version enable SMB1](https://www.cnblogs.com/mrcoolfuyu/p/12321159.html)
* [关于小米电视无法访问电脑创建共享文件夹问题](https://zhuanlan.zhihu.com/p/340762417)
* [SMB1 is disabled by default](https://wiki.samba.org/index.php/Samba_4.11_Features_added/changed#SMB1_is_disabled_by_default)
* [UBUNTU20 samba4 部分samba版本无法连接问题](https://zhuanlan.zhihu.com/p/322461735)
* [Samba: How to Disable LAN Samba Server Discovery](https://raspberrypi.stackexchange.com/questions/84565/samba-how-to-disable-lan-samba-server-discovery)
* [Failed to Enable a Service due to It is Masked](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/service/failed-to-enable-a-service-due-to-it-is-masked.md)

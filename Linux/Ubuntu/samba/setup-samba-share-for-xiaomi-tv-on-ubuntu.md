# Setup Samba Share for Xiaomi TV on Ubuntu

## Setup Samba Share on Ubuntu
* [Setup Samba Share on Ubuntu](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/samba/setup-samba-share-on-ubuntu.md)

## Settings for Xiaomi TV
* Enable SMB1 Support in `[global]` section of `/etc/samba/smb.conf`

  Xiaomi(Redmi) TV uses SMB1.

  ```
  sudo vi /etc/samba/smb.conf
  ```

  ```
  [global]
    ......
    client min protocol = NT1
    server min protocol = NT1
    ......
  ``` 

  Restart Samba service:

  ```
  sudo systemctl restart smbd
  ```

* Make Sure NetBIOS(`nmbd`) Service is Enabled(Optional)

  If NetBIOS service(`nmbd.service`) is enabled on Samba server,
  Xiaomi(Redmi) TV can discover your Samba share.

  You may just press "OK" on the remote to visit Samba share instead of inputting the IP address to create a new network share on the TV.

  `nmbd.service` is enabled by default after Samba is installed(`sudo apt install samba`)

  If it's disabled, you may re-enable it.

  ```
  sudo systemctl start nmbd
  sudo systemctl enable nmbd
  ```

* Set Xiaomi TV to `Office Mode`

  * It will show a "File Manager" icon when using `Office Mode`


## Access Samba Share from Xiaomi TV

* Press "OK" and run "File Manager", it will take Xiaomi TV 15 - 60 seconds to Find Samba share
* Once the Samba Share name appears, press "OK" and input user name and password(optional)
* Xiaomi TV will save the user name and password of the Samba Share
* It'll re-scan the network to discover Samba share when run "File Manager" after each reboot
* [Unplug Power Cable Will Make Mi TV Lose Samba Authentication](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/samba/unplug-power-cable-will-make-mi-tv-lose-samba-authentication.md)

## DEBUG
If Xiaomi TV can not discover the Samba share, try these:

* Make sure Samba server and Xiaomi TV are in the **SAME** VLAN(ethernet or WiFi)
* Check ethernet cable if using ethernet network
* Go to Xiaomi TV > Settings > Network > Speed Test to see if the speed is GOOD
  * Low speed or high latency will cause Xiaomi TV can not find the Samba share
* Switch to another network to test. Sometimes WiFi is faster than ethernet(100M)
* Restore Xiaomi TV to factory settings may fix the problem

## References
* [samba 4.11 or newer version enable SMB1](https://www.cnblogs.com/mrcoolfuyu/p/12321159.html)
* [关于小米电视无法访问电脑创建共享文件夹问题](https://zhuanlan.zhihu.com/p/340762417)
* [SMB1 is disabled by default](https://wiki.samba.org/index.php/Samba_4.11_Features_added/changed#SMB1_is_disabled_by_default)
* [Unplug Power Cable Will Make Mi TV Lose Samba Authentication](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/samba/unplug-power-cable-will-make-mi-tv-lose-samba-authentication.md)

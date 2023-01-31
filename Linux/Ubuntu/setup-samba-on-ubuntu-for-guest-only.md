# Setup Samba on Ubuntu for Guest Only

## Update
```
sudo apt update
```

## Install Samba
```
sudo apt install samba
```

## Enable Samba Service and Make it Start Automatically on Boot
```
sudo systemctl enable --now smbd
```

## Allow Samba in Firewall
```
sudo ufw allow samba
```

See [Setup Firewall on Ubuntu Using ufw](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/network/setup-firewall-on-ubuntu-using-ufw.md) for more information.

## Make a Dir to Put Public Share Data
```
sudo mkdir /data
```

## Edit `/etc/samba/smb.conf`
* Backup

  ```
  sudo cp /etc/samba/smb.conf /etc/samba/smb.conf.bk
  ```

* Create a Public(Guest Only) Share

  ```
  sudo vi /etc/samba/smb.conf
  ```

  * Add `server min protocol = NT1` under `[global]` section(optional)

    Xiaomi TV supports SMB v1 only, need to add this line for Xiaomi TV,
    see [小米电视无法访问samba共享文件](https://zhuanlan.zhihu.com/p/590959284)

  * Put the code to the end of the file

    ```
    [data]
       path = /data
       guest only = yes
       browsable = yes
       writable = no
    ```

## Restart Samba Service
```
sudo systemctl restart smbd
```

## References
* [How to install SAMBA on Ubuntu 22.04 LTS Jammy Linux](https://www.how2shout.com/linux/how-to-install-samba-on-ubuntu-22-04-lts-jammy-linux/)
* [A big change for Samba in Ubuntu 22.04 and how to get around it](https://www.techrepublic.com/article/big-change-samba-ubuntu/)
* [Setup Firewall on Ubuntu Using ufw](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/network/setup-firewall-on-ubuntu-using-ufw.md)
* [小米电视无法访问samba共享文件](https://zhuanlan.zhihu.com/p/590959284)

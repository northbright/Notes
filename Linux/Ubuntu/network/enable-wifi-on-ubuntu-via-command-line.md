# Enable WiFi on Ubuntu via Command Line

## Install `nmcli`
* Search package which provides `nmcli`

  You need to install `apt-file`,
  see: [How to Find the Package thag Provides a File](https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/how-to-find-the-package-that-provides-a-file.md)

  ```
  apt-file search nmcli

  // Output:
  // ......
  // network-manager
  // ......
  ```

  * You can see, `network-manager` provides `nmcli`

    ```
    sudo apt install network-manager
    ```

## Check Wireless Devices and States
```
nmcli d
```

## Set WiFi Radio On
```
sudo nmcli r wifi on
```

## Connect
```
sudo nmcli d wifi connect WIFI-NAME password PASSWORD
```

## References
* [How to enable wireless on Ubuntu Server 20.04 via CLI?](https://askubuntu.com/questions/1255866/how-to-enable-wireless-on-ubuntu-server-20-04-via-cli)

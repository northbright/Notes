# Install UBNT Network Server on Ubuntu 

## Install MongoDB
* [Install MongoDB Community Edition on Ubuntu](https://github.com/northbright/Notes/blob/master/mongodb/install-mongodb-community-edition-on-ubuntu.md)

## Download .deb File
* Goto <https://www.ui.com/download> and download latest Linux release

  ```sh
  // e.g. v9.0.108
  cd ~/download
  wget https://dl.ui.com/unifi/9.0.108/unifi_sysvinit_all.deb
  ``` 

## Check if port `8080` and `8443` are used by other apps
Port `8080` and `8443` are used by Unifi service.
Check if they are used by other apps.

## Configure Firewall(Optional)

```sh
// Allow ports used by Unifi Network Server
sudo ufw allow 8443
sudo ufw allow 8080

// UDP port 10001 is used for device discovery during adoption
// If there's no AP found, check if 10001 is allowed.
sudo ufw allow 10001
```

* If there's still no AP found after all rules added, you may turn off ufw and try again to see if it's ufw problem

  ```sh
  sudo systemctl stop ufw
  ```

## Install Unifi Network Server

```sh
sudo apt install ./unifi_sysvinit_all.deb
```

## Enable and Start Unifi Service
```sh
// Enable Unifi Service
sudo systemctl enable unifi

// Start Unifi Service
sudo systemctl start unifi

// Check Status
sudo systemctl status unifi
```

## Visit Unifi Network Server
* Visit `https://IP_of_Server:8443`

## Create a New Server
* Input Server Name and Select Country/Region and Click Next
* Click "Advanced Setup" on the button of "Sign In to Your UI Account" page
* Click "Skip" on "Create a UI Account" page
* Create a local admin account

## Export Site and Migrate Old Devices from Old Server to a New One(Optional)
* [Export Site and Migrate Devices from Old Unifi Network Server to a New One](https://github.com/northbright/Notes/blob/master/hardware/ubnt/export-site-and-migrate-devices-from-old-unifi-network-server-to-a-new-one.md)

## Remove Installed Unifi Network Server
* Use `dpkg --list | grep unifi` to get the package name: `unifi`
* Remove the package

  ```sh
  // Stop the Unifi Server
  sudo systemctl stop unifi

  // Remove Unifi
  sudo apt remove unifi
  ```

## References
* [Install UniFi Controller (Network Application) on Ubuntu 20.04](https://computingforgeeks.com/install-unifi-controller-network-application-on-ubuntu/)
* [Updating and Installing Self-Hosted UniFi Network Servers (Linux)](https://help.ui.com/hc/en-us/articles/220066768-Updating-and-Installing-Self-Hosted-UniFi-Network-Servers-Linux)
* [Ubuntu Linux Uninstall / Remove Any Installed Software](https://www.cyberciti.biz/faq/howto-delete-remove-software-using-apt-get-command/)

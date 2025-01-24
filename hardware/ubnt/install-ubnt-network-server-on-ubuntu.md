# Install UBNT Network Server on Ubuntu 

## Install MongoDB
* [Install MongoDB Community Edition on Ubuntu](https://github.com/northbright/Notes/blob/master/mongodb/install-mongodb-community-edition-on-ubuntu.md)

## Download .deb File
* Goto <https://www.ui.com/download> and download latest Linux release

  ```
  // e.g. v9.0.108
  cd ~/download
  wget https://dl.ui.com/unifi/9.0.108/unifi_sysvinit_all.deb
  ``` 

## Check if port `8080` and `8443` are used by other apps
Port `8080` and `8443` are used by Unifi service.
Check if they are used by other apps.

## Configure Firewall(Optional)

```
// Allow ports used by Unifi Network Server
sudo ufw allow 8443
sudo ufw allow 8080
```

## Install Unifi Network Server

```
sudo apt install ./unifi_sysvinit_all.deb
```

## Enable and Start Unifi Service
```
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
* [Export Site and Migrate Devices from Old Unifi Network Server to a New One](export-site-and-migrate-devices-from-old-unifi-network-server-to-a-new-one.md)

## References
* [Install UniFi Controller (Network Application) on Ubuntu 20.04](https://computingforgeeks.com/install-unifi-controller-network-application-on-ubuntu/)
* [Updating and Installing Self-Hosted UniFi Network Servers (Linux)](https://help.ui.com/hc/en-us/articles/220066768-Updating-and-Installing-Self-Hosted-UniFi-Network-Servers-Linux)

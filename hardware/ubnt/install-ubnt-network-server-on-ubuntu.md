# Install UBNT Network Server on Ubuntu 

## Download .deb File
* Goto <https://www.ui.com/download> and download latest Linux release

  ```
  // e.g. v9.0.108
  cd ~/download
  wget https://dl.ui.com/unifi/9.0.108/unifi_sysvinit_all.deb
  ``` 

## Install
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

## Configure Firewall(Optional)

```
// Allow ports used by Unifi Network Server
sudo ufw allow 8443
sudo ufw allow 8080
```

## Visit Unifi Network Server
* Visit `https://IP_of_Server:8443`

## Create a New Server
* Input Server Name and Select Country/Region and Click Next
* Click "Advanced Setup" on the button of "Sign In to Your UI Account" page
* Click "Skip" on "Create a UI Account" page
* Create a local admin account

## References
* [Install UniFi Controller (Network Application) on Ubuntu 20.04](https://computingforgeeks.com/install-unifi-controller-network-application-on-ubuntu/)

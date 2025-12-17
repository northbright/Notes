# Unifi Server Can not Find any AP due to Firewall Rules

## Problem
* Install Unifi Network Application on Ubuntu
* UFW is enabled as firewall service
* Port 8080, 8443 are allowed
* Still can not find any AP in Unifi Server

## Root Cause
* Stop UFW and it can discover AP

  ```sh
  sudo systemctl stop ufw
  ```

* Port 10001 is not allowd and it's used to device discovery during adoption

## Solution
Allow port 10001.

```sh
sudo ufw allow 10001
```

## References
* [Required Ports for UniFi](https://mkcontroller.com/blog/tutorials/unifi/unifi_required_ports/)

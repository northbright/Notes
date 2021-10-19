# Update `/etc/hosts` to Make Github Gist Accessiable in China

## Problem
* [Github Gist](https://gist.github.com/) is **BLOCKED** in China

## Root
* DNS of [Github Gist](https://gist.github.com/) is **Polluted**

## Solution
Set DNS of [Github Gist](https://gist.github.com/) in `/etc/hosts` manually

* Get IP of [Github Gist](https://gist.github.com/)
  * Visit <https://www.ipaddress.com/> and input `gist.github.com`


* Append IP of gist.github.com to `/etc/hosts`
```
// Backup /etc/hosts firstly
sudo cp /etc/hosts ~/hosts

sudo vi /etc/hosts
# Append the IP
IP_OF_GITHUB_GIST   gist.github.com
```

* Flush DNS cache
  * on MacOS: `sudo killall -HUP mDNSResponder`
  * on Windows: `ipconfig /flushdns`
  * on Ubuntu: `sudo systemd-resolve --flush-caches` or `sudo systemctl restart systemd-resolved`



# Got "The package xx need to be reinstalled, but I can't find an archive for it" Error when Reinstall a Package

## Problem
* Install MongoDB and Unifi server on Ubuntu
* Remove Unifi: `sudo apt remove unifi`
* Remove MongoDB: `sudo apt remove mongodb-org`
* Reinstall MongoDB: `sudo apt install mongodb-org`
* Got error:

  > E: The package unifi needs to be reinstalled, but I can't find an archive for it.

## Solution
Remove the corrupt package entry in `/var/lib/dpkg/status`.

```sh
sudo vi /var/lib/dpkg/status
```

```sh
// Find Unifi
Package: unifi
......
......
Homepage:...
```

* Remove the entry of Unifi and save the file
* Reinstall the package and it works

  ```sh
  sudo apt install mongodb-org
  ```

## References
* [Apt/Synaptic needs to reinstall package but can't find the archive for it](https://askubuntu.com/questions/88371/apt-synaptic-needs-to-reinstall-package-but-cant-find-the-archive-for-it)

# Accelerate Access to Github on macOS by Updating `etc/hosts` for China User

## Steps
* Get latest [hosts](https://raw.hellogithub.com/hosts) which contains records mapping IPs to github domains
* Open the downloaded `hosts` file(e.g. `~/Downloads/hosts`
  
  ```shell
  vi ~/Downloads/hosts
  ```

  ```shell
  # GitHub520 Host Start
  XX alive.github.com
  XX api.github.com
  XX assets-cdn.github.com
  ...
  ...
  XX private-user-images.githubusercontent.com
  # GitHub520 Host End
  ```

  Select all records and copy them

* Open `/etc/hosts` and append the records

  ```shell
  sudo vi /etc/hosts
  ```

  ```shell
  127.0.0.1       localhost
  255.255.255.255 broadcasthost
  ::1             localhost
 
  # GitHub520 Host Start
  ...
  ...
  # GitHub520 Host End
  ```

* Clear DNS Cache

  ```shell
  sudo killall -HUP mDNSResponder
  ```

## References
* [GitHub520](https://github.com/521xueweihan/GitHub520)

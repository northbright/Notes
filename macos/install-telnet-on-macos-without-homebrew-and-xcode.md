# Install telnet on macOS without Homebrew and Xcode

## Problem
* Need to install telnet client on macOS
* Do not want to install xcode
* Run Homebrew and get error:

  > The following directories are not writable by your user:
/usr/local/lib/pkgconfig

* Do not want to change the dir's owner
* Need to install telnet without Homebrew and Xcode

## Solution A
Download and build [inetutils](https://ftp.gnu.org/gnu/inetutils/) which contains `telnet` client.

* Download inetutils from offical ftp

  ```sh
  cd ~/download

  curl -sSL -o inetutils-2.8.tar.gz https://ftp.gnu.org/gnu/inetutils/inetutils-2.8.tar.gz

  tar -xzvf inetutils-2.8.tar.gz
  ```

* Make

  ```sh
  cd inetutils-2.8
  ./configure
  make
  ```

* Export telnet binary path in `~/.zprofile`

  Warning: run `sudo make install` may install all binaries which may conflict with existing ones(e.g. `ping`, `ifconfig`).

  ```sh
  vi ~/.zprofile
  ```

  ```sh
  // Replace xx to your user name
  export PATH=$PATH:/Users/xx/download/inetutils-2.8/telnet
  ```

  ```sh
  source ~/.zprofile
  which telnet
  ```

## Method B
Run `curl` with `--telnet-option`.

```sh
curl --telnet-option TTYPE=vt100 telnet://example.com:23
```

## References
* [Is there still a way to load Telnet on OS10.13](https://discussions.apple.com/thread/255344319?sortBy=rank)
* [PKGCONFIG permissions error #5626](https://github.com/orgs/Homebrew/discussions/5626)

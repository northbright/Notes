# Install pkg-config from Source on macOS

## Steps
* Download [latest release](https://pkgconfig.freedesktop.org/releases/pkg-config-0.29.2.tar.gz) of [pkg-config](https://pkgconfig.freedesktop.org/)
* Extract
  ```bash
  tar -xzvf pkg-config-0.29.2.tar.gz 
  ```

* Make and Install

  ```bash
  cd pkg-config-0.29.2
  ./configure --with-internal-glib
  make
  sudo make install
  ```

## References
* [mac 安装pkg-config](https://www.cnblogs.com/chuckTsao/p/14870325.html)

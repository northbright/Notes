# Install libtool from Source on macOS

## Steps
* Download latest release of [libtool](https://www.gnu.org/software/libtool/)

  ```sh
  cd ~/download
  aria2c https://ftpmirror.gnu.org/libtool/libtool-2.5.4.tar.gz
  tar -xzvf libtool-2.5.4.tar.gz
  cd libtool-2.5.4
  ```

* Configure

  ```sh
  ./configure
  ```

* Make and make install

  ```sh
  make
  sudo make install
  ```

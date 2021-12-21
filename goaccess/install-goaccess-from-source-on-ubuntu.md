# Install [GoAccess](https://goaccess.io) from Source on Ubuntu

## Solution
* Install Dependencies

  * Update apt
  
    ```
    sudo apt-get update
    ```

  * Install Development Tools
  
    ```
    sudo apt install build-essential
    ```

  * Install ncurses
  
    ```
    sudo apt install libncurses5-dev libncursesw5-dev
    ```

  * Install [libmaxminddb](https://github.com/maxmind/libmaxminddb)

    * [Install libmaxminddb from Source On Ubuntu](https://github.com/northbright/Notes/blob/master/libmaxminddb/install-libmaxminddb-from-source-on-ubuntu.md)

* Download Source Code

  ```
  cd download
  wget https://tar.goaccess.io/goaccess-1.5.3.tar.gz
  tar -xzvf goaccess-1.5.3.tar.gz
  cd goaccess-1.5.3
  ```

* Configure and Build

  * Set `CFLAGS` and `LDFLAGS` if libmaxminddb is configured and installed with `--prefix`, otherwise, ignore `CFLAGS` and `LDFLAGS`

    ```
    CFLAGS="-I/usr/local/libmaxminddb/include" LDFLAGS="-L/usr/local/libmaxminddb/lib" ./configure --enable-utf8 --enable-geoip=mmdb --prefix=/usr/local/goaccess
    ```

  * Build and Install

    ```
    make
    sudo make install
    ```

* Add GoAccess Binary Path

  ```
  sudo vi /etc/profile
  ```

  ```
  # Append this line
  PATH=$PATH:/usr/local/goaccess/bin
  ```

## References
* [Missing development files for the GeoIP library](https://github.com/allinurl/goaccess/issues/852)

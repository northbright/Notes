# Install [libmaxminddb](https://github.com/maxmind/libmaxminddb) from Source On Ubuntu

## Solution
* Download [libmaxminddb](https://github.com/maxmind/libmaxminddb)

  ```
  cd download
  wget https://github.com/maxmind/libmaxminddb/releases/download/1.6.0/libmaxminddb-1.6.0.tar.gz
  tar -xzvf libmaxminddb-1.6.0.tar.gz
  cd libmaxminddb-1.6.0
  ```

* Configure and Build

  ```
  ./configure --prefix=/usr/local/libmaxminddb
  make
  sudo make install
  ```

* Add Library Path

  ```
  su
  echo '/usr/local/libmaxminddb/lib' > /etc/ld.so.conf.d/libmaxminddb.conf
  exit

  sudo ldconfig
  ldconfig -p | grep libmaxminddb.so
  ```

## References
* [Missing development files for the GeoIP library](https://github.com/allinurl/goaccess/issues/852)

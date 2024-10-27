# Install autoconf from Source on macOS

## Install [automake](https://www.gnu.org/software/automake/)
* Download [latest release](https://ftp.gnu.org/gnu/automake/automake-1.17.tar.gz)
* Extract
  ```bash
  cd ~/download
  tar -xzvf automake-1.17.tar.gz
  ```
* Make and Install

  ```bash
  cd ~/download/automake-1.17
  ./configure
  make
  sudo make install
  ```

## Install [m4](https://www.gnu.org/software/m4/m4.html)
* Download [latest release](https://ftp.gnu.org/gnu/m4/m4-latest.tar.gz)
* Extract
  ```bash
  cd ~/download
  tar -xzvf m4-latest.tar.gz
  ```
* Make and Install

  ```bash
  cd ~/download/m4-1.4.19
  ./configure
  make
  sudo make install
  ```

## Install [autoconf](https://www.gnu.org/software/autoconf/)
* Download [latest release](https://ftp.gnu.org/gnu/autoconf/autoconf-latest.tar.gz)
* Extract
  ```bash
  cd ~/download
  tar -xzvf autoconf-latest.tar.gz
  ```
* Make and Install
  ```bash
  cd ~/download/autoconf-2.72
  ./configure
  make
  sudo make install
  ```

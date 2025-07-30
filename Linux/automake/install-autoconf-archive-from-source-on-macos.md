# Install `autoconf-archive` from Source on macOS

## About
The GNU Autoconf Archive is a collection of more than 500 macros for GNU Autoconf.

## Steps
* Download [autoconf-archive](https://www.gnu.org/software/autoconf-archive/) on <https://ftp.gnu.org/gnu/autoconf-archive/>

  ```sh
  cd ~/download
  aria2c https://ftp.gnu.org/gnu/autoconf-archive/autoconf-archive-2024.10.16.tar.xz
  tar -xzvf autoconf-archive-2024.10.16.tar.xz
  cd autoconf-archive-2024.10.16
  ```

* Configure

  ```sh
  ./configure
  ```

* Make & Make Install

  ```sh
  make
  sudo make install
  ```

  It'll put all m4 files to `/usr/local/share/aclocal/` which is the macro search path of automake tools(e.g. aclocal, autoreconf, configure). 

## References
* [autoconf-archive Homebrew Formulae](https://formulae.brew.sh/formula/autoconf-archive)
* [autoconf-archive.rb](https://github.com/Homebrew/homebrew-core/blob/12466756ef412ae7ec3496448b16d26f746ebc42/Formula/a/autoconf-archive.rb)

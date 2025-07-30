# Install libxls from Source on macOS

## Method A: Compile and install [libxls](https://github.com/libxls/libxls) from latest release
* Download latest release

  ```sh
  cd ~/download
  aria2c https://github.com/libxls/libxls/releases/download/v1.6.3/libxls-1.6.3.tar.gz
  tar -xzvf libxls-1.6.3.tar.gz
  cd libxls-1.6.3
  ```

* Configure

  ```sh
  ./configure
  ```

* Make and Make Install

  ```sh
  make
  sudo make install
  ```

## Method B: Compile and install [libxls](https://github.com/libxls/libxls) by cloning repo
* Install Dependencies
  * Install gettext
    * [Install gettext from Source on macOS](https://github.com/northbright/Notes/blob/master/automake/install-gettext-from-source-on-macos.md)

  * Install libtool
    * [Install libtool from Source on macOS](https://github.com/northbright/Notes/blob/master/automake/install-libtool-from-source-on-macos.md)

  * Install autoconf-archive
    * [Install autoconf-archive from Source on macOS](https://github.com/northbright/Notes/blob/master/automake/install-autoconf-archive-from-source-on-macos.md)

* Git clone [libxls](https://github.com/libxls/libxls)

  ```
  git clone https://github.com/libxls/libxls.git
  ```

* Run `autoreconf`

  ```sh
  autoreconf -i -f -I /usr/local/share/gettext/m4/
  ```

* Configure

  ```sh
  ./configure
  ```

* Make and Make Install

  ```sh
  make
  sudo make install
  ```

## References
* <https://github.com/libxls/libxls/blob/dev/.github/workflows/build.yml>
* [[SOLVED] gettext 0.24.1 build question](https://bbs.archlinux.org/viewtopic.php?id=305437)
* [gettext 0.25 moves m4 files which is causing many FTBFS](https://bugzilla.redhat.com/show_bug.cgi?id=2366708)
* [Macro Search Path](https://www.gnu.org/software/automake/manual/html_node/Macro-Search-Path.html)
* [autoconf-archive](https://www.gnu.org/software/autoconf-archive/)
* [AX_CXX_COMPILE_STDCXX_11 doesn't work: syntax error near unexpected token](https://stackoverflow.com/questions/24923600/ax-cxx-compile-stdcxx-11-doesnt-work-syntax-error-near-unexpected-token)
* [configure.ac: AX_CXX_COMPILE_STDCXX(11) is wrong #72](https://github.com/libpinyin/libpinyin/issues/72)

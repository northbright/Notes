# Install [gettext](https://www.gnu.org/software/gettext/) on macOS

## Steps
* Download [gettext-v0.26](https://ftp.gnu.org/pub/gnu/gettext/gettext-0.26.tar.gz)

  ```sh
  cd ~/download
  wget https://ftp.gnu.org/pub/gnu/gettext/gettext-0.26.tar.gz
  ```

  ```sh
  tar -xzvf gettext-0.26.tar.gz
  cd gettext-0.26
  ```

* Configure

  ```sh
  ./configure
  ```

  * Default prefix is `/usr/local`.
  * gettext `.m4` files install dir
    * Before v0.25
  * Wanning: gettext v0.25 and later moves m4 files from `${prefix}/share/aclocal` to `${prefix}/share/gettext/m4`
    e.g.
    * for gettext before v0.25
      m4 files are put in `/usr/local/share/gettext/m4/`
  * Macro search path of "aclocal" is `${prefix}/share/aclocal`
  * Need to specify `-I ${prefix}/usr/share/gettext/m4` when run `autoreconf`

* Make and Install

  ```sh
  make
  sudo make install
  ```

## gettext `.m4` files install dir and run `autoreconf`
* before v0.25
  * It puts all m4 files to `${prefix}/share/aclocal`(e.g. `/usr/local/share/aclocal`) which is the macro search path of `aclocal`.
  * Run `autoreconf`

    ```sh
    autoreconf -i -f
    ```

* v0.25 and later
  * It puts all m4 files to `${prefix}/share/gettext/m4`(e.g. `/usr/local/share/gettext/m4/`).
  * Need to use `-I /usr/local/share/gettext/m4/` when run `autoreconf`:

    ```sh
    autoreconf -i -f -I /usr/local/share/gettext/m4/
    ```

## References
* [[SOLVED] gettext 0.24.1 build question](https://bbs.archlinux.org/viewtopic.php?id=305437)
* [gettext 0.25 moves m4 files which is causing many FTBFS](https://bugzilla.redhat.com/show_bug.cgi?id=2366708)
* [Macro Search Path](https://www.gnu.org/software/automake/manual/html_node/Macro-Search-Path.html)

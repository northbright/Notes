# `AM_ICONV` Not Found 

## Problem
* Try to clone [libxls](https://github.com/libxls/libxls) and build it on macOS
* Follow the instruction in `INSTALL` to build libxls after cloned the git repo:

  ```sh
  ./autogen.sh
  ```

* Got error:

  > warning: macro 'AM_ICONV' not found in library
  > error: possibly undefined macro: AM_ICONV

## Root Cause
[gettext](https://www.gnu.org/software/gettext/) is not installed.

* `autogen.sh` calls `autoreconf -i -f`
* `autoreconf` calls `aclocal`
* `aclocal` will search required macros
* `AM_ICONV` macro is defined in `iconv.m4` after [gettext](https://www.gnu.org/software/gettext/) installed.

## Solution
Install [gettext](https://www.gnu.org/software/gettext/) on macOS.

* Method A: Install [gettext](https://www.gnu.org/software/gettext/) from [Homebrew](https://formulae.brew.sh/formula/gettext)

  ```sh
  brew install gettext
  ```

  ```sh
  ./autogen.sh
  ```

* Method B: [Install gettext from Source on macOS](https://github.com/northbright/Notes/blob/master/Linux/automake/install-gettext-from-source-on-macos.md)

  Warning: gettext v0.25 and later moves m4 files from `${prefix}/share/aclocal` to `${prefix}/share/gettext/m4`.

  ```sh
  autoreconf -i -f -I /usr/local/share/gettext/m4/
  ```

## References
* [gettext](https://www.gnu.org/software/gettext/)
* [macro 'AM_ICONV' not found in library #27](https://github.com/WizardMac/librdata/issues/27)

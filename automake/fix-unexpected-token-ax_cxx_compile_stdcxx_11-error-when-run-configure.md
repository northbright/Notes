# Fix "unexpected token `AX_CXX_COMPILE_STDCXX_11`" Error when Run `./configure`

## Problem
* Try to build [libxls](https://github.com/libxls/libxls) on macOS
* Git clone [libxls](https://github.com/libxls/libxls) repo
* Run `./autogen.sh`
* Run `./configure` and got error:

  > ./configure: line 19757: syntax error near unexpected token `,'
  > ./configure: line 19757: `AX_CXX_COMPILE_STDCXX_11(, optional)'

## Root Cause
* [autoconf-archive](https://www.gnu.org/software/autoconf-archive/) is missing
* `AX_CXX_COMPILE_STDCXX_11` is defined in `autoconf-archive/m4/ax_cxx_compile_stdcxx_11.m4`

## Solution
* Method A: Install [autoconf-archive](https://www.gnu.org/software/autoconf-archive/) via [Homebrew](https://formulae.brew.sh/formula/autoconf-archive)

  ```sh
  brew install autoconf-archive
  ```

* Method B: [Install autoconf-archive from Source on macOS](https://github.com/northbright/Notes/blob/master/automake/install-autoconf-archive-from-source-on-macos.md)

## References
* [autoconf-archive](https://www.gnu.org/software/autoconf-archive/)
* [AX_CXX_COMPILE_STDCXX_11 doesn't work: syntax error near unexpected token](https://stackoverflow.com/questions/24923600/ax-cxx-compile-stdcxx-11-doesnt-work-syntax-error-near-unexpected-token)
* [configure.ac: AX_CXX_COMPILE_STDCXX(11) is wrong #72](https://github.com/libpinyin/libpinyin/issues/72)

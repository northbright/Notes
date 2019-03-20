# CMake Could not Find curses

## Problem
* Compile [MariaDB](https://mariadb.org) from source on CentOS 7
* Already compiled and installed [ncurses](https://www.gnu.org/software/ncurses/ncurses.html) from source
* Still got "Could not find curses" error when running [CMake](https://cmake.org) with `-DWITH_READLINE=1` option

## How to Reproduce
* Configure, make  and install [ncurses](https://www.gnu.org/software/ncurses/ncurses.html)
   * Download latest release on <ftp://ftp.gnu.org/gnu/ncurses/>
        
         cd ~/download
         wget ftp://ftp.gnu.org/gnu/ncurses/ncurses-6.1.tar.gz
         tar -xzvf ncurses-6.1.tar.gz
         cd ncurses-6.1

   * Configure, make and install

         ./configure --prefix=/usr/local/ncurses --with-shared
         make
         sudo make install

* Configure [MariaDB](https://mariadb.org) 

      // Remove `CMakeCache.text` if it exists
      rm CMakeCache.txt

      cmake . \
      ......
      -DWITH_READLINE=1 \
      ......

* Got error message

   > Could NOT find Curses (missing: CURSES_LIBRARY CURSES_INCLUDE_PATH) 
      CMake Error at cmake/readline.cmake:65 (MESSAGE):
      Curses library not found.  Please install appropriate package,
      remove CMakeCache.txt and rerun cmake.On Debian/Ubuntu, package name is libncurses5-dev, on Redhat and derivates it is ncurses-devel.
      Call Stack (most recent call first):
      cmake/readline.cmake:173 (FIND_CURSES)
      CMakeLists.txt:340 (MYSQL_CHECK_READLINE)

## Root Cause
* [CMake](https://cmake.org) will find these header files in system-wide include dir(`/usr/include`) and set args:
   * `curses.h`: `CURSES_HAVE_CURSES_H`
   * `ncurses.h`: `CURSES_HAVE_NCURSES_H`
   * `ncurses/ncurses.h`: `CURSES_HAVE_NCURSES_NCURSES_H`
* It'll fail if
   * [ncurses](https://www.gnu.org/software/ncurses/ncurses.html) is NOT installed to `/usr`(`--prefix=/usr`)
   * `CURSES_LIBRARY`,`CURSES_INCLUDE_PATH` are not set

## Solutions
* Solution A(recommended)
   Install `ncurses-devel` via `yum`
   
      sudo yum install -y ncurses-devel

* Solution B
   * Install [ncurses](https://www.gnu.org/software/ncurses/ncurses.html) to `/usr/local/ncurses` as before
      
         ./configure --prefix=/usr/local/ncurses --with-shared
         make
         sudo make install
   
   * Set these args for CMake:
      * `CURSES_USE_NCURSES`
      * `CURSES_NCURSES_INCLUDE_PATH`
      * `CURSES_NCURSES_LIBRARY`

            cmake . \
            ......
            -DCURSES_USE_NCURSES=1 \
            -DCURSES_NCURSES_INCLUDE_PATH=/usr/local/ncurses/include \
            -DCURSES_NCURSES_LIBRARY=/usr/local/ncurses/lib


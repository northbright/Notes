# Example to Use `automake` for C Repo on Github

#### Preparation
* Make a `src` folder under your repository to put source files(.c, .h).
* Make sure code can be compiled successfully.
* `git add && git commit` before add `automake` files.

#### How to Use `automake`
1. Add Hand-edited files need by `automake`.

  * `vi src/Makefile.am`

          bin_PROGRAMS = example

          example_SOURCES = \
              appendstr.c \
              example.c 

  * `vi Makefile.am`

          AUTOMAKE_OPTIONS = foreign
          SUBDIRS = src

  * `vi configure.ac`

          AC_INIT([example], [1.0], [bug-automake@gnu.org])
          AM_INIT_AUTOMAKE([-Wall -Werror foreign])
          AC_PROG_CC
          AC_CONFIG_HEADERS([config.h])
          AC_CONFIG_FILES([
            Makefile
            src/Makefile
          ])
          AC_OUTPUT

2. Check if `automake` works.

* Run `autoreconf --install` to generate `automake` files(config.h.in, Makefile.in...).

* Run `./configure` to generate `Makefile`.

* Run `./make` to compile your binary under `src`.

#### Remove auto-generated files.

        git clean -dfx

#### Add Our `autogen.sh` to call `autoreconf --install`.

        #!/bin/sh
        echo "Regenerating autotools files"
        autoreconf --install --force --symlink || exit 1
        echo "Now run ./configure, make, and make install." 

* Run `chmod +x autogen.sh` to make script excutable.

#### Add `.travis.yml` to integrate build check.

        language: c

        compiler: gcc

        script: ./autogen.sh && ./configure && make

#### Usage after `git clone`
* Run `./autogen.sh`
* Run `./configure`
* Run `./make`

#### References
* [A Small Hello World](https://www.gnu.org/software/automake/manual/automake.html#Creating-amhello)
* [http://stackoverflow.com/questions/3290908/which-files-generated-by-autotools-should-i-keep-in-version-control-repository]
* <https://github.com/northbright/appendstr>




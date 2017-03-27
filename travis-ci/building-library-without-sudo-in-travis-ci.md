# Building Library without `sudo` in Travis-Ci

#### Why
Travis-Ci discourage using `sudo`.

* Container-Based Envionment:
  * No support for `sudo`, `setuid`, `setgid`

* Sudo-Enabled Envionment:
  * You need to set `sudo: required` to enable `sudo`

#### Solution

* Set `--prefix=$HOME` when run `./configure`.

        ./configure --prefix=$HOME
        make
        make install

* Set `LD_LIBRARY_PATH`, `CFLAGS`, `LDFLAGS` before run your script.

        script:
            - cd xls2csv
            - export LD_LIBRARY_PATH="$HOME/lib":$LD_LIBRARY_PATH
            - CGO_CFLAGS="-I$HOME/include" CGO_LDFLAGS="-L$HOME/lib -lxlsreader" go test -c && ./xls2csv.test

#### Example
* [install-libxls.sh](https://github.com/northbright/xls2csv-go/blob/master/install-libxls.sh)
* [.travis.yml](https://github.com/northbright/xls2csv-go/blob/master/.travis.yml)

#### References
* [How to build library without sudo?](http://www.howtobuildsoftware.com/index.php/how-do/bSGZ/ld-travis-ci-configure-travis-how-to-build-library-without-sudo)
* [How can I run Haxe 2.10 on Travis-CI (64-bit Ubuntu)?](http://stackoverflow.com/questions/27137351/how-can-i-run-haxe-2-10-on-travis-ci-64-bit-ubuntu)
* [Environment Variables](https://docs.travis-ci.com/user/environment-variables/)

        

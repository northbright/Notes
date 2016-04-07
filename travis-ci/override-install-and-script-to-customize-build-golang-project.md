# Override `install` and `script` to Customize Build for Golang Project

#### `install`

* The default dependency installation commands depend on the project language.
* If you need to perform special tasks before your tests can run, override the install: key in your .travis.yml:

        install:
          - go get github.com/bmizerany/assert
          - go get github.com/mrb/hob

#### `script`

* The default build command depends on the project language.
* Default: `script: go test ./...`

#### Example [.travis.yml](https://github.com/northbright/go-yuebao/blob/master/.travis.yml)

    language: go

    go:
      - 1.3.3
      - 1.4.2
      - 1.5
      - 1.6
      - tip

    before_install:
      - sudo apt-get install -y libsnappy-dev
      - ./install-levigo.sh

    install:
      - go get github.com/bitly/go-simplejson
      - CGO_CFLAGS="-I$TRAVIS_BUILD_DIR/leveldb-master/include" CGO_LDFLAGS="-L$TRAVIS_BUILD_DIR/leveldb-master/out-shared -lsnappy" go get github.com/jmhodges/levigo

    script:
      - LD_LIBRARY_PATH=$TRAVIS_BUILD_DIR/leveldb-master/out-shared go test -v


#### Example [install-levigo.sh](https://github.com/northbright/go-yuebao/blob/master/install-levigo.sh) to run in travis-ci build env

    #! /usr/bin/env sh

    wget https://github.com/google/leveldb/archive/master.zip
    unzip master.zip
    cd leveldb-master
    make

#### References
* [Customizing the Build](https://docs.travis-ci.com/user/customizing-the-build/)
* [Building a Go Project](https://docs.travis-ci.com/user/languages/go)

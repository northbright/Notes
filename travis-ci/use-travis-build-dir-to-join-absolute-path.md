# Use `TRAVIS_BUILD_DIR` to Join Absolute Path

#### TRAVIS_BUILD_DIR

The absolute path to the directory where the repository being built has been copied on the worker.

#### Example

[.travis.yml for github.com/northbright/go-yuebao](https://github.com/northbright/go-yuebao/blob/master/.travis.yml)

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

#### References
* [Environment Variables](https://docs.travis-ci.com/user/environment-variables)



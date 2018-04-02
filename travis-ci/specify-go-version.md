# Specify Go Version in .travis.yml

#### Use string version instead of float
Note that, in order to choose Go 1.10, you must use go: "1.10" (a string), not go: 1.10 (a float). Using a float results in the use of Go 1.1.

    language: go
    go:
      - "1.10"

#### References
* [Building a Go Project](https://docs.travis-ci.com/user/languages/go/)
* [Golang v1.10 is parsed as 1.1 #9247](https://github.com/travis-ci/travis-ci/issues/9247)


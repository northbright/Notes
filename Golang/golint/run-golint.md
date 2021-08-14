# Run golint

**NOTE:** Golint is [deprecated and frozen](https://github.com/golang/go/issues/38968).
There's no drop-in replacement for it, but tools such as [Staticcheck](https://staticcheck.io/)
and `go vet` should be used instead.

## Install golint

    go get -u github.com/golang/lint/golint
    cd $GOPATH/src/github.com/golang/lint/golint
    go build

## Add golint path

    sudo vi /etc/profile

    # Golint
    export PATH=$PATH:/home/xx/projects-go/src/github.com/golang/lint/golint

## Run golint
* `golint DIR`
  
        // e.g.
        cd $GOPATH/src/github.com/xx
        golint my-project   

* `golint PACKAGE`

        // e.g.
        golint github.com/xx/my-project

* `golint XX/...` to recurse into dirs.

        // e.g.
        cd $GOPATH/src/github.com/xx
        golint my-project/...
        golint github.com/xx/another-project/...

## References
* <https://github.com/golang/lint>

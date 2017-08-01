# Run golint

#### Install golint

    go get -u github.com/golang/lint/golint
    cd $GOPATH/src/github.com/golang/lint/golint
    go build

#### Add golint path

    sudo vi /etc/profile

    # Golint
    export PATH=$PATH:/home/xx/projects-go/src/github.com/golang/lint/golint

#### Run golint
* `golint DIR_NAME / PACKAGE_NAME`
* `golint DIR_NAME / PACKAG_NAME/...` to recurse into dirs.

#### References
* <https://github.com/golang/lint>

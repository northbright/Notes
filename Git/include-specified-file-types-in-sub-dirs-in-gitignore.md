# Include Specified File Types in Sub Dirs in `.gitignore`

#### Problem
* [golang](http://golang.org) projects may contain binary files after after run `go build` or `go test -c`:
    * Test Files - *.test(`go test -c`)
    * Executable build from main package.

#### Example Golang Project Folder

    .
    ├── go
    │   ├── ch01
    │   │   ├── ch01
    │   │   └── main.go
    │   ├── ch02
    │   │   ├── ch02
    │   │   └── main.go
    │   ├── ch03
    │   │   ├── ch03
    │   │   └── main.go
    │   ├── tmp
    │   │   └── ch04
    │   │       ├── ch04
    │   │       └── main.go
    │   └── util
    │       ├── util.go
    │       └── util.test
    └── README.md


* We want to ignore all binary files(ch01, ch02, ...) but just keep all Golang source file(*.go) in sub dirs.

#### Solution

* `vi .gitignore`

        # Include all .go under ch** folders
        /go/**/ch*/*
        !/go/**/ch*/*.go

        # Include all .go under util folder
        /go/**/util/*
        !go/**/util/*.go

* `git add -i` and choose add select `4: add untracked` to see the result:

    1: .gitignore
    2: README.md
    3: go/ch01/main.go
    4: go/ch02/main.go
    5: go/ch03/main.go
    6: go/tmp/ch04/main.go
    7: go/util/util.go


#### References
* [How do gitignore exclusion rules actually work?(See medge799's answer)](http://stackoverflow.com/questions/3001888/how-do-gitignore-exclusion-rules-actually-work)

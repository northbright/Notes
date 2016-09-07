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
        │   │   ├── main.go
        │   │   └── README.md
        │   ├── ch02
        │   │   ├── ch02
        │   │   ├── main.go
        │   │   └── README.md
        │   ├── ch04
        │   │   ├── ch04
        │   │   ├── main.go
        │   │   └── README.md
        │   └── util
        │       ├── main.go
        │       └── README.md
        ├── LICENSE
        └── README.md


#### Requirements
* Keep `LICENSE`
* Keep all markdown files(*.md)
* Ignore all binary files(ch01, ch02, ...) 
* Keep all Golang source file(*.go)

#### Solution

* `vi .gitignore`

        *
        !.gitignore
        !LICENSE 
        !*.md 
        !*.go 
        !/go/ 
        !/go/**/


* `git add -i` and choose add select `4: add untracked` to see the result:

        1: .gitignore
        2: LICENSE
        3: README.md
        4: go/ch01/README.md
        5: go/ch01/main.go
        6: go/ch02/README.md
        7: go/ch02/main.go
        8: go/ch04/README.md
        9: go/ch04/main.go
       10: go/util/README.md
       11: go/util/main.go

#### References
* [How do gitignore exclusion rules actually work?(See medge799's answer)](http://stackoverflow.com/questions/3001888/how-do-gitignore-exclusion-rules-actually-work)

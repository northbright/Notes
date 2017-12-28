# `go test` will generate test executable in temporary dir

#### Details
* `go test` will compile package source and generate the test executable(`.test`) in temporary dir. e.g.`/tmp/go-build122272071`
* It'll remove the test executable and whole temporary dir after test so that you can't find the dir in `/tmp`

#### Modify go source code to keep the temporary dir
To dive into the temporary dir, we need to modify the [go source code(go 1.9)](https://github.com/golang/go/blob/dev.boringcrypto.go1.9/src/cmd/go/internal/work/build.go#L708) to keep it.

* Find [func (b *Builder) Init() ](https://github.com/golang/go/blob/dev.boringcrypto.go1.9/src/cmd/go/internal/work/build.go#L708) in [src/cmd/go/internal/work/build.go](https://github.com/golang/go/blob/dev.boringcrypto.go1.9/src/cmd/go/internal/work/build.go#L708):
        
        func (b *Builder) Init() {
                ......
                if !cfg.BuildWork {
                        workdir := b.WorkDir
                        // Comment this line to keep the temporary dir.
                        // base.AtExit(func() { os.RemoveAll(workdir) })
                }
        }
* [Build Go from source](https://github.com/northbright/Notes/blob/master/Golang/Install/install-latest-go-release-from-source-on-centos7.md)

Now, after run `go test`, you'll find `/tmp/go-buildxxxxx`.

#### What's in the temporary dir
```
[xx@localhost tmp]$ tree go-build986631162/
go-build986631162/
└── github.com
    ├── dgrijalva
    │   ├── jwt-go
    │   │   └── _obj
    │   └── jwt-go.a
    └── northbright
        ├── jwthelper
        │   ├── _obj
        │   └── _test
        │       ├── github.com
        │       │   └── northbright
        │       │       └── jwthelper_test.a
        │       ├── jwthelper.test
        │       ├── main.a
        │       ├── _obj_xtest
        │       └── _testmain.go
        ├── jwthelper.a
        ├── pathhelper
        │   └── _obj
        └── pathhelper.a
```

As you can see, it'll generate:
* `.a` libararies of your packages and the dependencies
* `.test` executable test file
* **No** go source files and other **assets** under your original package dir will be copied to the temporary dir


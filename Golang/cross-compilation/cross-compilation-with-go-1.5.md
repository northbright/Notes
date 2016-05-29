# Cross Compilation with Go 1.5

Go 1.5 make it simple for cross compilation

#### Examples

    // os = windows, arch = 386(x86(
    env GOOS=windows GOARCH=386 go build -v

    // os = linux, arch = amd64
    env GOOS=linux GOARCH=amd64 go build -v

    // os = mac os x(darwin), arch = amd64
    env GOOS=darwin GOARCH=amd64 go build -v

#### List of `$GOOS` and `$GOARCH`
* [operating system and architecture](http://golang.org/doc/install/source#environment)
* or check [syslist]https://github.com/golang/go/blob/master/src/go/build/syslist.go) direcly if can't access [Golang.org](http://golang.org)(special for China Gophers).

          const goosList = "android darwin dragonfly freebsd linux nacl netbsd openbsd plan9 solaris windows "
          const goarchList = "386 amd64 amd64p32 arm armbe arm64 arm64be ppc64 ppc64le mips mipsle mips64 mips64le mips64p32 mips64p32le ppc s390 s390x sparc sparc64 "

#### Get Current Value of `$GOOS` and `GOARCH`
* run `go env GOOS`, `go env GOARCH`
* or run `go env` to list all environment variables

#### References
* [Cross compilation with Go 1.5](http://dave.cheney.net/2015/08/22/cross-compilation-with-go-1-5)

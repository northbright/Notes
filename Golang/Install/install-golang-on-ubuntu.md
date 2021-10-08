# Install Golang on Ubuntu

## Download [Golang](https://golang.google.cn/dl/)

```
mkdir ~/download
cd ~/download
wget https://golang.google.cn/dl/go1.17.2.linux-amd64.tar.gz

// Extract go to /home/xx/go
tar -xzvf go1.17.2.linux-amd64.tar.gz -C ~/
```

## Add `go get` installed binary path to `PATH`
* If you want to run the binary installed from `go get`(e.g. [staticcheck](https://staticcheck.io/)), we need to set `$GOPATH` and add `$GOPATH/bin` to `$PATH` in `~/.profile`

* Edit `~/.profile`

  ```
  vi ~/.profile
  ```

  ```
  # Append these lines
  export GOPATH=$HOME/go
  export PATH=$PATH:$GOPATH/bin
  ```

* `source ~/.profile`

## Set `GOPROXY`
* `go get` packages from `"https://golang.org/x/XX"` will fail in China(golang.org is blocked in China)
* `GOPROXY` is  set to `"https://proxy.golang.org,direct"` by default
* `"https://proxy.golang.org"` is blocked in China
* Use `"https://goproxy.io"` instead

  ```
  vi ~/.profile
  ```
  ```
  export GOPROXY="https://goproxy.io,direct"
  ```
  ```
  source ~/.profile
  ```

## Check Golang Version

```
go version
``

## Check Golang Environment Variables
```
go env

// Output:
...
GOPROXY="https://proxy.golang.org,direct"
GOROOT="/usr/xx/go"
GOSUMDB="sum.golang.org"
...
```

## References
* [Set Golang Development Environment on Mac OS X in China](https://github.com/northbright/Notes/blob/master/Golang/Install/setup-golang-dev-env-on-mac-os-x.md)

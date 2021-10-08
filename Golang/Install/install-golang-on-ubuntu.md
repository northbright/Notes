# Install Golang on Ubuntu

## Download [Golang](https://golang.google.cn/dl/)

```
mkdir ~/download
cd ~/download
wget https://golang.google.cn/dl/go1.17.2.linux-amd64.tar.gz

// Extract go to /home/xx/go
tar -xzvf go1.17.2.linux-amd64.tar.gz -C ~/
```

## Set `$GOPATH` and Append `$GOPATH/bin` to `$PATH`
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

## Check Golang Version

```
go version
``



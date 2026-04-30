# "go mod tidy" Got "Bad Gateway" Error when Use [goproxy](https://goproxy.io)

## Problem
* Set GOPROXY to [goproxy](https://goproxy.io)

  ```sh
  vi ~/.zprofile
  ```
  ```sh
  export GOPROXY="https://goproxy.io,direct"
  export GOSUMDB="sum.golang.google.cn"
  ```
* Works fine for a long time
* One day, it failed run `go mod tidy` or `go install` and got error:

  > module github.com/xx/xx: reading https://goproxy.io/github.com/xx/xx/@v/list: 502 Bad Gateway

## Root Cause
* [goproxy](https://goproxy.io) can not work for China for some reason

## Solution
Use [aliyun gomodule mirror] instead.

```sh
vi ~/.zprofile
```
```sh
export GOPROXY="https://mirrors.aliyun.com/goproxy/,direct"
export GOSUMDB="sum.golang.google.cn"
```

# Get Golang Packages on Golang.org in China

#### Background
* Golang.org is blocked in China.

#### Problem
* Can't run `go get golang.org/x/XX` to get Google Golang packages.

#### Solutions
* Solution A: Use [github mirror](https://github.com/golang)

  1. Get the mirror package path:
     `golang.org/x/PATH_TO_PACKAGE`  --> `github.com/golang/PATH_TO_PACKAGE`.

            // Ex:
            golang.org/x/net/context --> github.com/golang/net/context
  2. Run `go get` to download the package source code from github mirror.

            // Ex:
            go get github.com/golang/net/context

  3. You'll see error:

            package github.com/golang/net/context:
            code in directory /go/src/github.com/golang/net/context
            expects import "golang.org/x/net/context"

  4. Don't care about the error.
     You'll see full source code of the package has been download successfully under `$GOPATH/src/github.com/golang/PATH_TO_PACKAGE`.

  5. Copy `$GOPATH/src/github.com/golang/PATH_TO_PACKAGE` to `$GOPATH/src/golang.org/x/PATH_TO_PACKAGE`.

            // Ex:
            mkdir $GOPATH/src/golang.org/x -p
            cp $GOPATH/src/github.com/golang/net $GOPATH/src/golang.org/x/ -rf

  6. Run `go build` to build the package.

* Solution B: Use 3rd Party Website - <https://gopm.io/download>

  * Just input the package path and download the zip file.

#### References
* [Canonical Import Paths](https://github.com/northbright/Notes/blob/master/Golang/package/canonical_import_paths.md)

----------------------------------

# 在中国网络环境下获取Golang.org上的Golang Packages

#### 背景
* 目前在中国网络环境下无法访问Golang.org。

#### 问题
* 不能运行`go get golang.org/x/XX`来获取Golang packages。

#### 解决方案
* 方案 A: 使用[github 上的镜像](https://github.com/golang)

  1. 获取Golang Package在github镜像上的路径:
     `golang.org/x/PATH_TO_PACKAGE`  --> `github.com/golang/PATH_TO_PACKAGE`.

            // Ex:
            golang.org/x/net/context --> github.com/golang/net/context
  2. 运行`go get`来安装github镜像的Golang packages。
  
            // Ex:
            go get github.com/golang/net/context

  3. 你会碰到如下错误提示:

            package github.com/golang/net/context:
            code in directory /go/src/github.com/golang/net/context
            expects import "golang.org/x/net/context"

  4. 忽略错误。
      Golang的Package的源代码已经成功下载于：  
      `$GOPATH/src/github.com/golang/PATH_TO_PACKAGE`.

  5. 复制 `$GOPATH/src/github.com/golang/PATH_TO_PACKAGE` 到 `$GOPATH/src/golang.org/x/PATH_TO_PACKAGE`.

            // Ex:
            mkdir $GOPATH/src/golang.org/x -p
            cp $GOPATH/src/github.com/golang/net $GOPATH/src/golang.org/x/ -rf

  6. 运行 `go build` 来编译。

* 方案 B: 使用第三方网站 - <https://gopm.io/download>

  * 输入包路径即可下载zip文件。

#### 参考资料
* [Canonical Import Paths](https://github.com/northbright/Notes/blob/master/Golang/package/canonical_import_paths.md)

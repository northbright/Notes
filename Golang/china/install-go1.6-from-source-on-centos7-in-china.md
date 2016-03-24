# Install Go1.6 from Source on CentOS 7 in China

#### Background
* Accessing Google services include Golang.org is **blocked** in China.
* Downloading precompiled Go binary package release from other sites may have the risk of 3rd party code injection like [XcodeGhost](https://en.wikipedia.org/wiki/XcodeGhost).
* `Go` canonical Git repository is located at <https://go.googlesource.com/go> while there is a mirror of the repository at <https://github.com/golang/go>
* We can still access [github](https://github.com) in China for now:-)

#### Problems
* Build process of Go1.6 requires Go1.4 binaries for [bootstrap](https://github.com/golang/go/blob/master/doc/install-source.html)(In short: It needs Go to build Go).

#### Solution
* Get golang source code from [mirror repository  hosted on github](https://github.com/golang/go)
* Build Go1.4 from source firstly(using `gcc` and `glibc-devel`, no Go binary).
* Then build Go1.6 from source with Go1.4 binaries.

#### Steps
1. If there's old version of Go installed, **unset** `$GOPATH,` `$GOROOT`

2. Make sure [Git](https://git-scm.com/) is installed.
    * Configure `Git`
        * `git config --global user.email "email-for-github"`
        * `git config --global user.name "user name"`
    * New SSH Key and Add Public Key to Github Account
        * `ssh-keygen -t rsa -b 2048`
        * Copy the public key in `~/.ssh/id_rsa.pub` and go to [github SSH settings](https://github.com/settings/ssh) to add new SSH key.

3. Install `gcc` and `glibc-devel`
  * `sudo yum install gcc glibc-devel`

4. Build Go1.4 from source
  * `cd ~/`
  * `git clone git@github.com:golang/go.git`
  * `cd go`
  *  `git checkout -b 1.4.3 go1.4.3`
  * `cd src`
  * `./all.bash`

5. Copy `~/go` to `$GOROOT_BOOTSTRAP`(It's `~/go1.4` by default)`
  * `cp ~/go ~/go1.4 -rf`

6.  Build Go1.6 from source
  * `cd ~/go`
  *  `git clean -dfx`
  * `git checkout -b 1.6 go1.6`
  *  `cd src`
  *  `./all.bash`

7. Set `$GOPATH` and add Go binary path to `$PATH`
  * `sudo vi /etc/profile`

            # Golang Env
            export PATH=$PATH:/home/xx/go/bin
            export GOPATH=/home/xx/go-projects

8. Reboot and test
  * `sudo reboot`
  * `go version`
                        
            go version go1.6 linux/amd64

--------------------------

# 在中国网络环境下从源代码安装Go1.6到CentOS 7

#### 背景
* 在当前的中国网络环境下，我们无法访问Google的服务的，包括Golang.org。
* 从第三方网站下载预编译的二进制Go发行版可能存在第三方源代码注入的风险，例如之前的[XcodeGhost](https://en.wikipedia.org/wiki/XcodeGhost)。
* `Go`的权威仓库地址是<https://go.googlesource.com/go>，同时还有一个镜像仓库在<https://github.com/golang/go>。
* 至少在目前，我们还能访问[github](https://github.com):-)

#### 问题
* Go1.6的编译过程需要Go1.4的二进来实现 [bootstrap（自举）](https://github.com/golang/go/blob/master/doc/install-source.html)(简单来说: Go需要Go自身来编译)。

#### 解决方案
* 从[Github的Go仓库镜像](https://github.com/golang/go)获取Go的源代码。
* 首先编译Go1.4（只需要`gcc`和`glibc-devel`，不需要Go来编译）。
* 使用编译好的Go1.4的二进制文件来编译Go1.6。

#### 步骤
1. 如果之前已经安装过老版本的Go，清除`$GOPATH,` `$GOROOT`变量。

2. 安装好[Git](https://git-scm.com/)。
    * 配置 `Git`
        * `git config --global user.email "email-for-github"`
        * `git config --global user.name "user name"`
    * 创建SSH key，添加Public Key到Github账号。
        * `ssh-keygen -t rsa -b 2048`
        * 复制`~/.ssh/id_rsa.pub`中的Public Key到[github SSH settings](https://github.com/settings/ssh)以添加新的SSH key

3. 安装 `gcc`和`glibc-devel`
  * `sudo yum install gcc glibc-devel`

4. 从源代码编译安装Go1.4
  * `cd ~/`
  * `git clone git@github.com:golang/go.git`
  * `cd go`
  *  `git checkout -b 1.4.3 go1.4.3`
  * `cd src`
  * `./all.bash`

5. 复制 `~/go` 到 `$GOROOT_BOOTSTRAP`（默认值是`~/go1.4`）
  * `cp ~/go ~/go1.4 -rf`

6. 从源代码编译安装Go1.6
  * `cd ~/go`
  *  `git clean -dfx`
  * `git checkout -b 1.6 go1.6`
  *  `cd src`
  *  `./all.bash`

7. 设置 `$GOPATH` 以及添加Go二进制路径到 `$PATH`
  * `sudo vi /etc/profile`

            # Golang Env
            export PATH=$PATH:/home/xx/go/bin
            export GOPATH=/home/xx/go-projects

8. 重启和测试
  * `sudo reboot`
  * `go version`
                        
            go version go1.6 linux/amd64

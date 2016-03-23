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
* Build Go1.4 from source firstly.
* Then build Go1.6 from source with Go1.4 binaries.

#### Steps
1. If there's old version of Go installed, **unset** `$GOPATH,` `$GOHOME`

2. Make sure [Git](https://git-scm.com/) is installed.
    * Configure `git`
        * `git config --global user.email "email-for-github"`
        * `git config --global user.name "user name"`
    * New SSH Key and Add Public Key to Github Account
        * `ssh-keygen -t rsa -b 2048`
        * Copy the public keys in `~/.ssh/id_rsa.pub` and go to [github SSH settings](https://github.com/settings/ssh) to add new SSH key.

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

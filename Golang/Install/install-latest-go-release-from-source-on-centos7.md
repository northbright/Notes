# Install Latest Go Release from Source on CentOS 7

#### Problems
* Build process of latest Go requires Go1.4 binaries for [bootstrap](https://github.com/golang/go/blob/master/doc/install-source.html)(In short: It needs Go to build Go).

#### Solution
* Get golang source code from [mirror repository  hosted on github](https://github.com/golang/go)
* Build Go1.4 from source firstly(using `gcc` and `glibc-devel`, no Go binary).
* Then build latest Go from source with Go1.4 binaries.

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
  * `git checkout -b 1.4.3 go1.4.3`
  * `cd src`
  * `./all.bash`

5. Copy `~/go` to `$GOROOT_BOOTSTRAP`(It's `~/go1.4` by default)
  * `cp ~/go ~/go1.4 -rf`

6.  Build latest Go release from source
  * `cd ~/go`
  * `git clean -dfx`
  * `git tag -l`  
     get the tag of latest release(e.g. `go1.6.1`) 
  * `git checkout -b 1.6.1 go1.6.1`
  * `cd src`
  * `./all.bash`

7. Set `$GOPATH` and add Go binary path to `$PATH`
  * `sudo vi /etc/profile`

            # Golang Env
            export PATH=$PATH:/home/xx/go/bin
            export GOPATH=/home/xx/go-projects

8. Reboot and test
  * `sudo reboot`
  * `go version`
                        
            go version go1.6.1 linux/amd64


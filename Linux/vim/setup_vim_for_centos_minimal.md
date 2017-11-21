# Setup Vim for Centos Minimal

#### Config Proxy If Needed

    sudo vi /etc/environment

    http_proxy=http://proxy.mydomain.com:8080
    https_proxy=http://proxy.mydomain.com:8080
    no_proxy="localhost,127.0.0.1,.mydomain.com"

#### Install Vim

    yum install vim-enhanced -y

#### Check Version

    vim --version

    VIM - Vi IMproved X.X

#### Add Alias(vi = vim) and Set `VISUAL` and `EDITOR` env variables 

* Modify `/etc/profile`

        vi /etc/profile

        # VIM
        alias vi=vim

        export VISUAL=vim
        export EDITOR="$VISUAL"

* `source /etc/profile`

#### References
* [Howto Enable Vi and Vim Syntax Highlighting on Fedora / CentOS / Red Hat (RHEL)](http://www.if-not-true-then-false.com/2012/vi-vim-syntax-highlighting-on-fedora-centos-red-hat-rhel/)

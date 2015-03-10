
# Install Go on Linux

* Download Go  

        cd ~/Downloads
        wget https://storage.googleapis.com/golang/go1.4.2.linux-amd64.tar.gz
        tar -zxvf https://storage.googleapis.com/golang/go1.4.2.linux-amd64.tar.gz
        sudo mv go /usr/local

* Make go home dir to store go projects(Ex: `~/go`)

        mkdir ~/go

* Add `/usr/local/go/bin` in `$PATH` and Set `$GOPATH` in `~/.bashrc`

        # Go installation
        export PATH=$PATH:/usr/local/go/bin
        export GOPATH=$HOME/go

* Install [git](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git):

        // Ubuntu
        sudo apt-get install git

        // CentOS
        sudo yum install git

* Test

        go --help


# Go Apps Using HTTP or Other Packages Need Root Permission

1. Make `/etc/sudoers` writable for root:  
   `sudo chmod u+w /etc/sudoers`

2. Modify `/etc/sudoers`:  
   Add `/usr/local/go/bin` at the end of `secure_path`:  

     `Defaults    secure_path = /sbin:/bin:/usr/sbin:/usr/bin:/usr/local/go/bin`

3. Run `sudo` with `$GOPATH`:  
   `sudo /bin/env GOPATH=/home/XX/go go run main.go`
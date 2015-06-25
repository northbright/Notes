# SSH Config for Gerrit

#### Generate SSH Key

    ssh-keygen -t rsa

Then add the new key `~/.ssh/id_rsa.pub` to the gerrit settings(SSH Public Keys)

#### Config SSH for Gerrit Server

    vi ~/.ssh/config

    Host XX.XX.XX
    User YOUR_NAME
    Port 29418

#### References

* <https://gerrit.googlecode.com/svn/documentation/2.0/user-upload.html>
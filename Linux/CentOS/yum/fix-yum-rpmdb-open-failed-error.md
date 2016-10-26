# Fix yum error: rpmdb open failed

#### Solution

1. Backup `/var/lib/rpm`

        mkdir ~/rpm-backup
        sudo cp -avr /var/lib/rpm/ ~/rpm-backup

2. Clean db files under `/var/lib/rpm`

        sudo rm -f /var/lib/rpm/__db*

3. run `db_verify`

        sudo db_verify /var/lib/rpm/Packages

4. Rebuild rpm db

        sudo rpm --rebuilddb

5. Run `yum clean`

        sudo yum clean all

6. Run `yum update`

        sudo yum update

#### References
* [yum Error:rpmdb open failed](http://unix.stackexchange.com/questions/198703/yum-errorrpmdb-open-failed)

        

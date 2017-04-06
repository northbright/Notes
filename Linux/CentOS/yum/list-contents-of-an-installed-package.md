# List Contents of an Installed Package

#### Solution
* Use `rpm -ql <Package Name>` to List the Contents of the Installed Package.

        rpm -ql readline

        // Output:
        /lib64/libreadline.so.6
        /lib64/libreadline.so.6.2
        /usr/lib64/libhistory.so.6
        /usr/lib64/libhistory.so.6.2
        /usr/share/doc/readline-6.2
        /usr/share/doc/readline-6.2/CHANGES
        /usr/share/doc/readline-6.2/COPYING
        /usr/share/doc/readline-6.2/NEWS
        /usr/share/doc/readline-6.2/README
        /usr/share/doc/readline-6.2/USAGE
        /usr/share/info/history.info.gz
        /usr/share/info/rluserman.info.gz        

#### References
* [How to list the contents of a package using YUM?](http://stackoverflow.com/questions/104055/how-to-list-the-contents-of-a-package-using-yum)

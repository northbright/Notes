# sudo: xx command not found

#### Root Cause
* `sudo` will use `secure_path` instead of `PATH`

#### Solution

Add Your path to `secure_path`

    su
    visudo

    ## Find "secure_path" and add your own path(ex: /usr/local/bin)
    Defaults    secure_path = /usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin


#### References
* [充分发挥 sudo 的作用](http://www.ibm.com/developerworks/cn/aix/library/au-sudo/index.html)

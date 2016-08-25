# Fix Git Error: Unable to find remote helper for HTTPS

#### Root Cause
* `libcurl-devel` is not installed when compiling Git.

#### Solution
* `yum install libcurl-devel`
* Re-compile Git

#### References
* [“Unable to find remote helper for 'https'” during git clone](http://stackoverflow.com/questions/8329485/unable-to-find-remote-helper-for-https-during-git-clone)
* [git clone: fatal: Unable to find remote helper for 'https' ](http://blog.csdn.net/robertsong2004/article/details/38904681)
* [Install Latest Git from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/Git/install-latest-git-from-source-on-centos-7.md)

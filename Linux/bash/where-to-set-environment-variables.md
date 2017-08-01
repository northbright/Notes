# Where to Set Environment Variables

#### Problem
* Where to set $PATH? `~/.bashrc` or `/etc/profile`

#### Details
* `/etc/profile` 
    * `/etc/profile` is used to set system wide environmental variables on users shells.
    * The variables are sometimes the same ones that are in the .bash_profile, however this file is used to set an initial PATH or PS1 for all shell users of the system.

* `~/etc/.bashrc`
    * `~/.bash_rc` is not read by any program, and `~/.bashrc` is the configuration file of interactive instances of bash.
    * You should not define environment variables in `~/.bashrc`. The right place to define environment variables such as PATH is `~/.profile` (or `~/.bash_profile` if you don't care about shells other than bash)

#### Conclustion
* Set user's environment variables in `~/.profile`
* Set system wide environment variables in `/etc/profile`

#### References
* [Understanding a little more about /etc/profile and /etc/bashrc](http://bencane.com/2013/09/16/understanding-a-little-more-about-etcprofile-and-etcbashrc/)
* [How to correctly add a path to PATH?](https://unix.stackexchange.com/questions/26047/how-to-correctly-add-a-path-to-path)

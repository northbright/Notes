# Both stdout and stderr are Redirected to log file

`cmd > log 2>&1`

* It redirects stdout of cmd to log
* and then redirects stderr to wherever stdout is now being redirected, which is log
* both stdout and stderr are redirected to log

#### References
* [cmd 2>&1 > log vs cmd > log 2>&1](http://stackoverflow.com/questions/4699790/cmd-21-log-vs-cmd-log-21)
* [Tell me all about 2>&1 -- what's the difference between 2>&1 >foo and >foo 2>&1, and when do I use which?](http://mywiki.wooledge.org/BashFAQ/055)
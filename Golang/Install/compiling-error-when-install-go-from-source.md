# Compiling Error when Install Go from Source

#### Problem
After run `./all.bash` to build Go1.6, I got the `signal: killed` errors like this:  

    runoutput            rotate2.go          : incorrect output
    go build command-line-arguments: signal: killed

    signal: killed

#### Root Cause
* System is out of memory.
* run `sudo vi /var/log/messages` and found go compiling process was killed by kernel.  

    Mar 20 15:24:28 centos7 kernel: Out of memory: Kill process 5011 (compile) score 167 or sacrifice child
    Mar 20 15:24:28 centos7 kernel: Killed process 5011 (compile) total-vm:322196kB, anon-rss:308992kB, file-rss:604kB

* I had assigned 1024MB to the VM.

#### Solution
* Make sure your system has enough memory(>= 2048MB is OK for me to solve this problem)

#### References
* [go1.1RC2: compiling error in linux/amd64](https://github.com/golang/go/issues/5432)

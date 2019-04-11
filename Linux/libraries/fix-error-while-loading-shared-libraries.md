# Fix Error while Loading Shared Libraries

## Problem
* Get error: `error while loading shared libraries: libxx.so.x.x: cannot open shared object file: No such file or directory` while launch application

## Solution
1. Try to run:  
   `LD_LIBRARY_PATH=/home/xx/MY_LIB_PATH ./MY_APP` to see if it works

2. If it works, add library path:  

       su
       echo '/home/xx/MY_LIB_PATH' > /etc/ld.so.conf.d/mylib.conf
       exit

       sudo ldconfig
       ldconfig -p | grep xx.so
   

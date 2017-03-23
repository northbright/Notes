# Fix Error while Loading Shared Libraries

1. Try to run:  
   `LD_LIBRARY_PATH=/home/xx/MY_LIB_PATH ./MY_APP` to see if it works

2. If it works, add library path:  
   * `su`
   * `echo '/home/xx/MY_LIB_PATH' > /etc/ld.so.conf.d/mylib.conf`
   * `sudo ldconfig`
   * `sudo ldconfig -p` to check if our library is in cache
   

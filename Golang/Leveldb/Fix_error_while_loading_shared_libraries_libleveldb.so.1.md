
# Fix Error while loading shared libraries libleveldb.so.1 when golang apps which use leveldb

1. Try to run:  
   `LD_LIBRARY_PATH=/home/XX_ACCOUNT/LEVELDB_PATH ./MY_APP` to see if it works

2. If it works, add leveldb library path:  
   * `su`
   * `echo '/home/XX_ACCOUNT/LEVELDB_PATH' > /etc/ld.so.conf.d/leveldb.conf`
   * `sudo ldconfig`
   * `sudo ldconfig -p` to check if leveldb library is in cache
   
For more, see:  
<https://groups.google.com/forum/#!topic/golang-nuts/rllHbvhS9nQ>

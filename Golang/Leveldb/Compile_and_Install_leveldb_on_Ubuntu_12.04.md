
# Compile and Install leveldb on Ubuntu 12.04

1. Install `g++` to compile `leveldb`:  
   `sudo apt-get install g++ -y`

2. Install `snappy`(compression lib used by `leveldb`):  
   `sudo apt-get install libsnappy-dev -y`

3. Download `leveldb` from <https://github.com/google/leveldb/archive/master.zip>  
   `wget https://github.com/google/leveldb/archive/master.zip`  
   `unzip master.zip`

4. Compile & Install `leveldb`:  

        cd leveldb-master
        make
        sudo cp libleveldb.* /usr/local/lib
        sudo cp include/leveldb /usr/local/include -rf
        sudo ldconfig
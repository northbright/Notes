# Install leveldb From Source on Ubuntu 12.04

#### Steps
1. Set Proxy for `apt-get` if needed:  

  * Set http / https / ftp proxy in `/etc/apt/apt.conf.d/01proxy`:

            echo 'Acquire::http::Proxy "http://xx.com:8080";' | sudo tee --append /etc/apt/apt.conf.d/01proxy

  * Refernce:  
    <https://github.com/northbright/Notes/blob/master/Linux/Ubuntu/set_proxy_for_apt-get.md>

2. Install `g++` to compile `leveldb`:  
   `sudo apt-get install g++ -y`

3. Install `snappy`(compression lib used by `leveldb`):  
   `sudo apt-get install libsnappy-dev -y`

4. Download `leveldb` from <https://github.com/google/leveldb/archive/master.zip>  
   `wget https://github.com/google/leveldb/archive/master.zip`  
   `unzip master.zip`

5. Compile `leveldb`:  

        cd leveldb-master
        make

6. Install leveldb libraries
   * Create a conf file for `/etc/ld.so.conf`:
   
            sudo vi /etc/ld.so.conf.d/usrlocallib.conf
            ## add below line:
            /usr/local/lib
 
   * Copy libs and run ldconfig to update cache
   
            sudo cp include/leveldb /usr/local/include -rf
            sudo cp out-shared/libleveldb.* /usr/local/lib
            sudo ldconfig

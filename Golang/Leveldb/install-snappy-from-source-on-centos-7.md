# Install snappy from Source on CentOS 7

1. Download [snappy](https://github.com/google/snappy):  
   `wget https://github.com/google/snappy/archive/master.zip`

2. Install packages:  
   `sudo yum install unzip automake libtook gcc-c++`

3. Unzip `master.zip`:  
   `unzip master.zip`

4. `cd snappy-master`

5. Build snappy
   * `./autogen.sh`
   * `./configure`
   * `make`
   * `sudo make install`

   If you encountered errors during make because of lacking of some packages(ex: gcc-c++), please run `make clean` then go to step 5 to build snappy again.

6. Check `/usr/local/include` and `/usr/local/lib` to see if snappy header and libraries are copied successfully
7. Create a conf file to make `/usr/local/lib` path is in ldconfig cache

   * Create a conf file for `/etc/ld.so.conf`:
   
            sudo vi /etc/ld.so.conf.d/usrlocallib.conf
            ## add below line:
            /usr/local/bin

   * Reload `ldconfig` cache  
     `sudo ldconfig` 


# Compile and install snappy on CentOS 7

1. Download [snappy](https://github.com/google/snappy):  
   `wget https://github.com/google/snappy/archive/master.zip`

2. Install `unzip`:  
   `sudo yum install unzip`

3. Unzip `master.zip`:  
   `unzip master.zip`

4. `cd snappy-master`

5. Run `./autogen.sh` and you'll find some pkgs were not installed.  
   Use `yum provides xx` to get the package name.

   * Install `automake`:  
     `sudo yum install automake`

   * Install `libtool`:  
     `sudo yum install libtool`

   * `./autogen.sh`
   * `./configure`
   * `make`
   * `sudo make install`

6. Check `/usr/local/include` and `/usr/local/lib` to see if snappy header and libraries are copied successfully
7. Create a conf file to make `/usr/local/lib` path is in ldconfig cache

   * Create a conf file for `/etc/ld.so.conf`:
   
            sudo vi /etc/ld.so.conf.d/usrlocallib.conf
            ## add below line:
            /usr/local/bin

   * Reload `ldconfig` cache  
     `sudo ldconfig` 
# Install [LevelDB](https://github.com/google/leveldb) from Source on CentOS 7

#### Steps
1. [Install Snappy from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/snappy/install-snappy-from-source-on-centos-7.md) 

2. Download `leveldb` from <https://github.com/google/leveldb/archive/master.zip>

        wget https://github.com/google/leveldb/archive/master.zip
        unzip master.zip

3. Compile `leveldb`:

        cd leveldb-master
        make

4. Install libs
   * Copy files

            sudo cp include/leveldb /usr/local/include -rf
            sudo cp out-shared/libleveldb.* /usr/local/lib

   * Create a conf file for `/etc/ld.so.conf`:

            sudo vi /etc/ld.so.conf.d/usrlocallib.conf
            ## add below line:
            /usr/local/lib

   * Reload `ldconfig` cache

            sudo ldconfig


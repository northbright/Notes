# Install [LevelDB](https://github.com/google/leveldb) From Source on CentOS 7

#### Steps
1. Download `leveldb` from <https://github.com/google/leveldb/archive/master.zip>

        wget https://github.com/google/leveldb/archive/master.zip
        unzip master.zip

2. Compile `leveldb`:

        cd leveldb-master
        make

3. Install libs
   * Copy files

            sudo cp include/leveldb /usr/local/include -rf
            sudo cp out-shared/libleveldb.* /usr/local/lib

   * Create a conf file for `/etc/ld.so.conf`:

            sudo vi /etc/ld.so.conf.d/usrlocallib.conf
            ## add below line:
            /usr/local/lib

   * Reload `ldconfig` cache

            sudo ldconfig


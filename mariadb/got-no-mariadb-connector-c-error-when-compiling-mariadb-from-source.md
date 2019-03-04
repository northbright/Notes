# Got "No MariaDB Connector/C" Error when Compiling MariaDB from Source

## Problem
Got "No MariaDB Connector/C" when running CMake

## How to Reproduce
* Download MariaDB source code on <https://github.com/MariaDB/server/releases>

      wget https://github.com/MariaDB/server/archive/mariadb-10.3.13.tar.gz -O mariadb-10.3.13.tar.gz
      tar -xzvf mariadb-10.3.13.tar.gz
      cd mariadb-10.3.13

* CMake

      // Remove CMakeCache.txt before CMake
      rm CMakeCache.txt

      // CMake without any extra options to reproduce the error
      cmake .
      
      // Got Error: 
      //     No MariaDB Connector/C Run
      //     Git submodule update --init Then restart the build

## Root Cause
Look into [`./cmake/submodules.cmake`](https://github.com/MariaDB/server/blob/10.3/cmake/submodules.cmake), it'll read `./libmariadb/CMakeLists.txt` and will fail if it does NOT exist.

* `./libmariadb` sub-dir is a [git submodule](https://git-scm.com/book/en/v2/Git-Tools-Submodules) which URL is <https://github.com/MariaDB/mariadb-connector-c>
* You may find all submodules in [`.gitmodules`](https://github.com/MariaDB/server/blob/10.3/.gitmodules)

      [submodule "libmariadb"]
          path = libmariadb
          url = https://github.com/MariaDB/mariadb-connector-c
      [submodule "storage/rocksdb/rocksdb"]
          path = storage/rocksdb/rocksdb
          url = https://github.com/facebook/rocksdb.git

* [git submodule](https://git-scm.com/book/en/v2/Git-Tools-Submodules)  will be **EMPTY** after `git clone` by default
  * Need to execute `git submodule update`  to fetch data of sub modules
* When run `cmake`, [`./cmake/submodules.cmake`](https://github.com/MariaDB/server/blob/10.3/cmake/submodules.cmake) will execute `git submodule update --init` to update submodules **automatically** if we get the source by `git clone`, otherwise it will **FAIL**
* All mariadb-x.x.x.tar.gz on <https://github.com/MariaDB/server/releases> does **NOT** contain any git data(no `.git` dir)

## Solutions
* Solution A - recommended

  Download **FULL** source code on <https://downloads.mariadb.org/> which include submodules: `./libmariadb`...

* Solution B

  Use `git clone` to the the source code
   
      // git 1.7 or above supports "--single-branch" to fetch only 1 branch
      git clone --single-branch --branch 10.3 https://github.com/MariaDB/server.git
      
      // Now cmake will update submodules automatically
      // If got index-pack failed error when update submodules, free some memory or restart
      cd server
      cmake .
      
## References
* [Git Tools - Submodules](https://git-scm.com/book/en/v2/Git-Tools-Submodules)
* [Got "index-pack failed" Error when Run `git clone`](https://github.com/northbright/Notes/blob/master/Git/got-index-pack-failed-error-when-run-git-clone.md)

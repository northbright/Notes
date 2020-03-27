# Got sqlite3 Not Found Error when Configure PHP on CentOS

## Problem
* Compile PHP on CentOS
* Got error when configure PHP

  ```
  Package requirements (sqlite3 > 3.7.4) were not met:
  Package 'sqlite3', required by 'virtual:world', not found
  ```

## Solution
* [Install Sqlite3 from Source on CentOS](https://github.com/northbright/Notes/blob/master/sqlite/install-sqlite3-from-source-on-centos.md)
* Specify flags when run `configure`

  ```
  SQLITE_CFLAGS="-I/usr/local/sqlite/include" \
  SQLITE_LIBS="-L/usr/local/sqlite/lib" \
  ./configure
  ......
  ......
  ```

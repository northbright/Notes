# Got "Can't initialize rotatable log file" Error when Start MongoDB Service

## Problem
* Installed MongoDB on Ubuntu
  * [Install MongoDB Community Edition on Ubuntu](https://github.com/northbright/Notes/blob/master/mongodb/install-mongodb-community-edition-on-ubuntu.md)
* Uninstall MongoDB and delete data dir and log dir

  ```sh
  sudo apt remove mongodb-org
  sudo rm -rf /var/lib/mongodb
  sudo rm -rf /var/log/mongodb
  ```
* Reinstall MongoDB

  ```sh
  sudo apt install mongodb-org
  sudo systemctl enable mongod
  sudo systemctl start mongod
  ```

* Got error:

   > Can't initialize rotatable log file :: caused by :: Failed to open /var/log/mongodb/mongod.log

## Root Cause
* `/var/log/mongodb/` does not exist

## Solution
Create log / data dir and set permission.

```sh
// Create log dir
sudo mkdir -p /var/log/mongodb
sudo chown -R mongodb:mongodb /var/log/mongodb/

// Create data dir
sudo mkdir -p /var/lib/mongodb
sudo chown -R mongodb:mongodb /var/lib/mongodb
```

## References
* [MongoDB --- Failed global initialization: Failed to open "/var/log/mongodb/mongod-config.log"](https://dba.stackexchange.com/questions/205412/mongodb-failed-global-initialization-failed-to-open-var-log-mongodb-mongo)
* [MongoDB Mongodb /var/log/mongodb/mongod.log 阻止了mongod的启动](https://geek-docs.com/mongodb/mongodb-questions/299_mongodb_mongodb_varlogmongodbmongodlog_prevents_mongod_from_starting.html)
* [Bing search: mongodb Failed to open /var/log/mongodb/mongod.log](https://cn.bing.com/search?q=mongodb+Failed+to+open+%2Fvar%2Flog%2Fmongodb%2Fmongod.log&form=QBLHCN&sp=-1&lq=0&pq=mongodb+failed+to+open+%2Fvar%2Flog%2Fmongodb%2Fmongod.log&sc=0-50&qs=n&sk=&cvid=7E224F91B9024DE1AF8E0DCC73746F7F)

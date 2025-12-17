# Failed to Start MongoDB Service and Got Status Code 100

## Problem
* Start MongoDB service

  ```sh
  sudo systemctl start mongod
  ```

* Got Error:

  > Main process exited, code=exited, status=100

## Root Cause
Data dir specified in `/etc/mongod.conf` does not exists.

## Solution
Create data dir specified in `/etc/mongod.conf`

```sh
sudo vi /etc/mongod.conf
```

```sh
// Find dbPath

storage:
  dbPath: /var/lib/mongodb
```

DB dir in this case: `/var/lib/mongodb`(default on Ubuntu)
```sh
sudo mkdir -p /var/lib/mongodb
sudo chown -R mongodb:mongodb /var/lib/mongodb
```

## References
* [Bing search: mongodb code=exited, status=100](https://cn.bing.com/search?q=mongodb+code%3Dexited%2C+status%3D100&form=QBLHCN&sp=-1&lq=0&pq=mongodb+code%3Dexited%2C+status%3D100&sc=3-31&qs=n&sk=&cvid=EE6011A0F0A94EC9BB5FE37EFAD0715E)

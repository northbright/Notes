# Load `dump.rdb` into Redis

## Problem
* Have a `dump.rdb` File(Redis Data File on Server A)
* Need to Load the `dump.rdb` File into Redis on Server B

## Solution
* Make Sure `appendonly` is set to `no`
* **STOP** Redis Service on Server B

  ```
  sudo systemctl stop redis
  ```

  Because Redis overwrites the current rdb file when it exits
* Copy your backup rdb file to the Redis working directory(`dir` option in `redis.conf`)
* Restart Redis Service on Server B

  ```
  sudo systemctl start redis
  ```

## References
* [How to recover redis data from snapshot(rdb file) copied from another machine?](https://stackoverflow.com/questions/14497234/how-to-recover-redis-data-from-snapshotrdb-file-copied-from-another-machine)

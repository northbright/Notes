# Fix MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk Error.

#### Problem
* A large command set(~20000000) was send to Redis pipeline.
* Redis service was killed by kernel because it caused Out of Memory.
* The error occurs when run `FLUSHALL` command.

#### Root Cause
* Previous `bgsave` failed(rdb_last_bgsave_status:err)

#### Solution
* Run `redis-cli`

        redis 127.0.0.1:6379> config set stop-writes-on-bgsave-error no

* Set `stop-writes-on-bgsave-error no` in Redis configure file to not break Redis service if bgsave failed.

#### References
* [RedisError: MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk. Commands that may modify the data set are disabled. Please check Redis logs for details about the error. #584](https://github.com/antirez/redis/issues/584)

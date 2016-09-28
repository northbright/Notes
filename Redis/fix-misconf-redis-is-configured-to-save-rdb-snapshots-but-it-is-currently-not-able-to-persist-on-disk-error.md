# Fix MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk Error.

#### Problem
* Can't do ANY write commands.

#### Root Cause
* Previous `bgsave` failed.

        redis:6379> INFO Persistence
        redis:6379> ...
        redis:6379> rdb_last_bgsave_status:err

#### Solution
* Run `redis-cli`

        redis 127.0.0.1:6379> config set stop-writes-on-bgsave-error no

* Set `stop-writes-on-bgsave-error no` in Redis configure file to not break Redis service if bgsave failed.

#### References
* [RedisError: MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk. Commands that may modify the data set are disabled. Please check Redis logs for details about the error. #584](https://github.com/antirez/redis/issues/584)

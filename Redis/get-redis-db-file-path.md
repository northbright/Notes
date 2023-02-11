# Get Redis DB File Path

## Solution
* Open Redis Config File(e.g. `/etc/redis/redis.conf`)
* Check value of `dbfilename`

  It's `dump.rdb` by default
* Check value of `dir`

  It's `/var/lib/redis` after installed redis on Ubuntu via `sudo apt install redis`
* So, the Redis DB file path: `/var/lib/redis/dump.rdb`


# Install and Config Redis-2.8.19 on CentOS 7

#### Install Redis

1. Install gcc and wget  
`yum install make gcc wget`

2. Download Source Code  
`wget http://download.redis.io/releases/redis-2.8.19.tar.gz`

3. Extract Source Code  
`tar -xzvf redis-2.8.19.tar.gz`

4. Make and Make Install
  * `cd redis-2.8.19`
  * `make`
  * `make install`  
    This will copy following binaries to `/usr/local/bin`:  
        * redis-benchmark
        * redis-check-aof
        * redis-check-dump
        * redis-cli
        * redis-sentinel
        * redis-server


#### Config Redis as a Service

1. How Many Redis Instances You Want to Run?
    * Redis instance is single threaded
    * Run multi Redis instances - <http://redis.io/topics/partitioning>

2. Copy `redis_init_script` to `/etc/rc.d/init.d/` and Rename it to `redis_<port>`  

    Ex: We want to run 2 Redis instances on port 6379 and 6380
    * `cd ~/redis-2.8.19`
    * `sudo cp ~/redis-2.8.19/utils/redis/redis_init_script /etc/rc.d/init.d/redis_6379`
    * `sudo cp ~/redis-2.8.19/utils/resis/redis_init_script /etc/rc.d/init.d/redis_6380`

3. Modify each `/etc/rc.d/init.d/redis_<port>`

    * insert `# chkconfig: 2345 80 90` at 2nd line
      
            #!/bin/sh
            # chkconfig: 2345 80 90
            # Simple Redis init.d script conceived to work on Linux systems
            # as it does use of the /proc filesystem.
  
        This line will make redis configurable by `chkconfig` command.  
        It defines that on runlevels 2,3,4 and 5, this subsystem will be activated with priority 95 (one of the lasts), and deactivated with priority 05 (one of the firsts).

    * set `REDISPORT=XXXX` for each redis instance  
        `REDISPORT=6379` for `redis_6379`, `REDISPORT=6380` for `redis_6380` and so on...

    * `CONF="/etc/redis/${REDISPORT}.conf"` means you need to copy redis.conf to `/etc/redis/` and rename it to `<port>.conf`
        * `sudo cp ~/redis-2.8.19/redis.conf /etc/redis/6379.conf`
        * `sudo cp ~/redis-2.8.19/redis.conf /etc/redis/6380.conf`

4. Modify `/etc/redis/<port>.conf`
    * set `daemonize yes`
    * set `port 6379` for `6379.conf` and `port 6380` for `6380.conf`
    * set different rdb file paths for each redis instance  
        Ex:  
        `dir /home/xx/nodes/1/` for `6379.conf`  
        `dir /home/xx/nodes/2/` for `6380.conf` and so on...

5. Use `chkconfig --add <service_name>` to add redis services  
   `chkconfig --add redis_6379`  
   `chkconfig --add redis_6380`

6. Reboot 
# Install Latest Redis from Source on CentOS 7

## Install Dependencies

* Install `gcc`, `wget`, `tcl`(for redis make test)  

       yum install make gcc wget tcl

## Git Clone Official Repo: <https://github.com/antirez/redis>

    git clone https://github.com/antirez/redis.git
    cd redis
      
    # List tags to find latest stable release(e.g. 5.0.3)
    git tag -l
      
    # Checkout latest release
    git checkout -b 5.0.3 5.0.3

## Make and Install
 
    make
    make test
    
    # Install Redis binaries to `/usr/local/bin`
    sudo make install

## Create Folders to Store Redis Data Files

    # Create a folder to store DB file for Redis instance on port 6379(default)
    mkdir -p /home/xx/redis-db/6379

## Redis Config File
* Make `/etc/redis` Folder

      sudo mkdir /etc/redis

* Copy `redis.conf` to `/etc/redis/`      

      # File name is ${REDISPORT}.conf
      sudo cp redis.conf /etc/redis/6379.conf

* Set `daemonize` to `yes`

      daemonize yes

  When set `daemonize` to `yes`, set `Type=forking` under `[Service]` Section in  `/etc/redis/${REDISPORT}.service` later.

* Set `port`

      port 6379

* Set `pidfile` to `/var/run/redis_${REDISPORT}.pid`

      pidfile /var/run/redis_6379.pid

* Set `Dir` to Store Redis DB File

      dir /home/xx/redis-db/6379/

* Set `logfile` to `/var/log/redis_${REDISPORT}.log`

      logfile "/var/log/redis_6379.log"

## Configure Redis as a `systemd` Service

* Copy  `utils/redis_init_script` to `/etc/rc.d/init.d/redis_${REDISPORT}`

      sudo cp utils/redis_init_script /etc/rc.d/init.d/redis_6379

      # Add "exec bits"
      sudo chmod a+x /etc/rc.d/init.d/redis_6379

* Create  `/etc/systemd/system/redis_${REDISPORT}.service`

      sudo vi /etc/systemd/system/redis_6379.service

      [Unit]
      Description=Redis 
      After=network.target

      [Service]
      Type=forking
      ExecStart=/etc/rc.d/init.d/redis_6379 start
      ExecStop=/etc/rc.d/init.d/redis_6379 stop

      [Install]
      WantedBy=multi-user.target

* Enable / Start Redis Service

      sudo systemctl daemon-reload
      sudo systemctl enable redis_6379
      sudo systemctl start redis_6379
     
      # Check Redis Service Status
      systemctl status redis_6379
      systemctl -a | grep redis
      
* Warning
   If configure master-slave replication and master is set to NOT write to disk(comment all `save` lines), make sure not configure redis as service:
   * redis-server will restart on server restart(maybe server crashed, has to reboot it).
   * slave will sync to master and remove all data on slave's disk(master is empty in memory).
   * For more, see <http://redis.io/topics/replication>

## System Kernel Settings
In order to Redis work correctly you need to set some kernel options.
Without settings, you may see the warnings in `/var/log/redis_6379.log` when starting Redis server:

> WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.
Server initialized
WARNING overcommit_memory is set to 0! Background save may fail under low memory condition. To fix this issue add 'vm.overcommit_memory = 1' to /etc/sysctl.conf and then reboot or run the command 'sysctl vm.overcommit_memory=1' for this to take effect.
WARNING you have Transparent Huge Pages (THP) support enabled in your kernel. This will create latency and memory usage issues with Redis. To fix this issue run the command 'echo never > /sys/kernel/mm/transparent_hugepage/enabled' as root, and add it to your /etc/rc.local in order to retain the setting after a reboot. Redis must be restarted after THP is disabled.

* Set `vm.overcommit_memory` to `1`

      sudo sysctl -w vm.overcommit_memory=1

* Set `net.core.somaxconn` to a value larger than `tcp-backlog` set in `${REDISPORT}.conf`

      # tcp-backlog is 511 by default, we use 512 here
      sudo sysctl -w net.core.somaxconn=512
      
 * Disable Transparent Huge Pages Support 

       su
       echo never > /sys/kernel/mm/transparent_hugepage/enabled
       exit

       # Add the script to `/etc/rc.local` to retain the setting after a reboot
       sudo vi /etc/rc.local
       # Append this script at the bottom of the file
       echo never > /sys/kernel/mm/transparent_hugepage/enabled

## References
* [How to Install Redis Server on CentOS 7](https://linoxide.com/storage/install-redis-server-centos-7/)
* [systemctl管理Redis启动、停止、开机启动](https://blog.csdn.net/chwshuang/article/details/68489968)
* [CentOs 7: Systemd & PID File #3716](https://github.com/antirez/redis/issues/3716)

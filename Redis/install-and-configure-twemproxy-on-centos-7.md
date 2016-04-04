# Install and Configure twemproxy on CentOS 7

#### Install [twemproxy](https://github.com/twitter/twemproxy) from Source

* Install `automake` and `libtool`

        sudo yum install -y automake libtool

* Make twemproxy

        cd ~/
        git clone git@github.com:twitter/twemproxy.git
        cd twemproxy
        autoreconf -fvi
        ./configure
        make

* Copy binary to `/usr/local/bin`
        
        sudo cp src/nutcracker /usr/local/bin

#### Create a twemproxy  configuration file(.yml)
* We can re-use `~/twemproxy/conf/nutcracker.yml`:
  
        sudo mkdir /etc/twemproxy
        sudo cp  ~/twemproxy/conf/nutcracker.yml /etc/twemproxy/my.yml
        sudo vi /etc/twemproxy/my.yml
        
        // my.yml
        beta:
        listen: 127.0.0.1:22122
          hash: fnv1a_64
          hash_tag: "{}"
          distribution: ketama
          auto_eject_hosts: false
          timeout: 400
          redis: true
          servers:
           - 127.0.0.1:6380:1 server1
           - 127.0.0.1:6381:1 server2
           - 127.0.0.1:6382:1 server3
           - 127.0.0.1:6383:1 server4

#### Configure twemproxy as a `systemd` service

* Create `twemproxy.service` file

        sudo vi /etc/systemd/system/twemproxy.service

        // twemproxy.service
        [Unit]
        Description=twemproxy

        [Service]
        Type=simple
        ExecStart=/usr/local/bin/nutcracker -c /etc/twemproxy/my.yml

        [Install]
        WantedBy=multi-user.target

* Add `twemproxy.service` to `systemd`

        sudo systemctl daemon-reload
        sudo systemctl start twemproxy.service
        sudo systemctl status twemproxy.service
        sudo systemctl stop twemproxy.service
        sudo systemctl enable twemproxy.service
        sudo reboot

* Connect to twemproxy

        redis-cli -p <port_in_yml_file>
        Ex:
        redis-cli -p 22122


    

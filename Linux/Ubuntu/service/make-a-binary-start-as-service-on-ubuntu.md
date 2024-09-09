# Make a Binary Start as Service on Ubuntu

## Problem
* Write a Web Server(backend: Golang app, frontend: Quasar(Vue) SPA)
* Need to Start the HTTP Server as Service
* Depend on `redis-server.service`

## Solution
Create a `systemd` service.

* Create a `MY_APP.service` file under `/etc/systemd/system`

  ```
  sudo vi /etc/systemd/system/MY_APP.service
  ``` 

  Copy following lines
  ```
  [Unit]
  Description=MY_APP-service
  After=redis-server.service

  [Service]
  Type=simple
  ExecStart=/home/xx/PATH_TO_MY_APP/

  [Install]
  WantedBy=multi-user.target
  ```

* Reload Daemon Services

  ```
  sudo systemctl daemon-reload
  ```

* Enable, Start and Check `MY_APP.service`

  ```
  sudo systemctl enable MY_APP.service
  sudo systemctl start MY_APP.service
  ```

  ```
  sudo systemctl status MY_APP.service
  ```

## References
* [how to make a binary file to start as a service](https://askubuntu.com/questions/1314936/how-to-make-a-binary-file-to-start-as-a-service)
* [systemd service with multiple After](https://serverfault.com/questions/940220/systemd-service-with-multiple-after)
* [In systemd, what's the difference between After= and Requires=?](https://serverfault.com/questions/812584/in-systemd-whats-the-difference-between-after-and-requires)

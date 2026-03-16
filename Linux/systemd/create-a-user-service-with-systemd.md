# Create a User Service with systemd

## Problem
* [OpenClaw installs a systemd user service by default](https://docs.openclaw.ai/platforms/linux#system-control-systemd-user-unit)
* Can control `systemd` user service **without** `sudo`
* After enabled the systemd user service, it can start automatically once user login 
* Need to create a systemd user service like it 

## Solution

#### Prepare a binary or `.sh` as executable

For example we create a shell to show username and time in a loop as a service.

```sh
vi ~/example_service
```

```sh
!/bin/bash

while true
do
    now=$(date)
    me=$(whoami)
    echo "User $me at $now"
    sleep 10
done  
```

```sh
# Add Executable Permission

chmod a+x ~/example_service
```

#### Create a Unit File under `~/.config/systemd/user/`

```sh
vi ~/.config/systemd/user/example.service
```

Replace xx with your own user name.

```sh
[Unit]
Description=Example Service
After=
Wants=

[Service]
ExecStart=/home/xx/example_service
Restart=always
Environment=HOME=/home/xx

[Install]
WantedBy=default.target
```

#### Enable and Start systemd User Service
Run `systemctl` with `--user` flag for enable / start / status / ...

* Enable Service

  ```sh
  systemctl --user enable example.service

  // Output:
  Created symlink /home/xx/.config/systemd/user/default.target.wants/example.service → /home/xx/.config/systemd/user/example.service.
  ```

* Start Service

  ```sh
  systemctl --user start example.service
  ```

* Get Status

  ```sh
  systemctl --user status example.service

  // Output:
  User xx at Mon Mar 16 13:53:32 CST 2026
  ```

* Show Logs

  ```sh
  journalctl --user -u example.service
  ```

## References
* [OpenClaw installs a systemd user service by default](https://docs.openclaw.ai/platforms/linux#system-control-systemd-user-unit)
* [How do I make my systemd service run via specific user and start on boot?](https://askubuntu.com/questions/676007/how-do-i-make-my-systemd-service-run-via-specific-user-and-start-on-boot)
* [https://askubuntu.com/questions/676007/how-do-i-make-my-systemd-service-run-via-specific-user-and-start-on-boot(byteborg's answer](https://askubuntu.com/questions/676007/how-do-i-make-my-systemd-service-run-via-specific-user-and-start-on-boot)
* [Creating User’s Services With systemd](https://www.baeldung.com/linux/systemd-create-user-services)

# Set Environment Variable for a User systemd Service

## Solution
Set `EnvironmentFile` in the systemd unit file.

* Create an environment file(e.g. `~/.env`)

  ```sh
  vi ~/.env
  ```

  ```sh
  MY_VAR="xx"
  ```

* Set `EnvironmentFile` in the systemd unit file

  ```sh
  vi ~/.config/systemd/user/example.service
  ```

  ```
  [Unit]
  Description=Example Service
  After=
  Wants=

  [Service]
  ExecStart=/home/xx/example_service
  Restart=always
  EnvironmentFile=/home/xx/.env

  [Install]
  WantedBy=default.target
  ```

* Reload systemd daemon

  ```sh
  systemd --user daemon-reload
  ```

* Restart Service

  ```sh
  systemd --user restart example.service
  ```

## References
* [Create a User Service with systemd](https://github.com/northbright/Notes/blob/master/Linux/systemd/create-a-user-service-with-systemd.md)
* [Setting Environment Variables for systemd Services](https://www.baeldung.com/linux/systemd-services-environment-variables)
* [How to set environment variable in systemd service?](https://serverfault.com/questions/413397/how-to-set-environment-variable-in-systemd-service)
* [environment variables for daemons](https://unix.stackexchange.com/questions/374398/environment-variables-for-daemons)

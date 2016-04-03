# Use `systemctl` to Manage Services

Since Centos 7 use `systemd` to replaces `SysVinit`, it's time to learn `systemctl` command.

#### Enable / Disable Service

        sudo systemctl enable <service_name>.service
        sudo systemctl disable <service_name>.service

#### List Services

        // List all services include inactive services
        systemctl --all

        // List active services
        systemctl list-units

        // List unit files
        systemctl list-unit-files

#### Start / Stop Service

        sudo systemctl start <service_name>.service
        sudo systemctl stop <service_name>.service

#### References
* [CoreOS实践指南（三）：系统服务管家Systemd](http://www.csdn.net/article/2015-01-08/2823477/1)



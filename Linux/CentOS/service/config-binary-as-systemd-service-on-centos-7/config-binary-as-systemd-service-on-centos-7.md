# Configure Binary as `systemd` Service on CentOS 7

#### Create `/etc/systemd/system/my.service`

    [Unit]
    Description=my-service

    [Service]
    Type=simple
    ExecStart=/path/to/my-binary

    [Install]
    WantedBy=multi-user.target

#### Configure as systemd Daemon Service

    // Reload Daemon Services after add my.service
    sudo systemctl daemon-reload

    // Start Service
    sudo systemctl start my.service

    // Get Status of Service
    sudo systemctl status my.service

    // Stop Service
    sudo systemctl stop my.service

    // Enable Starting Service on Boot
    sudo systemctl enable my.service

    // Reboot
    sudo reboot

#### Example
* [sample .service file](./data2report.service)
* [sample install service script](./install.sh)

#### References
* [CoreOS实践指南（三）：系统服务管家Systemd](http://www.csdn.net/article/2015-01-08/2823477/1)
* <http://techarena51.com/index.php/how-to-create-an-init-script-on-centos-6/>

# Configure Bash Script as `systemd` Daemon Service on CentOS 7

#### Create `/etc/systemd/system/mybash.service`

    [Unit]
    Description=mybash

    [Service]
    Type=simple
    ExecStart=/path/to/mybash

    [Install]
    WantedBy=multi-user.target

#### Configure Our Bash Script as systemd Daemon Service

    // Reload Daemon Services after add mybash.service
    sudo systemctl daemon-reload

    // Start Service
    sudo systemctl start mybash.service

    // Get Status of Service
    sudo systemctl status mybash.service

    // Stop Service
    sudo systemctl stop mybash.service

    // Enable Starting Service on Boot
    sudo systemctl enable mybash.service

#### References
* [sample .service file](./data2report.service)
* [sample install service script](./install.sh)
* <http://techarena51.com/index.php/how-to-create-an-init-script-on-centos-6/>
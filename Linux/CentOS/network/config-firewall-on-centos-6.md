# Config Firewall on CentOS 6

#### Install `system-config-firewall-tui`

    sudo yum install -y system-config-firewall-tui

#### Run `system-config-firewall-tui`
* Customize the firewall settings: e.g. SSH, HTTP.

#### If you get error when run `system-config-firewall-tui` 

    dbus.exceptions.DBusException: org.freedesktop.DBus.Error.FileNotFound: Failed to connect to socket /var/run/dbus/system_bus_socket: No such file or directory

* Start message bus dameon to fix it.

        // install dbus if need
        sudo yum install -y dbus

        // start message bus
        service messagebus start

#### References
* [System-config-firewall-tui does not startup on CentOS – Failed to connect to socket system_bus_socket [Solved]](https://techglimpse.com/solution-setup-firewall-command-dbus-error/)

# Can not Resolve any Hostname may Caused by IP Conflict

#### Problem
* "Can not resolve xxx hostname" occurs when use Git or CURL on this Monday.
* It works 2 days ago(Last Friday).
* PC keeps power off during the weekend.

#### Root Cause
* Static IP has been found in network setting of this PC.

        # /etc/sysconfig/network-scripts/ifcfg-enXX
        BOOTPROTO=static
        IPADDR=192.168.1.121

* There's no entry of static IP-to-MAC table found in Router's DHCP settings.

* The static IP may be assigned to another PC during the weekend.

#### Solution
1. Goto Router Settings

    * Release the IP address in DHCP pool.

    * Add a new entry to Static IP-to-MAC table in DHCP settings.

    * Find an unused IP in DHCP pool to assign static IP.

2. Goto PC network settings.

    * Update network settings with this new static IP

    * Restart network service or reboot.

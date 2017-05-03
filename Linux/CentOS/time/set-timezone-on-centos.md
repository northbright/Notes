# Set Timezone on CentOS

#### Get Current Time / Timezone Information

Use `timedatectl` command

    timedatectl

    // Output:
    Local time: 三 2017-05-03 00:58:58 EDT
    Universal time: 三 2017-05-03 04:58:58 UTC
        RTC time: 三 2017-05-03 04:58:57
        Time zone: America/New_York (EDT, -0400)
        NTP enabled: n/a
        NTP synchronized: no
        RTC in local TZ: no
        DST active: yes
        Last DST change: DST began at
                         日 2017-03-12 01:59:59 EST
                         日 2017-03-12 03:00:00 EDT
        Next DST change: DST ends (the clock jumps one hour backwards) at
                         日 2017-11-05 01:59:59 EDT
                         日 2017-11-05 01:00:00 EST

#### List Timezones and Copy the Timezone

    timedatectl list-timezones

    // Output:
    ......
    Asia/Shanghai
    ......

#### Set Timezone

    sudo timedatectl set-timezone Asia/Shanghai

#### References
* [Chapter 2. Configuring the Date and Time](https://access.redhat.com/documentation/en-US/Red_Hat_Enterprise_Linux/7/html/System_Administrators_Guide/chap-Configuring_the_Date_and_Time.html)

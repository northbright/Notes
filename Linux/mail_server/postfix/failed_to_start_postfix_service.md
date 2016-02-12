# Failed to Start Postfix Service

## Description
    // Check Postfix service status
    sudo systemctl status postfix.service

    // Enable Postfix service if it's disabled
    sudo systemctl enable postfix.service

    // Start Postfix service
    sudo systemctl start postfix.service


It failed to start postfix.service:  

* Job for postfix.service failed. See 'systemctl status postfix.service' and 'journalctl -xn' for details.

* After run `journalctl -xn`  
  We got the error: `fatal parameter inet_interfaces no local interface found for ::1`

## Root Cause
* local interface can not be found for **ipv6**
* `inet_protocols = all`  
  ipv6 protocol is enabled by default.

## Solution
Use ipv4 only for localhost  

* Set `inet_protocols = ipv4` in `/etc/postfix/main.cf`:

        sudo vi /etc/postfix/main.cf
        ...
        inet_protocols = ipv4
        ...

* Restart postfix.servivce
        
        sudo systemctl start postfix.service

## References
* [解决阿里云postfix邮件发不出去的问题](http://ju.outofmemory.cn/entry/80844)
* <https://bbs.aliyun.com/simple/?t135851.html>
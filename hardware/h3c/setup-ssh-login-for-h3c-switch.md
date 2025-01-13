# Setup SSH Login for H3C Switch

## Setup IP Address
* Select VLAN Interface(e.g. VLAN Interface 1)

       interface vlan 1
       ip address 192.168.1.240 24

        // Check
        display vlan 1

        // Outpout:
        // ...
        // IPv4 address: 192.168.1.240
        // IPv4 subnet mask: 255.255.255.0

## Enable SSH Server
* Check SSH Server Status

       display ssh server status

* Enable SSH Server

       ssh server enable

## Create Publick Keys

```
public-key local create ecdsa secp256r1
```

## Set User Interface

    // 0, 4 means vty 0 - 4, total 5 user interfaces(lines) shared the same settings
    user-interface vty 0 4

    // Set authentication mode to scheme(AAA) which is required for SSH login
    authentication-mode scheme

    // Set protocol
    protocol inbound ssh

    // Quit
    quit

## Create SSH User

    // Create user xx
    local-user xx
    
    // Set password for xx
    password

    // Set service type of the user
    // use "service-type ?" to show all types
    service-type ssh

    // Set user role to network-admin
    // use "authorization-attribute user-role ?" to show all roles
    authorization-attribute user-role network-admin

    // Check
    display this

## Test
* Login via [`putty`](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html) to Test

## References
* [h3c交换机配置ssh密码验证登录方式](https://blog.csdn.net/skyxmstar/article/details/83828313)
* [H3C S5130S-EI系列以太网交换机 - 配置指导 - 08安全配置指导](http://www.h3c.com/cn/d_201710/1038136_30005_0.htm)
* [Fix "no matching host key type found" Issue when SSH into H3C Switch](https://github.com/northbright/Notes/blob/master/hardware/h3c/fix-no-matching-host-key-type-found-issue-when-ssh-into-h3c-switch.md)
* [SSH returns: no matching host key type found. Their offer: ssh-dss](https://askubuntu.com/questions/836048/ssh-returns-no-matching-host-key-type-found-their-offer-ssh-dss)
* [OpenSSH declares ssh-rsa deprecated. What do I do next?](https://security.stackexchange.com/questions/226131/openssh-declares-ssh-rsa-deprecated-what-do-i-do-next)
* [H3C交换机SSH使用RSA公钥免密登录配置](https://www.cnblogs.com/powpoia/p/18459875)


# Allow PC on Local Network Send Mail to Postfix Server

#### Steps

* Run `ifconfig` to get the local IP address(Ex: 15.15.1.2) of the PC runs `Postfix`

* Modify `/etc/postfix/main.cf`  

  * Set `inet_interfaces = IP of PC runs postfix`
        
        `Ex: inet_interfaces = 15.15.1.2`

  * Set `mynetworks = IP of another PC, 127.0.0.1`

        `Ex: mynetworks = 15.15.1.2, 127.0.0.1`

* Restart `Postfix`

        sudo systemctl stop postfix.service
        sudo systemctl start postfix.service
        sudo systemctl status postfix.service

* Config Firewalld(Centos 7)

        sudo firewall-cmd --permanent --zone=public --add-service=smtp
        sudo firewall-cmd --reload

#### References
* [Setup Postfix to Send Mail on Centos 7 Minimal](https://github.com/northbright/Notes/blob/master/Linux/mail_server/postfix/setup_postfix_to_send_mail_on_centos_minimal.md)
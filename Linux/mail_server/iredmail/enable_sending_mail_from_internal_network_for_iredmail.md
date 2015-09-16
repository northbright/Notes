
# Enable Sending Mail from Internal Network for iRedMail

#### Add port 25/tcp to iredmail zone to enable sending mail from internal network

When send mail(via client) from another PC on internal network after iRedMail is installed successfully, we get this error on client:

`554 5.5.1 Error: no valid recipients`

To find what happened, check `/var/log/maillog` on the mail server(iRedMail):

    sudo vi /var/log/maillog

    mx postfix/smtpd[3303]: NOQUEUE: reject: RCPT from xx.xx.xx[xx.xx.xx]: 
    504 5.5.2 <localhost>: Helo command rejected: need fully-qualified hostname; 
    from=<xx@xx.com> to=<xx@xx.com> proto=ESMTP helo=<localhost>
 

#### Solution

* Add IP Address into `mynetworks` of `/etc/postfix/main.cf` for the PC runs mail client

        sudo vi /etc/postfix/main.cf
        
        // find mynetworks at the bottom of file
        // ....
        mynetworks = 127.0.0.1
        // Add a new ip
        mynetworks = 127.0.0.1,192.168.10.1

* Restart postfix or Reboot to Take Effect

        sudo service postfix restart

* Add port 25 to zone iredmail(Centos 7)

    [A New Zone(`iredmail`) Will Be Added Into `firewalld` and Set as Default Zone After iRedMail is Installed](https://github.com/northbright/Notes/blob/master/Linux/mail_server/iredmail/a_new_zone(iredmail)_will_be_added_into_firewalld_and_set_as_default_zone_after_iredmail_is_installed.md)

        sudo firewall-cmd --zone=iredmail --permanent --add-port=25/tcp
        sudo firewall-cmd --reload
        sudo firewall-cmd --zone=iredmail --query-port=25/tcp



#### References
* [A New Zone(`iredmail`) Will Be Added Into `firewalld` and Set as Default Zone After iRedMail is Installed](https://github.com/northbright/Notes/blob/master/Linux/mail_server/iredmail/a_new_zone(iredmail)_will_be_added_into_firewalld_and_set_as_default_zone_after_iredmail_is_installed.md)
* [Start / Stop / Restart Postfix Mail Server](http://www.cyberciti.biz/faq/linux-unix-start-stop-restart-postfix/)

# A New Zone(`iredmail`) Will Be Added Into `firewalld` and Set as Default Zone After iRedMail is Installed

#### Get Default Zone

    sudo firewall-cmd --get-default-zone

    iredmail

#### Get Active Zones

    sudo firewall-cmd --get-active-zones

#### HTTP, IMAP, POP3, SMTP Serivces will also be added into firewalld

     sudo firewall-cmd --list-all-zones

     iredmail (default, active)
     interfaces: enp0s3
     sources:
     services: http https imap imaps pop3 pop3s smtp ssh submission
     ports:
     masquerade: no
     forward-ports:
     icmp-blocks:
     rich rules:

#### Add port 25/tcp to iredmail zone to enable sending mail from internal network

If you want to send mail from the other PCs on internal network, we can add port 25 to zone iredmail.

    sudo firewall-cmd --zone=iredmail --permanent --add-port=25/tcp
    sudo firewall-cmd --reload
    sudo firewall-cmd --zone=iredmail --query-port=25/tcp
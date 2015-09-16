
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

# Setup Postfix to Send Mail on Centos 7 Minimal

This server is used to send mail **only**.

#### DNS Settings

To avoid the mail sent by our sever won't be rejected as SPAM, we need to add DNS records:

* 

#### Steps

* Add `hostname` in `/etc/hosts`

        sudo vi /etc/hosts

        // Add your mail server hostname before localhost
        127.0.0.1   mail.mydomain.com localhost

* Restart network service

        sudo service network stop
        sudo service network start

* Check if `postfix` is installed(it should be install by default on Centos 7 minimal)

        yum list installed | grep postfix

        // Output:
        postfix.x86_64                          2:2.10.1-6.el7                 @anaconda

* Check if default `MTA` is `postfix`

        alternatives --display mta

        // Outpout:
        mta - status is auto.
        link currently points to /usr/sbin/sendmail.postfix
        /usr/sbin/sendmail.postfix - priority 30
      

* Configure `postfix`

    `sudo vi /etc/postfix/main.cf`

    * Hostname and domain  
    
            // myhostname
            myhostname = mail.mydomain.com

            // mydomain
            mydomain = mydomain.com

    * Disable Open-Relay

      * `inet_interfaces`
        
        * postfix will listen on these interfaces

      * `mynetworks`
           
        * disable open-relay to avaoid others use this sever to send spam mails
            
           * only the newtorks ip range listed in mynetworks can send mail to postfix
           * format: ip/ip_mask or just ip

      * Example
      
            There're 2 PCs:  
              15.15.1.1 runs Postfix  
              15.15.1.2 is another PC on the same local network.     
           

                // Ex: only localhost can send mail
                inet_interfaces = localhost
                mynetworks = 127.0.0.1
            
                // Ex: only localhost and 15.15.1.2(another PC on local network) can send mail
                inet_interfaces = 15.15.1.1, 127.0.0.1
                mynetworks = 15.15.1.2, 127.0.0.1

* Check / Start `postfix.service`  
`postfix.service` is auto-started by default on Centos 7 minial.

        sudo systemctl status postfix.service
        
        // Output:
        postfix.service - Postfix Mail Transport Agent
        Loaded: loaded (/usr/lib/systemd/system/postfix.service; enabled)
        Active: active (running) since Thu 2015-09-17 15:40:45 CST; 2s ago
        
        // Start postfix.service if it's not running
        sudo systemctl start postfix.service

* Config Firewalld(Centos 7)

        sudo firewall-cmd --permanent --zone=public --add-service=smtp
        sudo firewall-cmd --reload

* Now We Can Send mail via PHP's mail() function or Golang's `net/smtp` package

        // Golang
        package main

        import (
            "bytes"
            "log"
            "net/smtp"
        )

        func main() {
            // Connect to the remote SMTP server.
            c, err := smtp.Dial("mx.mydomain.com:25")
            if err != nil {
                log.Fatal(err)
            }
            defer c.Close()
            // Set the sender and recipient.
            c.Mail("support@mydomain.com")
            c.Rcpt("xx@xx.com")
            // Send the email body.
            wc, err := c.Data()
            if err != nil {
                log.Fatal(err)
            }
            defer wc.Close()
            buf := bytes.NewBufferString("This is the email body.")
            if _, err = buf.WriteTo(wc); err != nil {
                log.Fatal(err)
            }
        }

##### References

* [LNMP笔记：Centos下安装Postfix，替换sendmail发送邮件](http://www.cmhello.com/lnmp-centos-postfix.html)
* [Postfix Email Server](http://www.nurdletech.com/linux-notes/mail-server/postfix.html)
* [Allow PC on Local Network Send Mail to Postfix Server](https://github.com/northbright/Notes/blob/master/Linux/mail_server/postfix/allow_pc_on_local_network_send_mail_to_postfix_server.md)
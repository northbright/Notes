
# Setup Postfix to Send Mail on Centos 7 Minimal

#### Steps

* Add `hostname` in `/etc/hosts`

        sudo vi /etc/hosts

        // Add your mail server hostname before localhost
        127.0.0.1   mx.mydomain.com localhost

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

        sudo vi /etc/postfix/main.cf

        // myhostname
        myhostname = mx.mydomain.com

        // mydomain
        mydomain = mydomain.com

* Check / Start `postfix.service`  
`postfix.service` is auto-started by default on Centos 7 minial.

        sudo systemctl status postfix.service
        
        // Output:
        postfix.service - Postfix Mail Transport Agent
        Loaded: loaded (/usr/lib/systemd/system/postfix.service; enabled)
        Active: active (running) since Thu 2015-09-17 15:40:45 CST; 2s ago
        
        // Start postfix.service if it's not running
        sudo systemctl start postfix.service

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
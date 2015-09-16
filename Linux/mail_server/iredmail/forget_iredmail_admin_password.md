
# Forget iRedMail Admin Password

#### Solution

Find `iRedMail-x.y.z/iRedMail.tips` which contains admin account infomation.

    find -name "iRedMail.tips"
    /root/iRedMail-0.9.2/iRedMail.tips

    // It looks like this:
    // -----------------------------------------------
    Admin of domain mydomain.com:
        * Account: postmaster@mydomain.com
        * Password: 123456

        You can login to iRedAdmin with this account, login name is full email address.

    First mail user:
        * Username: postmaster@mydomain.com
        * Password: 123456
        * SMTP/IMAP auth type: login
        * Connection security: STARTTLS or SSL/TLS

Then you may visit `https://mydomain.com/iredadmin/` and login your admin account.

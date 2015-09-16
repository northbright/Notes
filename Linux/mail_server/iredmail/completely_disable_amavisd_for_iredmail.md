# Completely Disable Amavisd for iRedMail

#### Solution

    sudo vi /etc/postfix/main.cf

    # Comment out these 2 lines at the bottom of file
    #content_filter = smtp-amavis:[127.0.0.1]:10024
    #receive_override_options = no_address_mappings  # <- it's ok if you don't have this line

#### Restart postfix service

    sudo service postfix restart

#### References
* [Completely disable Amavisd + ClamAV + SpamAssassin](http://www.iredmail.org/docs/completely.disable.amavisd.clamav.spamassassin.html)
* [Disable Spam Virus Scanning for Outgoing Mails](https://github.com/northbright/Notes/blob/master/Linux/mail_server/iredmail/disable_spam_virus_scanning_for_outgoing_mails.md)


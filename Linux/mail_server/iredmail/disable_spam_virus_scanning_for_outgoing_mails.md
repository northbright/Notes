
# Disable Spam Virus Scanning for Outgoing Mails

If we [send mail from internal network](https://github.com/northbright/Notes/blob/master/Linux/mail_server/iredmail/enable_sending_mail_from_internal_network_for_iredmail.md), it will replace our outgoing mail subject with `***Spam***` by default.

#### Root Cause

`Amavisd` will apply default policies in `/etc/amavisd/amavisd.conf`(Centos) for mails which coming from internal networks in `$policy_bank{'MYUSERS'}`.  

#### Solution
**Uncomment** these lines under `$policy_bank{'MYUSERS'}` of `/etc/amavisd/amavisd.conf`:

* `bypass_spam_checks_maps`
* `bypass_virus_checks_maps`
* `bypass_header_checks_maps`
* `bypass_banned_checks_maps`

Reboot to take effect.

#### References
* [Disable spam virus scanning for outgoing mails](http://www.iredmail.org/docs/disable.spam.virus.scanning.for.outgoing.mails.html)
* [Enable Sending Mail from Internal Network for iRedMail](https://github.com/northbright/Notes/blob/master/Linux/mail_server/iredmail/enable_sending_mail_from_internal_network_for_iredmail.md)


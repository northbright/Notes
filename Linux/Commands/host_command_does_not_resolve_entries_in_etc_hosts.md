# `host` Command does not Resolve Entries in `/etc/hosts`

#### Root Cause

`host` uses `libresolv` to perform a DNS query directly and does not use `gethostbyname`.

#### Solution

Use `getent hosts` instead.

    getent hosts mydomain.com

#### References

* [Why does the host command not resolve entries in /etc/hosts?](http://serverfault.com/questions/498500/why-does-the-host-command-not-resolve-entries-in-etc-hosts)
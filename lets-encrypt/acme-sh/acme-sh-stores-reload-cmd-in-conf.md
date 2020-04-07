# acme.sh Stores Reload Command in Site Configuration File

## Problem
* Want to know where acme.sh stores the reload command(reload HTTP server) when renew a cert.

## Configuration File
```
cat ~/.acme.sh/mysite.com/mysite.com.conf
```

It stores the reload command in `Le_ReloadCmd` and encodes it with BASE64.

```
Le_ReloadCmd='__ACME_BASE64__START_c3lzdGVtY3RsIHJlc3RhcnQgbmdpbng=__ACME_BASE64__END_'
```

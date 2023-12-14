# Stop Cert Renewal

## Problem
* Cert of Domain(`xx.com`) is issued successfully by using [acme.sh](https://github.com/acmesh-official/acme.sh)
* Need to Stop Cert Renewal for `xx.com`

## Solution
```
acme.sh --remove -d xx.com
```

## References
* [How to stop cert renewal](https://github.com/acmesh-official/acme.sh?tab=readme-ov-file#13-how-to-stop-cert-renewal)

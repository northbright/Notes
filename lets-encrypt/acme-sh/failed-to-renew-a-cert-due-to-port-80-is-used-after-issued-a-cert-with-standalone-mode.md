# Failed to Renew a Cert Due to Port 80 is Used after Issued a Cert with Standalone Mode

## Background
* Issued a cert with standalone mode
* Installed and configured nginx with the cert
* Want to test renew script in the crontab
* Got error:

  ```
  Standalone mode.
  tcp 80 is already used by nginx.
  Please stop it first
  ```

## Root Cause
* [acme.sh](https://github.com/acmesh-official/acme.sh/blob/2.8.5/acme.sh#L3233) will check `$_currentRoot` to determine if it's standalone mode:

  ```
  if [ "$_currentRoot" = "$NO_VALUE" ]; then
    _info "Standalone mode."
  ```

## Solution
Make sure renew mode is the **SAME** as issue mode

* If you want to renew the cert when nginx is running, issue the cert with nginx mode

## References
* [通过(--standalone)方式安装证书 - 【续签】 #2449](https://github.com/acmesh-official/acme.sh/issues/2449)
* [无法自动更新证书 #1737](https://github.com/acmesh-official/acme.sh/issues/1737)

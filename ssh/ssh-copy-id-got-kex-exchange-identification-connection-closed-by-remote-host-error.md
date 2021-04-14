# ssh-copy-id Got "kex_exchange_identification: Connection closed by remote host" Error

## Problem
* Run `ssh-copy-id xx@xx.com` to copy local public key to remote server
* Got "kex_exchange_identification: Connection closed by remote host"

## Root Cause
* Visited the sites(e.g. digitalocean）which are blocked by the Chinese GFW
* All next SSL(HTTPS) connections within some time(maybe 5 minutes) will be RESET by the Chinese GFW:

  > PR_CONNECT_RESET_ERROR

* The connection between local pc to remote server via `sshd-copy-id` was also interrupted

## Solution
* Wait for some time and try again

## References
* [What causes SSH error: kex_exchange_identification: Connection closed by remote host?](https://serverfault.com/questions/1015547/what-causes-ssh-error-kex-exchange-identification-connection-closed-by-remote)

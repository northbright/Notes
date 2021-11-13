# Use `ssh-keyscan` to Get Public Keys of Hosts

## Where are the Public Keys of Host

They are under `/etc/ssh`:
* `/etc/ssh/ssh_host_rsa_key.pub` for RSA
* `/etc/ssh/ssh_host_dsa_key.pub` for DSA
* `/etc/ssh/ssh_host_ecdsa_key.pub` for ECDSA 
* `/etc/ssh/ssh_host_ed25519_key.pub` for ED25519

## Usage of `ssh-keyscan`
* `-t` option to specify the key type, possible values: `dsa`, `ecdsa`, `ed25519`, or `rsa`
* `-H` option should be used(hash public key) if `HashKnownHosts` is set to `yes` in `/etc/ssh/ssh_config` and you want to append the public key with hash to `~/.ssh/known_hosts` on your server 

## Examples
```
ssh-keyscan -t rsa -H www.server-a.com
```
  
## References
* [Avoid SSH Asking Permission](avoid-asking-ssh-permission.md)

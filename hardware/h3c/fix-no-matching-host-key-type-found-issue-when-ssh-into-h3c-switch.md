# Fix "no matching host key type found" Issue when SSH into H3C Switch

## Problem
* H3C Switch enabled SSH server
  * Create RSA, DSA public key pair
  * Create local user

* Run `ssh xx.xx.xx.xx(IP of H3C switch)` on Ubuntu(Windows 10, WSL)
* Got error:

  > no matching host key type found. Their offer: ssh-rsa,ssh-dss

## Root Cause
* OpenSSH deprecated DSA and RSA keys

## Solution
Use ECDSA algorithms(keys) on H3C switch.

```
public-key local create ecdsa secp256r1
```

## References
* [SSH returns: no matching host key type found. Their offer: ssh-dss](https://askubuntu.com/questions/836048/ssh-returns-no-matching-host-key-type-found-their-offer-ssh-dss)
* [OpenSSH declares ssh-rsa deprecated. What do I do next?](https://security.stackexchange.com/questions/226131/openssh-declares-ssh-rsa-deprecated-what-do-i-do-next)
* [H3C交换机SSH使用RSA公钥免密登录配置](https://www.cnblogs.com/powpoia/p/18459875)


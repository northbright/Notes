# acme.sh Changes Default CA to ZeroSSL

## Problem
* Starting from August-1st 2021, acme.sh uses [ZeroSSL](https://zerossl.com/) as default CA
* Need to change default CA back to [Let's Encrypt](https://letsencrypt.org/)

## Solution
Use `--set-default-ca` parameter to set default CA back to [Let's Encrypt](https://letsencrypt.org/)

```
acme.sh --set-default-ca --server letsencrypt
```

## References
* [Change default CA to ZeroSSL](https://github.com/acmesh-official/acme.sh/wiki/Change-default-CA-to-ZeroSSL)
* [ZeroSSL.com CA](https://github.com/acmesh-official/acme.sh/wiki/ZeroSSL.com-CA)
* [acme.sh获取证书 设置crontab定时检查更新及更新通知Li.017](https://zhuanlan.zhihu.com/p/393423092)
* [acme.sh被收购 更换默认证书颁发机构为ZeroSSL 还安全吗?Li.005](https://lizicai.com/p/acme.sh%E8%A2%AB%E6%94%B6%E8%B4%AD-%E6%9B%B4%E6%8D%A2%E9%BB%98%E8%AE%A4%E8%AF%81%E4%B9%A6%E9%A2%81%E5%8F%91%E6%9C%BA%E6%9E%84%E4%B8%BAzerossl-%E8%BF%98%E5%AE%89%E5%85%A8%E5%90%97li.005/)

# Avoid SSH Asking Permission

## Problem
* Want to SSH login Server A from B using public key authentication
* Run `ssh-keygen` to generate and set RSA public / private key pair for user xx(`/home/xx/.ssh/id_rsa / id_rsa.pub`) on Server B
* Public key of Server B is appended to `/home/xx/authorized_keys` on Server A
* SSH asked permission(yes / no) when run `ssh xx@Server_A` the first time on Server B
* Need to SSH login Server A **WITHOUT** asking permission for the first time
  
  It's useful when use [Github Actions](https://github.com/features/actions) for CI / CD(e.g. deploy to user's server from [Github-Hosted Runners](https://docs.github.com/en/actions/using-github-hosted-runners/about-github-hosted-runners) via SSH)

## Root Cause
* `StrictHostKeyChecking` setting in `/etc/ssh/ssh_config` is set to `ask` by default for most distros
* Set it to `no` is **NOT** a good idea for security reason
  
  With `StrictHostKeyChecking`, SSH refuses to connect to hosts whose host key has changed.
  This provides maximum protection against trojan horse attacks.

## Solution
* Method A(recommended) - Set `StrictHostKeyChecking` to `accept-new`(which is supported in most modern verions of openssh)

  * Modify per-user SSH config file on Server B

    ```
    vi ~/.ssh/config
    ```

    ```
    ## Append this line
    StrictHostKeyChecking  accept-new
    ```

  * Run `ssh xx@Server_A` and you will not be asked permission

* Method B - Use `ssh-keyscan` to get the public key of host(Server A) firstly and append it to `~/.ssh/known_hosts` of Server B before running SSH

  * Run `ssh-keyscan` on Server B to get the public key of Server A

    ```
    // '-t' option is used to specify the key type.
    // Possible values are `dsa`, `ecdsa`, `ed25519`, or `rsa`
    ssh-keyscan -t rsa Server_A
    ```

    ```
    // If `HashKnownHosts` is set to `yes` in `/etc/ssh/ssh_config` on Server B
    // We need to hash public key of Server A with `-H` option
    ssh-keyscan -t rsa -H Server_A
    ```

    // You may check the public key file(rsa type): `/etc/ssh/ssh_host_rsa_key`
    ```
    vi /etc/ssh/ssh_host_rsa_key
    ```

  * Append the public key of Server A to `~/.ssh/known_hosts` on Server B

  * Run `ssh xx@Server_A` and you will not be asked permission

## References
* [how to avoid ssh asking permission?](https://unix.stackexchange.com/questions/33271/how-to-avoid-ssh-asking-permission)
* <https://man7.org/linux/man-pages/man5/ssh_config.5.html>

-----------------

# 避免 SSH 连接要求询问权限

## 问题
* 希望使用 Public Key Authentication 来从 Server B 登陆到 Server A
* 运行 `ssh-keygen` 来为 Server B 上的用户 `xx` 生成以及设置 RSA public / private key pair(`/home/xx/.ssh/id_rsa / id_rsa.pub`)
* Server B 的Public key 已经添加到 Server A 的 `/home/xx/authorized_keys`
* 在 Server B 上第一次运行 `ssh xx@Server_A`，SSH 会询问权限(yes / no)
* 需要第一次 SSH 连接时，避免询问权限
    在使用 [Github Actions](https://github.com/features/actions) 来进行 CI / CD(e.g. 通过 SSH 从 [Github-Hosted Runners](https://docs.github.com/en/actions/using-github-hosted-runners/about-github-hosted-runners) 发布到用户自己的服务器)，这将会很有用

## 原因
* `/etc/ssh/ssh_config` 中的 `StrictHostKeyChecking` 在多数 Linux 发行版上，默认设置为 `ask`
* 设置为 `no` 不是一个好主意，考虑到安全因素的话

  通过 `StrictHostKeyChecking`, SSH 拒绝连接 key 发生变化的 host。
  这提供了极大的针对木马攻击的保护。

## 解决方法
* 方法 A(推荐) - 将 `StrictHostKeyChecking` 设置为 `accept-new`(多数最新版本的 openssh 都支持该选项)

  * 修改 Server B 上针对用户的 SSH config file

    ```
    vi ~/.ssh/config
    ```

    ```
    ## Append this line
    StrictHostKeyChecking  accept-new
    ```

  * 运行 `ssh xx@Server_A`，这时不会再被询问权限

* 方法 B - 在运行 SSH 前，先使用 `ssh-keyscan` 来获取 Server A 的 public key，并添加到 Server B 上的 `~/.ssh/known_hosts`

  * 在 Server B 上运行 `ssh-keyscan` 来获取 Server A 的 Public Key

    ```
    // '-t' option is used to specify the key type.
    // Possible values are `dsa`, `ecdsa`, `ed25519`, or `rsa`
    ssh-keyscan -t rsa Server_A
    ```

    ```
    // If `HashKnownHosts` is set to `yes` in `/etc/ssh/ssh_config` on Server B
    // We need to hash public key of Server A with `-H` option
    ssh-keyscan -t rsa -H Server_A
    ```

    // You may check the public key file(rsa type): `/etc/ssh/ssh_host_rsa_key`
    ```
    vi /etc/ssh/ssh_host_rsa_key
    ```


  * 将 Server A 的 Public key 添加至 Server B 的 `~/.ssh/known_hosts`

  * 运行 `ssh xx@Server_A`，这时不会再被询问权限

## 参考资料
* [how to avoid ssh asking permission?](https://unix.stackexchange.com/questions/33271/how-to-avoid-ssh-asking-permission)
* <https://man7.org/linux/man-pages/man5/ssh_config.5.html>

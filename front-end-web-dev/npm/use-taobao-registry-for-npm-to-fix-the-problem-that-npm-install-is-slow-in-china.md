# Use `taobao` Registry for npm to Fix the Problem that `npm install` is Slow in China

## Problem

- `npm install` is VERY slow in China

## Solution

Use taobao registry

- Set registry in user's config

  - Method A: Run `npm config` command

        npm config set registry https://registry.npm.taobao.org

  - Method B: Add registry in `~/.npmrc`

        vi ~/.npmrc
        // Append this line
        registry=https://registry.npm.taobao.org

- Set registry in global config

  To install global command, we need use `sudo npm install -g X`.
  This will make npm use `/root/.npmrc` instead of `~/.npmrc`.
  We need to set a global npm config.

      // Global npm config file is $PREFIX/etc/npmrc
      // e.g. $PREFIX=/usr/local/node
      // global config file is /usr/local/node/etc/npmrc

      // Create etc dir
      sudo mkdir /usr/local/node/etc -p

      sudo vi /usr/local/node/etc/npmrc
      // Append this line
      registry=https://registry.npm.taobao.org

- check

      // Check for current user
      npm config get registry

      // Check for sudo user
      sudo npm config get registry


## References

- [国内优秀 npm 镜像推荐及使用](http://riny.net/2014/cnpm/)
- [npm 设置淘宝镜像的两个方法](https://www.jianshu.com/p/92116d8d2298)
- [npmrc](https://docs.npmjs.com/files/npmrc)

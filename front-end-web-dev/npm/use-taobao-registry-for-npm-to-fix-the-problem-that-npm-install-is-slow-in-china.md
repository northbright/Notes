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
  We need to set a global npm config.

  * Get Global Config File of npm
    * [Get Global Config File of npm](https://github.com/northbright/Notes/blob/master/front-end-web-dev/npm/get-global-config-file-of-npm.md)

  * Set Registry in Global Config
      // Global npm config file is $PREFIX/etc/npmrc
      // e.g. $PREFIX=/usr/local/node
      // global config file is /usr/local/node/etc/npmrc

      // Create etc dir
      sudo mkdir /usr/local/node/etc -p

      sudo vi /usr/local/node/etc/npmrc
      // Append this line
      registry=https://registry.npm.taobao.org

- check

  ```
  npm config ls -l | grep registry
  // Output:
  // Overridden by Global
  registry = "https://registry.npmjs.org/" ; overridden by global
  // or Overridden by User
  registry = "https://registry.npmjs.org/" ; overridden by user
  ```

## References

- [国内优秀 npm 镜像推荐及使用](http://riny.net/2014/cnpm/)
- [npm 设置淘宝镜像的两个方法](https://www.jianshu.com/p/92116d8d2298)
- [npmrc](https://docs.npmjs.com/files/npmrc)

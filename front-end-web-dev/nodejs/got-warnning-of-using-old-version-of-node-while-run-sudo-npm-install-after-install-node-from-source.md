# Got Warnning of Using Old Version of [Node](https://nodejs.org/en/) When Run `sudo npm install` after [Install Node.js from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/front-end-web-dev/nodejs/install-nodejs-from-source-on-centos-7.md) 

## Problem
* [Install Node.js from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/front-end-web-dev/nodejs/install-nodejs-from-source-on-centos-7.md) 
* Got correct version while run `node --version` or `npm --version`
* Got warnning of using old version when run `sudo npm install`

## Root Cause
* There's old version installed by default
* `sudo` will use `secure_path` instead of `$PATH`(you may add new version binary path there)

## Solution
* Check node / npm version

      // local user
      which node

      // output:
      /usr/local/node/bin/node

      // for su command
      sudo which node

      // output:
      /usr/local/bin

* Insert `/usr/local/node/bin` to `secure_path`

      sudo visudo
      
      # Find "secure_path" and insert "/usr/local/node/bin" to it
      # XX is the default value of secure_path

      Defaults    secure_path = /usr/local/node/bin:XX

  

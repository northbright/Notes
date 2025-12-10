# Install [Node.js](https://nodejs.org/en/) and `npm` on macOS

## Steps

#### Method A
Visit [Download](https://nodejs.org/en/download/) to get official script to install latest version of Node.js(e.g. Run nvm v0.40.3 to install Node.js v24). 

```sh
# Download and install nvm:
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.3/install.sh | bash

# in lieu of restarting the shell
\. "$HOME/.nvm/nvm.sh"

\# Download and install Node.js:
nvm install 24

# Verify the Node.js version:
node -v # Should print "v24.11.1".

# Verify npm version:
npm -v # Should print "11.6.2".
```

#### Method B
Visit [Download](https://nodejs.org/en/download/) to download prebuilt Node.js.

* Select LTS or Current Version and download 
* Click the `.pkg` file to install it on macOS
* Run `node -v` and `npm -v` to check

## Set npm Registry(Optional)
**UPDATE: 2024/07/04**
Run `sudo yarn global add @quasar/cli` to install [Quasar](https://quasar.dev/) and got Error: `certificate has expired` after use taobao registry.
Remove taobao registry and it works.

`npm install` is very slow for China developers.
To speed up the installation, we can set registry located in China.

* [Use taobao Registry for npm to Fix the Problem that npm install is Slow in China](https://github.com/northbright/Notes/blob/master/front-end-web-dev/npm/use-taobao-registry-for-npm-to-fix-the-problem-that-npm-install-is-slow-in-china.md)

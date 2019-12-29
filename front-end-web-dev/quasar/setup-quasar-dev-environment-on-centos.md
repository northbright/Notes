# Setup [Quasar](https://quasar.dev/) Development Environment(Vim) on CentOS

## Install [Node.js](https://nodejs.org)
* [Install Node.js from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/front-end-web-dev/nodejs/install-nodejs-from-source-on-centos-7.md)

## Install [Vim](https://www.vim.org/)
* [Install VIM 8 from Source on Centos 7](https://github.com/northbright/Notes/blob/master/Linux/vim/install-vim-8-from-source-on-centos-7.md)

## Setup Vim Plugins
* [Use vim-plug to Install Vim Plugins on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/vim/use-vim-plug-to-install-vim-plugins.md)
* [Vim Syntax Highlighting for Vue](https://github.com/northbright/Notes/blob/master/front-end-web-dev/vue/vim-syntax-highlighting-for-vue.md)
* [Setup vim-prettier for vim](https://github.com/northbright/Notes/blob/master/Linux/vim/setup-vim-prettier-for-vim.md)

## Install [Quasar CLI](https://quasar.dev/start/quasar-cli)
    npm install -g @quasar/cli
    
## Create a Quasar Project

    mkdir ~/my_project
    cd ~/my_project
    
    quasar create
    // Select ESlint and Prettier as ESlint preset
    
    // Run dev server
    quasar dev

## Config ESlint(Optional)
* [Fix Unexpected Console Statement in ESLint](https://github.com/northbright/Notes/blob/master/front-end-web-dev/eslint/fix-unexpected-console-statement-in-eslint.md)

## Check
* Open a browser and goto `http://localhost:8080`


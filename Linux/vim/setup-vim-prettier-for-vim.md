# Setup [vim-prettier](https://github.com/prettier/vim-prettier) for Vim

## Install [Node.js](https://nodejs.org)
* CentOS
  * [Install Node.js from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/front-end-web-dev/nodejs/install-nodejs-from-source-on-centos-7.md)
* macOS
  * [Install Node.js and npm on macOS](https://github.com/northbright/Notes/blob/master/front-end-web-dev/nodejs/install-nodejs-and-npm-on-macos.md)

## Install [vim-plug](https://github.com/junegunn/vim-plug)
* CentOS
  * [Install vim-plug on CentOS](https://github.com/northbright/Notes/blob/master/Linux/vim/install-vim-plug-on-centos.md)
* macOS
  * [Install vim-plug on macOS](https://github.com/northbright/Notes/blob/master/Linux/vim/install-vim-plug-on-macos.md)

## Install [vim-prettier](https://github.com/prettier/vim-prettier)
* Open `~/.vimrc`, find `call plug#begin` ... `call plug#end()`, insert `Plug 'prettier/vim-prettier'`

  ```
  vi ~/.vimrc
  ```
  ```
  call plug#begin('~/.vim/plugged')
  " post install (yarn install | npm install) then load plugin only for editing supported files
    Plug 'prettier/vim-prettier', {
    \ 'do': 'npm install',
    \ 'for': ['javascript', 'typescript', 'css', 'less', 'scss', 'json', 'graphql', 'markdown', 'vue', 'yaml', 'html'] }
  call plug#end()
  ```

* Open Vim and Run `:PlugInstall` to Install [vim-prettier](https://github.com/prettier/vim-prettier)

  ```
  vim
  ```

  ```
  :PlugInstall
  ```

## Usage
* Run `:Prettier` to format `.js, .vue, .html, .css...` files 

## References
* [Use vim-plug to Install Vim Plugins](https://github.com/northbright/Notes/blob/master/Linux/vim/use-vim-plug-to-install-vim-plugins.md)

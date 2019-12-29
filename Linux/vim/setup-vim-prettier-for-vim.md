# Setup [vim-prettier](https://github.com/prettier/vim-prettier) for Vim

## Install [Node.js](https://nodejs.org)
* [Install Node.js from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/front-end-web-dev/nodejs/install-nodejs-from-source-on-centos-7.md)

## Install [vim-plug]([vim-plug](https://github.com/junegunn/vim-plug) )
*  [ Use vim-plug to Install Vim Plugins on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/vim/use-vim-plug-to-install-vim-plugins.md)

## Install [vim-prettier](https://github.com/prettier/vim-prettier)
Open `~/.vimrc`, find `call plug#begin` ... `call plug#end()`, insert `Plug 'prettier/vim-prettier'`

    vi ~/.vimrc

    call plug#begin('~/.vim/plugged')
    " post install (yarn install | npm install) then load plugin only for editing supported files
    Plug 'prettier/vim-prettier', {
    \ 'do': 'npm install',
    \ 'for': ['javascript', 'typescript', 'css', 'less', 'scss', 'json', 'graphql', 'markdown',      'vue', 'yaml', 'html'] }
    call plug#end()

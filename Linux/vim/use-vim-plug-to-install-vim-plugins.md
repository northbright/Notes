# Use [vim-plug](https://github.com/junegunn/vim-plug) to Install Vim Plugins on CentOS 7

## Installation
* Download [plug.vim](https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim) to `~/.vim/autoload`

      curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
      https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim

* Run `vim`

## Install Plugins
* Open `~/.vimrc` and put plugins in `call plug#begin('~/.vim/plugged')` and `call plug#end()`

      // Example
      call plug#begin('~/.vim/plugged')
           " post install (yarn install | npm install) then load plugin only for editing supported files
           Plug 'prettier/vim-prettier', {
           \ 'do': 'npm install',
           \ 'for': ['javascript', 'typescript', 'css', 'less', 'scss', 'json', 'graphql', 'markdown', 'vue', 'yaml', 'html'] }
      call plug#end()

* Run `vim`
  * type `:PlugInstall`

## References
* [Automatic installation](https://github.com/junegunn/vim-plug/wiki/tips#automatic-installation)

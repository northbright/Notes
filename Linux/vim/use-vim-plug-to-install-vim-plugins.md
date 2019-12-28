# Use [vim-plug](https://github.com/junegunn/vim-plug) to Install Vim Plugins on CentOS 7

## Installation
* Method A: Download [plug.vim](https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim) to `~/.vim/autoload`

      curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
      https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim

* Method B: If you have problem to access `raw.githubusercontent.com`, download release on [Github](https://github.com/junegunn/vim-plug/releases) directly

      cd ~/download
      wget https://github.com/junegunn/vim-plug/archive/0.10.0.tar.gz
      tar -xzvf 0.10.0.tar.gz
      cp vim-plug-0.10.0/plug.vim ~/.vim/autoload/

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
* [How do I install a plugin in Vim/vi?](https://vi.stackexchange.com/questions/613/how-do-i-install-a-plugin-in-vim-vi)

# Use [vim-plug](https://github.com/junegunn/vim-plug) to Install Vim Plugins on CentOS 7

## Installation
* Method A: Download [plug.vim](https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim) to `~/.vim/autoload`

      curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
      https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim

* Method B: If you have problem to access `raw.githubusercontent.com`, download release on [Github](https://github.com/junegunn/vim-plug/releases) directly

      // Create ~/.vim/autoload
      mkdir -p ~/.vim/autoload

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
           Plug 'fatih/vim-go', { 'do': ':GoUpdateBinaries' }
      call plug#end()

* Run `vim`
  * type `:PlugInstall`

## Remove Plugins
* Remove the `Plug xx` you want to remove in `~/.vimrc`
  ```
  call plug#begin('~/.vim/plugged')
  call plug#end()
  ```

* Open `Vim` and run `:PlugClean`
  * It'll ask if delete add under folder XX
  * Press `y` to delete all if you want

## References
* [Automatic installation](https://github.com/junegunn/vim-plug/wiki/tips#automatic-installation)
* [How do I install a plugin in Vim/vi?](https://vi.stackexchange.com/questions/613/how-do-i-install-a-plugin-in-vim-vi)

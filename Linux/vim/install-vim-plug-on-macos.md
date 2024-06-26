# Install [vim-plug](https://github.com/junegunn/vim-plug) on macOS

## Steps
* Download [vim-plug](https://github.com/junegunn/vim-plug)

  ```
  cd ~/download
  // Use curl, wget or aria2c to download the release
  aria2c "https://github.com/junegunn/vim-plug/archive/refs/tags/0.11.0.tar.gz"
  tar -xzvf 0.11.0.tar.gz
  ```

* Copy `plug.vim` to `~/.vim/autoload`

  ```
  mkdir -p ~/.vim/autoload
  cp ~/download/vim-plug-0.11.0/plug.vim ~/.vim/autoload
  ```

* Add a vim-plug Section to `~/.vimrc`
  Example:

  ```
  call plug#begin('~/.vim/plugged')
     Plug 'fatih/vim-go', { 'do': ':GoUpdateBinaries' }
  call plug#end()
  ```

* Run `vim` and `:PlugStatus`

  ```
  vim
  ```
  ```
  // :PlugInstall, :PlugStatus should be available
  :PlugStatus
  ```

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
  mkir -p ~/.vim/autoload
  cp ~/download/vim-plug-0.11.0/plug.vim ~/.vim/autoload
  ```

* Run `vim` and `:PlugStatus`

  ```
  vim
  ```
  ```
  // :PlugInstall, :PlugStatus should be available
  :PlugStatus
  ```

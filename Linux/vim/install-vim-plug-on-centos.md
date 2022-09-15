# Install [vim-plug](https://github.com/junegunn/vim-plug) on CentOS 

## Steps
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

* Run `vim` and `:PlugStatus`

  ```
  vim
  ```
  ```
  :PlugStatus
  // Output:
  - vim-prettier: OK
  ```

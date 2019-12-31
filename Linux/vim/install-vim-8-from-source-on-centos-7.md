# Install VIM 8 from Source on Centos 7
  
## Install Dependencies

    sudo yum install -y ncurses-devel

## Get Latest VIM Release from <https://github.com/vim/vim/releases>

```
cd ~/download
wget https://github.com/vim/vim/archive/v8.0.1428.zip
unzip v8.0.1428.zip
```

## Build and Install VIM from Source
```
cd vim-vim-8.0.1428/src

./configure --prefix=/usr/local/vim
make
sudo make install
```

## Add New Binary Path of Vim
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of Vim
      export PATH=/usr/local/vim/bin:$PATH

* `source /etc/profile`

## Add `/usr/local/vim/bin` in `secure_path` for `sudo vim xx`

`sudo visudo`

```
// Find "secure_path" and add your own path(ex: /usr/local/vim/bin)
Defaults    secure_path = /usr/local/vim/bin:/sbin:/bin:/usr/sbin:/usr/bin:/usr/local/bin:
```

#### Check Version

```
vim --version

// Output:
// VIM - Vi IMproved X.X
```

## Add Alias(vi = vim) and Set `VISUAL` and `EDITOR` env variables 

* `vi /etc/profile`

    
   ```
    ......
    # VIM
    alias vi=vim

    export VISUAL=vim
    export EDITOR="$VISUAL"
    ```

* `source /etc/profile`

## Copy `/etc/vimrc` to `~/.vimrc` and customize `~/.vimrc` if need

    cp /etc/vimrc ~/.vimrc

## Make it Can Copy Text Selected by Mouse
* See [Can not Copy Text Selected by Mouse in VIM 8](can-not-copy-text-selected-by-mouse-in-vim-8.md)

## [Use vim-plug to Install Vim Plugins on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/vim/use-vim-plug-to-install-vim-plugins.md)

## References
* [Howto Enable Vi and Vim Syntax Highlighting on Fedora / CentOS / Red Hat (RHEL)](http://www.if-not-true-then-false.com/2012/vi-vim-syntax-highlighting-on-fedora-centos-red-hat-rhel/)
* [Example vimrc](http://vim.wikia.com/wiki/Example_vimrc)
* [sudo: xx command not found](https://github.com/northbright/Notes/blob/master/Linux/Commands/sudo-command-not-found.md)
* [Can not Copy Text Selected by Mouse in VIM 8](can-not-copy-text-selected-by-mouse-in-vim-8.md)

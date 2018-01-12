# Install VIM 8 from Source on Centos 7
  
#### Get Latest VIM Release from <https://github.com/vim/vim/releases>

```
cd ~/download
wget https://github.com/vim/vim/archive/v8.0.1428.zip
unzip v8.0.1428.zip
```

#### Build and Install VIM from Source
```
cd vim-vim-8.0.1428/src

// Default install path: /usr/local/bin
./configure
make
sudo make install
```

#### Add `/usr/local/bin` in `secure_path` for `sudo vim xx`

`sudo visudo`

```
// Find "secure_path" and add your own path(ex: /usr/local/bin)
Defaults    secure_path = /sbin:/bin:/usr/sbin:/usr/bin:/usr/local/bin:/usr/local/bin:
```

#### Check Version

```
vim --version

// Output:
// VIM - Vi IMproved X.X
```

#### Add Alias(vi = vim) and Set `VISUAL` and `EDITOR` env variables 

* `vi /etc/profile`

    
   ```
    ......
    # VIM
    alias vi=vim

    export VISUAL=vim
    export EDITOR="$VISUAL"
    ```

* `source /etc/profile`

#### Default VIM 8 Settings
* See `/usr/local/share/vim/vim80/defaults.vim`

#### Create a `~/.vimrc` for Customized Settings

`vi ~/.vimrc`

```
set nocompatible
filetype plugin indent on
set mouse=v                "text selected by mouse can be copied(e.g. Mac OS Terminal)
syntax on
```

#### References
* [Howto Enable Vi and Vim Syntax Highlighting on Fedora / CentOS / Red Hat (RHEL)](http://www.if-not-true-then-false.com/2012/vi-vim-syntax-highlighting-on-fedora-centos-red-hat-rhel/)
* [Example vimrc](http://vim.wikia.com/wiki/Example_vimrc)
* [sudo: xx command not found](https://github.com/northbright/Notes/blob/master/Linux/Commands/sudo-command-not-found.md)
* [Can not Copy Text Selected by Mouse in VIM 8](can-not-copy-text-selected-by-mouse-in-vim-8.md)


# Add vim-go Plugin for vim on CentOS 7

#### Part I - Install vim

* [Install VIM 8 from Source on Centos 7](https://github.com/northbright/Notes/blob/master/Linux/vim/install-vim-8-from-source-on-centos-7.md)

#### Part II - Install Vundle and vim-go

You may find go editor infomation in `/usr/local/go/misc/editor`:  
<https://code.google.com/p/go-wiki/wiki/IDEsAndTextEditorPlugins>

* Install [Vundle](https://github.com/gmarik/Vundle.vim)
    * Vundle is short for Vim bundle and is a Vim plugin manager.
    * `git clone https://github.com/gmarik/Vundle.vim.git ~/.vim/bundle/Vundle.vim`
    * Copy the following content into `~/.vimrc`: 
    
    <pre><code>
    set nocompatible              " be iMproved, required
    filetype off                  " required

    " set the runtime path to include Vundle and initialize
    set rtp+=~/.vim/bundle/Vundle.vim
    call vundle#begin()
    " alternatively, pass a path where Vundle should install plugins
    "call vundle#begin('~/some/path/here')

    " let Vundle manage Vundle, required
    Plugin 'gmarik/Vundle.vim'

    " All of your Plugins must be added before the following line
    call vundle#end()            " required
    filetype plugin indent on    " required
    " To ignore plugin indent changes, instead use:
    "filetype plugin on
    "
    " Brief help
    " :PluginList       - lists configured plugins
    " :PluginInstall    - installs plugins; append `!` to update or just :PluginUpdate
    " :PluginSearch foo - searches for foo; append `!` to refresh local cache
    " :PluginClean      - confirms removal of unused plugins; append `!` to auto-approve removal
    "
    " see :h vundle for more details or wiki for FAQ
    " Put your non-Plugin stuff after this line
    </code></pre>

    * Run `vim` and run `:PluginInstall` command

* Install [vim-go](https://github.com/fatih/vim-go)  
    
        $ cd ~/.vim/bundle
        $ git clone https://github.com/fatih/vim-go.git  

    Insert `Plugin 'fatih/vim-go'` after `Plugin 'gmarik/Vundle.vim'` in `~/.vimrc`  
    Run `vim` and run `:PluginInstall` command again


    
    

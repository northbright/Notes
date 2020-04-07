# Add vim-go Plugin for VIM on CentOS 7

## Part I - Install VIM

* [Install VIM 8 from Source on Centos 7](https://github.com/northbright/Notes/blob/master/Linux/vim/install-vim-8-from-source-on-centos-7.md)

## Part II - [vim-go](https://github.com/fatih/vim-go) 

* Method A: [Use vim-plug to Install Vim Plugins on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/vim/use-vim-plug-to-install-vim-plugins.md)

      // vi ~/.vimrc

      call plug#begin('~/.vim/plugged')
          Plug 'fatih/vim-go', { 'do': ':GoUpdateBinaries' }
      call plug#end()

      // vim
      :PlugStatus
      :PlugInstall

* Method B: Copy file directly

      git clone https://github.com/fatih/vim-go.git ~/.vim/pack/plugins/start/vim-go

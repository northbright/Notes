# Vim Syntax Highlighting for [Vue](https://vuejs.org/)

## Solution
Use [vim-vue](https://github.com/posva/vim-vue)

For Vim 8 and later:
 
* Method A: [Use vim-plug to Install Vim Plugins on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/vim/use-vim-plug-to-install-vim-plugins.md)

      // vi ~/.vimrc
      
      call plug#begin('~/.vim/plugged')
      Plug 'posva/vim-vue'
      call plug#end()
    
      // vim
      :PlugStatus
      :PlugInstall
        
* Method B: Copy [vim-vue](https://github.com/posva/vim-vue) directly
    git clone https://github.com/posva/vim-vue.git ~/.vim/pack/plugins/start/vim-vue

#### References
* [vim-vue](https://github.com/posva/vim-vue)



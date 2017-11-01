# Fix Vim Error while run `git commit`

#### Background
Already set alias:

    // .bashrc
    ......
    # VIM
    alias vi=vim
    ......

#### Problem
When run `git commit`, we get error like this:

    Error detected while processing .vimrc:
    line    6:
    E492: Not an editor command: Plugin 'gmarik/Vundle.vim'

#### Solution
Set `vim` as core editor for Git.

    // Set vim as global editor.
    git config --global core.editor vim

    // Check
    git config --global -l


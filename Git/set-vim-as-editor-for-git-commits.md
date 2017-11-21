# Set `vim` as Editor for `git` commits

#### Set `vim` only for `git`
    
    git config --global core.editor "vim"

#### Set `vim` for `git` and other programs

    // Set VISUAL and EDITOR env variables
    // Ex: /etc/profile or ~/.bashrc
    export VISUAL=vim
    export EDITOR="$VISUAL"

#### References
* [How do I make git use the editor of my choice for commits?](http://stackoverflow.com/questions/2596805/how-do-i-make-git-use-the-editor-of-my-choice-for-commits)

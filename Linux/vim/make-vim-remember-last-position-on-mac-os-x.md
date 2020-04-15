# Make Vim Remember Last Position on Mac OS X

## Background
* OS: Mac OS X 10.15.4
* Vim: version 8.1.2292(system default) 

## Problem
* Vim can not remember last position of previous edited files

## Solution
Modify `~/.vimrc`(for Mac OS X)

```
vi ~/.vimrc
```

```
" Uncomment the following to have Vim jump to the last position when
" reopening a file
if has("autocmd")
  au BufReadPost * if line("'\"") > 1 && line("'\"") <= line("$") | exe "normal! g'\"" | endif
endif
```

## References
* [vim is not remembering last position](https://askubuntu.com/questions/223018/vim-is-not-remembering-last-position) 

# Can not Copy Text Selected by Mouse in VIM 8

#### Problem
After Install VIM 8 from Source, it can not copy text selected by mouse in VIM 8.

#### Root Cause
* Default VIM settings: `/usr/local/share/vim/vim80/defaults.vim`

   ```
   if has('mouse')
  set mouse=a  "this will make VIM select the text but not terminal
  endif
   ```

#### Solution
Comment `set mouse=a`

```
"if has('mouse')
"set mouse=a  "this will make VIM select the text but not terminal
"endif
```

#### References
* [Can't select text in terminal after upgrading to VIM 8 on Debian 9 Stretch](https://superuser.com/questions/1223924/cant-select-text-in-terminal-after-upgrading-to-vim-8-on-debian-9-stretch/1226054)

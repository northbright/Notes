# Set Alias for `ls` on macOS to Enable Colorized Output and Human Readable Format

## Problem
* Run `ls` on macOS
* Need **Colorized** output
* Need the file size to be **Human Readable**

## Solution
Set alias for `ls`
* `-G` to enable colorized output
* `-lh` to output human readable format

* Modify ~/.zshrc
```
vi ~/.zshrc
```

```
// Append this line
alias ls="ls -Glh"
```

* `source ~/.zshrc`

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

## References
* [See Sizes in Human Readable Format from the Command Line](https://osxdaily.com/2012/01/25/see-sizes-in-human-readable-format-from-the-command-line/)

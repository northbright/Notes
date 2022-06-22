# Use "tree" Command on macOS

## Problem
* `tree` command can not be found on macOS

## Solution
Add new alias for `tree` in `~/.zshrc`

* Modify `~/.zshrc`

  ```
  vi ~/.zshrc
  ```

* Append this line

  ```
  alias tree="find . -print | sed -e 's;[^/]*/;|____;g;s;____|; |;g'"
  ```

* Run `source ~/.zshrc` to take effect


## References
* [Using a Mac Equivalent of Unix “tree” Command to View Folder Trees at Terminal](https://osxdaily.com/2016/09/09/view-folder-tree-terminal-mac-os-tree-equivalent/)


# [vim-go](https://github.com/fatih/vim-go) Does Not Work With Go 1.18 Generics Syntax

## Problem
* Installed [vim-go](https://github.com/fatih/vim-go) on macOS and it worked fine
* Updated Go to 1.18
* Updated [vim-go](https://github.com/fatih/vim-go) to latest by run `PlugUpdate`
* Wrote some code using generic syntax:

  ```
  func Test[T any](f func(input T), input T) {
        f(input)
  }
  ```
* Pressed `:w` to save and got error:

  > expected '(', found '['

## Solution
* Run `:GoUpdateBinaries` in [vim-go](https://github.com/fatih/vim-go) to update the binaries used by [vim-go](https://github.com/fatih/vim-go)

## References
* ["text motion objects" - "[[" AND "]]" not working with go1.18 generic syntax](https://github.com/fatih/vim-go/issues/3383)

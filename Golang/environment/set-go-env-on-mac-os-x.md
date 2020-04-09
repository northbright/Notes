# Set Go Environment Variables on Mac OS X

## Mac OS X Version
* 10.15.4

## Go Version
* 1.14.2

## Solution
Use `~/.zprofile` to export Go Environment Variables.


## Example of Set `GOPROXY`
```
vi ~/.zprofile
```
```
export GOPROXY="https://goproxy.io,direct"
```

## References
* [Set alias on Mac OS X which its Default Shell is zsh](https://github.com/northbright/Notes/blob/master/macos/shell/set-alias-on-mac-os-x-which-default-shell-is-zsh.md)

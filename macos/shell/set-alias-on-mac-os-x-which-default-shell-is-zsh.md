# Set alias on Mac OS X which its Default Shell is zsh

## Problem
* Set alias for `ls` to `ls -G` in `~/.profile` does NOT work on Mac OS X 10.15.4(Catalina)

## Root Cause
* Apple change default shell to zsh in Mac OS X 10.15

## Solution
* Use `~/.zshrc` instead of `~/.bashrc`
* Use `~/.zprofile` instead of `~/.bash_profile`

## References
* [macOS Catalina 10.15(beta) - Why is ~/.bash_profile not sourced by my shell?](https://stackoverflow.com/questions/56784894/macos-catalina-10-15beta-why-is-bash-profile-not-sourced-by-my-shell) 

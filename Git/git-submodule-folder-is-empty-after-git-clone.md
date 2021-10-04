# Git Submodule Folder is Empty After Git Clone

## Problem
* Git clone a repo with a submodule
* The submodule folder is empty after git clone

## Solution
* Need to run 2 commands after `git clone`
  * `git submodule init`
  * `git submodule update`

  ```
  // Clone a project with submodule
  git clone git@github.com:USER_A/PROJECT.git

  cd PROJECT

  // Init and update submodule
  git submodule init
  git submodule update
  ```

## References
* [7.11 Git Tools - Submodules](https://git-scm.com/book/en/v2/Git-Tools-Submodules)

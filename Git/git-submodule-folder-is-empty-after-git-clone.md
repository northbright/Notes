# Git Submodule Folder is Empty After Git Clone

## Problem
* Git clone a repo with a submodule
* The submodule folder is empty after git clone

## Solution
* Sync URL of submodule in .gitmodules to .git/config
  ```
  git submodule sync --recursive
  ```

* Initialize and update submodules

  ```
  git submodule update --init --recursive --force
  ```

* Example

  ```
  // Clone a project with submodules
  git clone git@github.com:USER_A/PROJECT.git

  cd PROJECT

  // Sync, init and update submodules
  git submodule sync --recursive
  git submodule update --init --recursive --force
  ```

## References
* [7.11 Git Tools - Submodules](https://git-scm.com/book/en/v2/Git-Tools-Submodules)
* [Easy way to pull latest of all git submodules](https://stackoverflow.com/questions/1030169/easy-way-to-pull-latest-of-all-git-submodules)
* [使用 Hugo 搭建个人网站（博客、个人主页）并发布到 Github 上](https://zhuanlan.zhihu.com/p/417259374)

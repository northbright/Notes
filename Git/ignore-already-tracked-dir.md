# Ignore Already Tracked Dir

## Problem
* Forget to add `examples/output` in `.gitignore`
* The dir was included in previous commits.
* Need to ignore it

## Solution
* Untrack the dir using `git rm -r --cached` 

  ```sh
  git rm -r --cached examples/output
  ```

* Add it in `.gitignore`

  * Method A: Ignore "examples/output" under ROOT only(which `.gitignore` is in)

  ```sh
  /examples/output
  ```

  * Method B: Ignore "output" in everywhere

  ```sh
  output
  ```

  `/` prefix of the path in `.gitignore` is used to locate ROOT dir.
 
## References
* [.gitignore 忽略 repo 下的 examples/output 怎样写](https://qianwen.my.cn/share/chat/5e30fd634ed64e298f3facce755fa12b)

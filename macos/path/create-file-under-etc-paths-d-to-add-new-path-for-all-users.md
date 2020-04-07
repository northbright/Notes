# Create File under `/etc/paths.d` to Add New Path for All Users

## Mac OS X Version
* 10.15.4 Catalina

## Problem
Want to add `/usr/local/aria2/bin/` to `$PATH` for all users

## Solution
* Create a new file(`aria2`) under `/etc/paths.d`

  ```
  sudo vi /etc/paths.d/aria2
  ```

* Put the path of aria2 binary in the file

  ```
  /usr/local/aria2/bin
  ```

* Re-open a shell(terminal) to test

  ```
  echo $PATH
  ```

## References
* [Mac OS X: Set / Change $PATH Variable](https://www.cyberciti.biz/faq/appleosx-bash-unix-change-set-path-environment-variable/)


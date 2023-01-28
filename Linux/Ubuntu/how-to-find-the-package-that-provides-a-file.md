# How to Find the Package thag Provides a File

## Problem
* Run `ifconfig` on Ubuntu 22.04 and got `command not found`
* Need to know the package that provides `ifconfig` and use `apt` to install it

## Solution
Install and Run `apt-file`

* Install `apt-file`

  ```
  sudo apt install apt-file
  ```

* Update `apt-file`

  ```
  sudo apt-file update
  ```

* Search package that provides the file

  ```
  apt-file search ifconfig

  // Output:
  // ...
  // net-tools: /sbin/ifconfig
  // ...
  ```

  `net-tools` is the package provides `ifconfig`.
  Run `sudo apt install net-tools` to install it.

## References
* [Debian / Ubuntu Linux: Find Out What Package Provides a File](https://www.cyberciti.biz/faq/equivalent-of-rpm-qf-command/)
* [How do I find the package that provides a file?](https://askubuntu.com/questions/481/how-do-i-find-the-package-that-provides-a-file)

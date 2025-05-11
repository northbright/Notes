# Create a User with Home Dir on Ubuntu

## Problem
* Create a user via `sudo useradd xx` does not create a home dir for user `xx`

## Solution
* Delete the user `xx` created if need(optional)

  ```bash
  sudo userdel xx
  ```

* Create a user via `adduser` script provided by Ubuntu

  ```bash
  sudo adduser xx
  ```

  or with `--gecos ""` option to ingore additional information.

  ```bash
  sudo adduser xx --gecos ""
  ```

## References
* [Easiest way to create a new user with home directory and default settings on Ubuntu](https://medium.com/fusionqa/easiest-way-to-create-a-new-user-with-home-directory-and-default-settings-on-ubuntu-e866aa462136)
* [Home directory not being created](https://askubuntu.com/questions/374870/home-directory-not-being-created)
* [What do the `--disabled-login` and `--gecos` options of `adduser` command stand for?](https://askubuntu.com/questions/420784/what-do-the-disabled-login-and-gecos-options-of-adduser-command-stand)
* [Run adduser non-interactively](https://askubuntu.com/questions/94060/run-adduser-non-interactively)

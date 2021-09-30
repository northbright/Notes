# Create a User with Home Dir on Ubuntu

## Problem
* Create a user via `sudo useradd xx` does not create a home dir for user `xx`

## Solution
* Delete the user `xx` created if need(optional)

  ```
  sudo userdel xx
  ```

* Create a user via `adduser` script provided by Ubuntu

  ```
  sudo adduser xx
  ```

## References
* [Easiest way to create a new user with home directory and default settings on Ubuntu](https://medium.com/fusionqa/easiest-way-to-create-a-new-user-with-home-directory-and-default-settings-on-ubuntu-e866aa462136)
* [Home directory not being created](https://askubuntu.com/questions/374870/home-directory-not-being-created)

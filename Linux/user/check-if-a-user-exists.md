# Check if a User Exists

## Problem
* Need to know if a user exists

## Solution

#### Method A

Use `getent` command
  
* Usage

  ```
  getent passwd USERNAME
  ```

* Example

  ```
  getent passwd www-data
  // Output:
  // www-data:x:33:33:www-data:/var/www:/usr/sbin/nologin
  ```

#### Method B

Check `/etc/passwd` file

* Example

  ```
  cat /etc/passwd
  ```

  ```
  cat /etc/passwd | grep www-data
  ```
  
## References
* [UNIX / Linux Command To Check Existing Groups and Users](https://www.cyberciti.biz/faq/linux-check-existing-groups-users/)

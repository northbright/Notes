# Show an User's Groups

## Problem
* Need to list the user groups an user belongs to

## Solution
* Method A(recommended)

  Use `groups USER` command

  * Example

    ```
    group xx
    // Output:
    // xx : xx adm cdrom sudo dip plugdev lxd
    ```

* Method B

  Run `cat /etc/group | grep USER`

  * Example

    ```
    cat /etc/group | grep xx
    ```

## References
* [How to Check the User Group(s) an Ubuntu User Belongs To](https://vitux.com/how-to-check-the-user-groups-an-ubuntu-user-belongs-to/)

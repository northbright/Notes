# Get Primary Group of a User

## Solution
* Method A: Run `id USERNAME and Check `gid`: Group ID (GID)

  ```
  id admin
  uid=1002(admin) gid=114(sambashare) groups=114(sambashare),1001(admins)
  ```

  `sambashare` is the primary group.

* Method B: Run `-id` with `-ng` Options
  * `-n`: print group name
  * `-g`: print primary group only

  ```
  id -ng admin
  sambashare
  ```

* Method C: Run `groups USERNAME`

  The first group is the primary group.

  ```
  groups admin
  sambashare admins
  ```

## References
* [How to get the primary group of a user?](https://unix.stackexchange.com/questions/410367/how-to-get-the-primary-group-of-a-user)
* [How to List Groups in Linux](https://linuxize.com/post/how-to-list-groups-in-linux/)

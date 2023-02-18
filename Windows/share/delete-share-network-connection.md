# Delete Share Network Connection

## Solution
Use `NET USE {SHARE_NAME} /DELETE`

## Example
* List All Shared Resources

  ```
  NET USE

  // Output:
  OK    \\10.0.20.x\my_share    Microsoft Windows Network
  ```

* Delete Connection of Shared Resource

  ```
  NET USE \\10.0.20.x\my_share /DELETE
  ```

## Resources
* [How to Use the Net Use Command in Windows](https://www.lifewire.com/net-use-command-2618096)

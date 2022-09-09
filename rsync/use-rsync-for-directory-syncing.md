# Use `rsync` for Directory Syncing

## Solution
* Use `-r` or `-a` option for directory syncing, `-z` for compressing

  ```
  rsync -avz SRC_DIR/ USER@HOST:DEST_DIR/

  // example
  // rsync over ssh
  rsync -avz ./public/ xx@xx.com:~/public/
  ```

* Do NOT forget to add '/' after `SRC_DIR`
  * Mean “the contents of `SRC_DIR`”.
  * The alternative, without the trailing slash, would place `SRC_DIR`, including the directory, within `DEST_DIR`. This would create a hierarchy that looks like: `DEST_DIR/SRC_DIR`.

## References
* [How To Use Rsync to Sync Local and Remote Directories](https://www.digitalocean.com/community/tutorials/how-to-use-rsync-to-sync-local-and-remote-directories)

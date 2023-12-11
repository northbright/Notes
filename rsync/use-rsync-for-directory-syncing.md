# Use `rsync` for Directory Syncing

## About `/` after `SRC_DIR`
* Mean “the contents of `SRC_DIR`”.
* The alternative, without the trailing slash, would place `SRC_DIR`, including the directory, within `DEST_DIR`. This would create a hierarchy that looks like: `DEST_DIR/SRC_DIR`.

## Remote Directory Syncing
* Use `-r` or `-a` option for directory syncing, `-z` for compressing

  ```Shell
  rsync -avz SRC_DIR/ USER@HOST:DEST_DIR/
  ```

  e.g. rsync over ssh
  ```Shell
  rsync -avz ./public/ xx@xx.com:~/public/
  ```

## Local Directory Syncing
* Use `cp` Command or Finder App to Copy the Dir for the FIRST time(Rsync Will Be Very Slow)
* Then Use `Rsync` to Sync Directory

  * First use -n option to dry run
    ```Shell
    rsync -anv ~/Volumes/WD-SSD/my-backup/ ~/my-backup/
    ```

  * Do the real sync if there's no problem
    ```Shell
    rsync -av ~/Volumes/WD-SSD/my-backup/ ~/my-backup/
    ```

## References
* [How To Use Rsync to Sync Local and Remote Directories](https://www.digitalocean.com/community/tutorials/how-to-use-rsync-to-sync-local-and-remote-directories)
* [How to speed up rsync between two local disks?](https://superuser.com/questions/109780/how-to-speed-up-rsync-between-two-local-disks)

# Force Deletion of Files Using BAT

## Problem
* Failed to delete one folder or files under it

## Solution
* Write a BAT file with `del` and `rd` commands to delete the folder / files
  * Create a new `del.txt` file and copy / paste the commands

    ```
    DEL /F /A /Q \\?\%1
    RD /S /Q \\?\%1
    ```

  * Rename the `del.txt` to `del.bat`
* Drag the folders or files to the icon of the BAT file and release it

## References
* [6 Ways to Delete a File or Folder That Can’t Be Deleted on Windows 10](https://www.reneelab.com/cant-delete-folder-windows-10.html)
* [del](https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/del)
* [rd](https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/rd)

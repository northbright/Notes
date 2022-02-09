# Partition and Mount a Data Disk of Aliyun ECS(Ubuntu 20.04)

## Steps
* List Data Disk

  ```
  sudo fdisk -l

  // Check /dev/vdb in Output:
  ......
  Disk /dev/vdb: 100 GiB, 107374182400 bytes, 209715200 sectors
  ......
  ```

* Use `gdisk` to Create GPT Partition

  * Update `apt`
  
    ```
    sudo apt update
    ```

  * Install `gdisk`

    ```
    sudo apt install gdisk
    ```

  * Create GPT Partition

    ```
    sudo gdisk /dev/vdb
    ```
    
    * Input ? for Help
    * Press `n` to Create a New GPT Partition
    * Press `Enter` to Use `1`(default) as the Partition Number(`/dev/vdb1)`
    * Press `Enter` to Use Default Settings for First / Last Sector
    * Press `Enter` for Use Default Hex Code or GUID(8300)
    * Press `w` to Write the Partition Table
    * Press `y` to proceed

  * List Created Partition

    ```
    sudo lsblk

    // Output:
    vdb    252:16   0  100G  0 disk 
    └─vdb1 252:17   0  100G  0 part 
    ```
    
  * Install `xfsprogs`

    ```
    sudo apt install xfsprogs
    ```

  * Make Filesystem for the Partition

    ```
    sudo mkfs.xfs /dev/vdb1
    ```

  * Use `blkid` to Show UUID and Type of the Partition

    ```
    sudo blkid

    // Output:
    /dev/vda1: LABEL="/" UUID="xx" TYPE="ext4" PARTUUID="xx"
    /dev/vdb1: UUID="xx" TYPE="xfs" PARTLABEL="Linux filesystem" PARTUUID="xx"
    ```

  * Configure `/etc/fstab` and Mount the Partition

    * Backup `/etc/fstab`

      ```
      sudo cp /etc/fstab /etc/fstab.bak
      ```

    * Create the mount point(e.g. `/data`)

      ```
      sudo mkdir /data
      ```

    * Show current records of `/etc/fstab`

      ```
      sudo cat /etc/fstab
      ```

    * Write the new partition into `/etc/fstab`

      * `sudo vi /etc/fstab`

      * Append a new record

        ```
        UUID=XXXX /data           xfs     defaults 0 0
        ```

        * Column #1: Replace XXXX with the UUID of the partition in the output of blkid
        * Column #2: Mount point
        * Column #3: Filesystem
        * Column #4: Options - use `defaults` is OK
        * Column #5: Dump this partition or not - use `0` is OK
        * Column #6: fsck priority - use `0` is OK

  * Mount the partition

    ```
    sudo mount /dev/vdb1 /data
    ```

  * Check

    ```
    df -h
    ```

## References
* [https://help.aliyun.com/document_detail/25426.htm](https://help.aliyun.com/document_detail/25426.htm)
* [在fstab文件中配置UUID方式自动挂载数据盘](https://help.aliyun.com/document_detail/194379.htm)
* [第 6 堂課：基礎檔案系統管理](https://linux.vbird.org/linux_basic_train/centos8/unit06.php)

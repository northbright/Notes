# Install TestDisk and PhotoRec from Source on macOS

## Steps
* Install XCode App
* Install the Command Line Tools for Xcode
  ```bash
  xcode-select --install
  ```
* Install pkg-config on macOS
  * [Install pkg-config from Source on macOS](https://github.com/northbright/Notes/blob/master/macos/dev-tools/install-pkg-config-from-source-on-macos.md)

* Install autoconf on macOS
  * [Install autoconf from Source on macOS](https://github.com/northbright/Notes/blob/master/macos/dev-tools/install-autoconf-from-source-on-macos.md)

* Download Latest Release of [TestDisk](https://www.cgsecurity.org/wiki/TestDisk) from [Github Repo](https://github.com/cgsecurity/testdisk)
  ```bash
  git clone https://github.com/cgsecurity/testdisk.git
  ```

* Configure
  ```bash
  cd testdisk
  mkdir config
  autoreconf --install -W all -I config
  ```

  ```
  ./configure
  ```

* Make and Install

  ```bash
  make
  sudo make install
  ```

* Prepare Test Disk Image

  Create an APFS image disk and copy a JPG file into its volume and then delete it.

  ```bash
  // Use hdiutil to create an APFS disk image and it will be mounted to /Volumes/untitled.
  hdiutil create -fs apfs -size 5m -type UDIF -attach ~/apfs.dmg

  // Copy a JPG file to APFS volume. 
  cp ~/Download/my_cat.jpg /Volumes/untitled

  // Delete the JPG file.
  rm /Volumes/untitled/1.txt

  // Sync write operation to disk.
  sync

  // Detach APFS disk image.
  hdiutil detach /Volumes/untitled
  ```

* Try to run PhotoRec to recovery the data

  ```bash
  photorec <device | disk image> /d <recovery_dir> /log
  ```

  e.g.
  ```bash
  photorec ~/apfs.dmg /d ~/recovered_data /log
  ```

  You'll be asked to select the file system type to store the recovered files(`<recovery_dir>`).
  e.g. Select "Others" for this case because we store the data on APFS disk partition.
  It stores recovered files under `~/recovered_data` which we specified when run PhotoRec.

## References
* <https://github.com/cgsecurity/testdisk>
* [download](https://www.cgsecurity.org/wiki/TestDisk_Download)
* [Create an Empty APFS Disk with hdiutil](https://github.com/northbright/Notes/blob/master/macos/apfs/create-an-empty-apfs-disk-with-hdiutil.md)

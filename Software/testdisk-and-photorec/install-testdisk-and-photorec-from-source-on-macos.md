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

* Run `PhotoRec`

  ```bash
  // Use hdiutil to create an APFS disk image and attach it.
  hdiutil create -fs apfs -size 5m -type UDIF -attach ~/apfs.dmg

  // Create a text file in APFS. 
  echo "Test for PhotoRec" > /Volumes/untitled/1.txt

  // Delete the text file.
  rm /Volumes/untitled/1.txt

  // Sync write operation to disk.
  sync

  // Detach APFS disk image.
  hdiutil detach /Volumes/untitled
  ```

  ```bash
  photorec ~/apfs.dmg /d ~/recovery_data
  ```

## References
* <https://github.com/cgsecurity/testdisk>
* [download](https://www.cgsecurity.org/wiki/TestDisk_Download)

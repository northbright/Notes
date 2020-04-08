# Install aria2 on Mac OS X

## Mac OS X Version
* 10.15.4(Catalina)

## Problem
* Download the aria2 release(`.dmg` / `.tar.bz`) using browser(Firefox, Sarafi)
* Run `.dmg` or `aria2c` will pop up the "Can not open...The developer can not be verified..."

## Root Cause
* Sincd Mac OS 10.15, Apple requires distributed apps must be [notarized](https://developer.apple.com/documentation/xcode/notarizing_macos_software_before_distribution)

## Solution
* Method A: Use cURL to download the tar.bz release(recommended)

  * Download prebuilt release
    ```
    curl -L -O https://github.com/aria2/aria2/releases/download/release-1.35.0/aria2-1.35.0-osx-darwin.tar.bz2
    tar -xzvf aria2-1.35.0-osx-darwin.tar.bz2
    ```

  * Copy aria2 to /usr/local/aria2
    
    ```
    sudo cp -rf aria2-1.35.0 /usr/local/aria2
    ```

  * Add binary path of aria2
    ```
    sudo vi /etc/paths.d/aria2
    ```

    ```
    /usr/local/aria2/bin
    ```
  
  * Re-open a terminal to test

    ```
    aria2c --version
    ```

* Method B: Use cURL to download the .dmg release

  ```
  // Download the dmg
  curl -L -O https://github.com/aria2/aria2/releases/download/release-1.35.0/aria2-1.35.0-osx-darwin.dmg
  ```

* Method C: Install aria2 from Source
  * [Install aria2 from Source on Mac OS X](https://github.com/northbright/Notes/blob/master/aria2/install-aria2-from-source-on-mac-os-x.md)    

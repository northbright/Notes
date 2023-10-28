# Install [FFmpeg](http://ffmpeg.org/) on macOS

## Problem
* Download FFmpeg binaries (`ffmpeg`, `ffplay`, `ffprobe`...) via browser
* Failed to run the FFmpeg binary due to macOS security policy

## Solution
* Open Browser(Safari or Edge) to visit [FFmpeg Official Site](http://ffmpeg.org/)
* Go to [Download Page](https://evermeet.cx/ffmpeg/)
* Install [aria2](https://github.com/aria2/aria2/)
  * [Install aria2 from Source on Mac OS X](https://github.com/northbright/Notes/blob/master/aria2/install-aria2-from-source-on-mac-os-x.md)
* Copy the link and use [aria2](https://github.com/aria2/aria2/) to download it 

  ```
  cd ~/download
  aria2c https://evermeet.cx/ffmpeg/ffmpeg-5.1.1.zip
  ```
* Unzip the Zip and Put the Binary to Your App Dir(e.g. `/usr/local/ffmpeg/bin`)

  ```
  sudo mkdir -p /usr/local/ffmpeg/bin
  sudo unzip ffmpeg-5.1.1.zip -d /usr/local/ffmpeg/bin
  ```

* Add Binary Path of FFmpeg

  * Method A
  
    ```
    sudo vi /etc/paths.d/ffmpeg
    ```
    Copy these lines:
    ```
    /usr/local/ffmpeg/bin
    ```

  * Method B
    
    ```
    sudo vi ~/.zprofile
    ```

    Copy these lines:
    ```
    # FFmpeg
    /usr/local/ffmpeg/bin
    ```

    Run `source` command in the terminal.
    ```
    source ~/.zprofile
    ```

* Reopen a Terminal and Check

  ```
  ffmpeg -version
  ```

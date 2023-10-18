# Install Latest macOS on Unsupported Mac for China Users

## Problem
* iMac 27" 2017(iMac18,3) and It's NOT in the Supported Models for macOS Sonoma
* Need to Install Xcode 15 But It Requires macOS Sonoma

## Solution
Use [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) to install latest macOS(e.g. Sonoma) on unsupported Macs.

1. Get [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher)
For China users, download the [release](https://github.com/dortania/OpenCore-Legacy-Patcher/releases) from [Github](https://github.com) directly via browser will meet some problems: broken connection, very slow download speed. There're 2 methods to fix this issue.

* Method A: Use a Download App which Support Resume Download(e.g. [aria2c](https://github.com/aria2/aria2))
  * [Install aria2 on Mac OS X](https://github.com/northbright/Notes/blob/master/aria2/install-aria2-on-mac-os-x.md)
  * Run `aria2` to Download [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher)
 
    ```
    // Output Dir: ~/Downloads
    aria2c "https://github.com/dortania/OpenCore-Legacy-Patcher/releases/download/1.0.1/OpenCore-Patcher-GUI.app.zip" -o ~/Downloads/OpenCore-Patcher-GUI.app.zip

    ```

    * Run the Command **AGAIN** to Resume the Download when It Exits with Some Error:

      > [ERROR] CUID#8 - Download aborted. URI=https://github.com/dortania/OpenCore-Legacy-Patcher/releases/download/1.0.1/OpenCore-Patcher-GUI.app.zip
Exception: [AbstractCommand.cc:340] errorCode=2 Timeout.
    * Click the `OpenCore-Patcher-GUI.app.zip` to Unzip It
    * Move `OpenCore-Patcher-GUI.app` to `/Applications` Folder

* Method B: Run [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) from Source
  * Clone the Repo
  
    To make `git clone` faster for China Users, it's better to use `SSH` protocol instead `HTTPS`.
    * [Fork](https://docs.github.com/en/get-started/quickstart/fork-a-repo) the [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) repo.
    * Go to Your Forked Repo Page, Click "Code" Button > Select "SSH" and Copy the URL(e.g. `git@github.com:YOUR_USER_NAME/OpenCore-Legacy-Patcher.git`)
    * Run `git clone` Command

      ```
      cd ~/Downloads
      git clone git@github.com:YOUR_USER_NAME/OpenCore-Legacy-Patcher.git
      ```
  * Install Python
    * Do **NOT** use Python provided with Xcode or the Xcode Command Line Tools are unsupported due to reliability issues.
    * Download Python from [Official Site](https://www.python.org/downloads/macos/)
  * Install Dependencies
    ```
    cd ~/Downloads/OpenCore-Legacy-Patcher
    pip3 install -r requirements.txt
    ```
  * Run from Source
    ```
    python3 OpenCore-Patcher-GUI.command
    ```
  * Check [SOURCE.md](https://github.com/dortania/OpenCore-Legacy-Patcher/blob/main/SOURCE.md) for More Information

2. Get a USB Disk Ready
  * Plug in a USB Disk
  * Open "Disk Utility" > Select the USB Disk on the Left Side > Click Right-Top "Erase"
  * Set "Format" to "Mac OS Extended(Journaled)" and "Scheme" to "GUID Partition Map" and Click "Erase" Button

3. Create macOS Installer on the USB Disk
  * Click "Create macOS Installer" Button
  * Click "Download macOS Installer" Button
  * Select the macOS(e.g. macOS 14.0 Sonoma)
  * It'll Download the macOS Installer to `/Applications`
  * It Requires to Input User Password to Extract the Installer and  Download is Done
  * Click "Yes" When It Ask "Create macOS Installer?"
  * Select Local macOS Installer(e.g. macOS 14.0 Sonoma)
  * Select Local Disk: the USB Disk
  * After "Successfully Create the macOS Installer", It'll Ask "Would you like to continue to intall OpenCore to this disk?"
  * Click "Yes" > It'll Build a OpenCore for Your Model of Mac
  * "Finished building your OpenCore configuration" Message Pop Up
  * Click "Install to Disk"
  * Select USB Disk and EFI Partition(Volume) and Input Password to Install
  * Select "Ignore" when It Requires to Reboot after It's Done
  * Copy `OpenCore-Patcher-GUI.app` from `/Applications` to USB Volume(`e.g. install macos Sonoma`) for a Backup if You Download It Successfully

4. Create the Latest macOS Installer Supported by Your Model on the USB Disk
  If it fails to install the latest macOS, you may not boot the Mac. It's better to have a plan B for this.
  * Create a New Partition for the Latest macOS Installer Supported by Your Model
    * Open "Disk Utility" and Select USB Disk
    * Click Right-Top "Partition"
    * Click Left-Botton "+" Button to Create a New Partition
    * Set Partition Size to a Proper Size(e.g. 15 GB for Monterey) and Apply
    * It'll Show a New Volume(`Untitled`) on the Desktop
  * Click "Create macOS Installer" Button Again
  * Click "Download macOS Installer" Button
  * Select the macOS(e.g. macOS 12.7 Monterey)
  * It'll Download the macOS Installer to `/Applications`
  * It Requires to Input User Password to Extract the Installer and  Download is Done
  * **IMPORTANT**: Click **"NO"** When It Ask "Create macOS Installer?"
    If we click "Yes" and it will erase the partition / macOS installer for latest macOS(e.g. macOS Sonoma). We just use "Create macOS Installer" to download the installer to `/Applications`.
  * Open a Terminal and Type `sudo` and a space(` `)
  * Open a Finder and Go to `Applications` > Right Click the Latest macOS Installer Your Model Supported(e.g. install macOS Monterey) > Click "Show Package Contents"
  * Go to "Contents" > "Resources"
  * Find "createinstallmedia" > Drag "createinstallmedia" to the Terminal Window
  * Insert a space(` `) and Type `--volume ` in the Terminal
  * Drag the `Untitled` Volume on the Desktop to the Terminal
  * The Full Command
    ```
    sudo /Applications/Install\ macOS\ Monterey.app/Contents/Resources/createinstallmedia --volume /Volumes/Untitled
    ```
  * Press "Enter" and Input Password to Run the Command
  * The Volume Name will be Set to "Install macOS Monterey" After It's Done



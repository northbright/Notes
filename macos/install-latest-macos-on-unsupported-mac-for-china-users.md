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


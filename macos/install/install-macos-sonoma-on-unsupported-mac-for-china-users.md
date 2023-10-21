# Install macOS Sonoma on Unsupported Mac for China Users

## Problem
* iMac 27" 2017(iMac18,3) and It's NOT in the Supported Models for macOS Sonoma
* Need to Install Xcode 15 But It Requires macOS Sonoma

## Solution
Use [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) to install macos Sonoma on unsupported Macs.

For non-China Users, you may just follow the video tutorial:
* [Install macOS Sonoma on Unsupported Macs [2008-2017] with OCLP!](https://www.bilibili.com/video/BV1vh4y167DA)

For China users, the hardest part is to download [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) from Github.

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
  * Install [Git](https://git-scm.com/download/mac) on macOS
    * [Install and Configure Git on macOS](https://github.com/northbright/Notes/blob/master/Git/install-and-config-git-on-macos.md)
  * Clone the Repo
  
    To make `git clone` faster for China Users, it's better to use `SSH` protocol instead `HTTPS`.
    * [Fork](https://docs.github.com/en/get-started/quickstart/fork-a-repo) the [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) repo.
    * Go to Your Forked Repo Page, Click "Code" Button > Select "SSH" and Copy the URL(e.g. `git@github.com:YOUR_USER_NAME/OpenCore-Legacy-Patcher.git`)
    * Run `git clone` Command

      ```
      cd ~/Downloads
      git clone git@github.com:YOUR_USER_NAME/OpenCore-Legacy-Patcher.git
      ```
  * Install [Python](https://www.python.org/downloads/macos/)
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
  * Select the macOS 14.0 Sonoma
  * It'll Download the macOS Installer to `/Applications`
  * It Requires to Input User Password to Extract the Installer and  Download is Done
  * Click "Yes" When It Ask "Create macOS Installer?"
  * Select Local macOS Installer: macOS 14.0 Sonoma
  * Select Local Disk: the USB Disk
  * After "Successfully Create the macOS Installer", It'll Ask "Would you like to continue to intall OpenCore to this disk?"
  * Click "Yes" > It'll Build a OpenCore for Your Model of Mac
  * "Finished building your OpenCore configuration" Message Pop Up
  * Click "Install to Disk"
  * Select USB Disk and EFI Partition(Volume) and Input Password to Install
  * Select "Ignore" when It Requires to Reboot after It's Done
  * Copy `OpenCore-Patcher-GUI.app` from `/Applications` to USB Volume(`e.g. install macos Sonoma`) for a Backup if You Download It Successfully Using Method A

4. Create the Latest macOS Installer Supported by Your Model on the USB Disk
   If it fails to install the latest macOS, you may not boot the Mac. It's better to have a plan B for this.
   * Create a New Partition for the Latest macOS Installer Supported by Your Model on the USB Disk
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
   * Click "NO" When It Ask "Create macOS Installer?"
     * If we click "Yes" and it will erase the partition / macOS installer for macOS Sonoma. We just use "Create macOS Installer" to download the installer to `/Applications`.
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

5. Backup All Data
   * Your Data in `/home/XX`
   * Downloads, Photos, Videos, Documents
   * Configure Files for Developers
     * RSA private / public keys in `~/.ssh`
     * VIM configure file in `~/.vimrc`

6. Reboot to Install macOS Sonoma from USB Drive
  * Press "Option" Key or "Alt" Key for Windows Keyboard
  * Select "EFI Boot" with Open Core Legacy Patcher(Blue One) and USB External Drive Icon to Boot
  * Select "Install macOS Sonoma"
  * When in "macOS Recovery", Select "Disk Utility"
  * Select Internal HD and Erase
    * Name: Macintosh HD
    * Format: APFS
    * Scheme: GUID Partition Map
  * Quit Disk Utitlity
  * Click "Install macOS Sonoma"
  * Select the Internal Drive(Macintosh HD)
  * After 3 - 5 Reboot, the Installation will be done
    * It will select "macos Installer" as Default Boot Loader Automatically, Do Not Change It

7. Install Open Core Legacy Patcher on Internal HD's EFI Partition
  * It'll Pop Up a Window and Ask to Intall Open Core Legacy on Disk

    > OpenCore Legacy Patcher has detected that you are booting OpenCore from an USB or External drive.
    > If you would like to boot your Mac normally without a USB drive plugged in, you can install OpenCore to the internal hard drive.
    > Would you like to launch OpenCore Legacy Patcher and install to disk?
  * Click "Yes" and Select Internal HD and EFI Partition to Install It on Disk
  * If You Never See This Window, You May Run Open Core Legacy Patcher Manually to Install It on Disk

8. Reboot to Select Open Core Legacy Patcher EFI Boot Installed on The Disk
   * Eject all USB Drives
   * Unplug the USB Disk
   * Reboot
   * Press "Option" Key("Alt" Key for Windows Keyboard)
   * Select "EFI Boot" and Select Internal Drive(e.g. Macintosh HD)
   * Next Time, It will Use "EFI Boot" and Macintosh HD as Default Boot Loader and The USB Disk is NO More Need

## References
* [OpenCore Legacy Patcher](https://dortania.github.io/OpenCore-Legacy-Patcher/)
* [Install macOS Sonoma on Unsupported Macs [2008-2017] with OCLP!](https://www.bilibili.com/video/BV1vh4y167DA)

--------------------

# 为中国用户在不支持的 Macs 上安装 macOS Sonoma

## 问题
* iMac 27" 2017(iMac18,3) 不支持升级 macOS Sonoma
* 安装 Xcode 15 需要先升级为 macOS Sonoma

## 解决方法
使用 [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) 来安装 macOS Sonoma 到不支持的 Mac 型号上。

对于非中国用户，直接跟着下面的视频教程即可：
* [Install macOS Sonoma on Unsupported Macs [2008-2017] with OCLP!](https://www.bilibili.com/video/BV1vh4y167DA)

对于中国用户，最难的部分是从 Github 获取[OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher)。

1. 获取 [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher)
对中国用户来说，通过浏览器直接从 [Github](https://github.com) 下载 [release](https://github.com/dortania/OpenCore-Legacy-Patcher/releases) 会遇到问题: 连接断开, 十分缓慢的下载速度。有 2 个方法：

* 方法 A：使用可以断点续传的下载 App（e.g. [aria2c](https://github.com/aria2/aria2)）
  * [Install aria2 on Mac OS X](https://github.com/northbright/Notes/blob/master/aria2/install-aria2-on-mac-os-x.md)
  * 运行 `aria2` 下载 [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher)
 
    ```
    // Output Dir: ~/Downloads
    aria2c "https://github.com/dortania/OpenCore-Legacy-Patcher/releases/download/1.0.1/OpenCore-Patcher-GUI.app.zip" -o ~/Downloads/OpenCore-Patcher-GUI.app.zip

    ```

    * 如果遇到下载出错退出，则再次（重复）运行以上命令来继续下载，直到成功：
      > [ERROR] CUID#8 - Download aborted. URI=https://github.com/dortania/OpenCore-Legacy-Patcher/releases/download/1.0.1/OpenCore-Patcher-GUI.app.zip
Exception: [AbstractCommand.cc:340] errorCode=2 Timeout.
    * 点击 `OpenCore-Patcher-GUI.app.zip` 进行解压
    * 拖动 `OpenCore-Patcher-GUI.app` 到 `/Applications`（应用）文件夹

* 方法 B：从源代码运行 [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher)
  * 在 macOS 上安装 [Git](https://git-scm.com/download/mac)
    * [Install and Configure Git on macOS](https://github.com/northbright/Notes/blob/master/Git/install-and-config-git-on-macos.md)
  * 克隆该仓库(Repo)
  
    为了使 `git clone` 速度更快，建议使用 `SSH` 协议而不是 `HTTPS`。
    * [Fork](https://docs.github.com/en/get-started/quickstart/fork-a-repo) [OpenCore Legacy Patcher](https://github.com/dortania/OpenCore-Legacy-Patcher) 仓库
    * 访问已经 Fork 好的你自己的仓库主页，点击 "Code" 按钮，选择 "SSH" 协议的地址进行复制(e.g. `git@github.com:YOUR_USER_NAME/OpenCore-Legacy-Patcher.git`)
    * 运行 `git clone` 命令

      ```
      cd ~/Downloads
      git clone git@github.com:YOUR_USER_NAME/OpenCore-Legacy-Patcher.git
      ```
  * 安装 [Python](https://www.python.org/downloads/macos/)
    * **不要**使用 Xcode 或 Xcode Command Line Tools 自带的 Python，因为可靠性问题不被支持。
    * 需要从 [官网](https://www.python.org/downloads/macos/) 下载安装 Python。
    * 安装依赖
      ```
      cd ~/Downloads/OpenCore-Legacy-Patcher
      pip3 install -r requirements.txt
      ```
  * 从源代码运行
    ```
    python3 OpenCore-Patcher-GUI.command
    ```
  * 查看 [SOURCE.md](https://github.com/dortania/OpenCore-Legacy-Patcher/blob/main/SOURCE.md) 来获取更多信息

2. 准备 U 盘
  * 插入 1 个 U 盘
  * 打开“磁盘工具” > 在左侧选择 U 盘 > 点击右上角“抹掉”
  * 格式：Mac OS 扩展（日志式），方案：GUID 分区图 > 点击“抹掉”

3. 在 U 盘上创建 macOS Installer
  * 点击 "Create macOS Installer" 按钮
  * 点击 "Download macOS Installer" 按钮
  * 选择 macOS 14.0 Sonoma
  * 将会下载 macOS Installer 到 `/Applications`（应用程序）中
  * 下载完成后需要输入用户的密码来解压
  * 当提示 "Create macOS Installer?" 点击 "Yes"
  * Select Local macOS Installer: 选择 macOS 14.0 Sonoma
  * Select Local Disk: 选择之前的 U 盘
  * 当提示 "Successfully Create the macOS Installer"（写入 macOS Installer 到 U 盘完成）后，询问"Would you like to continue to intall OpenCore to this disk?"（是否安装 OpenCore 到磁盘？）
  * 点击 "Yes" 来编译适用于当前型号的 OpenCore
  * 编译完成后提示 "Finished building your OpenCore configuration"（编译完成）
  * 点击 "Install to Disk"
  * 选择 U 盘以及 EFI 分区，输入用户密码进行安装
  * 当安装 OpenCore 到 U 盘完成后，提示需要 "Reboot"（重启）时，选择 "Ignore"（忽略）
  * 从`/Applications`（应用程序） 复制 `OpenCore-Patcher-GUI.app` 到 USB 分区（install macos Sonoma）来进行备份该应用程序（通过方法 A 下载 Open Core Legacy Patcher）

4. 创建最新且你的 Mac 型号支持的 macOS Installer 到 U 盘上
   如果通过 U 盘重启安装 macOS Sonoma 失败，Mac 可能不能启动。我们最好有个备份计划。
   * 在 U 盘上新创建 1 个分区来存放你的 Mac 型号支持的最新版本的 macOS Installer
   * 运行“磁盘工具” > 选择 U 盘
   * 点击右上角的“分区”
   * 点击左下角的"+"来创建 1 个新的分区
   * 分区大小：Monterey 需要约 15GB > 点击应用来创建分区
   * 一个新的卷创建好了，桌面显示"Untitiled"
   * 点击 "Create macOS Installer" 按钮
   * 点击 "Download macOS Installer" 按钮
   * 选在当前型号 Mac 支持的 macOS(e.g. macOS 12.7 Monterey)
   * macOS Installer 将会被下载到 `/Applications`（应用程序）文件夹
   * 下载完成后输入用户密码来解压
   * 注意：点击 "NO" 当询问 "Create macOS Installer?"
     * 如果点击 "Yes" 将抹掉之前已经在 U 盘安装好的 macOS Sonoma Installer 和 EFI 分区上的 Open Core Legacy Patcher
     * 我们只是利用 "Create macOS Installer" 来下载 macOS Monterey installer 到 `/Applications`（应用程序）文件夹。
   * 打开  Terminal（终端）应用，输入 `sudo` 和 1 个空格（` `）
   * 打开 Finder（访达）应用，访问 `Applications`（应用程序）文件夹 > 找到 "macOS Monterey Installer > 右键点击 > 点击“显示包内容”
   * 点击 "Contents" > "Resources"
   * 找到 "createinstallmedia" > 拖动 "createinstallmedia" 到刚刚打开的 Terminal(终端)的窗口，会在终端中插入 "createinstallmedia" 的全路径
   * 在终端中输入 1 个空格（` `） 和 `--volume `
   * 将桌面上的 "Untitled" 的 USB 卷的图标拖动到终端的窗口中
   * 终端中完整的命令行
     ```
     sudo /Applications/Install\ macOS\ Monterey.app/Contents/Resources/createinstallmedia --volume /Volumes/Untitled
     ```
  * 按下回车输入用户密码来运行该命令
  * 安装 macOS Monterey 到 USB 的分区后，该卷名会变为 "Install macOS Monterey"

5. 备份数据
   * 用户下的数据：`/home/XX`
   * 下载, 照片, 文稿等
   * 开发者的配置文件（可选）
     * RSA private / public keys in `~/.ssh`
     * VIM configure file in `~/.vimrc`

6. 重新启动，从 USB 启动并安装 macOS Sonoma
  * 重启时按住 "Option" 键，Windows 键盘按住 "Alt" 键
  * 选择 "Open Core Legacy Patcher" 的 "EFI Boot" 来启动（蓝色图标 和 USB 驱动器图标）
  * 选择 "Install macOS Sonoma"
  * 进入 "macOS Recovery" 后，选择 "磁盘工具"
  * 选择内置硬盘然后抹掉
    * 名称: Macintosh HD
    * 格式: APFS
    * 方案: GUID Partition Map
  * 退出磁盘工具
  * 选择 "Install macOS Sonoma"
  * 选择刚才抹掉的内部硬盘(Macintosh HD)
  * 重启 3 - 5 次后，macOS Sonoma 安装完成
    * 每次重启时会自动选择 "macos Installer" 作为 Boot Loader, 不用手动选择

7. 安装 Open Core Legacy Patcher 到内置硬盘的 EFI 分区
  * 进入 macOS Sonoma 后，会弹出提示框，询问是否安装 Open Core 到磁盘上

    > OpenCore Legacy Patcher has detected that you are booting OpenCore from an USB or External drive.
    > If you would like to boot your Mac normally without a USB drive plugged in, you can install OpenCore to the internal hard drive.
    > Would you like to launch OpenCore Legacy Patcher and install to disk?
  * 点击 "Yes" 然后选择内置硬盘 和 EFI 分区来进行安装
  * 如果没有出现提示框，你也可以手动运行 Open Core Legacy Patcher App（从 U 盘的备份或者重新下载）来进行安装

8. 重启并从安装在内置硬盘的 EFI 分区上的 Open Core 启动
   * 推出所有 USB 卷
   * 拔掉 U 盘
   * 重新启动
   * 按住 "Option" 键（Windows 键盘按住"Alt" 键）
   * 选择内部硬盘上的 "EFI Boot" (e.g. Macintosh HD)
   * 之后会默认从内部硬盘上的 "EFI Boot" 启动，不再需要 U 盘了

## 参考资料
* [OpenCore Legacy Patcher](https://dortania.github.io/OpenCore-Legacy-Patcher/)
* [Install macOS Sonoma on Unsupported Macs [2008-2017] with OCLP!](https://www.bilibili.com/video/BV1vh4y167DA)

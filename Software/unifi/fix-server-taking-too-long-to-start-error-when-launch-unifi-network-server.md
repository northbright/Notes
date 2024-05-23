# Fix "Server taking too long to start" Error When Launch Unifi Network Server

## Problem
* Installed [Unifi Network Server v8.1.127](https://dl.ui.com/unifi/8.1.127/UniFi-installer.exe)
* Failed to Start Unifi Network Server with "Server taking too long to start" Error
* Analyze the Log File
  * Click "Create Support Info" Button
  * Name the File to a "`*.zip`"(e.g. "unifi-support-info.zip") and Save the File
  * Unzip the File and Open "server.log" with Notpad
  * Found Messages:

    > <launcher> INFO - Starting database process...
    > <mongod-tail> WARN mongo - Mongo log not found during startup
    > <mongo-db> WARN mongo - Stop listening to Mongo logs after process has exited
    > <mongo-db> INFO mongo - Database process stopped, code=-1073741515
  * The Launcher Failed to Start Mongo DB Process
  * Open File Explorer and Go to "C:\Users\XX\Ubiquiti UniFi\bin"
  * Run "mongod.exe" and Got "VCRUNTIME140.dll not found" and "MSVCP140.dll not found" Errors

## Root Cause
* MongoDB Requires [Visual C++ Redistributable for Visual Studio 2015](https://www.microsoft.com/en-gb/download/details.aspx?id=48145) to be Installed

## Solution
* Install [Visual C++ Redistributable for Visual Studio 2015](https://www.microsoft.com/en-gb/download/details.aspx?id=48145)
* Close the "Unifi Network Server" and Reboot
  * You'll Meet "Port 8080 is used by other programs" if Run Unifi Network Server Again without Reboot(the Other Program is Last Process of Unifi Network Server Itself)
* Launch Unifi Network Server and It Works

-------------------

# 修复启动Unifi Network Server 时遇到的 "Server taking too long to start" 错误

## 问题
* 已安装 [Unifi Network Server v8.1.127](https://dl.ui.com/unifi/8.1.127/UniFi-installer.exe)
* 启动Unifi Network Server 时遇到的 "Server taking too long to start" 错误
* 分析日志文件
  * 点击 "Create Support Info" 按钮
  * 命名为 "`*.zip`"(e.g. "unifi-support-info.zip") 然后保存
  * 解压该 zip 文件然后使用记事本打开 "server.log"
  * 找到一些信息：

    > <launcher> INFO - Starting database process...
    > <mongod-tail> WARN mongo - Mongo log not found during startup
    > <mongo-db> WARN mongo - Stop listening to Mongo logs after process has exited
    > <mongo-db> INFO mongo - Database process stopped, code=-1073741515
  * 启动器因为不能启动 MongoDB 的进程而失败
  * 打开文件管理器然后访问 "C:\Users\XX\Ubiquiti UniFi\bin"
  * 运行 "mongod.exe" 然后提示 "VCRUNTIME140.dll 无法找到" 和 "MSVCP140.dll 无法找到"的错误

## 原因
* MongoDB 依赖 [Visual C++ Redistributable for Visual Studio 2015](https://www.microsoft.com/en-gb/download/details.aspx?id=48145)

## 解决方法
* 安装 [Visual C++ Redistributable for Visual Studio 2015](https://www.microsoft.com/en-gb/download/details.aspx?id=48145)
* 关闭 Unifi Network Server 然后重启电脑
  * 如果不重启直接再次运行 Unifi Network Server，会遇到 "Port 8080 is used by other programs" 的错误（另一个使用 8080 端口的程序就是上一个 Unifi Network Server 自身的进程）
* 启动 Unifi Network Server，运行正常

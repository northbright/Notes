# Run Unifi Controller in CMD

## Problem
* Clicking the shotcut does not start Unifi Controller suddenly
* It asks users to choose programs to open "ace.jar" 

## Root Cause
* Some malwares make .jar files can not be opened by JRE

## Solution
* Run command in CMD to start Unifi Controller

  ```
  cd "PATH\To\Unifi Controller"
  java -jar "\lib\ace.jar" ui
  ```

----------

# 使用命令行手动启动 Unifi Controller

## 问题
* 点击快捷方式不能运行 Unifi Controller
* 询问使用哪个程序来打开 "ace.jar"

## 原因
* 恶意软件导致 .jar 文件不能被 JRE 运行

## 解决方法
* 手动使用命令行运行 Unifi Controller

  ```
  cd "PATH\To\Unifi Controller"
  java -jar "\lib\ace.jar" ui
  ```

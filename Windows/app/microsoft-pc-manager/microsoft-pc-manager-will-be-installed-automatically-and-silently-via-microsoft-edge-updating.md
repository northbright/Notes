# Microsoft PC Manager Will Be Installed Automatically and Silently via Microsoft Edge Updating

## Problem
* [Microsoft PC Manager](https://pcmanager.microsoft.com/zh-cn) is installed automatically on a clean installed Windows 10 PC

## Root Cause
* [Microsoft PC Manager](https://pcmanager.microsoft.com/zh-cn) will be installed automatically and silently via Microsoft Edge updating
* You may find the `MSPCManagerOnline_x.x.x.x.exe`(installer) in `C:\Program Files(x86)\Microsoft\EdgeUpdate\Download\{2355FF0C-CD74-421A-8631-57546E824C2D\x.x.x.x`

## Solution
* Unstall Microsoft PC Manager
  * Click Start > Right click Microsoft PC Manager > Uninstall
* Create `C:\Program Files\Microsoft PC Manager` dir(make sure it's empty)
* Right click the dir > Properties > Security Tab > Advanced
* Owner > Change > Input your user name(e.g. `my`) and click "check names" > Confirm
* Permissions > Delete all records
* You may get the error when deleting record of TrustedInsaller:

  > You can not delete this object because that TrustedInstaller inherits permissions from its parent. To delete TrustedInstaller, you must stop object inherit permissions. Turn off the inherit permission options and try delete TrustedInstaller again.
* Click "Stop Inherit" button > Delete all inherited permissions in the object
* Right click the dir > Properties > Properties > Make sure "Read Only" is checked
* Reboot PC

## References
* [电脑每次开机都会自动下载安装包并安装微软电脑管家](https://learn.microsoft.com/zh-cn/answers/questions/2405086/question-2405086?page=1#answers)

------------------------
# 微软电脑管家会通过 Edge 更新自动静默安装

## 问题
* [微软电脑管家](https://pcmanager.microsoft.com/zh-cn)会通过 Edge 更新自动静默安装
* 可以在`C:\Program Files(x86)\Microsoft\EdgeUpdate\Download\{2355FF0C-CD74-421A-8631-57546E824C2D\x.x.x.x`找到`MSPCManagerOnline_x.x.x.x.exe`(安装包)

## 解决方法
* 卸载微软电脑管家
  * 点击开始 > 右键电脑管家 > 卸载
* 创建`C:\Program Files\Microsoft PC Manager`(确保是空文件夹)
* 右键点击文件夹 > 属性 > 安全 > 高级
* 所有者 > 更改 > 输入当前用户名(e.g. `my`) > 点击"检查名称" > 确定
* 权限 > 删除所有记录
* 你可能在删除 TrustedInstaller 的记录时出现如下错误:

  因为 TrustedInstaller 从其父系继承权限，你无法删除此对象。要删除 TrustedInstaller，你必须阻止对象继承权限。关闭继承权限的选项，然后重试删除 TrustedInstaller。
* 点击"禁用继承"按钮 > 从此对象中删除所有已继承的权限
* 右键点击文件夹 > 属性 > 确认“只读”已经勾选
* 重启电脑

## 参考资料
* [电脑每次开机都会自动下载安装包并安装微软电脑管家](https://learn.microsoft.com/zh-cn/answers/questions/2405086/question-2405086?page=1#answers)

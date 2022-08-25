# Fix "Account Currently Disabled" Error When Accessing Share

## Problem
* Access share PC(e.g `\\share`)
* Get error

  > logon failure: account currently disabled

## Solution
* Go to Control Panel > Credential Manager > Click "Windows Credential" Tab
* Click "Add a Credential"
  * Internet or network address name: (e.g `\\share`)
  * User name
  * Password
* After the Windows Credential added, it can access shared PC successfully

## References
* [Logon failure : account currently disabled ](https://answers.microsoft.com/en-us/windows/forum/all/logon-failure-account-currently-disabled/6508846b-4a8a-4dc8-80ed-51133711626a)
* [Windows10访问共享文件夹:此用户无法登录，因为该账户当前已被禁用此用户无法登录，因为该账户当前已被禁用或者直接找不到相应的计算机解决办法](https://www.cnblogs.com/JvYouQing/p/14864830.html)
* ["account currently disabled" when accessing share, even before logging in](https://serverfault.com/questions/181365/account-currently-disabled-when-accessing-share-even-before-logging-in)

--------

# 修复”此用户无法登录，因为该账户当前已被禁用“

## 问题
* 访问共享 PC(e.g. `\\share`)
* 提示错误

  > 你可能没有权限使用网络资源。请与这台服务器管理员联系以查明你是否有访问权限。
  此用户无法登录，因为该账户当前已被禁用。

## 解决方法
* 访问控制面板 > 凭据管理器 > Windows 凭据 > 点击 Windows 凭据 Tab
* 点击“添加 Windows 凭据”
  * Internet 地址或网络地址：(e.g. `\\share`)
  * 用户名
  * 密码
* 添加好 Windows 凭据后，可以成功访问共享 PC

## 参考资料
* [Logon failure : account currently disabled ](https://answers.microsoft.com/en-us/windows/forum/all/logon-failure-account-currently-disabled/6508846b-4a8a-4dc8-80ed-51133711626a)
* [Windows10访问共享文件夹:此用户无法登录，因为该账户当前已被禁用此用户无法登录，因为该账户当前已被>禁用或者直接找不到相应的计算机解决办法](https://www.cnblogs.com/JvYouQing/p/14864830.html)
* ["account currently disabled" when accessing share, even before logging in](https://serverfault.com/questions/181365/account-currently-disabled-when-accessing-share-even-before-logging-in)

# Can not Remote Preview Hikvision Camera with "Encrypted Stream" Error

#### Problem
* Remote preview via IP can not work with "Encrpyted Stream" error
* Yingshiyun App has the same problem

#### Root Cause
* The "Enable Encrypted Stream" option is checked in NVR settings

#### Solution
* Goto "Network Settings"->"Platform Connection"->"Yingshiyun"->"Uncheck the "Enable Encrypted Stream" option 

---------------

# 远程登录海康威视录像机不能预览，出现"码流加密"错误

#### 问题
* 远程登录海康威视录像机不能预览，出现"码流加密"错误
* 荧石云App出现同样问题

#### 原因
* 在录像机的设置中"启用码流加密"被勾选

#### 解决方法
* "网络设置"->"平台接入"->"萤石云"->取消勾选"启用码流加密"

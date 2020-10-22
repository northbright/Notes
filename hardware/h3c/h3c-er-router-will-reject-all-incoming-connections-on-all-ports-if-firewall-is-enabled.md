# H3C ER Series Router will Reject All Incoming Connections if Firewall is Enabled

#### Problem
* We have a H3C ER3260 Router.
* We need to reject incoming connection on TCP 445 port to avoid [WannaCrypt](https://github.com/northbright/Notes/blob/master/Windows/windows-update/wannacrypt/windows-updates-for-wannacrypt-attacks.md) attacks.

#### Solution
* Turn on Firewall of H3C is enabled(by default).
* Make sure **"Default incoming policie"** is "Disable"(on all ports).

#### H3C Support Tel
* 4006009999(china).
* Need Serial Number which can be found in management system of router.

#### References
* [Windows Updates for WannaCrypt Attacks](https://github.com/northbright/Notes/blob/master/Windows/windows-update/wannacrypt/windows-updates-for-wannacrypt-attacks.md)

-------------------------------------------------------------------------
# H3C 华三 ER系列路由器如果启用防火墙(默认)，在所有端口上禁止所有入站通信

#### 问题
* 我们有一个H3C ER3260路由器.
* 需要禁止445端口的入站连接来防御[WannaCrypt](https://github.com/northbright/Notes/blob/master/Windows/windows-update/wannacrypt/windows-updates-for-wannacrypt-attacks.md) 勒索软件.

#### 解决方案
* 启用防火墙(默认防火墙就是启用的).
* 防火墙的入站默认策略是"禁止"(适用所有端口).

#### 路由器售后电话
* 4006009999
* 需要输入路由器序列号，可以在>管理界面的信息处找到.

#### 参考资料
* [Windows Updates for WannaCrypt Attacks](https://github.com/northbright/Notes/blob/master/Windows/windows-update/wannacrypt/windows-updates-for-wannacrypt-attacks.md)

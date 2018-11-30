# H3C ER3260 Router Report Warning of Client Exceeded 10Mbps Speed Limit and has been Added to Blacklist

## Background
* H3C ER3260 Router connects Internet via PPPOE dial connection
* No `QoS` Settings

## Problem
* Users report network broken problems frequently
   * Failed to upload large files
   * Network broken after failure of upload

## Steps to Find Out Root Cause
* Log in the H3C ER3260 Router's web console(`192.168.1.1`)
* Set `Log Level` to `debug(7)` to get more information
* Find many warning logs of `MAC XX client exeeded 10Mbps speed limit, has been added to attacker blacklist`

## Root Cause
In "Settings" -> "Security Zone" -> "Attack Protection" -> "Abnormal Bandwidth Protection",
the "Abnormal Bandwidth Protection" Settings is enabled and bandwidth limit is set to `10Mbps` by default

## Solution
* Disable "Abnormal Bandwidth Protection" and click "Apply"

## References
* [H3C ER3200路由器未知流量超过限定的阈值10Mbps，系统将限制其上行流量在阈值范围内](https://zhidao.baidu.com/question/585052873121655045.html)

-------------------------------
# H3C ER3260路由器报告主机超过10Mbps流量限制，被加入攻击黑名单

## 背景
* H3C ER3260路由器通过PPPOE拨号连接Internet
* 没有在路由器上设置`QOS`

## 问题
* 用户频繁报告断网的问题
  * 上传大文件失败
  * 失败后网络断开

## 寻找原因的步骤
* 登录H3C ER3260路由器的管理控制台(`192.168.1.1`)
* 将系统日志设置成`debug(7)`用以获取更多信息
* 在日志中找到很多警告信息：`MAC:XX 主机流量超过限定的阈值10Mbps，系统将限制其上行流量在阈值范围内`，`主机因流量超过限定的阈值，被加入到攻击列表中`

## 原因
在“设置” -> “安全专区” -> “防攻击” -> “异常流量防护”中，
“启用异常主机流量防护功能，设置异常流量阈值为10Mbps”被设置为“启用”

## 解决方法
* 取消“启用异常主机流量防护功能”

## 参考资料
* [H3C ER3200路由器未知流量超过限定的阈值10Mbps，系统将限制其上行流量在阈值范围内](https://zhidao.baidu.com/question/585052873121655045.html)

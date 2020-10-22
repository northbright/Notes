# Dual WAN Settings of H3C ER5200 to Bind IP Addresses and WAN

#### Problem
Need to restrict out connections from specified source IP addresses go through specified WAN port. 

#### Solution
* Goto "Advanced Settings" -> "Route Settings" -> "Policy Route Settings"
* Add a new policy
    * "Protocol": IP
    * "Source IP Address Range": Your IP address range
    * "Destination IP Address Range": 0.0.0.0-255.255.255.255(ALL)
    * "WAN Port": Your WAN port

    ![](img/01.png)

#### Reference
* [H3C ER5200，两个wan口都在用，内网有一台主机需要固定通过wan2连通外网，具体设置标签在那个位置](http://ask.zol.com.cn/q/169207.html)

=======================================

# H3C ER5200路由器双WAN口设置 - 绑定IP地址和对应的WAN口

#### 问题
需要限制内网特定范围的源IP地址只走特定的WAN口

#### 解决方案
* "高级设置" -> "路由设置" -> "策略路由"
* 新增一个策略
    * "协议类型": IP
    * "源IP地址段": 需要限制的IP地址段
    * "目的IP地址段": 0.0.0.0-255.255.255.255(表示全部)
    * "出接口": 特定的WAN口

    ![](img/01.png)

#### 参考资料
* [H3C ER5200，两个wan口都在用，内网有一台主机需要固定通过wan2连通外网，具体设置标签在那个位置](http://ask.zol.com.cn/q/169207.html) 

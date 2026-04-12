# 接入交换机上的电脑ping不通H3C-ER5200路由器的Vlanif1的地址

## 核心交换机H3C S5120V2 POE 配置
```sh
Vlan 10 100

// Vlanif1: 192.168.1.1/24
interface vlan 1
ip address 192.168.1.1 24
quit

// Vlanif10: 192.168.10.1/24
interface vlan 10
ip address 192.168.10.1 24
quit

// Vlanif100: 192.168.100.1/24
interface vlan 100
ip address 192.168.100.1 24
quit

// 在 VLAN 10 上开启 DHCP server
dhcp server ip-pool vlan10
network 192.168.10.0 mask 255.255.255.0
gateway-list 192.168.10.1
dns-list 223.5.5.5 223.6.6.6
quit

// 28口: trunk 口连接 H3C ER5200 LAN1
interface ge1/0/28
port link-type trunk
port trunk permit vlan 100
quit

// 1口：access 口连接电脑
interface ge1/0/1
port link-type access
port access vlan 10

// 静态路由: 默认路由指向路由器Vlanif100的IP: 10.0.100.2
ip route-static 0.0.0.0 0.0.0.0 192.168.100.2
```

—————————
## H3C ER5200 路由器配置

* WAN: 上连本地网络
* 获取 IP 方式: DHCP
* Vlanif1:
  192.168.1.2/24

* Vlanif100:
  192.168.100.2/24

* 高级>路由>静态路由
* 配置VLAN10的回程路由
* 目标地址: 192.168.10.0
* 子网掩码: 255.255.255.0
* 下一跳: 192.168.100.1
* 出接口: Vlan100

* Vlan > Trunk口
  LAN1的Permit VLAN: 100

## 问题
* 电脑插在核心交换机 1 口上，可以获取IP: 192.168.10.2
* 可以 ping 通路由器的 Vlanif100: 192.168.100.2
* 不能 ping 通路由器的 Vlanif1: 192.168.1.2
* 路由器上可以在网络维护中 ping 通电脑地址: 192.168.10.2

## 原因
核心交换机创建好Vlanif1后
会生成如下的路由

192.168.1.0/24     Direct  0   0           192.168.1.1     Vlan1
192.168.1.0/32     Direct  0   0           192.168.1.1     Vlan1
192.168.1.1/32     Direct  0   0           127.0.0.1       InLoop0

默认路由
0.0.0.0/0          Static  60  0           192.168.100.2   Vlan100

PC 访问 192.168.1.2 时，最长匹配原则会优先匹配
192.168.1.0/24     Direct  0   0           192.168.1.1     Vlan1
所以下一跳会到核心交换机的Vlanif1，不会到路由器上

PC 访问 192.168.100.2 时，最长匹配原则会优先匹配
0.0.0.0/0          Static  60  0           192.168.100.2   Vlan100

## 解决方法
新增一条静态路由，指定
ip static-route 192.168.1.2 255.255.255.255 192.168.100.2

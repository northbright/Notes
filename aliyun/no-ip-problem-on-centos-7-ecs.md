# 阿里云运行CentOS 7的ECS内网IP丢失

## 问题
* 阿里云一台运行CentOS 7的ECS突然不能访问。`ping`, `ssh`, 80端口均失败。
* 运行`sudo cat /etc/sysconfig/network-scripts/ifcfg-xx`查看是使用DHCP分配IP
   
      DEVICE=eth0
      BOOTPROTO=dhcp
      ONBOOT=yes
      ZONE=public

* 使用阿里云的控制台进行远程登录，运行`ifconfig`，发现网卡的没有分配到内网的IP地址(inet)。
   
## 原因
* [使用CentOS 7镜像的VPC网络类型的ECS实例可能存在IP地址无法自动刷新的风险预警](https://help.aliyun.com/noticelist/articleid/1000051501.html)
   > ECS实例使用DHCP方式获取IP地址，在实例运行过程中，dhclient会定期向DHCP服务器更新和续租IP地址。2018年5月30号（含）之前基于公共CentOS 7镜像创建的ECS实例会小概率清理dhclient，以致在下个IP续租时间到期后无法获取IP地址

## 解决方法
* 重启网络服务
   `sudo systemctl restart network`
* 再次运行`ifconfig`检查网卡是否DHCP分配到新的内网地址
* ping / ssh 公网地址

## 参考资料
* [使用CentOS 7镜像的VPC网络类型的ECS实例可能存在IP地址无法自动刷新的风险预警](https://help.aliyun.com/noticelist/articleid/1000051501.html)
* [检查与修复CentOS 7实例IP地址缺失问题](https://help.aliyun.com/knowledge_detail/94181.html?spm=a2c4g.11174386.n2.3.39aa1051ett8GF)

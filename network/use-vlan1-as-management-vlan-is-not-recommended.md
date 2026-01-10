# Use VLAN 1 as Managment VLAN is NOT Recommended

* Broadcast Affect: any unconfigured port uses VLAN 1
* Attacker connects to any port can access VLAN 1

## Recommended Configuration
* Create a specific VLAN for management(e.g. VLAN 100)
* Create a Vlanif of the management VLAN(e.g VLAN 100) on switch

  ```sh
  interface Vlanif 100
  ip address 10.0.100.1 24
  ```
* Use VLAN 100 instead VLAN 1 for the access port used for management

  ```sh
  interface GigabitEthernet0/0/24
  port link-type access
  port default vlan 100
  ```

## References
* [网络工程师必会：VLAN 1默认管理VLAN知识体系与实战配置详解](https://rk.51cto.com/article/484619.html)
* [管理VLAN和业务VLAN的推荐配置](https://support.huawei.com/enterprise/zh/doc/EDOC1100372039/e6a84e91)
* [S380 V600R025C00 配置指南（Web网管）](https://support.huawei.com/enterprise/zh/doc/EDOC1100514643/24181660)

# Huawei Switch Commands（华为交换命令）

## Enter System-View
```
system-view
```

## Disable Logging(info-center)
```
undo info-center enable
```

## Set Sys-Name
```
sysname XX(e.g. sw-core)
```

## Change Console Password
Login via console with old password.
```
// Check login users.
display users

// Check privilege of user: CONSOLE 0 is 15.
display user-interface

// Enter System-View.
system-view

// Enter user interface.
user-interface console 0

// Set authentication mode.
authentication-mode password

// Set password to NEW_PASSWORD and you'll be asked to input old password.
set authentication password cipher NEW_PASSWORD

return
```

## Create VLAN
```
// Batch Create VLAN 2 3 6 10 20 100
vlan batch 2 3 6 10 20 100
```

## Create VLAN Interface
```
// Create VLAN Interface for VLAN 2
interface Vlanif 2
ip address 10.0.2.1 24
quit
```

## Create DHCP Server on Vlan Interface
```
dhcp enable
```

```
// Create DHCP Server on Vlanif 2
interface Vlanif 2
dhcp select interface

// Reserve IP addresses.
dhcp server excluded-ip-address 10.0.2.1 10.0.2.50

// Set DNS servers.
dhcp server dns-list 223.5.5.5 223.6.6.6

// Set lease time.
// Lease time for AP & AC is UNLIMITED.
dhcp server lease unlimited

// Lease time for Phone is 2 hours
dhcp server lease day 0 hour 2 minute 0

quit
```

## Check DHCP Pool

```
// Show all IP pool.
display ip pool

// Show IP pool on Vlanif(e.g 2)
display ip pool interface Vlanif2
```

## Set Trunk Port
```
// Set port GE0/0/1 link type to trunk and allow VLAN 10 and 20.
interface GigabitEthernet 0/0/1
port link-type trunk
port trunk allow-pass vlan 10 20
quit
```

## Set Access Port
```
// Set port GE0/0/4 link type to access and use VLAN 10 as default VLAN.
interface GigabitEthernet 0/0/4
port link-type access
port default vlan 10 
quit
```

## Batch Set Port Interface
```
// Set trunk ports for GE0/0/2 to GE0/0/12
port-group 1 
group-member GigabitEthernet0/0/2 to GigabitEthernet0/0/12
port link-type trunk
port trunk allow-pass vlan 2 10 20
port trunk pvid vlan 2
quit
```

## Set Static Route
```
ip route-static 0.0.0.0 0.0.0.0 10.0.100.2
```

```
ip route-static 10.0.10.0 255.255.255.0 10.0.100.2
```

```
ip route-static 10.0.20.0 24 10.0.100.2
```

## Display IP Routing Table
```
display ip routing-table
```

## Display IP Interface
```
display ip interface brief
```

## Do Factory Recovery
```
// Do factory recovery in user-view.
reset factory-configuration

// Check latest factory recovery result in user-view.
display factory-configuration reset-result
```

## Enable Login via SSH
* Enter system-view

  ```
  system-view
  ```

* Create RSA key pair

  ```
  rsa local-key-pair create
  ```

  * Input `y` to replace already defined RSA key
  * Input public key size(default: 2048)

* Disable alert original in policy administrator(进入 AAA 本地管理员的密码策略，关闭原始密码报警)

  Alert orignal policy is enabled by default. It'll force new created user to change initial password for the first login via SSH(默认开启，会强制新创建的 SSH 用户第一次登陆时修改原始密码).

  Reference: [S5731登录提示修改密码，不修改无法登陆](https://support.huawei.com/enterprise/zh/knowledge/EKB1100060188)

```
aaa
local-aaa-user password policy administrator
undo password alert original
quit
```

* Create local user

```
aaa

// Create 'admin' user with 'YOUR_PASSWORD'
local-user admin password cipher YOUR_PASSWORD

// Set service type to SSH
local-user admin service-type ssh

// Set privilege level
local-user admin privilege level 15

quit
```

* Set SSH user authentication and service type

```
ssh user admin authentication-type password
ssh user admin service-type stelnet
```

* Start SSH server

```
stelnet server enable
```

* Configure VTY

```
user-interface vty 0 4
authentication-mode aaa
protocol inbound ssh
quit
```

* Enable Login via SSH from Vlan interfaces

```
// Enable all interfaces.
ssh server-source all-interface
```

```
// Enable Vlanif10
ssh server-source -i Vlanif 10
```

* Save
```
quit
save
```

* Login via SSH

```
// User: admin, Vlanif10: 10.0.10.1
ssh admin@10.0.10.1
```

## Change user password

```
aaa

// It requires to use irreversible-cipher instead of cipher to change administrator's password since V200R007
local-user admin password irreversible-cipher NEW_PASSWORD
```

* References
  * [S12700修改管理员账号密码时报错](https://support.huawei.com/enterprise/zh/knowledge/EKB1000478063)
  * [华为交换机-修改密码时报错](https://www.cnblogs.com/subsea/p/15489517.html)

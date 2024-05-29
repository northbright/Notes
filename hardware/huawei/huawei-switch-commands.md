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

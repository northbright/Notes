# Manage Huawei S380 

## Default Web Portal URL
```
https://192.168.112.1
```

## Register Admin Account
* Input admin password and click "Register"
* Login as Admin

## Enable Automatic Firmware Update
When admin logged in for the first time, you'll be asked to enable "Automatic Firmware Update" or not.
Disable "Automatic Firmware Update" for now.

## Select "Local Management" Mode
When admin logged in for the first time, you'll be asked to select "Management Mode".
Select "Local Management".

## Update Firmware
* Select "Configuration" tab > "Device List" > select "S380" > click "Set Parameter" icon
* Select "System Management" tab > "Software Upgrade" > "Automatic Upgrade"
* The "Immediate Upgrade" button will be available if new version is detected, just click it to update.

## Time Settings
* Select "System" tab > "Entire Network Managment" > Time > Modify
* Set Time Zone to UTC+8(Beijing)
* Set Mode to Automatic
  * Create NTP server
    * Server address: `203.107.6.88`(`ntp.aliyun.com`)
    * Key configuration: turn off(no key)
    * Server source port: Vlanif1(default VLAN)
    * OK
    * Wait for one minute and it'll sync local time with NTP server

## WAN Configuration
* Select "Internet Access Configuration" tab > select WAN port(e.g. `ge/0/0/10`)
* Interface Configuration > select "Internet access mode"
* e.g. `PPPOE`
  * Input PPPoE username and password
  * Enable NAT
* Apply

## Create LAN(VLAN)
* Select "LAN" tab > create
* Input VLAN name and VLAN ID > check "Create a VLANIF interface"
* Input IP address / mask(e.g. `10.0.3.2/255.255.255.0`)
* Disable or enable DHCP server
* OK

## Static Route Configuration
We may create static routes back to switch via Vlanif 1 for all subnets(e.g. VLAN 3, 10, 20).

* Select "Static Route" tab > create
* Destination IP Address: (e.g. `10.0.3.0` for VLAN 3)
* Subnet Mask: `255.255.255.0(24)`
* Outbound Interface: `Vlanif 1`(switch uses an access port(VLAN 1) connect to S380).
* Next Hop: IP address of Vlanif 1 of the switch(e.g.`192.168.112.1`)

## LAN Configuration(connect to switch)
* LAN > LAN Interface > select a port to connect to switch(e.g. `GE0/0/1`)
* Set "Interface mode" to "access"
* Set "Default VLAN"(e.g. 1)

## Approve AP
* Configuration > Device List
* Select AP(s) > Approve

## Wireless Management

* WLAN Management IP
  VLAN 1 IP and WLAN management IP must be the same.

* Create Wireless Service
  * Select "Wireless Management" > Wireless Service
  * Create > set SSID(e.g. `huawei`) > set Service VLAN ID(e.g. `10`)
  * Select auth method: PSK(WPA2), SAE(WPA3), PSK-SAE(WPA2-WPA3 mixed)
  * Select crypto method: WPA2, WPA3, WPA2-WPA3 and set key(password)
  * Select AP group(e.g. `default`)
  * Select radio to apply to(e.g. `2.4G`)

## Save Configuration
* Click top-right "Save" button to save current configuration.

## References
* [S380 产品文档](https://support.huawei.com/hedex/hdx.do?docid=EDOC1100409534&tocURL=resources%2Fhedex-homepage.html)
* [S380 V600R024C10 配置指南（Web网管）](https://support.huawei.com/enterprise/zh/doc/EDOC1100460452/531f26f6)

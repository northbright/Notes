# Manage Huawei AirEngine9700 via Web

## Default Manage IP
* Huawei AirEngine9700 Use `169.254.1.1` of `Vlanif1` as Manage IP by Default
* If You've Changed the Manage IP and Forget It, You May Do a Factory-Recovery by Keep Pressing "RST" Button for 5 Seconds

## Connect PC to Huawei AirEngine9700
* Configure PC Network Adapter to Use Static IP
  * Huawei AirEngine9700 Does NOT Enable DHCP Server on Vlanif1
  * We Need to Use a Static IP for PC(e.g. `169.254.1.10/255.255.255.0`).
* Connect PC to any LAN(e.g. GE0/0/1)
* Open a Browser Window and Visit `https://169.254.1.1`

## Disable Password Policy(Optional)
* Go to Maintenance > Administrator > Password Policy > Turn Off

## Upload / Download Files via File Manager
* Go to Maintenance > System > File Management

  | File Type | Example |
  | :--: | :--: |
  | System File | `airengine9700s-s_v200r020c00spc300.cc` |
  | Patch File | `AirEngine9700S-S_V200R020C00SPH003.pat` |
  | Current Config File | `vrpcfg.zip` |
  | License File | `LIC20240525XX.dat` | 

## Install License
#### Activate License and Download License File
* [Active and Download License as End User](activate-and-download-license-as-end-user.md)

#### Upload the License File
* Go to Maintenance > System > File Management
* Upload the Downloaded License File

#### Load the License
* Go to Maintenance > License > License File Information
* Click "Load" and Select the Uploaded License(e.g. `flash:/LIC20240525XX.dat`)
* It Shows the License Details after It Succeeded
  * The Device ESN and License File ESN are the Same
  * AP resources license

    | Item | Value |
    | :--: | :--: |
    | Control item current status | Normal |
    | Control item expiration time | Permanent |
    | Number of licenses | 16 |

## Upgrade AC

#### Save Current Configuration
* Click Right-Top "Save" Icon to Save Current Configration

#### Backup
* Backup Startup Files
  * Go to Maintenance > Device Upgrade > AC Upgrade > Export Startup Files
* Backup Configuration File(`vrpcfg.zip`)
  * Click Export Configuration File(Optional)
* Backup License File
  * Go to Maintenance > System > File Management
  * Find the License File(e.g. `LIC20240525XX.dat`) and Download

#### Download New System File and Patch File
* [Download New System File and Patch File](download-system-file-and-patch-of-huawei-device.md)

#### Upload New System File and Patch File
* Go to Maintenance > System > File Management
* Upload the Downloaded System / Patch File to the Device
  * It'll Take a Few Time(About 5 Minutes) to Upload System File(About 127MB), Please be Patient

#### Select Next Startup System / Patch File
* Go to Maintenance > Device Upgrade > AC Upgrade > Next Startup Information
* Select Next Startup System / Patch File
* Apply
* Restart the Device

#### Check Version
* You Can Check the Log of Console
* Login after Reboot
* Check Version
  ```
  display version
  ```

## Configure AC

Network Topology

+------------------------------------------------------------------------+
|                                                                        |
|            +------------+                                              |
|            |  Gateway   |                                              |
|            +-----+------+                                              |
|                  |                                                     |
|                  |       VLAN 2: AC,AP Management                      |
|                  |       VLANIF: 10.0.2.1/24, DHCP server is enabled.  |
|            +-----+-----+                                               |
|            |Core Switch| VLAN 10: WLAN Service for laptop.             |
|            +-----+-----+ VLANIF: 10.0.10.1/24, DHCP server is enabled. |
|                  |                                                     |
|                  |       VLAN 20: WLAN Service for mobile device.      |
|                  |       VLANIF: 10.0.20.1/24, DHCP server is enabled. |
|                  |                                                     |
|                  |VLAN 2,10,20                                         |
|                  |                                                     |
|             +----+-----+  VLAN 2  +----+                               |
|             |POE Switch+----------+ AC | VLANIF: 10.0.2.3/24           |
|             +----+-----+          +----+                               |
|     VLAN 2,10,20 |                                                     |
|                +-+--+                                                  |
|      +---------+ AP +--------------+                                   |
|      |         +----+              |                                   |
|      |                             |                                   |
|   +--v---+                      +--v--+                                |
|   |Laptop|IP:10.0.10.60/24      |Phone| IP:10.0.20.60/24               |
|   +------+                      +-----+                                |
|                                                                        |
+------------------------------------------------------------------------+

#### Create Mangement VLAN and VLANIF
* Go to Configuration > AC Config > VLAN > Create(e.g. `VLAN 2`)
* VLAN ID: 2
* Description: "AC-AP-Management"
* Add Interfaces(e.g. `GE0/0/10`) to List
  * Set Link-Type to "Trunk"
* Check "Create VLANIF"
* Input IP of VLANIF(e.g. `10.0.2.3/255.255.255.0`)

#### Configure Port Interface(Connected to Switch)
* Go to Configuration > AC Config > Interface > Select the Interface(e.g. `GE0/0/10`)
* Check Link-Type(`Trunk`)
* Check Allowed VLANs(e.g `2`)
* Set Default VLAN(PVID) to `2`

#### Create Static Route(from AC to Switch)
* Configuration > AC Config > IP > Route > Static Root Configuration Table > Create
* Destination IP / Subnet Mask: `0.0.0.0/0.0.0.0`
* Next Hoop Address: Switch Vlanif IP Address(e.g. `10.0.2.1`)
* Outbound Interface: Management Vlanif(e.g. `Vlanif2`)

#### Set AC source address
* Go to Configuration > AC Config > Basic Config > AC source address
* Select Vlanif(e.g. `Vlanif2`)
* Click "+" Button to Add the IP of Vlanif2 as AC Source Address

#### Set AP Authentication Mode
* Go to Configuration > AC Config > Basic Config
* Set "AP authentication mode" to "Non-authentication"
* Apply
* You'll be Asked to Create AP Account and Offline VAP Key

## Configure AP
Use Config Wizard for AP.

#### Create AP Group
We can use `default` AP Group for APs.
But if we need to do some customization(e.g. 5 GHz DCA Channel Set), create a new AP group is recommended.

* Go to AP Config > AP Group > Create
* AP Group Name: XX(e.g. `group1`)
* Copy parameters from other groups: `default`

#### Transfer All APs from One Group to Another(Optional)
* Go to AP Config > AP Group
* Select the Record of AP Group which Binds APs Already > Click the Number of Binded APs(e.g. 10)
* It'll Pop a Dialog > Transfer All APs > Confirm

#### Create Regulatory Domain Profile for Radio Management
Default frequency bandwidth of 5G DCA Channel Set is 20 MHz,
We can set it to 40 MHz to increase the connection speed.
To do this, create a Regulatory Domain Profile and apply it to `group1`.

* Go to AP Config > AP Group > Click the group(e.g. `group1`)
* Click Radio Managment > Regulatory Domain Profile
* Regulatory Domain Profile > Click "Create" Button
* Profile Name: e.g. `radio1`
* Copy parameters from other profiles: e.g. `default`
* Click OK and `group1` Use `radio1` as Regulatory Domain Profile
* Go to "5 GHz DCA Channel Set"
  * Frequency bandwidth > Select 40 MHz
  * Channel Set: Check All Channels
* Apply

#### AP Going Online
Go to Config Wizard > AP Going Online.

1. APs Go Online
  * AP authentication mode: Non-authentication(Already Set via AC Config)
  * Check Total Number of APs
  * Check Status is `normal` of APs in the List
  * Click Next

2. Group APs
  * Use `group1` Group
  * Check the APs in `group1` Group
  * Click Next

3. Confirm Configurations
  * Click "Continue With Wireless Service Configuration"

#### Wireless Service Configuration
Create a new SSID

1. Basic Information
  * SSID Name: e.g. `huawei`(VLAN 20) or `huawei-pc`(VLAN 10)
  * Service VLAN: Single VLAN
  * Service VLAN ID: e.g. `20` or `10`
  * Forwarding Mode: Direct
  * Next

2. Security Authentication
  * Security Settings: Key
  * Authentication Policy: PSK
  * Encryption Mode: WPA-WPA2
  * WPA Encryption Algorithm: AES
  * WPA2 Encryption Algorithm: AES
  * Key Type: PASS-PHRASE
  * Key: YOUR-KEY
  * Click Next

3. Access Control
  * Binding the AP Group: Select `group1` Group
  * Valid Radio: Specify Which Radio Profile to Use(Default is `All`: `0`, `1`, `2`)
    * `0`: Radio Profile 0: 2.4G
    * `1`: Radio Profile 1: 5G / 6G
    * `2`: Radio Profile 2: 5G / 6G

    Using 2 Different SSIDs for 2.4G and 5G is recommended(e.g. `XX-2.4G`, `XX-5G`).

  * Finish

#### Radio Planning / Calibration(Optional)
* Go to AP Config > AP Group > Click the group(e.g. `group1`)
* Expand "Radio Management" by Click "+"
* Select Radio Name(e.g. "Radio 0" for 2.4G, "Radio 1" and "Radio 2" for 5G)
* Modify Radio Settings and Apply

## References
* [Web示例(V2R19C00版本)：旁挂二层组网直接转发【AP+L3+旁挂AC+出口网关】](https://forum.huawei.com/enterprise/zh/thread/580934502589546496)
* [AirEngine 9700-射频资源管理（SmartRadio）](https://support.huawei.com/enterprise/zh/doc/EDOC1100278107/c349ef2)

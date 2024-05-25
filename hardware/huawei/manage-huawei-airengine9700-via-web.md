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

+---------------------------------------------------------------------+
|                                                                     |
|         +------------+                                              |
|         |  Gateway   |                                              |
|         +-----+------+                                              |
|               |                                                     |
|         +-----+-----+ VLAN 2: AC,AP Management VLAN.                |
|         |Core Switch| VLANIF: 10.0.2.1/24, DHCP server is enabled.  |
|         +-----+-----+                                               |
|               |       VLAN 20: WLAN Service VLAN                    |
|               |       VLANIF: 10.0.20.1/24, DHCP server is enabled. |
|               |                                                     |
|               |VLAN 2,20                                            |
|               |                                                     |
|          +----+-----+  VLAN 2  +----+                               |
|          |POE Switch+----------+ AC | VLANIF: 10.0.2.3/24           |
|          ++------+--+          +----+                               |
|  VLAN 2,20|      |VLAN 2,20                                         |
|        +--+-+  +-+--+                                               |
|        |AP-1|  |AP-2|                                               |
|        +----+  +----+                                               |
|                                                                     |
+---------------------------------------------------------------------+

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

#### AP Going Online
Go to Config Wizard > AP Going Online.

1. APs Go Online
  * AP authentication mode: Non-authentication(Already Set via AC Config)
  * Check Total Number of APs
  * Check Status is `normal` of APs in the List
  * Click Next

2. Group APs
  * Use `default` Group
  * Check the APs in `default` Group
  * Click Next

3. Confirm Configurations
  * Click "Continue With Wireless Service Configuration"

#### Wireless Service Configuration
Create a new SSID

1. Basic Information
  * SSID Name: e.g. `Huawei`
  * Service VLAN: Single VLAN
  * Service VLAN ID: e.g. `20`
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
  * Binding the AP Group: Select `default` Group
  * Valid Radio: All, 0, 1, 2
  * Finish

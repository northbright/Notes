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

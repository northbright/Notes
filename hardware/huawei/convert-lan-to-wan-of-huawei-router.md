# Convert LAN to WAN of Huawei Router

## Problem
* Huawei AR611E-S Router Has 1 WAN Interface by Default
* Need Another WAN

## Solution
Convert a LAN Interface to a WAN Interface

#### Convert a LAN Interface to a WAN Interface
* Go to Configuration > LAN Configuration > LAN
* Go to Physical Interface > Select an Interface(e.g. `GE0/0/1`) and Click "convert"
* It Popups a Dialog with Warning Messages:

  > Are you sure you want to convert the interface to a Layer 3 interface?
* Click "OK"

#### Configure WAN Interface
* Go to Configuration > WAN Configuration > Ethernet Interface
* Go to Interface Configuration > Select the Interface Converted(e.g. `GE0/0/1`)
* Check IPv4 Configuration > Select Connection Mode(e.g. "PPPOE")
* Set "Enable NAT" to "ON"
* Apply

#### Save
* Click Right-Top Save Button to Save the Configuration

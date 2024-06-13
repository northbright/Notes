# Configure SSD and HDD Storage When Install Ubuntu Server

## Problem
* Need to Install Ubuntu Server 22.04 on a Server
* The server has 2 disks
  * Samsung 1TB SSD - used as boot device
  * Seagate 18TB HDD - used to store data(samba server)
* Need to Do Custom Storage Layout

## Solution
#### Select "Custom storage layout" at "Guided storage configuration"
#### Configure SSD
* Create Boot Partition
  * Go to "Available Devices" > "Samsung SSD" > Enter > Select "Use As Boot Device"
  * It'll Create EFI Partition which Mount Pointer is `/boot/efi`
* Create Primary Partition for `/`
  * Go to "Available Devices" > "Samsung SSD" > Free Space > Enter > Add GPT Partition
  * Size: Leave Empty to Use All Free Space
  * Format: `ext4`
  * Mount: `/`
  * Create
  * It'll Create a ext4 Partition which Mount Pointer is `/`
#### Configure HDD
* Create Logical Volume Group
  * Goto "Avaialble Devices" > "Create volume group(LVM)"
    * Name: "vg-hdd"
    * Devices: Seagate HDD
    * Size: Leave Empty to Use All Free Space
    * Create
    * It'll a "vg-hdd" Device under Available Devices
* Create Logical Volume
  * Goto "Available Devices" > "vg-hdd" > free space > Create Logical Volume
  * Name: "lv-seagate"
  * Size: Leave Empty to Use All Free Space
  * Format: `ext4`
  * Mount: Other > `/data`(which is used to store data for Samba)

#### Finish
* Select "Done" > "Continue"

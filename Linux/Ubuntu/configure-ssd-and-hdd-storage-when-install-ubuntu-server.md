# Configure SSD and HDD Storage When Install Ubuntu Server

## Problem
* Need to Install Ubuntu Server 22.04 on a Server
* The server has 3 disks
  * Samsung 1TB SSD - used as boot device
  * Seagate 18TB HDD - used to store data(samba server)
  * WD 18TB HDD - also used to store data(samba server)
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
    * Devices:
      * Select the one or more deivces via press "space" key.
      * Select "Seagate 18TB HDD" and "WD 18 TB HDD"
      * Warning: you may got black screen when select devices(Install Ubuntu 24.04 on HP Z228)
        * Check the "Size" to determine which device is selected.
        * Do NOT select the bootable USB disk(it'll be cleaned).
      * If your device is not in the devices list, it may be used as Boot Device before.
        * Select the device > Stop Using As Boot Device.
        * It should be displayed in the device list now.
    * Size: Leave empty to use all free space of all selected devices.
    * It'll create a "vg-hdd" device under "Available Devices".
* Create Logical Volume
  * Goto "Available Devices" > "vg-hdd" > free space > Create Logical Volume
  * Name: "lv-samba"
  * Size: Leave empty to use all free space
  * Format: `ext4`
  * Mount: Other > `/data`(which is used to store data for Samba)

#### Finish
* Select "Done" > "Continue"

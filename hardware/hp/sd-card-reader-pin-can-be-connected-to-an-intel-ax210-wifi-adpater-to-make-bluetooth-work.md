# SD Card Reader Pin Can Be Connected to an Intel AX210 WiFi Adpater to Make Bluetooth Work

## Problem
* Need to install an Intel AX210 WiFi adapter on an HP Z228 workstation
* To make Bluetooth work, need to connect the USB 9 pin on the mainboard to the adapter via an USB cable
* Can not find any USB 9 pin on the mainboard of HP Z228 workstation 

## Solution
Use SD card reader pin instead.

* Find the "SR RDR" label on the mainboard(nearby the SATA ports)
* It has 11 pins

  ```
  x XXXX
  xXXXXX
  ```

* Connect the 9-PIN usb connector to the X(captial X) pins

## References
* [Unable to find 9 pin USB connector in Z2 Tower G5 Workstation for Ubit Wifi and Bluetooth PCIe Modul](https://h30434.www3.hp.com/t5/Business-PCs-Workstations-and-Point-of-Sale-Systems/Unable-to-find-9-pin-USB-connector-in-Z2-Tower-G5/td-p/8480554)
* [9-Pin USB Motherboard Male Header to Single USB 2.0 Type A Male Cable 7.8inch](https://www.amazon.com/-/zh/9-Pin-Motherboard-Header-Single-7-8inch/dp/B08Q2TLWGV)
* [How to Check and Upgrade Your Bluetooth Version on Windows](https://windowsforum.com/threads/how-to-check-and-upgrade-your-bluetooth-version-on-windows.350587/)
* [英特尔® Wi-Fi 6E AX210](https://www.intel.cn/content/www/cn/zh/products/sku/204836/intel-wifi-6e-ax210-gig/downloads.html)

# How to Check Bluetooth Version on Windows

## Problem
* Installed an Intel AX210 WiFi Adapter on a desktop PC(Windows 10)
* Need to know the Bluetooth version

## Solution
* Go to Control Panel > Device Manager > Bluetooth > Select the device name which contains hardware manufacture info(e.g. Intel(R) Wireless Bluetooth(R))
* Right click > Properties > Advanced > Firmware Version > Check LMP number

  | LMP Number | Bluetooth Version |
  | :--: | :--: |
  | LMP 0 | Bluetooth 1.0b (Withdrawn) |
  | LMP 1 | Bluetooth 1.1 (Withdrawn) |
  | LMP 2 | Bluetooth 1.2 (Withdrawn) |
  | LMP 3 | Bluetooth 2.0 + EDR (Withdrawn) |
  | LMP 4 | Bluetooth 2.1 + EDR (Deprecated) |
  | LMP 5 | Bluetooth 3.0 + HS (Deprecated) |
  | LMP 6 | Bluetooth 4.0 |
  | LMP 7 | Bluetooth 4.1 |
  | LMP 8 | Bluetooth 4.2 |
  | LMP 9 | Bluetooth 5.0 |
  | LMP 10 | Bluetooth 5.1 |
  | LMP 11 | Bluetooth 5.2 |
  | LMP 12 | Bluetooth 5.3 |
  | LMP 13 | Bluetooth 5.4 |
  | LMP 14 | Bluetooth 6.0 (Predicted/Upcoming) |

## References
* [How to Check and Upgrade Your Bluetooth Version on Windows](https://windowsforum.com/threads/how-to-check-and-upgrade-your-bluetooth-version-on-windows.350587/)

# Use `screen` to Connect to Serial Port on Mac

## Problem
* Need to Connect to H3C Switch via USB-Serial Cable on Mac

## Solution
Use `screen` to Connect to Serial Port

* List USB Serial Devices

  ```
  ls /dev/cu.*
  ```
  
  Output:
  
  ```
  /dev/cu.usbserial-1420
  ```

* Connect to Serial Port

  ```
  screen /dev/cu.usbserial-1420
  ```

  or With USB Serial Console Speed Specified

  ```
  screen /dev/cu.usbserial-1420 115200
  ```

* Quit
  * Kill Current Screen Window(Session)

    * Press `CTRL+A` then Press `k`

      It'll ask:

      > Really kill this window [y/n]

      Press `y`

  * Kill All Screen Windows(Sessions)
  
    * Press `CTRL+A` then Press `CTRL+\`

      It'll ask:

      > Really quit and kill all your windows [y/n]

      Press `y`

* Check if There's No Screen Session

  ```
  screen -list
  ```

  Output:
  ```
  No Sockets found in /var/......
  ```

## References
* [Is there an OS X terminal program that can access serial ports?](https://apple.stackexchange.com/questions/32834/is-there-an-os-x-terminal-program-that-can-access-serial-ports)
* [terminate screen monitoring serial port](https://unix.stackexchange.com/questions/180900/terminate-screen-monitoring-serial-port)

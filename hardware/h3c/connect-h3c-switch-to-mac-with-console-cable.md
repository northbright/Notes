# Connect H3C Switch to Mac with Console Cable

## Connect H3C Switch to Mac with Console Cable / DB9 -> USB Adapter
* Purchase a DB9 -> USB adapter(e.g. [绿联（UGREEN）USB转RS232串口连接转换线](https://item.jd.com/1309051.html))
* Power on H3C Switch and Mac
* Find out the console cable(RJ45 -> DB9) in the box of H3C switch, connect it to the DB9 -> USB adapter
* Connect USB side of the DB9 -> USB adapter to Mac firstly
* Connect RJ45 side to the `console` port of H3C Switch

## Use `screen` command to connect the serial device
* Get the name of USB-Serial device

  ```
  ls /dev/cu.usbserial*

  // Output:
  /dev/cu.usbserial-1410
  ```

* Connect to the Switch

  ```
  // Copy the device name as the argument of screen
  screen -L /dev/cu.usbserial-1410
  ```

* Exit

  1. Press `Ctrl` + `A`
  2. Then press `Ctrl` + `K`

  Warnning: If you forcely exit terminal running `screen`, you'll meet problem to run `screen` agian in a new terminal. You need to unplug and re-plug the USB-Serial adapter to Mac to fix this.

## References
* [MAC OS X 如何使用USB串口设备](https://www.jianshu.com/p/e25009af3726)
* [Minicom---MAC OS使用串口调试交换机的利器](https://www.jianshu.com/p/3d921b547705)
* [Installing a USB Serial Adapter on Mac OS X](https://archive.plugable.com/2011/07/12/installing-a-usb-serial-adapter-on-mac-os-x/#VERIFY)

---------------------

# 使用 Console 线连接 H3C 交换机和 Mac

## 使用 Console 线配合 DB9 -> USB 适配器，连接 H3C 交换机和 Mac
* 购买 1 个 DB9 -> USB 的适配器(e.g. [绿联（UGREEN）USB转RS232串口连接转换线](https://item.jd.com/1309051.html))
* Mac 和 H3C 交换机开机
* 找到 H3C 交换机包装内自带的 Console 线（RJ45 -> DB9），连接 DB9 -> USB 适配器
* 首先连接 USB 端到 Mac
* 然后连接 RJ45 端到 H3C 交换机

## 使用 `screen` 命令来连接串口设备
* 获取 USB-Serial 设备名

  ```
  ls /dev/cu.usbserial*  

  // 输出:
  /dev/cu.usbserial-1410
  ```  

* 连接交换机

  ```
  // 复制设备名作为 screen 的参数
  screen -L /dev/cu.usbserial-1410 
  ```

* 退出

  1. 首先按下 `Ctrl` + `A`
  2. 然后按下 `Ctrl` + `K`

  警告：如果强制退出运行 `screen` 的 terminal，再次在新的 terminal 中运行 `screen` 会出现问题。需要移除再次插入 USB-Serial 适配器到 Mac 来解决此问题。

## 参考资料
* [MAC OS X 如何使用USB串口设备](https://www.jianshu.com/p/e25009af3726)
* [Minicom---MAC OS使用串口调试交换机的利器](https://www.jianshu.com/p/3d921b547705)
* [Installing a USB Serial Adapter on Mac OS X](https://archive.plugable.com/2011/07/12/installing-a-usb-serial-adapter-on-mac-os-x/#VERIFY)

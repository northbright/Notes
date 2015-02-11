
# adb sideload OTA package

1. make ota package(`out/target/product/xx/xx-ota-xx.zip`)  
   `make otapackage -j16`

2. reboot device to enter recovery mode  
   `adb reboot recovery`

3. select `apply update from adb`

4. You will see "run adb sideload <FileName>"

5. install `Android ADB Interface`:  
   * "Control Panel" -> "Device Manager" -> Find Device -> "Update Driver Software"
   * "Browse my computer for driver software" -> "Let me pick from a list of device drivers of my computer" -> "Show All Devices" -> "Have Disk" -> Select "android_winusb.inf" under you downloaded Android SDK
   * Choose `Android ADB Interface`

6. Run `adb sideload <FileName>` to update OTA package  
   File name should be the OTA package(`out/target/product/xx/xx-ota-xx.zip`)
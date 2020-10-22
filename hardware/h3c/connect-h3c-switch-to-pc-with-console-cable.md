# Connect H3C Switch to PC with Console Cable

## Steps
### 1. Connect H3C Switch to PC with Console Cable / DB9 -> USB Adapter
* Purchase a DB9 -> USB adapter(e.g. [绿联（UGREEN）USB转RS232串口连接转换线](https://item.jd.com/1309051.html))
* Power on H3C Switch and PC
* Find out the console cable(RJ45 -> DB9) in the box of H3C switch, connect it to the DB9 -> USB adapter
* Connect USB side of the DB9 -> USB adapter to PC firstly
* Connect RJ45 side to the `console` port of H3C Switch

### 2. Install Driver of DB9 -> USB Adapter
* Goto "Control Panel" -> "Hardware and Sound" -> "Device Manager"
* Select "Port(COM and LPT)" and find "Prolific USB-to-Serial Comm Port(COMX)" device(X is number, e.g. COM3), right click on it, select "Update Driver" to install the adapter driver

### 3. Use [`putty`](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html) to Connect the Switch
* Download latest [putty](https://the.earth.li/~sgtatham/putty/latest/w64/putty.zip) on [official site](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html)
* Launch  [`putty`](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html)
* Goto "Session"
   * Set "Connection Type" to "**Serial**"
   * Set "Speed" to "9600"
 * Goto "Connection" -> "SSH" -> "Serial"
    * Set "Flow Control" to "**None**"
* Click "Open" to open a connection window
* Press **ENTER** and it'll show `<H3C>`

# Setup ASUS RT-N18U Wireless Router to AP Mode

## Part I - Set Static IP for Computer
* Goto "Control Panel" -> "Network and Sharing Center" -> "Local  Area Connection"

  ![](img/01.png)
* Click "Properties"

  ![](img/02.png)
* Double click "TCP/IPv4"

  ![](img/03.png)
* Select "Use Static IP Address"
    * input a static IP **other than** `192.168.1.1`(e.g. `192.168.1.87`)
    * set subnet mask to `255.255.255.0`
    
  ![](img/04.png)

## Part II - Configure Wireless Router
* Power on the router for the first time or keep pressing reset button to do a factory reset
* Connect the ethernet cable from computer to any one of **LAN**(yellow color) ports of the router
* Open a browser enter `192.168.1.1` to login the web admin page of the router
   * Username: `admin` 
   * Password: `admin`
   
  ![](img/05.png)

* Click "Next" button to goto Wireless Settings
  * Input SSID(e.g. `Test`)
  * Input WPA2 password(e.g. `Password`)
  * Apply settings

  ![](img/06.png)
  ![](img/07.png)

* It'll show the main settings UI
* Click "Operation Mode"

  ![](img/08.png)
* Set "Operation Mode" to "Access Point" mode

  ![](img/09.png)
* Enable "DHCP" and confirm previous wireless settings

  ![](img/10.png)
  ![](img/11.png) 
* Apply settings and you'll be notified that IP of the router will be changed due to DHCP

  ![](img/12.png)
* Remove the ethernet cable from the computer and connect the cable to the switch and wait for a while
* Use another ethernet cable to connect from the computer to the swich
   ```
   +--------+  cable 1 +--------+     
   | switch |----------|Computer|
   |        |          +--------+
   |        |
   |        |  cable 2 +----------------------------+
   |        |----------|ASUS RT-N18U Wireless Router|
   +--------+          +----------------------------+
  ```
## Part III - Set DHCP Back for Computer
* Goto "Control Panel" -> "Network and Sharing Center" -> "Local  Area Connection"

  ![](img/01.png)
* Click "Properties"

  ![](img/02.png)
* Double click "TCP/IPv4"

  ![](img/03.png)
* Select "Use DHCP"

  ![](img/14.png)
   
## Part IV(Optional) - Find IP of the Router and Setup for the Future
* You need to download / run [ASUS Wireless Router Device Discovery Utility](https://dlsvr04.asus.com/pub/ASUS/wireless/4G-AC53U/Discovery_1482.zip) to get the IP of the router later

  ![](img/13.png)

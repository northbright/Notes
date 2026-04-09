# Change MAC Address on macOS

## Steps
* Press Option key and click WiFi icon to get the interface of WiFi(e.g. en0)
* Disconnect from any network(SSID) and KEEP WiFi on
* Run the command in a Terminal window:

  ```sh
  sudo ifconfig en0 ether 00:07:29:55:35:57
  ```

* Reconnect to the network(SSID)
* Press Option key and click WiFi still shows the old MAC
* Run the command in a Terminal window:
  
  ```sh
  ifconfig en0
  ```

  and it shows the new MAC 

## Reference:
* [How do I properly change the MAC address of my MacBook Pro?](https://apple.stackexchange.com/questions/388352/how-do-i-properly-change-the-mac-address-of-my-macbook-pro)

# Failed to Connect PPPoE on macOS Sequoia 15

## Problem
* MacBook Pro 2019(Intel), upgraded to macOS Sequoia 15
* China Telecom gateway(Raisecom) has been configured to use bridge mode
* Connect from MacBook Pro to gateway's LAN 8(using USB-to-Etherenet adapter)
* Go to Settings > Networks > click "..." > Add Service > Set interface to "PPPoE"
* Select Etherenet Interface > OK
* Click "Details" > Input account and password > click "Connect"
* Failed to create PPPoE connection
* `/var/log/ppp.log`

  ```
  Sun Sep 14 13:10:00 2025 : PPPoE connection established.
  Sun Sep 14 13:10:00 2025 : Using interface ppp0
  Sun Sep 14 13:10:00 2025 : Connect: ppp0 <--> socket[34:16]
  Sun Sep 14 13:10:33 2025 : LCP: timeout sending Config-Requests
  Sun Sep 14 13:10:33 2025 : Connection terminated.
  Sun Sep 14 13:10:33 2025 : PPPoE disconnecting...
  Sun Sep 14 13:10:33 2025 : PPPoE disconnected
  Sun Sep 14 13:11:39 2025 : publish_entry SCDSet() failed: Success!
  Sun Sep 14 13:11:39 2025 : publish_entry SCDSet() failed: Success!  
  ```

* But it can create PPPoE connection successfully on the same MacBook Pro with macOS Big Sur a few months ago
* H3C Router can also create PPPoE connection successfully

## Root Cause
Maybe there's some problem with PPPoE service on macOS Sequoia 15

## Solution
Use a Windows PC instead.

## References
* [使用 PPPoE 将 Mac 接入互联网](https://support.apple.com/zh-cn/guide/mac-help/mchlp27142/mac)
* [在 macOS Sequoia 15.2 中，Mac 上 PPPoE 拨号无法成功](https://discussionschinese.apple.com/thread/255893345)
* [mac os 下 pppoe 拨号有什么需要特殊设置的地方吗？ - V2EX](https://www.v2ex.com/t/1095994)

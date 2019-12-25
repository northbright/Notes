# Search H3C Switch Port by Client MAC Address

## Problem
* Get IP and MAC address of client
* Want to know which port of H3C switch is connected to the client 

## Solution
* Use `display mac-address | in`
* Example

      // go to system view
      sys

      // MAC: 00:a1:b2:c3:d4:f5
      display mac-address | in d4f5

      // Output
      // 00:a1:b2:c3:d4:f5 xx LEARNED GigabitEthernet1/0/1

## References
* [如何通过MAC地址查端口（H3C篇、cisco篇）](https://jingyan.baidu.com/article/a17d5285ea5ae98098c8f204.html)

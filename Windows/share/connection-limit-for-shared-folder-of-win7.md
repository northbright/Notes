# Connection Limit for Shared Folder of Windows 7 / 10

## Problem
* Can not access shared folder on Windows 7 due to max connection number is reached

## Root Cause
* Windows 7 / 10 has a hardcoded limit to concurrent connections to the computer, which is 20

## Solution A
* Use Windows Server instead

## Solution B

Clear the connections when you can NOT access the share folder

* Create a BAT file:

      net session /delete /y

* Add it to a scheduled task(e.g. every 2 hours)

## References
* [What is the maximum number of users to access the shared folder?](https://community.spiceworks.com/topic/2208934-what-is-the-maximum-number-of-users-to-access-the-shared-folder)
* [已达到计算机的连接数最大值，无法再同此远程计算机连接 XP或WIN7](http://www.cnblogs.com/wybshyy/p/5847981.html)

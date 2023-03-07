# Set DNS to`4.2.2.2` When It Failed to Activate Windows 11

## Problem
* Clean Install Windows 11 Home(Chinese) on Dell Precision T3460 Workstation
* Get `0xC004C003` Error when Activate Windows
* Location: Shanghai, China
* DNS Server: `223.5.5.5`(Aliyun Public DNS)

## Root Cause
DNS Server Does NOT Resolve the IP of Microsoft Server(s) Provide Activation Service

## Solution
Set DNS to `4.2.2.2` to Activate Windows 11 and Set it Back after Windows is Activated.

## References
* [新买的笔记本microsoft账户无法登陆怎么办？](https://www.zhihu.com/question/428164904)
* [Who does the nameserver 4.2.2.2 belong to?](https://serverfault.com/questions/88115/who-does-the-nameserver-4-2-2-2-belong-to)
* [Why do we ping the IP 4.2.2.2 to test connectivity?](https://serverfault.com/questions/132805/why-do-we-ping-the-ip-4-2-2-2-to-test-connectivity)

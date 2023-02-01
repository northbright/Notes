# Xiaomi TV Can NOT Connect to Samba Share

## Problem
* Setup Samba share on Ubuntu
* PC clients can connect the Samba share
* Xiaomi TV can NOT connect

## Root Cause
* Xiaomi TV only support SMB v1

## Solution

Add SMB v1 protocol support for Samba service

* Edit `/etc/samba/smb.conf`
* Add `server min protocol = NT1` under `[global]` section(optional)

## References
* [小米电视无法访问samba共享文件](https://zhuanlan.zhihu.com/p/590959284)

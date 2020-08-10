# Fail to Get Resources of `raw.githubusercontent.com`

## Problem
* Can not get resources(most are images) of `raw.githubusercontent.com` from China

## Root Cause
* DNS resolve problem caused by GFW

## Solution
* Get the IP of `raw.githubusercontent.com`
  * visit <ipaddress.com> and input `raw.githubusercontent.com`
  * Record the IP

* Update `/etc/hosts`
  * Mac
    * Open a shell
    * Make a copy of `/etc/hosts` and add DNS record
      * `cp /etc/hosts ~/`
      * `vi ~/hosts`

        ```
        # 199.232.68.133 is the IP from ipaddress.com
        # Make sure to update the IP if it's out of date.
        199.232.68.133  raw.githubusercontent.com
        ```

    * Open Finder
    * Press `Command + Shift + G` and input `/etc`
    * Copy `~/hosts` to `/etc/hosts`(override)
    * Flush DNS cache
      * `sudo killall -HUP mDNSResponder`

  * Windows
    * Add the record to `C:/windows/system32/drivers/etc/hosts`
    * Run `ipconfig /flushdns` to clear the DNS cache

## References
* [解决GitHub网页githubusercontent地址无法访问问题](https://zhuanlan.zhihu.com/p/107691233)

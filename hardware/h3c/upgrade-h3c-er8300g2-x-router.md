# Upgrade H3C ER8300G2-X Router

## Problem
* Need to upgrade H3C ER8300G2-X router

## Steps
#### Download Firmware
1. Register an [H3C](https://www.h3c.com/cn/) account and login
2. Register the device by SN
  * Get the SN from web portal
    * Login the web portal of router(default: `192.168.1.1`)
    * Go to Navigation > Basic Info > SN
  * Register the device on [H3C](https://www.h3c.com/cn/)
    * Click right-top "新华三" to visit [Personal Center](https://www.h3c.com/cn/Aspx/personalcenter/default.aspx)
    * My Products > Register Product > Input SN
3. Go to [小贝优选](https://www.h3c.com/cn/Service/Document_Software/Software_Download/SMB/)
  * Go to "Mini" > "ER系列路由器" > [H3C ER3100G2 ER3200G2 ER3260G2 ER5100G2 ER5200G2 ER6300G2 ER8300G2 ER8300G2-X 路由器](https://www.h3c.com/cn/Service/Document_Software/Software_Download/SMB/Catalog/Mini/ER/G2_WAN/?CHID=192563&v=612)
4. Download latest software(e.g. R1128)
5. Extract the `.bin` from the `.zip`

#### Upgrade via Web
* Login the web portal
* Go to Device Management > Software Upgrade Tab > Local Upgrade > Select the `.bin` file 

## References
* [H3C ER8300G2-X 路由器怎么升级软件版本](https://zhiliao.h3c.com/questions/dispcont/287185)

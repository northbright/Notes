# Native Mail App on iOS or Android Does Not Work since May 2023 Due to Office 365 Operated by 21vianet Disable Exchange Basic Auth

## Problem
* Purchase Office 365 in China(by [21Vianet](https://login.partner.microsoftonline.cn/))
* Native Mail App(iOS or Android) Require to Re-Input Password
* Got "Can Not Validate User Account" Error After Input the Correct Password

## Root Cause
* Microsoft Starts to Enable Modern Auth and Disable Basic Auth for Exchange for China Users Since May 2023
* Native Mail App on iOS Support Exchange Modern Auth Since iOS 12, But Office 365 Operated by 21Vianet（世纪互联）is Excluded
* Native Mail App on Android Does NOT Support Exchange Modern Auth

## References
* [将 Apple 设备与 Microsoft Exchange 集成](https://support.apple.com/zh-cn/guide/deployment/dep158966b23/web)
* [Exchange Online服务即将停用基本身份验证](https://mp.weixin.qq.com/s?__biz=MzU0MzUxMzU2NA==&mid=2247485843&idx=1&sn=b415bc47e41ab63d53bf184c7ad3291b&chksm=fb0b0720cc7c8e368b3dd108610fa16b5635d47bd448e73736c086304c7316ad5ce7588a2856&scene=178&cur_album_id=2512101116806004739#rd)

# URL is Blocked by Wechat Builtin Browser

## Problem
* We put a URL of ERP system in the menu of our company's Wechat offical account to make our employees easy to visit the ERP system in Wechat(builtin browser)
* It reported that this URL is blocked by "Tecent URL Sec"
* Click the "Request to unblock" in Wechat browser will provide 2 methods
  1. You're the web administrator

     It'll ask you to put a txt file which contains random numbers to the web root and tencent will validate the file then ask you to provide information include ID card No, ICP No, mobile phone number...
  2. You're not the web adiministrator

     It'll ask you to provide information(the same as method 1).
* Both method 1 and 2 have a button to send a validation code to the phone number you provided, but we can NOT receive the validation code so we are blocked at this stage

## Solution
* Goto [Tencent URL Sec（腾讯安全-网址安全中心）](https://urlsec.qq.com/complain.html)
* Select "URL Unblock Request（网站拦截申诉）" > input URL > check if it's blocked
* Goto [Tencent Cloud（腾讯云）> Console（控制台）> 品牌经营管家 > 违规申诉](https://console.cloud.tencent.com/bma/complaint)
* Create new ticket of request to unblock the URL
* You may also dial the service number(`400 910 0100`)( of Tencent Cloud to complain

## References
* [域名被恶意举报，微信端拦截，腾讯安全网址拦截，能不能告知什么问题呢？服务器IP都被拦截了](https://developers.weixin.qq.com/community/develop/doc/00004c693e0510d0288b2e53156000?highLine=%25E6%258B%25A6%25E6%2588%25AA)
* [域名被微信拦截了，怎么办？](https://developers.weixin.qq.com/community/develop/doc/000080af6f8168fd28db2845851400?highLine=%25E6%258B%25A6%25E6%2588%25AA)

-------------

# 网站被微信自带浏览器拦截

## 问题
* 在公司的微信公众号的菜单放置了外链 URL 可以访问公司的 ERP 管理系统（便于员工在微信公众号可以进入 ERP）
* 突然有员工反应不能在微信访问 ERP:
  > 已停止访问该网页
  > 据用户投诉及腾讯安全网址安全中心检测，该网页包含不安全内容。
  > 为维护绿色上网环境，已停止访问。
* 在微信浏览器的下方，点击“申请恢复访问”，提供了2种方法
  1. “我是站长”
     需要在 Web 根目录下放置一个 txt 文件，内容是要求的随机数字
     在腾讯验证完该 txt 文件后，需要提供详细信息：身份证，ICP 号，手机号码......
  2. ”非站长申诉”
     同样需要提供详细信息（和方法1后续的内容一样）
* 不管是方法1/2，都有个按钮，发送短信验证码到你提供的手机。但是我们始终不能接收到短信验证码，所以卡在这一步

## 解决方法
* 访问 [Tencent URL Sec（腾讯安全-网址安全中心）](https://urlsec.qq.com/complain.html)
* 选择 "网站拦截申诉" > 输入网址 > 确认是否被拦截
* 访问 [Tencent Cloud（腾讯云）> Console（控制台）> 品牌经营管家 > 违规申诉](https://console.cloud.tencent.com/bma/complaint)
* 创建一个新的申诉
* 也可以拨打腾讯云的客服电话(`400 910 0100`)

## 参考链接
* [域名被恶意举报，微信端拦截，腾讯安全网址拦截，能不能告知什么问题呢？服务器IP都被拦截了](https://developers.weixin.qq.com/community/develop/doc/00004c693e0510d0288b2e53156000?highLine=%25E6%258B%25A6%25E6%2588%25AA)
* [域名被微信拦截了，怎么办？](https://developers.weixin.qq.com/community/develop/doc/000080af6f8168fd28db2845851400?highLine=%25E6%258B%25A6%25E6%2588%25AA)

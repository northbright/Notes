# 需要注册微信开放平台账号才能获取 UnionID

## 问题
* 小程序只能获取 OpenID 不能获取 UnionID

## 原因
* 需要注册[微信开放平台](https://open.weixin.qq.com)的账号（注意：不是[微信公众平台](https://mp.weixin.qq.com/)）

## 解决方法
* 注册[微信开放平台](https://open.weixin.qq.com)的账号
  * 使用一个没有在[微信公众平台](https://mp.weixin.qq.com/)注册过的邮件地址
* 完成微信认证
  * 企业营业执照副本的复印件，盖章，再扫描
  * 银行开户账户，用于小额支付
  * 300元微信认证费
* 认证完成后，在“管理中心” > “公众账号” / “小程序” 绑定公众号和小程序
  * 公众号 / 小程序的管理员的账号（邮件地址），密码
  * 使用管理员的个人微信扫描二维码
* 开放平台账号绑定的公众号和小程序，共享1个 UnionID


## 参考资料
* [微信开放平台和公众平台的区别？](https://www.zhihu.com/question/21074751/answer/1419900591)
* [小程序登录、用户信息相关接口调整说明](https://developers.weixin.qq.com/community/develop/doc/000cacfa20ce88df04cb468bc52801)
* [微信小程序获取openID及unionID](https://developers.weixin.qq.com/community/develop/article/doc/00082a04b94c00a9f3eb879ba5ac13)
* [从getUserInfo接口更换为getUserProfile接口后服务端怎么获取unionid](https://developers.weixin.qq.com/community/develop/doc/000ae602670bb0b1dafb576f95ac00?highLine=unionID)
* [绑定公众号/小程序与open帐号主体是否必须一致？](https://kf.qq.com/faq/170824UFrQjE170824m26NRB.html)

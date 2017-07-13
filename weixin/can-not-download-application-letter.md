# 微信认证不能下载申请公函的解决方法

#### 问题
* 在微信认证页面，申请公函->点击"下载公函"没有任何反应
* 浏览器使用Firefox

#### 原因
* 公函会弹出一个新页面
* Firefox默认拦截弹出式窗口

#### 解决方法
* 在地址栏最右面，点击阻止的小图标，放行:

    `https://mp.weixin.qq.com/acct/wxverify?action=letter_page&token=xx`

* 或者把`https://mp.weixin.qq.com`添加到Firefox的拦截弹出式窗口的例外中

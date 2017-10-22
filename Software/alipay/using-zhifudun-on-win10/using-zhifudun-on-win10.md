# Using Zhifudun(by iTrusChina) on Win10

#### Problem
* IE11 on Win10 failed to use Zhifudun(report "current environment does not support alipay control"）

  ![](img/01.jpg)

#### Solution
1. Download and install [latest driver of Zhifudun](http://www.itrus.com.cn/alipay/download.html).
2. Use IE 11 to open alipay.com.
3. Press `F12` to open developer tools.
   * Set `Document Mode` to `10`.
   * Set `User Agent String` to `Internet Explorer 10`

     ![](img/02.jpg)

   * Press `F5` to refresh page
4. Zhifudun will work now.

   ![](img/03.jpg)   

---------------

# 在Win10上使用支付盾（天威诚信）

#### 问题
* Win10上IE11使用支付盾会失败（"当前操作环境不支持支付宝控件"）。 

  ![](img/01.jpg)

#### 解决方案
1. 从天威诚信官网下载安装[最新版本的支付盾驱动](http://www.itrus.com.cn/alipay/download.html)。
2. 使用IE 11打开支付宝网站。
3. 按下`F12`打开开发者工具。
   * `文档模式`设置为`10`
   * `用户代理字符串`设置为`Internet Explorer 10`

      ![](img/02.jpg)

   * 按`F5`刷新页面
4. 支付盾现在应该可以正常工作了

   ![](img/03.jpg)

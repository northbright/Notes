# 使用“快速开店”方式开通的微信小商店，依然可以调用API

## 问题
* 微信小商店可以有2种开通方法
  * 使用“快速开店“方式
  * 注册微信小程序，使用“标准版交易组件及开放接口”
* 已经使用“快速开店”开通微信小商店
* 开发文档中，接口部分都在“标准版交易组件及开放接口”下
* 大多数API需要`access_token`
* 对于“快速开店”方式开通的小商店，依然希望能调用开放平台的API

## 实现方法
* 首先获取`access_token`
  * 在微信小商店的“店铺管理” > “基础信息” > “账号信息”
  * 获取 AppID（小程序ID），AppSecret（小程序密钥）
  * 通过[小程序的文档:auth.getAccessToken](https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/access-token/auth.getAccessToken.html)

    ```
    GET https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET

    // Response
    {"access_token":"XXXX","expires_in":7200}
    ```
* 使用获取的`access_token`，调用开放接口（例如：[获取商品列表](https://developers.weixin.qq.com/doc/ministore/minishopopencomponent/API/spu/get_spu_list.html)）

  ```

  curl -X POST "https://api.weixin.qq.com/product/spu/get_list?access_token=XXXX" --data '{"status":11,"page":1,"page_size":10}'

  ```

## 参考资料
* [小商店获取订单列表的 access_token 怎么获取?](https://developers.weixin.qq.com/community/develop/doc/000e40ad5206a84fba7b9902751400?_at=1611730857061)
* [auth.getAccessToken](https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/access-token/auth.getAccessToken.html)
* [获取商品列表](https://developers.weixin.qq.com/doc/ministore/minishopopencomponent/API/spu/get_spu_list.html)

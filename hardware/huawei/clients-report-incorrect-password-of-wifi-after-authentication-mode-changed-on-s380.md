# Clients Report Incorrect Password of WiFi after Authentication Mode Changed on S380

## Problem
* Huawei S380 with ver: V600R024C10SPC100
* Created a wireless service
* Changed authentication mode of the wireless service
  * Change authentication mode from PSK to PSK-SAE
  * Change encryption mode from WPA2 to WPA2-WPA3
  * Keep the key NOT changed
  * Go next and finish
* Clients reports incorrect WiFi password and WiFi connections are broken
  * Xiaomi TV shows the WiFi state is changed from "connected" to "saved"
  * iPhone WiFi connection are broken and prompt "incorrect password" when re-join the SSID

## Solution
Re-set key when change authentication mode, encryption mode.

---------------------------

华为 S380 修改认证方式后，客户端报告 WiFi 密码错

## 问题
* 华为 S380, 版本: V600R024C10SPC100
* 创建了 1 个无线业务
* 修改了无线业务的认证方式
  * 将认证方式从 PSK 修改为 PSK-SAE
  * 将加密方式从 WPA2 修改为 WPA2-WPA3
  * 保持 key 不变
  * 下一步 > 完成
* 客户端报告 WiFi 密码错误
  * 小米电视显示 WiFi 状态从“已连接”变为“已保存”, 新版小米电视即使 WiFi 密码错误也不会提示错误，而是会显示“已保存”
  * iPhone WiFi 连接断开，重新连接提示密码错误

## 解决方法
* 在修改认证方式，加密方式的时候，同时重新设置密钥(key)

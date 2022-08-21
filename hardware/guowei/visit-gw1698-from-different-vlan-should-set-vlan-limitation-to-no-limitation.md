# Visit GW1698 from Different VLAN Should Set Vlan Limitation to No Limitation

## Problem
* IP of GW1698 is `10.0.6.x`(VLAN 6)
* It failed to visit GW1698(`10.0.6.x:3038`) in browser from other VLAN(e.g. `10.0.10.x`)

## Root Cause
* Account Management > VLAN Limitation is set to "Same VLAN" by default

## Solution
* Go to Account Management > VLAN Limitation > set to "No Limitation"
* Click up-right "Save" button

-------------

# 从不同的 VLAN 访问 GW1698 需要设置网段限定为不限

## 问题
* GW1698 的 IP 为 `10.0.6.x`(VLAN 6)
* 从其他 VLAN (e.g. `10.0.10.x`) 在浏览器中访问 GW1698(`10.0.6.x:3038`) 失败

## 原因
* 账号管理 > 网段限定 > 默认设置为相同网段(VLAN)

## 解决方法
* 账号管理 > 网段限定 > 设置为"不限"
* 点击右上角的“保存”按钮

# S380 Web Management Can be Accessed from Vlanif1 Only

## Problem
* S380 web management(`https://192.168.112.1`) can be accessed from Vlanif1 only(e.g. computer's IP: `192.168.112.x`)
* S380 version: V600R023C00SPC200

## Root Cause
Web management can be accessed from Vlanif1 only by default if S380 runs old software. See [Web网管登录](https://support.huawei.com/enterprise/zh/doc/EDOC1100300382/459acbb0)

## Solution
* Upgrade to latest software version(e.g. V600R024C10SPC100 for 2025/05)
* Web management can be accessed from other Vlanif(e.g. Vlanif10) by default now

## References
* [S380 V600R022C10 配置指南-Web网管登录](https://support.huawei.com/enterprise/zh/doc/EDOC1100300382/459acbb0)
* [S380 V600R024C10 配置指南（Web网管）](https://support.huawei.com/enterprise/zh/doc/EDOC1100460452)
* [Manage Huawei S380](https://github.com/northbright/Notes/blob/master/hardware/huawei/manage-huawei-s380.md)

---------------

# 华为 S380 只能从 Vlanif1 访问 Web 网管

## 问题
* S380 的 Web 网管（`https://192.168.112.1`）只能从 Vlanif1 访问（计算机的 IP: `192.168.112.x`）
* S380 的版本: V600R023C00SPC200

## 原因
* 老版本的 S380 只能从 Vlanif 1 访问 Web 网管。查看[Web网管登录](https://support.huawei.com/enterprise/zh/doc/EDOC1100300382/459acbb0)

## 解决方法
* 升级到最新软件版本(e.g. V600R024C10SPC100 for 2025/05)
* 默认可以从其他 Vlanif 访问 Web 网管(e.g. Vlanif10)

## 参考资料
* [S380 V600R022C10 配置指南-Web网管登录](https://support.huawei.com/enterprise/zh/doc/EDOC1100300382/459acbb0)
* [S380 V600R024C10 配置指南（Web网管）](https://support.huawei.com/enterprise/zh/doc/EDOC1100460452)
* [Manage Huawei S380](https://github.com/northbright/Notes/blob/master/hardware/huawei/manage-huawei-s380.md)

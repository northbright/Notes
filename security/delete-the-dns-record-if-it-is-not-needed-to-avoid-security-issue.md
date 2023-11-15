# Delete the DNS Record if It is Not Needed to Avoid Security Issue

## Problem
* Purchased an Aliyun ECS and a Public IP Address to Run Some Services
* Created a `A` Record to Point `x.my-site.com` to the IP
* Users Could Visit `x.my-site.com` and Use the Services
* The Services were NOT Needed Any More After Some Days
* The ECS and IP Addres were Released
* Cyberspace Office Reported a Security Issue(Swagger API Related)

## Root Cause
* The IP was Recycled and Re-Used by Other User
* The `A` Record was Still Working and `x.my-site.com` Points to this IP Owned by Other User

## Solution
* Delete the `A` Record Since It's NOT Needed Any More

---------------------
# 删除不再使用的 DNS A 记录来避免安全问题

## 问题
* 购买了 1 台阿里云 ECS 和 1 个公网 IP 来运行一些服务
* 创建了 1 条 `A` 记录，将 `x.my-site.com` 指向这个 IP
* 用户能通过访问 `x.my-site.com` 来使用这些服务
* 这些服务在使用一些日子后不再需要
* 阿里云的 ECS 和 IP 被释放（到期）
* 网信办通告 1 个安全问题（Swagger API 暴露）

## 原因
* IP 被回收，然后被其他用户重新使用
* `A` 记录还在继续工作，`x.my-site.com` 指向其他用户在使用的 IP

## 解决方法
* 删除不再使用的 `A` 记录

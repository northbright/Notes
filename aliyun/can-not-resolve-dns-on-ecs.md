# Can not Resolve DNS on ECS

## Background
* Purchased one ECS on Aliyun
* Bind ECS instance to a Security Group(安全组)
* Security Group type is enterprise(企业安全组)
* Add rules:
  inbound: TCP port 80, 443
  outbound: TCP port 80, 443

## Problem
* Got `failed to resolve DNS` error when run `sudo yum update`

## Root Cause
* DNS service uses UDP port 53
* Default outbound rules of enterprise security group（企业安全组）: deny ALL

## Solution
* Add a new outbound rule to permit: UDP/53

----------------

# 阿里云ECS不能解析DNS

## 背景
* 购买了一台ECS
* 绑定ECS实例到一个安全组的实例（企业安全组）
* 添加规则
  * 入站: TCP/80, TCP/443
  * 出站: TCP/80, TCP/443

## 问题
* 当运行`sudo yum update`时，不能解析DNS

## 原因
* DNS服务需要使用UDP/53
* 默认的企业安全组的出站规则：拒绝所有

## 解决方案
* 添加出站规则：UDP/53


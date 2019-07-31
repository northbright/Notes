# Usernames Conflict in Ming Cause Login Failure

## Problem
* One user reported it failed to login due to username and password didn't match suddenly
* The user did not change the password
* It didn't work after reset the user's password using admin account

## Root Cause
* Other admin account added a new user which username is the **SAME** as previous user
* Ming system permit users have the same name
* The 2 users which have the same username will have problem when login

## Solution
* Change username to another unique name

------

# 用户名冲突导致用户登录明日系统失败

## 问题
* 一个用户报告登录失败。提示用户名和密码不匹配
* 该用户没有修改密码
* 使用管理员账号登录重置改用户密码后，依旧登录失败

## 原因
* 另一个管理员账号添加了一个和之前已有用户名一样的用户
* 明日系统允许用户名重复
* 重名的用户名会导致用户登录失败

## 解决方案
* 更改冲突的用户名，使用另一个特别的用户名

# Handle 20000 Incoming GET Requests with 499 Error in 10 Minutes When Use Nginx as Reverse Proxy

## Problem
* There's a CMS(HTTP service) written in .net
* Use Nginx as the reverse proxy to pass HTTP request to the .net application
* It continued to have NO response when visit the service about 10 minutes
* After 10 minutes it' OK again

## Root Cause
* Open Nginx Access Log(e.g. `/var/log/nginx/access.log`) and find 20000 GET requests to the same URL in 10 minutes
* The codes of all the responses are `HTTP 499 error`:

  > 499Client Closed Request (Nginx)
  > Used in Nginx logs to indicate when the connection has been closed by client while the server is still processing itsrequest, making server unable to send a status code back
* The HTTP service(APIs need to run SQL on Database) can NOT handle so many requests in such a short time
* Got database connection timeout exception and .net application's CPU usage is very high(about 187%) for the 10 minutes
* It maybe an attack or run a loop to do the HTTP requests from client side
* According to the URL with unique ID(e.g. class ID), we can determine the user name
* When we go the seat of the user, we can see there're a lot of things on her keyboard and maybe `F5` is keeping pressed for about 10 minutes

## Solution
* [Rate Limiting with NGINX and NGINX Plus](https://www.nginx.com/blog/rate-limiting-nginx/)

------------------

# 使用 Nginx 做反向代理时，在 10 分钟内处理了 20000 个 GET 请求，返回代码为 499 错误

## 问题
* 有 1 个使用 .net 实现的 CMS 系统（HTTP 服务）
* 使用 Nginx 做反向代理，转发 HTTP Request 到 .net 应用
* 系统突然开始没有响应，持续 10 分钟
* 10 分钟后，系统重新正常

## 原因
* 检查 Nginx 的访问日志（e.g `/var/log/nginx/access.log`）发现在 10 分钟内有 20000 个相同 URL 的 GET 请求
* 所有的响应代码为 `HTTP 499 error`:
  > 499Client Closed Request (Nginx)
  > Used in Nginx logs to indicate when the connection has been closed by client while the server is still processing itsrequest, making server unable to send a status code back
* HTTP 服务（API 需要在数据库上运行 SQL）不能在短时间内处理这么多的请求
* 发现数据库的连接超时异常，.net 应用的 CPU 占用率在 10 分钟内持续非常高（187%)
* 可能是攻击，或者从客户端在循环中发起 HTTP Request
* 根据 URL 中的特殊 ID（e.g. 班级 ID），确定了用户
* 当我们到达了用户的座位时，发现她的键盘上压着很多重物。可能 `F5` 被持续按压了 10 分钟
 
## 解决方法
* [Rate Limiting with NGINX and NGINX Plus](https://www.nginx.com/blog/rate-limiting-nginx/)

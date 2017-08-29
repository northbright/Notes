# Use JWT for Single Sign On

## Problem
* We have many apps(services) hosted on mydomain.com, sub1.mydomain.com, sub2.mydomain.com...
* Need SSO(Single Sign On)

## Solution
* Use JWT(JSON Web Token)
* Set JWT in Cookie
* Configure cookie
  * Set `HttpOnly;` to make sure that JWT can not be read by Javascript.
  * Set domain to `.mydomain.com`
    * All services can read JWT in cookies(both "mydomain.com" and "*.mydomain.com")

## References
* [八幅漫画理解使用JSON Web Token设计单点登录系统](http://blog.leapoahead.com/2015/09/07/user-authentication-with-jwt/)

# Access Control List Rules Use Wildcard but Not Subnet Mask

## Problem
* Huawei S380 S2P8T
* Created an access control policy rule for guest download rate limiting
* Source IP / wildcard mask: `0.0.0.0` / `0.0.0.0`
* Destination IP / wildcard mask: `10.0.30.0` / `255.255.255.0`
* Rate limiting does not work

## Root Cause
Wildcard masks are incorrect(it was set as subnet mask).

> The wildcard mask is an inverted mask where the matching IP address or range is based on 0 bits.
> The additional bits are set to 1 as no match required.
> The wildcard 0.0.0.0 is used to match a single IP address.
> The wildcard 255.255.255.255 is used to match any IP address.

## Solution
* Source IP / wildcard mask: `0.0.0.0` / `255.255.255.255`(matching any IP address)
* Destination IP / wildcard mask: `10.0.30.0` / `0.0.0.255`(matching `10.0.0.x`)

## References
* [ACL管理与配置（ACL规则编号、通配符、ACL的分类）](https://blog.csdn.net/weixin_55807049/article/details/122743629)
* [Cisco Access Control Lists (ACL)](https://community.cisco.com/t5/networking-knowledge-base/cisco-access-control-lists-acl/ta-p/4182349)

# Set SRV Record on Aliyun(阿里云)

#### Microsoft Office 365 SRV Record DNS Settings Requirements

| Type | Service | Protocol | Port | Weight | Priority | TTL | Name | Address |
| :--- | :------ | :------- | :--- | :----- | :------- | :-- | :--- | :---- |
| SRV | _sip | _tls | 443 | 1 | 100 | 1 Hour | @ | sipdir.online.lync.com |
| SRV | _sipfederationtls | _tcp | 5061 | 1 | 100 | 1 Hour | @ | sipfed.online.lync.com |

#### Add an Aliyun SRV Record
* Record Type - SRV
* Name - Service Name.Service Protocol(Ex: `_sip._tls`)
* Value

        // Priority Weight Port Address(split by white space)
        Ex: 100 1 443 sipdir.online.lync.com

#### References
* [域名解析 SRV 记录设置方法](https://help.aliyun.com/knowledge_detail/39810.html)






# Use `tcpdump` to Monitor HTTP Request and Response Headers on CentOS

#### Install `tcpdump` on CentOS

    sudo yum install -y tcpdump

#### Mointor HTTP Request and Response Headers

    sudo tcpdump -A -s 0 'tcp port 80 and (((ip[2:2] - ((ip[0]&0xf)<<2)) - ((tcp[12]&0xf0)>>2)) != 0)'

#### References
* [使用tcpdump查看HTTP请求响应](http://www.jianshu.com/p/3cca9a74927c) 

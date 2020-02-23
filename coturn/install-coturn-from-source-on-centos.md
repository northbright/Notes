# Install [Coturn](https://github.com/coturn/coturn) from Source on CentOS 7

## Install Dependencies
* [OpenSSL](https://www.openssl.org/)
  * [Install Latest Release of OpenSSL from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos.md)
* [libevent](http://libevent.org/)
  * [Install libevent from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/libevent/install-libevent-from-source-on-centos.md) 

## Download Source from [github](https://github.com/coturn/coturn/releases)
```
cd download
wget https://github.com/coturn/coturn/archive/4.5.1.1.tar.gz
tar -xzvf 4.5.1.1.tar.gz
cd coturn-4.5.1.1/
```

## Configure

```
// Specify the OpenSSL, libevent include / lib path

CFLAGS="-I/usr/local/openssl/include/ -I/usr/local/libevent/include/" \
LDFLAGS="-L/usr/local/openssl/lib/ -L/usr/local/libevent/lib/" \
./configure --prefix=/usr/local/coturn
```

## Make and Install
```
make
sudo make install
```

## Add Binary Path
```
sudo vi /etc/profile

# Add these lines
# Coturn
export PATH=/usr/local/coturn/bin/:$PATH
```

```
source /etc/profile
```

## Add Binary Path for `sudo`
```
su
visudo

# find "secure_path", insert "/usr/local/coturn/bin"
Defaults    secure_path = /usr/local/coturn/bin:/sbin:/bin:/usr/sbin:/usr/bin
```

## Generate Self-Signed Cert
```
sudo openssl req -x509 -newkey rsa:2048 -keyout /usr/local/coturn/etc/turn_server_pkey.pem -out /usr/local/coturn/etc/turn_server_cert.pem -days 999999 -nodes
```

## Configuration File
```
// Copy default config file
 sudo cp /usr/local/coturn/etc/turnserver.conf.default /usr/local/coturn/etc/turnserver.conf
```

```
// Modify "turnserver.conf"
sudo vi /usr/local/coturn/etc/turnserver.conf

// Set "listening-ip" and "relay-ip" to local IP
listening-ip=<LOCAL IP>
relay-ip=<LOCAL IP>

// Set "external-ip" to public IP
external-ip=<PUBLIC-IP>

// UDP relay ports
min-port=49152
max-port=65535

// For WebTRC: use long-term credential mechanism
lt-cred-mech

// Set TLS key and cert created previously
cert=/usr/local/coturn/etc/turn_server_cert.pem
pkey=/usr/local/coturn/etc/turn_server_pkey.pem

// Set PID file
pidfile="/var/run/turnserver.pid"

// Set Log file
log-file=/var/tmp/turn.log

// Create user and set password
user=<USER>:<PASSWORD>

// Set realm to your domain of the server
realm=turn.mysite.com

// Set CLI password or you'll get error when run turn server
cli-password=<YOUR PASSWORD>
```

## Configure `firewalld`
```
// Check
systemctl is-enabled firewalld

// Enable if disable
sudo systemctl enable firewalld

// Start and Get Status
sudo systemctl start firewalld
sudo systemctl status firewalld
```

```
sudo firewall-cmd --permanent --zone=public --add-port=3478/tcp
sudo firewall-cmd --permanent --zone=public --add-port=3478/udp

sudo firewall-cmd --permanent --zone=public --add-port=5349/tcp
sudo firewall-cmd --permanent --zone=public --add-port=5349/udp

sudo firewall-cmd --permanent --zone=public --add-port=49152-65535/udp

sudo firewall-cmd --reload
sudo firewall-cmd --list-all
```

## Add Security Group Rules(安全组规则) for Aliyun ECS(optional)
`firewalld` is disabled by default on Aliyun ECS and it use Security Group Rules.

* inbound（入方向）
  * `22/tcp`(SSH) 
  * `443/tcp`(HTTPS)
  * `3478/tcp`, `3478/udp`(TURN)
  * `5349/tcp`, `5349/udp`(TLS/DLS TURN)
  * `49152-65535/udp`(UDP relay ports)
* outbound（出方向） 
  * `22/tcp`(SSH)
  * `53/udp`（DNS resolve）
  * `80/tcp`(HTTP)
  * `443/tcp` (HTTPS)

## Run Coturn
```
sudo /usr/local/coturn/bin/turnserver -c /usr/local/coturn/etc/turnserver.conf
```

## Test
* Goto <https://webrtc.github.io/samples/src/content/peerconnection/trickle-ice/>
* Remove all servers in "ICE servers"
* Add a new ICE server
  * URI: `turn:turn.mysite.com:3478` or `turn:turn.mysite.com:5349`(for TLS)
    * `turn.mysite.com` is the your server domain which is `realm` in the `turnserver.conf`.
  * Set user and password which specified in the `turnserver.conf`
  * Click "Add"
* Click "Gather candidates"
* If you see your public IP of the turn server in "protocol address" and "Done", it works.

## Run Coturn as Systemd Service
```
sudo vi /etc/systemd/system/coturn.service
```
```
// Copy these lines
[Unit]
Description=coturn service

[Service]
Type=simple
ExecStart=/usr/local/coturn/bin/turnserver -c /usr/local/coturn/etc/turnserver.conf

[Install]
WantedBy=multi-user.target
```
```
sudo systemctl enable coturn
sudo systemctl start coturn
systemctl status coturn
```

## References
* [webrtc笔记(1): 基于coturn项目的stun/turn服务器搭建](https://www.cnblogs.com/yjmyzz/p/how-to-install-coturn-on-ubuntu.html)
* [Turnserver服务器搭建](https://yq.aliyun.com/articles/670085)
* [webRTC中的coturn服务安装及常见问题](https://blog.csdn.net/qq_35432904/article/details/103808345)
* [coturn(turn)服务器搭建注意事项](https://www.jianshu.com/p/9f98042ac0f6)
* [Trickle ICE cannot work on chrome 77 under window 10 #1227](https://github.com/webrtc/samples/issues/1227)
* [trickle-ice]
  * <https://webrtc.github.io/samples/src/content/peerconnection/trickle-ice/>
* [NAT, STUN, TURN, and ICE](https://www.thirdlane.com/blog/nat-stun-turn-and-ice)
* [How to Build and Configure STUN and TURN Server](https://www.thirdlane.com/blog/how-to-build-and-configure-stun-and-turn-server)
* [How to Install & Configure TURN Server (coTURN)](https://fatiherikci.com/en/how-to-install-turn-coturn/)
* [webrtc学习: 部署stun和turn服务器](https://www.cnblogs.com/lingdhox/p/4209659.html)
* [Coturn: TURN and STUN Server](https://zhuanlan.zhihu.com/p/32093871)
* [CoturnConfig](https://github.com/coturn/coturn/wiki/CoturnConfig)
* [coturn穿透服务器搭建(阿里云)](https://www.jianshu.com/p/915eab39476d)


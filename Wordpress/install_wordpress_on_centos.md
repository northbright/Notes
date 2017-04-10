# Install WordPress On Centos

## Part I - WordPress的安装

1. 如果使用putty远程登录，将Window -> Translation -> Remote character set设置成utf-8

2. 设置eth0的onboot为yes

    * vi /etc/sysconfig/network-scripts/ifcfg-eth0
    
            ONBOOT=yes

    * service network restart

3. 设置proxy的环境变量（optional)

    * vi /etc/environment

            http_proxy=http://xx.com:8080
            https_proxy=http://xx.com:8080
            no_proxy="localhost,127.0.0.1,.xx.net"

    * reboot

4. yum更新和安装软件

        yum update

        // CentOS 7(Install MariaDB)
        yum -y install unzip wget setuptool system-config-firewall-tui httpd mariadb mariadb-server gd gd-devel php php-mysql php-gd vsftpd

        // CentOS 6(Install MySQL)
        yum -y install unzip wget setuptool system-config-firewall-tui httpd mysql mysql-server gd gd-devel php php-mysql php-gd vsftpd

5. 下载wordpress

        mkdir download
        cd download
        wget http://wordpress.org/latest.zip
        unzip latest.zip
        mkdir /var/www/mysite1
        mkdir /var/www/mysite2
        cp wordpress -R /var/www/mysite1
        cp wordpress -R /var/www/mysite2

6. 设置mysite的dir的owner和mod

        chown -R apache:apache /var/www/mysite1
        chown -R apache:apache /var/www/mysite2
        chmod 755 -R /var/www/mysite1
        chmod 755 -R /var/www/mysite2

7. httpd设置

    * VirtualHost设置
    
            vi /etc/httpd/conf/httpd.conf

            打开此行注释
            NameVirtualHost *:80

            <VirtualHost *:80>
                ServerAdmin admin@mysite1.com
                DocumentRoot /var/www/mysite1/wordpress
                ServerName mysite1.com
                ServerAlias www.mysite1.com
                ErrorLog /var/log/httpd/mysite1_error.log

                # Fix xmlrpc.php pingback vulnerability
                <Directory /var/www/mysite1/wordpress>
                    AllowOverride None
                    Include /var/www/mysite1/wordpress/.htaccess
                </Directory>
            </VirtualHost>
            <VirtualHost *:80>
                ServerAdmin admin@mysite2.com
                DocumentRoot /var/www/mysite2/wordpress
                ServerName mysite2.com
                ServerAlias www.mysite2.com
                ErrorLog /var/log/httpd/mysite2_error.log

                # Fix xmlrpc.php pingback vulnerability
                <Directory /var/www/mysite2/wordpress>
                    AllowOverride None
                    Include /var/www/mysite2/wordpress/.htaccess
                </Directory>
            </VirtualHost>

    * Wordpress XMLRPC Pingback Vulnerability Fix

            vi /var/www/mysite1/wordpress/.htaccess

                # protect xmlrpc

                <Files xmlrpc.php>
                Order Deny,Allow
                Deny from all
                </Files>

    * httpd性能设置

            vi /etc/httpd/conf/httpd.conf

            KeepAlive On
            MaxKeepAliveRequests 50
            KeepAliveTimeout 10

            # prefork MPM
            StartServers     2
            MinSpareServers  1
            MaxSpareServers  2
            ServerLimit      100
            MaxClients       100
            MaxRequestsPerChild  500

    * 重启和设置httpd的service

            chkconfig httpd on
            service httpd start

8. MySQL设置

    * 设置mysqld的service

            chkconfig mysqld on
            service mysqld start

    * MYSQL安全设置

            mysql_secure_installation

    * 创建WordPress的数据库

            mysqld -u root -p
            create database mysite1;
            create database mysite2;

    * 绑定127.0.0.1，禁用3306对外端口
            
            sudo vi /etc/my.cnf
            [mysqld]
            ......
            bind-address = 127.0.0.1

9. vsftpd设置

    * vi /etc/vsftpd/vsftpd.conf

            禁止anonymouse登陆:
            anonymouse_enable=NO

            允许本地用户登录
            local_enable=YES(去掉注释)

            在最后一行
            local_root=/var/ftp

    * 如果使用local user登陆，确认在/etc/vsftpd/user_list中的禁止登陆用户list中没有你希望登陆的帐号，比如新添加的帐号。

            vi /etc/vsftpd/user_list

    * 将用户锁定在自己的ftp目录
    
            vi /etc/vsftpd/vsftpd.conf
            chroot_local_user=NO(去掉注释)
            chroot_enable_list=YES(去掉注释）
            chroot_list_file=/etc/vsftpd/chroot_list(去掉注释，创建此文件，每行是一个用户名，表示将其锁定在ftp的目录,把刚刚新创建的用户添加进去).

            chown -R xxu:xxu /var/ftp
            chmod 755 -R /var/ftp
            使xxu用户对var/ftp可写。

    * 配置service

            chkconfig vsftpd on
            service vsftpd start

10. firewall设置

    * CentOS 6  
        
            setup
            firewall setup
            ftp / ssh / http打上勾

    * Centos 7  
      [Configure Firewall to Enable HTTP Service on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/CentOS/network/Configure_Firewall_to_Enable_HTTP_Service_on_CentOS_7.md)

11. selinux设置

    * 如果禁用selinux

            vi /etc/sysconfig/selinux
            将SELINUX=disabled
            然后reboot,下面的步骤可以跳过

    * 如果没有禁用selinux:

        * 查看当前httpd相关的设置
        
                getsebool -a | grep httpd | less

        * 设置httpd可以访问网络

                setsebool -P httpd_can_network_connect 1

        * 查看当前ftp的设置

                getsebool -a | grep ftp

        * 设置`ftp_home_dir` on

                setsebool -P ftp_home_dir 1

12. 添加user,禁止root使用ssh

        adduser xxu
        passwd xxu
        visudo
        ## Allow root to run any commands anywhere
        root    ALL=(ALL)       ALL
        xxu     ALL=(ALL)       ALL

        vi /etc/ssh/sshd_config
        PermitRootLogin no(将注释去掉)
        service sshd restart

13. 域名还未指向真实ip前，在其他机器中测试

    * hosts文件

            xx.xx.xx.xx   mysite1.com
            xx.xx.xx.xx   mysite2.com

    * 网络设置如果有代理，那么在例外中加入mysite1.com;mysite2.com


## PART II - Wordpress的迁移
1. 在新的和老的主机的wordpress搜索安装wp-clone插件

2. 在原来的网站上wp-clone -> create backup

3. 把backup的zip文件上传到新服务器的本地,ex: /var/www/mysite1/wordpress, var/www/mysite2/wordpress

4. 确保新主机上的域名已经能够正常访问.Ex: mysite1.com, mysite2.com

5. 在浏览器中输入域名（不能是ip,否则post中的链接都是http://xx.xx.xx.xx的ip起始地址，如果1个主机有2个或以上的域名，就会出错).
进入/wp-admin -> wp-clone -> restore from -> http://mysite1.com/backup.zip

6. 进入wp-admin, 确认Settings -> General -> wordpress url和site url都指向域名(指向ip的话，如果2个域名共享1个ip就会有问题).

7. 确认appearance -> menus -> 首页 也指向域名(2个域名共享1个ip就会有问题).

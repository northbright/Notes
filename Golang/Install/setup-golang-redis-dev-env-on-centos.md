# Setup Golang / Redis Dev Env on CentOS

#### CentOS Account Setup
* Creare a new user

        adduser xx
        passwd xx

* Add user to run `sudo`

        visudo
        // find this line:
        // ## Allow root to run any commands anywhere
        root    ALL=(ALL)    ALL
        xx       ALL=(ALL)    ALL

*  Disable `root` to `ssh`

        vi /etc/ssh/sshd_config
        PermitRootLogin no  // remove comment
        
        service sshd restart
  
#### Network Setup
* Install net-tools(provide `ifconfig`)

        sudo yum -y install net-tools

* Set static IP if need(optional)

    * `sudo vi /etc/sysconfig/network-scripts/ifcfg-eXX`(XX is your network interface).

            BOOTPROTO=static
            ONBOOT="yes"
            IPADDR=192.168.1.104
            NETMASK=255.255.255.0
            GATEWAY=192.168.1.1
            DNS1=192.168.1.1

    * Restart `network.service`:  
    
            sudo service network restart

#### Setup `vim`
* [Setup Vim for Centos Minimal](https://github.com/northbright/Notes/blob/master/Linux/vim/setup_vim_for_centos_minimal.md)

#### Install Golang from Source on CentOS
* [Install Latest Go Release from Source on CentOS 7](install-latest-go-release-from-source-on-centos7.md)
* [Add vim-go Plugin for vim on CentOS 7](https://github.com/northbright/Notes/blob/master/Golang/Editor/Add_vim-go_for_vim_on_CentOS_7.md)

#### Install Redis on CentOS
* [Install and Configure Redis-2.8.19 on CentOS 7](https://github.com/northbright/Notes/blob/master/Redis/Install/Install_and_Config_Redis_on_CentOS.md)



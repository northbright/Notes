# Install Latest Release of [OpenSSL](https://www.openssl.org/) from Source on CentOS 7

## Install Dependencies
* "Development Tools"

      # Find the name of "Development Tools" Group under "Optional Group" in the output
      # Pass the group name to `yum group install`
      # The group name may be translated string(e.g. "开发工具" in Chinese)
      yum group list
      sudo yum group install -y "Development Tools"

* [zlib](https://www.zlib.net/)
   * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md) 

## Download Latest Source on [github](https://github.com/openssl/openssl/releases) or [offical site](https://www.openssl.org/source/)

    wget https://github.com/openssl/openssl/archive/OpenSSL_1_1_1b.tar.gz
    tar -xzvf OpenSSL_1_1_1b.tar.gz
    cd openssl-OpenSSL_1_1_1b
            
## Configure, Make and Install

    # configure, make & make install
    ./config --prefix=/usr/local/openssl --openssldir=/usr/local/openssl
    make
    sudo make install

## Add New Binary Path of OpenSSL
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of OpenSSL
      export PATH=/usr/local/openssl/bin:$PATH

* `source /etc/profile`

## Add New Binary Path of OpenSSL for `sudo`
```
su
visudo

# Find "secure_path", insert "/usr/local/openssl/bin"
Defaults    secure_path = /usr/local/openssl/bin:/sbin:/bin:/usr/sbin:/usr/bin
```

## Add New Shared Libraries Path of OpenSSL
      
    su
    echo '/usr/local/openssl/lib/' > /etc/ld.so.conf.d/openssl.conf
    exit
    sudo ldconfig
            
    # Check if libssl.so.x is in the output
    ldconfig -p | grep libssl.so
         
## Check OpenSSL Version
   
    openssl version -a

## References
* [How to install latest version of OpenSSL on CentOS?](https://blacksaildivision.com/how-to-install-openssl-on-centos)

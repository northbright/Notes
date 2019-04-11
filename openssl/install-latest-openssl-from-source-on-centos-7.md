# Install Latest Release of [OpenSSL](https://www.openssl.org/) from Source on CentOS 7

## Install Dependencies

    sudo yum install -y wget zlib-devel

    # Find the name of "Development Tools" Group under "Optional Group" in the output
    # Pass the group name to `yum group install` 
    # The group name may be translated string(e.g. "开发工具" in Chinese)
    yum group list
    sudo yum group install "Development Tools" -y

## Download Latest Source on <https://github.com/openssl/openssl/releases>

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

## Add New Shared Libraries Path of OpenSSL
      
    su
    echo '/usr/local/openssl/lib/' > /etc/ld.so.conf.d/openssl.conf
    exit
    ldconfig
            
    # Check if libssl.so.x is in the output
    ldconfig -p | grep libssl.so
         
## Check OpenSSL Version
   
    openssl version -a

## References
* [How to install latest version of OpenSSL on CentOS?](https://blacksaildivision.com/how-to-install-openssl-on-centos)

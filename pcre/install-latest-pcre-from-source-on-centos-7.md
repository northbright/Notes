# Install Latest PCRE from Source on CentOS 7

## Steps
* Install Dependencies

      # Find the name of "Development Tools" Group under "Optional Group" in the output
      # Pass the group name to `yum group install` 
      # The group name may be translated string(e.g. "开发工具" in Chinese)
      yum group list
      sudo yum group install "Development Tools" -y

* Download Latest [PCRE](http://www.pcre.org/) from Source
      
   Goto <https://ftp.pcre.org/pub/pcre/> and download the latest release:
      
      wget https://ftp.pcre.org/pub/pcre/pcre-8.42.zip
      unzip pcre-8.42.zip
      cd pcre-8.42

* Compile and Install

      # configure, make & make install
      ./configure --prefix=/usr/local/pcre
      make
      sudo make install

* Add New Binary Path of PCRE
  * `sudo vi /etc/profile`

        # Append these lines:
        # Use New Version of PCRE
        export PATH=/usr/local/pcre/bin:$PATH

  * `source /etc/profile`

* Add New Shared Libraries Path of PCRE
      
      su
      echo '/usr/local/pcre/lib/' > /etc/ld.so.conf.d/pcre.conf
      exit
      sudo ldconfig
            
      # Check if libpcre*.so.x is in the output
      ldconfig -p | grep libpcre
         
* Check PCRE Version
   
      pcregrep --version

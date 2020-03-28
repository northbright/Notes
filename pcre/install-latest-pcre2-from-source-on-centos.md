# Install Latest PCRE2 from Source on CentOS

## Install Dependencies

```
# Find the name of "Development Tools" Group under "Optional Group" in the output
# Pass the group name to `yum group install` 
# The group name may be translated string(e.g. "开发工具" in Chinese)

yum group list
sudo yum group install "Development Tools" -y
```

## Download Latest [PCRE2](http://www.pcre.org/) from Source
      
Goto <https://ftp.pcre.org/pub/pcre/> and download the latest release:

```      
wget https://ftp.pcre.org/pub/pcre/pcre2-10.34.tar.gz
tar -xzvf pcre2-10.34.tar.gz
cd pcre2-10.34
```

## Compile and Install

```
// It sets '-Wl,-rpath=$PREFIX' by default.
// No need to specify RPATH in configure.

./configure --prefix=/usr/local/pcre2

make
sudo make install

```

## Add New Binary Path of PCRE(Optional)
```
sudo vi /etc/profile

# Append these lines:
# Use New Version of PCRE2
export PATH=/usr/local/pcre2/bin:$PATH
```

```
source /etc/profile
```

## Check PCRE Version
```   
pcre2grep --version
```

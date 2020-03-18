# Install libiconv from Source on CentOS

## Download
* Get source code on [offical site](https://ftp.gnu.org/pub/gnu/libiconv/)

       cd download
       wget https://ftp.gnu.org/pub/gnu/libiconv/libiconv-1.16.tar.gz
       tar -xzvf libiconv-1.16.tar.gz
       cd libiconv-1.16

## Configure
```
./configure --prefix=/usr/local/libiconv
```

## Make and Install
```
make
sudo make install
```

## Add New Binary Path
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of libiconv
      export PATH=/usr/local/libiconv/bin:$PATH

* `source /etc/profile`

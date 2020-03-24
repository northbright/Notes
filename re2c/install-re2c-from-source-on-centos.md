# Install re2c from Source on CentOS

## Get Source from [Github](https://github.com/skvadrik/re2c/releases)
```
wget https://github.com/skvadrik/re2c/archive/1.3.tar.gz
tar -xzvf 1.3.tar.gz
cd re2c-1.3/
```

## Configure
```
./autogen.sh

./configure --prefix=/usr/local/re2c
```

## Make and Install
```
make
sudo make install
```

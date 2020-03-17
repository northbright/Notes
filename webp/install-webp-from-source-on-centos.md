# Install WebP from Source on CentOS

## Download Source on [Github Mirror](https://github.com/webmproject/libwebp/releases)
```
cd download
wget https://github.com/webmproject/libwebp/archive/v1.0.2.tar.gz
tar -xzvf v1.0.2.tar.gz
cd libwebp-1.0.2
```

## Configure
```
./autogen.sh
```

```
./configure --prefix=/usr/local/libwebp \
```

## Make and Install

```
make
sudo make install
```


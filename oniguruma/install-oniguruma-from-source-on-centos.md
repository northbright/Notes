# Install oniguruma from Source on CentOS

## Get Source from [Github](https://github.com/kkos/oniguruma/releases)

```
wget https://github.com/kkos/oniguruma/archive/v6.9.4.tar.gz
tar -xzvf v6.9.4.tar.gz
```

## Configure
```
./autogen.sh
```

```
./configure --prefix=/usr/local/oniguruma
```

## Make and Install
```
make
sudo make install
```


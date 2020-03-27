# Install Sqlite3 from Source on CentOS

## Get Source from [Offical Site](https://sqlite.org/download.html)
```
wget https://sqlite.org/2020/sqlite-autoconf-3310100.tar.gz
tar -xzvf sqlite-autoconf-3310100.tar.gz
cd sqlite-autoconf-3310100
```

## Configure
```
./configure --prefix=/usr/local/sqlite
```

## Make and Install
```
make
sudo make install
```

## Add Binary Path
```
sudo vi /etc/profile
```

```
# Append these lines
# Use New Version of Sqlite
export PATH=/usr/local/sqlite/bin:$PATH
```

```
source /etc/profile
```



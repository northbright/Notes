# Install [CMake](https://cmake.org/) from Source on CentOS

## Get Source Code
* A. From [Offical Site](https://cmake.org/download/)
* B. From [GitHub](https://github.com/Kitware/CMake/releases)

```
cd ~/download
wget https://github.com/Kitware/CMake/releases/download/v3.15.4/cmake-3.15.4.tar.gz
tar -xzvf cmake-3.15.4.tar.gz
cd cmake-3.15.4
```

## Configure
```
./configure --prefix=/usr/local/cmake
```

## Make and Install
```
gmake

sudo make install
```

## Add New Binary Path
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of CMake
      export PATH=/usr/local/cmake/bin:$PATH

* `source /etc/profile`


## Check
```
// Check version
cmake --version
```

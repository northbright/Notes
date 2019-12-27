# Install [Node.js](https://nodejs.org) from Source on CentOS 7

## Install Dependencies
* [Install `gcc` / `g++` 8 on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/gcc/install-gcc-8-on-centos-7.md)

## Download Source from [Offical Site](https://nodejs.org/en/download/) or [Github](https://github.com/nodejs/node/releases)

```
cd download
wget https://nodejs.org/dist/v12.13.1/node-v12.13.1.tar.gz
tar -xzvf node-v12.13.1.tar.gz
cd node-v12.13.1
```

## Configure
```
./configure --prefix=/usr/local/node
```

## Make and Install
```
make
sudo make install
```

## Add New Binary Path for Local Users
* `sudo vi /etc/profile`
  
      # Append these lines:
      # Use New Version of node
      export PATH=/usr/local/node/bin:$PATH

* `source /etc/profile`

## Add New Binary Path for `sudo` command

    // Run visudo as root
    su
    visudo

    # Add these lines
    # Add new version of Node / NPM
    Defaults    secure_path += /usr/local/node/bin
  
Use vim-plug to Install Vim Plugins on CentOS 7

## Check
```
// Check node version
node --version

// Check npm version
npm --version
```

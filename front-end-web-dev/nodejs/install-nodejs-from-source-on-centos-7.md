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

## Add New Binary Path of node, npm for Local Users
* `sudo vi /etc/profile`
  
      # Append these lines:
      # Use New Version of node
      export PATH=/usr/local/node/bin:$PATH

* `source /etc/profile`

## Add New Binary Path of node, npm for `sudo` command

* Insert `/usr/local/node/bin` to `secure_path` 

      sudo visudo

      # Find "secure_path" and insert "/usr/local/node/bin" to it
      # XX is the default value of secure_path

      Defaults    secure_path = /usr/local/node/bin:XX

## Check
```
// Check node version
node --version
sudo node --version

// Check npm version
npm --version
sudo npm --version
```

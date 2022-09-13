# Install aria2 from Source on Mac OS X

## Install Developer Tools
* To install developer tools include gcc, we need to install Command Line Tools
  ```
  xcode-select --install
  ```

## Get Source from [Github](https://github.com/aria2/aria2/releases/download/release-1.35.0/aria2-1.35.0.tar.gz)
* You may use browser(Firefox, Safari...) to download the source code
* You may also use cURL to download

  ```
  cURL -L -O https://github.com/aria2/aria2/releases/download/release-1.35.0/aria2-1.35.0.tar.gz
  ```
```
tar -xzvf aria2-1.35.0.tar.gz
cd aria2-1.35.0
```

## Configure
```
./configure --prefix=/usr/local/aria2
```

## Make and Install
```
make
sudo make install
```

## Add aria2 Binary Path(Optional)
```
sudo vi /etc/paths.d/aria2
```
Copy these lines
```
/usr/local/aria2/bin
```

## Check
Open a new Terminal Window and run:

```
aria2c --version
```

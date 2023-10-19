# Install [aria2](https://github.com/aria2/aria2/) from Source on Mac OS X

## Install Developer Tools
* To install developer tools include gcc, we need to install Command Line Tools
  ```
  xcode-select --install
  ```

## Download [aria2 Source Code](https://github.com/aria2/aria2/releases)
There're many ways to get the source code of aria2:
1. Download the "aria2-X.Y.Z.tar.bz2(.gz | .xz)" in "Assets"(Recommended).
2. Download the "Source Code(zip) | (tar.gz)" in "Assets".
3. Run `git clone https://github.com/aria2/aria2.git`.

We need to run `./configure` before run `make` in the source dir.
Only "aria2-X.Y.Z.tar.bz2(.gz | .xz)" contains the `configure` file.
"Source Code(zip) | (tar.gz)" and the git repo does NOT contains it and need extra steps to build the source code.

To make it easy, we just download "aria2-X.Y.Z.tar.bz2(.gz | .xz)".

```
cURL -L -O https://github.com/aria2/aria2/releases/download/release-1.36.0/aria2-1.36.0.tar.gz
```

```
tar -xzvf aria2-1.36.0.tar.gz
cd aria2-1.36.0
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

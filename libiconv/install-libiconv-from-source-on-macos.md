# Install libiconv from Source on macOS

## Steps

#### Download
Get source code on [offical site](https://ftp.gnu.org/pub/gnu/libiconv/)

```sh
cd download
aria2c https://ftp.gnu.org/pub/gnu/libiconv/libiconv-1.18.tar.gz
tar -xzvf libiconv-1.18.tar.gz
cd libiconv-1.18
```

#### Configure

```sh
./configure
```

#### Make and Install

```sh
make
sudo make install
```

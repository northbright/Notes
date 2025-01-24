# Install MongoDB Community Edition on Ubuntu

## Import Public GPG Key of MongoDB

* Install `gnupg` and `curl`

  ```
  sudo apt install gnupg curl -y
  ```

* Import public GPG key of MongoDB

  ```
  curl -fsSL https://www.mongodb.org/static/pgp/server-8.0.asc | \
  sudo gpg -o /usr/share/keyrings/mongodb-server-8.0.gpg \
  --dearmor
  ```

## Create List File

Create `/etc/apt/sources.list.d/mongodb-org-8.0.list` for Ubuntu release.

e.g. Ubuntu 24.04:

```
echo "deb [ arch=amd64,arm64 signed-by=/usr/share/keyrings/mongodb-server-8.0.gpg ] https://repo.mongodb.org/apt/ubuntu noble/mongodb-org/8.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-8.0.list
```

## Install MongoDB Community Server

```
sudo apt update
```

```
sudo apt install mongodb-org -y
```

## Enable and Start MongoDB Service

```
sudo systemctl enable mongod
sudo systemctl start mongod
```

## References
* [在 Ubuntu 上安装 MongoDB Community Edition](https://www.mongodb.com/zh-cn/docs/manual/tutorial/install-mongodb-on-ubuntu/)

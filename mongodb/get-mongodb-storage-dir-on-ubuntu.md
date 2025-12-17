# Get MongoDB Storage Dir on Ubuntu

## Steps
Check `storage` in `/etc/mongod.conf`.

```sh
sudo vi /etc/mongod.conf
```

```sh
# Where and how to store data.
storage:
  dbPath: /var/lib/mongodb
```

# Install Redis from Source on macOS

## Steps

#### Download Redis

Use `wget` or `aria2c` to download the source.

```bash
cd ~/download
wget https://download.redis.io/redis-stable.tar.gz
```

#### Make and Install
```bash
tar -xzvf redis-stable.tar.gz
cd redis-stable

make
sudo make install
```

It'll install `redis-cli` and `redis-server` to `/usr/local/bin`

#### Make DB Dir and Create Redis Config File

Assume we have 2 apps, we need to create the db dir for each app.

```bash
mkdir -p ~/db/app1
mkdir -p ~/db/app2
```

We need to copy default redis config files to our db dir and modify it if need.
```bash
cp ~/download/redis-stable/redis.conf ~/db/app1/redis.conf
cp ~/download/redis-stable/redis.conf ~/db/app2/redis.conf
```

#### Run Redis Server and Client
To run Redis Server for App1, run:

```bash
redis-server ~/db/app1/redis.conf &
```

To run Redis Client, run:

```bash
redis-cli --raw
```

```bash
INFO
```

## References
* [Install Redis from Source](https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-from-source/)

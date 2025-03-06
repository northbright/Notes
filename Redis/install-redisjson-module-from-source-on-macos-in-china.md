# Install RedisJSON Module from Source on macOS in China

## Install Latest Redis from Source
* [Install Redis from Source on macOS](https://github.com/northbright/Notes/blob/master/Redis/install-redis-from-source-on-macos.md)

## Install Rust
* [Install Rust on macOS in China](https://github.com/northbright/Notes/blob/master/rust/install-rust-on-macos-in-china.md)

## Download RedisJSON Source
To make `git clone` faster in China, it's better to use "git" protocol instead "https" to run `git clone`.

* Fork [RedisJSON](https://github.com/RedisJSON/RedisJSON)

* Clone RedisJSON repo

  ```shell
  cd ~/download
  git clone git@github.com:YOUR_ACCOUNT/RedisJSON.git
  ```

## Build

```shell
cd RedisJSON
cargo build --release
```

It'll generate the lib: `target/release/librejson.dylib`

## Run `redis-server` with `librejson.dylib` Module Loaded

* Method A

  Run `redis-server` with `--loadmodule` option.

  ```shell
  redis-server /path/to/redis.conf --loadmodule /path/to/librejson.dylib &
  ```

* Method B

  Set `loadmodule` for `librejson.dylib` in `redis.conf`

  ```shell
  vi /path/to/redis.conf
  ```

  ```shell
  loadmodule /path/to/librejson.dylib
  ```

## Run `redis-cli` to Test

```shell
redis-cli --raw
```

* Show modules

```shell
module list

// Output:
...
ReJSON
...
```

## References
* [RedisJSON](https://github.com/RedisJSON/RedisJSON)

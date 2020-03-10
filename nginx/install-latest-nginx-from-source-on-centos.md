# Install Latest Nginx from Source on CentOS

## Supported CentOS Versions
* CentOS 7
* CentoS 8

## Install Dependencies
* Install "Development Tools"
   
      sudo yum group install "Development Tools" -y

* zlib
  * [Install zlib on CentOS from Source](https://github.com/northbright/Notes/blob/master/zlib/install-zlib-on-centos-from-source.md)

* PCRE
  * [Install Latest PCRE from Source on CentOS](https://github.com/northbright/Notes/blob/master/pcre/install-latest-pcre-from-source-on-centos.md) 

* OpenSSL
  * [Install Latest Release of OpenSSL from Source on CentOS](https://github.com/northbright/Notes/blob/master/openssl/install-latest-openssl-from-source-on-centos.md)
   
## Download source on [github](https://github.com/nginx/nginx/releases)
```
cd download
wget https://github.com/nginx/nginx/archive/release-1.17.8.tar.gz
tar -xzvf release-1.17.8.tar.gz
cd nginx-release-1.17.8
```

## Configure [Nginx](http://nginx.org/)
There're 2 configure methods to make nginx use latest or specified versions of zlib, pcre and OpenSSL.
* Method A: Use `--with-zlib`, `--with-pcre`, `--with-openssl`

  * Set `--with-xx` to the source directories and make nginx compile the library from source by itself
  * To add options for compiling zlib, pcre, OpenSSL, you may need to add additional `--with-zlib-opt`, `--with-pcre-opt`, `--with-openssl-opt`
  * Nginx will link the libraries(libz, libpcre, libssl, libcrypto) statically
  * Example Configuration

    ```
    // Make sure to replace PATH/to/xx to your own zlib, pcre, openssl source dir

    ./auto/configure \
    --prefix=/usr/local/nginx \
    --with-zlib=/PATH/to/zlib-1.2.11/ \
    --with-pcre=/PATH/to/pcre-8.44 \
    --with-openssl=/PATH/to/openssl-OpenSSL_1_1_1d/ \
    --with-http_ssl_module \
    ```

* Method B: Use `--with-cc-opt`, `--with-ld-opt`(**recommended**)

  * We compiled and installed specified version of zlib, pcre, openssl on system(e.g. `/usr/local/zlib`, `/usr/local/pcre`, `usr/local/openssl`)
  * If NO `--with-zlib`, `--with-pcre` and `--with-openssl` specified, nginx will use "System" ones.
  * Set `--with--cc-opt`, `--with-ld-opt` to the install directories of specified version of zlib, pcre, OpenSSL
  * When nginx compiles source / link libraries, overrided paths in `CFLAGS`, `LDFLAGS` will make nginx use specified version of zlib, pcre, openssl(installed) instead of system default ones.
  * Nginx will link the shared libraries(libz, libpcre, libssl, libcrypto) dynamically
  * Example Configuration

    ```
    ./auto/configure \
    --prefix=/usr/local/nginx \
    --group=nobody \
    --user=nobody \
    --with-cc-opt="-I /usr/local/pcre/include \
    -I /usr/local/zlib/include \
    -I /usr/local/openssl/include" \
    \
    --with-ld-opt="-L /usr/local/pcre/lib \
    -L /usr/local/zlib/lib \
    -L /usr/local/openssl/lib \
    -Wl,-rpath=/usr/local/pcre/lib \
    -Wl,-rpath=/usr/local/zlib/lib \
    -Wl,-rpath=/usr/local/openssl/lib" \
    \
    --with-http_ssl_module \
    ```

## Default Values of Unspecified Options
* `configure` will set default values if options values are not set

| Description | Variable | Option | Default Value |
| :--: | :--: | :-- : | :--: |
| binary path | `NGX_SBIN_PATH` | `--sbin-path` | `$PREFIX/sbin/nginx` |
| `nginx.conf` path | `NGX_CONF_PATH` | `--conf-path` | `$PREFIX/conf/nginx.conf` |
| PID file path | `NGX_PID_PATH` | `--pid-path` | `$PREFIX/logs/nginx.pid` |
| error log path  | `NGX_ERROR_LOG_PATH` | `--error-log-path` | `$PREFIX/logs/error.log` |
| HTTP log path | `NGX_HTTP_LOG_PATH` | `--http-log-path` | `$PREFIX/logs/access.log` |

* Check the default option values in [./auto/options](https://github.com/nginx/nginx/blob/release-1.17.9/auto/options#L597)

## Make and Install
```
make
sudo make install
```

## Check need / linked libraries
```
readelf -d /usr/local/nginx/sbin/nginx
ldd -d /usr/local/nginx/sbin/nginx
```

## Check version of nginx
```
/usr/local/nginx/sbin/nginx -v
```


## Add New Binary Path of Nginx
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of Nginx
      export PATH=/usr/local/nginx/sbin:$PATH

* `source /etc/profile`

## Configure Nginx as `systemd` Service
* Create `/lib/systemd/system/nginx.service` File

      sudo vi /lib/systemd/system/nginx.service

      [Unit]
      Description=The NGINX HTTP and reverse proxy server
      After=syslog.target network.target remote-fs.target nss-lookup.target

      [Service]
      Type=forking
      PIDFile=/usr/local/nginx/logs/nginx.pid
      ExecStartPre=/usr/local/nginx/sbin/nginx -t
      ExecStart=/usr/local/nginx/sbin/nginx
      ExecReload=/usr/local/nginx/sbin/nginx -s reload
      ExecStop=/bin/kill -s QUIT $MAINPID
      PrivateTmp=true

      [Install]
      WantedBy=multi-user.target

* Enable and Start Nginx Service
  
      sudo systemctl enable nginx.service
      sudo systemctl start nginx.service
        
      # Check nginx service stastus
      systemctl status nginx.service

* Check Users of Running Nginx Processes

      ps aux | grep nginx

    The output should looks like this:

    | User | Process |
    | :--: | :--: |
    | root | master process(`/usr/local/nginx/sbin/nginx`) |
    | nobody | worker process |

## References
* [烂泥：nginx、php-fpm、mysql用户权限解析](http://blog.51cto.com/ilanni/1561097)

# The "http2" Parameter Requires `ngx_http_v2_module`

## Problem
* Use `http2` in `nginx.conf`

  ```
  server {
        listen       443 ssl http2;
        ...
  }
  ```
* Failed to start nginx service
* Open `/usr/local/nginx/logs/error.log` and found:

  > the "http2" parameter requires ngx_http_v2_module

## Solution
* Add `--with-http_v2_module` when run `configure`

## References
* [Nginx开启TLSv1.3和HTTP/2](https://www.acgist.com/article/541.html)
* [nginx升级到支持HTTP2.0](https://segmentfault.com/a/1190000019867599)

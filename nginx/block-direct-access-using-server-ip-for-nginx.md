# Block Direct Access Using Server IP for Nginx

## Solution

* Block direct access using server IP via HTTP

  Add a new `server` block in `nginx.conf`

  ```
  # Default Server block disable direct IP access via HTTP
  server {
      listen 80 default_server;
      server_name "";
      return 444;
  }

  ```

* Block direct access using server IP via HTTPS
  * Create self-signed cert for server IP

    ```
    sudo openssl req \
    -x509 \
    -nodes \
    -days 365 \
    -newkey rsa:4096 \
    -keyout /usr/local/openssl/private/nginx-selfsigned.key \
    -out /usr/local/openssl/certs/nginx-selfsigned.crt \
    -subj '/CN=<SERVER-IP>'
    ```

  * Add a new `server` block in `nginx.conf`

    ```
    # Default Server block disable direct IP access via HTTPS
    server {
        listen 443 ssl default_server;
        server_name <SERVER-IP>;
        ssl_certificate /usr/local/openssl/certs/nginx-selfsigned.crt;
        ssl_certificate_key /usr/local/openssl/private/nginx-selfsigned.key;

        return 444;
    }
    ```

* Restart Nginx

  ```
  // e.g. on CentOS 7
  sudo systemctl restart nginx
  ```

## References
* [Block direct access to webserver IP via HTTPS](https://serverfault.com/questions/794953/block-direct-access-to-webserver-ip-via-https)
* [how to disable direct access to a web site by ip address](https://stackoverflow.com/questions/29104943/how-to-disable-direct-access-to-a-web-site-by-ip-address)
* [Configure Self-Signed SSL Certificate for Nginx on CentOS](https://github.com/northbright/Notes/blob/master/nginx/configure-self-signed-ssl-certificate-for-nginx-on-centos.md)

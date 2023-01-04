# Install Nginx and Setup Virtual Host on Ubuntu

## Install Nginx
```
sudo apt-get update
sudo apt-get install nginx
```

## Configure `/etc/nginx/nginx.conf`

* Backup `nginx.conf`

  ```
  sudo cp /etc/nginx/nginx.conf /etc/nginx/nginx.conf.bak
  ```

* Modify `nginx.conf`

  ```
  sudo vi /etc/nginx/nginx.conf
  ```

  ```
  # Disable `sites-enabled/*`
  # Go to Virtual Host Configs
  # Comment sites-enabled

  #include /etc/nginx/sites-enabled/*;
  ```

  ```
  # Disable default SSL settings to avoid confliction with
  # customized SSL settings in virtual host config
  # Go to SSL Settings
  # Comment ssl_protocols, ssl_prefer_server_ciphers

  #ssl_protocols TLSv1 TLSv1.1 TLSv1.2 TLSv1.3; # Dropping SSLv3, ref: POODLE
  #ssl_prefer_server_ciphers on;
  ```

## Create `/etc/nginx/conf.d/YOUR_DOMAIN.conf`

```
sudo vi /etc/nginx/conf.d/a.com.conf
```

```
server {
        listen       80;
        
        # Set server_name to your domain 
        server_name  a.com;

        location / {
            # Set webroot to home(/var/www/html) of `www-data` user.
            # Nginx worker process is run as `www-data`.
            # Put public content to /var/www/html.
            root   /var/www/html;
            index  index.html index.htm;
        }
}
```

## Add a test `index.html`

```
sudo vi /var/www/html/index.html
```

```
Hello World!
```

## Restart Nginx and Test
```
sudo systemctl restart nginx
```

```
curl localhost
// Output:
// Hello World!
```

```
curl a.com
// Output:
// Hello World!
```

## References
* [Difference in sites-available vs sites-enabled vs conf.d directories (Nginx)?](https://serverfault.com/questions/527630/difference-in-sites-available-vs-sites-enabled-vs-conf-d-directories-nginx)

# Configure Nginx to Deny Access by Public IP of Host

#### Problem
* Need to configure Nginx server to **BLOCK** access by using public IP of the host.
* Nginx server should be accessed **ONLY** by using domain name.

#### Solution
Add fake `default servers` before your **REAL** server block:

    // Fake default HTTP server to block IP access.
    server {
        listen 80 default_server;
        return 501;
    }
    
    // Fake default HTTPS server to block IP access.
    server {
        listen 443 ssl default_server;
        return 501;
    }

    # Real Server goes here.
    server {
        listen 80;
        server_name mydomain.com;
        ......
    }

#### References
* [nginx 如何禁止 ip 直接访问](https://www.v2ex.com/t/239589)


# Set Proxy for apt-get

* Set http / https / ftp proxy in `/etc/apt/apt.conf.d/01proxy`:

        echo 'Acquire::http::Proxy "http://xx.com:8080";' | sudo tee --append /etc/apt/apt.conf.d/01proxy

* Reference  
  <http://blog.csdn.net/sww_simpcity/article/details/8776098>

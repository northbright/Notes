# Use GoAccess to Analyze Nginx Log in Real-Time

## Install [GoAccess](https://goaccess.io/)
* [Install GoAccess from Source on Ubuntu](https://github.com/northbright/Notes/blob/master/goaccess/install-goaccess-from-source-on-ubuntu.md)

## Run [GoAccess](https://goaccess.io/) to Analyze Nginx Log in Real-Time
* Run GoAccess as `root`

  In most case, `access.log` of Nginx needs root permission to read.

  ```
  su
  /usr/local/goaccess/bin/goaccess /var/log/nginx/access.log -c
  ```

* Press "space" to select `NCSA Combined Log Format` for Nginx log

## References
* [Get Started](https://goaccess.io/get-started)

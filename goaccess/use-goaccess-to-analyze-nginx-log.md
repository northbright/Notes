# Use GoAccess to Analyze Nginx Log in Real-Time

## Install [GoAccess](https://goaccess.io/)
* [Install GoAccess from Source on Ubuntu](https://github.com/northbright/Notes/blob/master/goaccess/install-goaccess-from-source-on-ubuntu.md)

## Run [GoAccess](https://goaccess.io/) to Analyze Nginx Log in Real-Time
* Analyze Current Access Log(Today) in Terminal

  ```
  sudo /usr/local/goaccess/bin/goaccess /var/log/nginx/access.log \
  --log-format=COMBINED
  ```

* Analyze Current Access Log(Today) and Generate HTML Report

  ```
  sudo /usr/local/goaccess/bin/goaccess /var/log/nginx/access.log \
  --log-format=COMBINED \
  -o /home/xx/report.html
  ```

* Extract Compressed Nginx Log to stdout and Use [GoAccess](https://goaccess.io) to Read the Log from stdin then Analyze it

  ```
  sudo zcat /var/log/nginx/access.log.2.gz | sudo /usr/local/goaccess/bin/goaccess - --log-format=COMBINED
  ```

* Analyze Both Latest Log File and Compressed Log Files

  ```
  sudo zcat /var/log/nginx/access.log.2.gz /var/log/nginx/access.log.3.gz | \
  sudo /usr/local/goaccess/bin/goaccess \
  /var/log/nginx/access.log \
  /var/log/nginx/access.log.1 - \
  --log-format=COMBINED \
  ```

* Analyze Both Latest Log File and Compressed Log Files and Generate HTML Report

  ```
  sudo zcat /var/log/nginx/access.log.2.gz /var/log/nginx/access.log.3.gz | \
  sudo /usr/local/goaccess/bin/goaccess \
  /var/log/nginx/access.log \
  /var/log/nginx/access.log.1 - \
  --log-format=COMBINED \
  -o /home/xxu/report.html
  ```

## References
* [Get Started](https://goaccess.io/get-started)
* [EXAMPLES](https://goaccess.io/man#examples)
* [Use of Dash “-” in Command-Line Parameters](https://www.baeldung.com/linux/dash-in-command-line-parameters)

# Meaning of Dash(`"-"`)

The `"-"` character means different things to different commands on the Linux terminal.

## On the most commonly used shells like **bash** and **zsh**, the “-” character is used to specify a standard input or a standard output for a command

Most of the commands(`cat`, `tar`) on Linux treat the string `-` as a synonym for stdin or stdout.

## Examples

* Read from stdin, `cat -` is the same as `cat /dev/stdin`

  ```
  cat -
  Hello
  Hello 
  ```

* Download a gzip file to stdout and extract it from stdin without download it to the disk

  ```
  curl -L https://github.com/hishamhm/htop/archive/refs/tags/2.2.0.tar.gz --output - | tar zxf -
  ```

* Extract Compressed Nginx Log to stdout and Use [GoAccess](https://goaccess.io) to Read the Log from stdin then Analyze it

  ```
  sudo zcat /var/log/nginx/access.log.2.gz | sudo /usr/local/goaccess/bin/goaccess --log-format=COMBINED -
  ```

## References
* [Use of Dash “-” in Command-Line Parameters](https://www.baeldung.com/linux/dash-in-command-line-parameters)

# Use Wildcards with scp

## Problem
* Want to use scp to copy all .tar.gz from 10.0.0.1 to 10.0.0.2
* Got error when run `scp 10.0.0.1:~/*.tar.gz ./` on 10.0.0.2

  > No such file

## Solution
Add `\` before `*`

## Example
```
scp 10.0.0.1:~/\*.tar.gz ./
```

## References
* [How to use wildcards when copying with scp?](https://unix.stackexchange.com/questions/27419/how-to-use-wildcards-when-copying-with-scp)

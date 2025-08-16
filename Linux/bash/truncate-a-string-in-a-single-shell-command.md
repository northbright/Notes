# Truncate a String in a Single Shell Command

## Solution
```sh
str=${Var:Offset:Lenth}
```

```sh
str="hello world" && str=${str:0:5} && echo $str

// Output:
hello
```

It's better to add a check to the lenth of the string or bash'll report error when offset >= length.


```sh
d=3.1415 && frac=$(echo $d | awk -F. '{ print $2}') && if [[ ${#frac} -ge 3 ]]; then frac=${frac:0:3}; else frac=000; fi  && echo $frac

// Output:
141
```

## References
* [Demystifying the Art of Truncating String Variables in Bash](https://thelinuxcode.com/bash-truncate-string-variable/)

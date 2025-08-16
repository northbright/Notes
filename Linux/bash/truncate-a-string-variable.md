# Truncate a String Variable

## Solution

#### Method A: Use Bash’s Substring Expansion

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

#### Method B: Use `awk` with `substr()` function

```sh
substr(var, index, length)
index is 1-based.
```

```sh
d=3.1415 && frac=$(echo $d | awk -F. '{ print substr($2, 1, 3)}') && echo $frac

// Ouput:
141
```

## References
* [Demystifying the Art of Truncating String Variables in Bash](https://thelinuxcode.com/bash-truncate-string-variable/)
* [Extracting a Substring in Bash](https://www.baeldung.com/linux/bash-substring)

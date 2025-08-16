# Use `if` `then` in a Single Shell Command

## Problem
Need to write `if then` in a single shell command.

## Solution

Format
```sh
if [[ XX ]]; then XX; else XX; fi
```

## Example

```sh
d=3.1415 && frac=$(echo $d | awk -F. '{ print $2}') && if [[ ${#frac} -ge 3 ]]; then frac=${frac:0:3}; else frac=000; fi  && echo $frac

// Output:
141
```

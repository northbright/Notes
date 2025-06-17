# 09 is Invalid Number when Call printf

## Problem
```bash
a="09"; printf "%02d" $a
```

Run this in bash("bash -c") and got "invalid number error".
But it's ok(shows "09") when run this with "zsh" on macOS.

## Root Cause
A number literal starting with 0 but having no x at the 2nd place is interpreted as octal value.

## Solution
Use `${a#0}` to remove prefix `0`.

```bash
a="09"; printf "%02d" ${a#0}
```

## References
* [printf in bash: "09" and "08" are invalid numbers, "07" and "06" are fine](https://stackoverflow.com/questions/8078167/printf-in-bash-09-and-08-are-invalid-numbers-07-and-06-are-fine)

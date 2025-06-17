# bash -c "v=value; echo $v" Shows Nothing

## Problem
Run `bash -c "v=value; echo $v"`

## Root Cause
* There're 2 shells
  * The calling shell, the interactive shell from which you are running this
  * The non-login, non-interactive shell, spawned by `bash -c`
* The variable expansion, `$v`, is actually taking place in the calling shell, not the called shell. 
* But the declaration, `v=value`, is taking place on the called non-interactive shell.
* As the value variable is unset in the calling shell, hence you are getting nothing in the output(`$v -> ""`).

## Solution
#### Method A - Use single quotes

```bash
bash -c 'v=value; echo $v'
```

#### Method B - Escape `$`:

```bash
bash -c "v=value; echo \$v"
```

## References
* [bash -c "v=value; echo $v" displays nothing](https://askubuntu.com/questions/786816/bash-c-v-value-echo-v-displays-nothing)

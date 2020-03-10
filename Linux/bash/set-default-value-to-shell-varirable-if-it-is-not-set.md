# Set Default Value to Shell Variable if It Is NOT Set

## Solution
```
FOO=${VAR:-default}
```

## Example

print `$USER` with default value(`Frank`)

```
echo ${USER:-Frank}
// Output:
// Frank

// Set $USER to John
USER=John

// Test again
echo ${USER:-Frank}
// Output:
// John
```

## References
* [Assigning default values to shell variables with a single command in bash](https://stackoverflow.com/questions/2013547/assigning-default-values-to-shell-variables-with-a-single-command-in-bash)

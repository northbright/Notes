# Use Double Square Brackets for Numeric and String Comparison

Double square brackets `[[ ]]` in Bash provide distinct conditional tests and evaluations with additional features.

## Examples

Cut first 5 letters of name if name length >= 5.

```sh
name="Frank Xu" && if [[ ${#name} -ge 5 ]]; then first=${name:0:5}; fi && echo $first

// Output:
Frank
```

Campare if name is Frank.

```sh
name="Jacky" && if [[ $name != "Frank" ]]; then echo "Hi $name"; else echo "Hello Frank"; fi
```

## Refernces
* [Using Double Square Brackets in If Statement in Bash](https://linuxsimply.com/bash-scripting-tutorial/conditional-statements/if/double-brackets/)
* [Differences Between Single and Double Brackets in Bash](https://www.baeldung.com/linux/bash-single-vs-double-brackets)

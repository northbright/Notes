# Use `if` Statement in a Single Shell Command

## Solution
To execute the if statements as a one-liner code, separate commands by putting the semicolon `;`.

Format
```sh
if [ XX ]; then XX; else XX; fi
```

or use double brackets `[[ ]]`:

```sh
if [[ XX ]]; then XX; else XX; fi
```

## Example

```sh
d=3.1415 && frac=$(echo $d | awk -F. '{ print $2}') && if [[ ${#frac} -ge 3 ]]; then frac=${frac:0:3}; else frac=000; fi  && echo $frac

// Output:
141
```

## References
* [How to Write If Statement in One Line? [2 Easy Ways]](https://linuxsimply.com/bash-scripting-tutorial/conditional-statements/if/if-one-line/)

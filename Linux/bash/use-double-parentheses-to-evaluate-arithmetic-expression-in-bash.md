# Use Double Parentheses to Evaluate Arithmetic Expression in Bash

## Examples
```bash
s=3882; hh=$((s / 3600)); mm=$((s % 3600 / 60)); ss=$((s % 3600 % 60)); printf -v timestamp "%02d:%02d:%02d" hh mm ss; echo $timestamp
```
Output:

```bash
01:04:42
```

## References
* [How to Evaluate Arithmetic Expressions in Bash](https://www.baeldung.com/linux/bash-arithmetic-expressions)
* [Bash Scripting: Understanding the Use of Parentheses, Brackets, and Braces](https://linuxconfig.org/bash-scripting-parenthesis-explained)
* [Use `printf -v` to assign formatted output to a variable](https://www.linuxbash.sh/post/use-printf--v-to-assign-formatted-output-to-a-variable)

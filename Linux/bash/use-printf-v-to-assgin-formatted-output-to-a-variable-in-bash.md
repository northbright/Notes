# Use `printf -v` to Assgin Formatted Output to a Variable in Bash

## Example

```bash
s=3882; hh=$((s / 3600)); mm=$((s % 3600 / 60)); ss=$((s % 3600 % 60)); printf -v timestamp "%02d:%02d:%02d" hh mm ss; echo $timestamp
```
Output:

```bash
01:04:42
```

## References
* [Use `printf -v` to assign formatted output to a variable](https://www.linuxbash.sh/post/use-printf--v-to-assign-formatted-output-to-a-variable)

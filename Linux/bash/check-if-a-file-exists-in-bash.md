# Check if a File Exists in Bash

## Example

```bash
FILE="/path/to/my/file"

if [[ -f $FILE ]]; then
    echo "$FILE exists"
fi
```

* `-f`: It returns True if the file exists as a common(regular) file.

## References
* [How to Check if a File or Directory Exists in Bash](https://linuxize.com/post/bash-check-if-file-exists/)
* [Bash Scripting - How to check If File Exists](https://www.geeksforgeeks.org/bash-scripting-how-to-check-if-file-exists/)

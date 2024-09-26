# Remove Backslash

## Problem
* Run "ls" and got "\" in the current dir.
* Need to delete the "\" file

## Solution
* Run `ls ./XX` to list all files to be removed.

```bash
ls ./XX

// Output:
\\
```

It shows the file name: "\\".

* Run `rm ./\\" to remove the "\" file.

```bash
rm ./\\
```

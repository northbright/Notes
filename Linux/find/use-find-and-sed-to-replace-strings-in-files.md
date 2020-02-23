# Use `find` and `sed` to Replace Strings in Files

## Problem
* Want to replace strings in all ".md" files

## Solution
```
// Example
// Replace all "AA" with "BB" in all ".md" files
// under current dir, include sub dirs

find . -name "*.md" -type f -print0 | xargs -0 sed -i 's/AA/BB/g'
```

## References
* [How to Use sed to Find and Replace String in Files](https://linuxize.com/post/how-to-use-sed-to-find-and-replace-string-in-files/)


# Extract File Base Name in Bash Script

## Problem
* Run a bash script to get all file names of `"*.docx"` in a dir
* Get file base name of each file.

## Solution
Use `"{$file%.*}"` to remove all extensions or use `"{$file%.docx}"` to remove `".docx"`.

```bash
#! /bin/bash
for file in *.docx; do
   echo "${file}" "${file%.docx}" 
done
```

## References
* [Bash get basename of filename or directory name](https://www.cyberciti.biz/faq/bash-get-basename-of-filename-or-directory-name/)
* [Extract name of file without extension in shell script](https://unix.stackexchange.com/questions/56720/extract-name-of-file-without-extension-in-shell-script)
* [How to extract the filename without the extension from a full path?](https://superuser.com/questions/731227/how-to-extract-the-filename-without-the-extension-from-a-full-path)

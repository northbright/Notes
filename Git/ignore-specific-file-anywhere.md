# Ignore Specific File Anywhere

## Problem
* Need to Include All `.txt` in Repo
* Need to Ignore `log.txt` Any Where(e.g. `/log.txt`, `/output/log.txt`, `server/log.txt`)

## Solution
Use `log.txt` to ignore any `log.txt`

e.g.

```
# Ignore All
*
# Unignore All Sub dirs
!*/

# Text
!*.txt
log.txt
```

## References
* [.gitignore File – How to Ignore Files and Folders in Git](https://www.freecodecamp.org/news/gitignore-file-how-to-ignore-files-and-folders-in-git/)

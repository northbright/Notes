# Use `git mv` to Commit Case-Sensitive Only Filename Changes

## Problem
* The repo is cloned to a Mac OS X(Case-insensitive FS)
* Want to rename `README.MD` to `README.md`
* `git status` and `git add` will not detect the case-sensitive filename change

## Solution
* Use `git mv` with `-f` option

## Example
```
git mv -f old_file new_file
```

## References
* [How do I commit case-sensitive only filename changes in Git?](https://stackoverflow.com/questions/17683458/how-do-i-commit-case-sensitive-only-filename-changes-in-git)

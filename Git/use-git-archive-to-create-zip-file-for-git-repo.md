# Use `git archive` to Create Zip File for Git Repo

## Problem
* Need to create a zip file for a Git Repo
* Need to exclude all hidden files / dirs(e.g. `.git/*`)

## Solution
Use `git archive` command.

```bash
cd ~/my-project
git archive --format=zip HEAD -o my-project.zip
```

## References
* [how to exclude directories and file zipping a directory?](https://askubuntu.com/questions/371579/how-to-exclude-directories-and-file-zipping-a-directory)

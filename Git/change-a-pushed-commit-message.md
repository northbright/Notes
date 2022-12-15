# Change a Pushed Commit Message

## Problem
* `git commit` and pushed commit to remote(origin/master)
* Need to change the latest remote's commit message

## Solution
* Run `git commit --amend` to update latest local commit message
* Run `git push <REMOTE> <BRANCH> --force` to update remote's commit message(e.g. `git push origin HEAD:master --force`)

## References
* [How to Change a Git Commit Message](https://linuxize.com/post/change-git-commit-message/)

# Fix "There is no tracking information for the current branch"

## Problem
* Run `git pull` on `dev` Branch
* Got "There is no tracking information for the current branch" Error

## Solution
Set tracking information for the branch.

```bash
git branch --set-upstream-to=origin/<branch> <branch>
```

e.g. for `dev` branch
```
git branch --set-upstream-to=origin/dev dev
```

## References
* [Demystifying the "No Tracking Information" Error in Git](https://thelinuxcode.com/why-there-is-no-tracking-information-for-the-current-branch/)

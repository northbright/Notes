
# Use git reflog and git cherry-pick to get removed HEAD caused by git reset

To find removed HEAD caused by `git reset xxx`:

* `git reflog` to find the HEAD id you want to recover
* `git cherry-pick <HEAD_ID>` to get the HEAD back
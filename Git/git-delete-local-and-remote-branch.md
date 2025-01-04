# Git Delete Local and Remote Branch

## Delete Local Branch
* List Branches

  ```
  git branch -a

  //  Output:
  master
  * dev
  remotes/origin/HEAD -> origin/master
  remotes/origin/master
  remotes/origin/dev
  ```

* Delete Local Branch

  ```
  // Switch to a branch other than the branch to be deleted(e.g. "master")
  git checkout master

  // Delete "dev" branch
  git branch -D dev
  ```

## Delete Remote Branch

```
git push origin --delete dev
```

## References
* [How to Delete Git Branches On Local and Remote Repositories](https://www.howtogeek.com/devops/how-to-delete-git-branches-on-local-and-remote-repositories/)

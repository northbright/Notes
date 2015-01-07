
# Remove change id and other gerrit message in comments after git cherry-pick

After `git fetch ssh://xx refs/changes/xx && git cherry-pick FETCH_HEAD`,  
You may need to run `git commit --amend` to remove Change-Id and other gerrit info in comments:  

* Change-Id
* Reviewed-on
* Tested-by
* Reviewed-by
* other gerrit info 